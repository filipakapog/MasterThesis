function rez = keepRelevantCenterline(skelImage, binaryImage)
    [labeledImage, numCenterlines] = bwlabel(skelImage);

    % Select the computed distances which are on the centerline
    maxRadiuses = zeros(1, numCenterlines);
    for k=1:numCenterlines
        edtImage = bwdist(~binaryImage);
        radiuses = edtImage(labeledImage == k);
        maxRadiuses(k) = max(radiuses);
    end

    % Eliminate centerline which is not principal
    meanMaxRadiuses = mean(maxRadiuses);
    labels = find(maxRadiuses < meanMaxRadiuses);
    sz = size(labels);
    for k=1:sz(2)
        [row, col] = find(labeledImage == labels(k));
        skelImage(row, col) = 0;
    end
    
    rez = skelImage;
end