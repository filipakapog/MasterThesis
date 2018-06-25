% Dirs
home_dir    = 'D:\Dropbox\Master\Disertatie\Code\MasterThesis\Matlab\';
data_dir    = [home_dir 'Data\'];
helpers_dir = [home_dir 'Helpers'];
fe_dir      = [home_dir 'Feature Extractor'];
sample_dir  = [home_dir 'Demo Code\Physionet\ECG\sample2017\'];
valid_dir   = [sample_dir 'validation\'];

% Files
stenosis_file           = [data_dir 'classification_data.mat'];
arrhythmia_data_file    = [data_dir 'arrhythmia_data.mat'];

addpath(home_dir, data_dir, helpers_dir, fe_dir, sample_dir, valid_dir);
