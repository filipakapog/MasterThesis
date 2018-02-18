%% detect radius for normal
meanDiameters = zeros(1, 20);
featuresForNorm = zeros(1, 20);
for k = 1:20
    binaryImage = imagesBWNorm{k};
    % Computes the double of the distance 
    % from each 1 pixel to each 0 pixel.
    % e.g. 
    % A =
    %   0     0     0     0
    %   0     0     0     1
    %   0     0     1     1
    %   1     1     1     0
    %   1     1     0     0
    %   0     0     0     0
    % -----------------------
    % We swich 0 to 1 in order to compute the distance,
    % because bwdist computes the distrance from a 0 value
    % pixel to the neareast 1 value pixel.
    % ~A =
    % 
    %      1     1     1     1
    %      1     1     1     0
    %      1     1     0     0
    %      0     0     0     1
    %      0     0     1     1
    %      1     1     1     1
    % --------------------------
    % Then we compute the distance.
    % bwdist(~A) =
    % 
    %     0     0     0     0
    %     0     0     0     1
    %     0     0     1     1
    %     1     1     1     0
    %     1     1     0     0
    %     0     0     0     0
    % -------------------------
    edtImage = bwdist(~binaryImage);

    skelImage = bwmorph(binaryImage, 'skel', inf); % nu prea inteleg
    skelImage = bwmorph(skelImage, 'spur', 15); % nu prea inteleg
    [labeledImage, numLines] = bwlabel(skelImage);
    
    meanRadius = mean(edtImage(skelImage));
    meanDiameters(k) = 2 * meanRadius;
end
display(meanDiameters)
display(featuresForNorm)

%% detect radius for sten
meanDiameters2 = zeros(1, 20);
featuresForSten = zeros(1, 20);
for k = 1:20
    binaryImage = imagesBWSten{k};
    edtImage = 2 * bwdist(~binaryImage);

    skelImage = bwmorph(binaryImage, 'skel', inf);
    skelImage = bwmorph(skelImage, 'spur', 15);
    [labeledImage, numLines] = bwlabel(skelImage);
    
    meanRadius = mean(edtImage(skelImage));
    meanDiameters2(k) = 2 * meanRadius;
end
display(meanDiameters2)
display(featuresForSten)

%% display stem
fileName = 'myfileNorm';
for k = 1:20
    binaryImage = imagesBWNorm{k};
    file = [fileName, int2str(k)];
   dlmwrite(file, binaryImage,'delimiter','\t')
end

