function pixeliZedScratchPad = plotCoordinatesToImagePixels(x_coordinates, y_coordinates, pixeliZedScratchPad)
%PLOTCOORDINATESTOIMAGEPIXELS 
[r,c]=size(pixeliZedScratchPad);
pixeliZedScratchPad=zeros(r,c);
numberOfPoints = length(x_coordinates);
% make into an image by pixelization the coordinates 1st
x_min = min(x_coordinates);
x_max = max(x_coordinates);
y_min = min(y_coordinates);
y_max = max(y_coordinates);


unpixelizedRange_x = linspace(x_min, x_max, r);
unpixelizedRange_y = linspace(y_min, y_max, c);

pixelized_x_range = 1:r;
pixelized_y_range = 1:c;

% pixelized the delineating cooridinates
for i = 1:numberOfPoints      
        distances = abs(x_coordinates(i) - unpixelizedRange_x); % find closest distance
        min_distanceIndex = find(min(distances) == distances);
        min_distanceIndexFor_x(i) = min_distanceIndex(1,1); % if there is more than 1, choose 1
        
        distances = abs(y_coordinates(i) - unpixelizedRange_y); % find closest distance
        min_distanceIndex = find(min(distances) == distances);
        min_distanceIndexFor_y(i) = min_distanceIndex(1,1); % if there is more than 1, choose 1
end    

increasedNumberOfPoints = numberOfPoints; % in the case that the points are sufficient
        
% mark the delineating pixels
for i = 1:increasedNumberOfPoints 
    pixeliZedScratchPad(min_distanceIndexFor_x(i), min_distanceIndexFor_y(i)) = 1;
end


% pixeliZedScratchPad(min_distanceIndexFor_Centroid_x0, min_distanceIndexFor_Centroid_y0) = 1; % mark the centroid pixel
% pixeliZedScratchPad(min_distanceIndexFor_x0, min_distanceIndexFor_y0) = 1; % mark the centre pixel relative to the plot

% % invert it
% pixeliZedScratchPad = ~pixeliZedScratchPad;
% 
% % plot right side up
% pixeliZedScratchPad = pixeliZedScratchPad';
% pixeliZedScratchPad = flipud(pixeliZedScratchPad);


end

