% Keeps only the principal centerline

%% Load needed data
load('date_noi_clasif_v2.mat')

%% Compute the centerline
binaryImage = imagesBWSten{19};
skelImage = bwmorph(binaryImage, 'skel', inf); % nu prea inteleg
skelImage = bwmorph(skelImage, 'spur', 15); % nu prea inteleg


%% Label the discovered centerlines
% If there are more centerliens then numCenterliens will be > 1
[labeledImage, numCenterlines] = bwlabel(skelImage);

%% Select the computed distances which are on the centerline
maxRadiuses = zeros(1, numCenterlines);
for k=1:numCenterlines
    edtImage = bwdist(~binaryImage);
    radiuses = edtImage(labeledImage == k);
    maxRadiuses(k) = max(radiuses);
end

%% Eliminate centerline which is not principal
meanMaxRadiuses = mean(maxRadiuses);
labels = find(maxRadiuses < meanMaxRadiuses);
sz = size(labels);
for k=1:sz(2)
    [row, col] = find(labeledImage == labels(k));
    skelImage(row, col) = 0;
    imshow(skelImage)
    imtool(skelImage);
end

%%

%% Select pixels only from zone 3
[y, x] = find(labeledImage == 3);


%% Plot images
subplot(3, 1, 1), imshow(binaryImage);
subplot(3, 1, 2), imshow(labeledImage);
subplot(3, 1, 3), imshow(skelImage);

imtool(labeledImage);
