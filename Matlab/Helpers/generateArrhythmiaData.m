% Clean the workspace.
clear all;
close all;
clc

% Adding directories to search path.
home_dir = 'D:\Dropbox\Master\Disertatie\Code\MasterThesis\Matlab\'; 
data_dir = [home_dir 'Demo code\Physionet\ECG\sample2017\validation\'];
arrhythmia_file = [home_dir 'Data\arrhythmia_data.mat'];

if exist(arrhythmia_file, 'file') == 2
  delete(arrhythmia_file);
end

addpath(home_dir, data_dir);

% Create from scratch.
if (exist(arrhythmia_file, 'file') == 2)
   delete(arrhythmia_file); 
end

% Read the labels.
refs = readtable([data_dir 'REFERENCE.csv'],'ReadVariableNames',false);
refs.Properties.VariableNames = {'FileName','ClassificationLabel'};


sample_sz = min(100, length(refs.FileName));
sample_time = 9000;

sample = datasample(refs, sample_sz);

arrhythmia_set.xs = zeros(sample_sz, sample_time);
arrhythmia_set.ys = cell2mat(sample.ClassificationLabel(1:sample_sz));


% Read the observations.
for i = 1:sample_sz
    fname = sample.FileName(i);
    data = getDataFromFile(fname{1}, sample_time);
    arrhythmia_set.xs(i,:) = data(1);
end

data = struct2table(arrhythmia_set);
save(arrhythmia_file, 'data');