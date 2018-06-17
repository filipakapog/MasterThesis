% Computes the features of an image with blood vessels
function feature = computeFeatures(skelImage, binaryImage)
    edtImage = bwdist(~binaryImage);
    radiuses = edtImage(skelImage);
    
    xs = 1:size(radiuses,1);
    ys = radiuses.';
    figure, plot(xs, ys)
    
    feature.rMin = min(radiuses);
    
    % We compute the area under the curve as a ratio from the area
    % described by the enclosing rectangle. The rectangle will be defined 
    % based on max radius and length of the skeleton.
    areaRadiues = trapz(xs, ys);
    areaRectangle = max(radiuses) * size(radiuses,1);
    feature.areaRatio = areaRadiues / areaRectangle;
    
    [r c] = size(binaryImage);
    nrWhitePxs = sum(binaryImage(:));
    feature.pxRadio =  nrWhitePxs / (r * c); 
end