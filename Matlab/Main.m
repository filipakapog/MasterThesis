clear all;
close all;
rng default
clc

setupEnv;
saveArrhythmiaData({data_dir, valid_dir})
java.lang.Thread.sleep(2*1000);

% sf = load(stenosis_file);
arrhythmia_data = load(arrhythmia_data_file);

%% Run PCA.
X = arrhythmia_data.data.xs;
Y = arrhythmia_data.data.ys;

% De-mean
X = bsxfun(@minus,X,mean(X));
% Do the PCA
[coeff,score,~] = pca(X);
predictors = score(:,(1:2));


%% Splitting the data set.
XTrain = predictors((1:80),:);
yTrain = Y(1:80);
XTest  = predictors((81:100),:);
yTest  = Y(81:100);
%% Training the data with:
% [1] hypothesis (Bagging):
% h1 = TreeBagger(50,predictors,Y); % [IMPORTANT] #tress < #predictors
h1 = fitcensemble(XTrain,yTrain,'Method','Bag','NumLearningCycles', ...
    50,'Learners','Tree');
% [2] hypothesis (Boosting):
templ = templateTree('Surrogate','all');
h2 = fitcensemble(XTrain, yTrain,'Method', 'AdaBoostM2', ...
    'NumLearningCycles',50, 'Learners',templ);
% [3] hypothesis (Neuro-Fuzzy):

% Classification
% [1] results (Bagging):
predY_1 = predict(h1, XTest);
diff_1 = yTest == predY_1;
rez_1 = sum(diff_1 == 1) / length(yTest);

% [2] results (Boosting):
predY_2 = predict(h2, XTest);
diff_2 = yTest == predY_2;
rez_2 = sum(diff_2 == 1) / length(yTest);

figure;
plot(loss(h1,XTest,yTest,'mode','cumulative'));
hold on;
plot(loss(h2,XTest,yTest,'mode','cumulative'), 'r.');
legend('Bagging','Boosting','Location','NE');
ylabel('Eroare de classificare');
xlabel('Observatii');

% [3] results (Neuro-Fuzzy);
rez_1
rez_2


