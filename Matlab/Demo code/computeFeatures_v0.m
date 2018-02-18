function feature = computeFeatures(skelImage, binaryImage)
    edtImage = bwdist(~binaryImage);
    radiuses = edtImage(skelImage);
    
    xs = 1:size(radiuses,1);
    ys = radiuses.';
    figure, plot(xs, ys)
    
    feature.rMin = min(radiuses);
    

    feature.areaRadiues = trapz(ys);
    
    [r c] = size(binaryImage);
    nrWhitePxs = sum(binaryImage(:));
    feature.pxRadio =  nrWhitePxs / (r * c); 
end