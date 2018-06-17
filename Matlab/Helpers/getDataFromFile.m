function [ result ] = getDataFromFile( fname, sample_time )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
    result = ones(1,sample_time);
    rawData = struct2array(load(fname));
    size = min(sample_time,length(rawData));
    
    result = rawData(1:size);
end

    