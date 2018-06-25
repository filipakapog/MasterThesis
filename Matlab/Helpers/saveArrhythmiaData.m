function [] = saveArrhythmiaData( output_dirs )
    output_file = [output_dirs{1} 'arrhythmia_data.mat'];
    if exist(output_file, 'file') == 2
        delete(output_file);
    end

    data = generateArrhythmiaDataSet(100, output_dirs{2});
    save(output_file, 'data');
end