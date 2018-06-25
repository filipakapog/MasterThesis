function [ data ] = generateArrhythmiaDataSet( sample_sz, refs_dir )
%GENERATEARRHYTHMIA Summary of this function goes here
%   Detailed explanation goes here

    % Read the labels.
    refs = readtable([refs_dir 'REFERENCE.csv'],'ReadVariableNames',false);
    refs.Properties.VariableNames = {'FileName','ClassificationLabel'};

    work_sample_sz = min(sample_sz, length(refs.FileName));
    
    sample = datasample(refs, work_sample_sz);

    arrhythmia_set.xs = ones(work_sample_sz, 3);
    arrhythmia_set.ys = cell2mat(sample.ClassificationLabel(1:work_sample_sz));

    % Read the observations.
    for i = 1:work_sample_sz
        fname = sample.FileName(i);
        extractor = FeatureExtractorArrythmia(fname{1});
        arrhythmia_set.xs(i,:) = extractor.compute();
    end

    data = struct2table(arrhythmia_set);
end

