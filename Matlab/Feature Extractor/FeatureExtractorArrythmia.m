classdef FeatureExtractorArrythmia
    %FEATUREEXTRACTORARRYTHMIA Summary of this class goes here
    %   Detailed explanation goes here
    
    properties
        ecg_file
    end
    
    methods
        function extractor = FeatureExtractorArrythmia( ecg_file )
            if nargin > 0
                if ischar(ecg_file)
                    extractor.ecg_file = ecg_file;
                else
                    error('Value must be char')
                end
            end
        end
    
        function features = compute( obj )
            [tm,ecg,fs,siginfo] = rdmat(obj.ecg_file);
            [QRS,sign,en_thres] = qrs_detect2(ecg',0.25,0.6,fs);
            RR=diff(QRS')/fs;
            AFEv = comput_AFEv(RR);
            features = [AFEv, sign, en_thres];
        end
    end
end
