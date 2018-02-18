% Extracts a geature of the blood vessels base on formula
% Q = (Area_max - Area_min) / Area_min
% Area = pi * radius ^ 2

%% Features for normal blood vessels
featuresForNorm = zeros(1, 20);
for k = 1:20
    binaryImage = imagesBWNorm{k};
    edtImage = 2 * bwdist(~binaryImage);

    skelImage = bwmorph(binaryImage, 'skel', inf);
    skelImage = bwmorph(skelImage, 'spur', 15);
    
    radiuses = edtImage(skelImage);
    minArea = pi * pow2(min(radiuses));
    maxArea = pi * pow2(max(radiuses));
    Q = (maxArea - minArea) / minArea;
    featuresForNorm(k) = Q;
end
display(featuresForNorm)

%% Features for sten blood vessels
featuresForSten = zeros(1, 20);
for k = 1:1
    binaryImage = imagesBWSten{k};
    edtImage = 2 * bwdist(~binaryImage);
    figure, imshow(binaryImage);

    skelImage = bwmorph(binaryImage, 'skel', inf);
    skelImage = bwmorph(skelImage, 'spur', 15);
    figure, imshow(skelImage);
    
    radiuses = edtImage(skelImage);
    figure, plot(radiuses);
    minArea = pi * pow2(min(radiuses));
    maxArea = pi * pow2(max(radiuses));
    Q = (maxArea - minArea) / minArea;
    featuresForSten(k) = Q;
end
display(featuresForSten)


%% show all Sten images
for k = 1:20
    figure;
    
    binaryImage = imagesBWSten{k};
    subplot(2, 1, 1), imshow(binaryImage);
    
    skelImage = bwmorph(binaryImage, 'skel', inf);
    skelImage = bwmorph(skelImage, 'spur', 15);
    subplot(2, 1, 2), imshow(skelImage);
end
