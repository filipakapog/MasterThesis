clear all;
close all;
clc

stenosis_file   = [pwd filesep 'Data' filesep 'classification_data.mat'];
arrhythmia_file = [pwd filesep 'Data' filesep 'arrhythmia_data.mat'];

sf = load(stenosis_file);
af = load(arrhythmia_file);

