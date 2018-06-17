%% Extracts the features
%% MAIN PROGRAM
%% Loading data
load('Data\classification_data.mat')

close all
for k=1:1
	% Load stenoses binay image
    binaryImage = imagesBWSten{k};
   
    % Compute the skelimage (contains all centerlines)
    skelImage = bwmorph(binaryImage, 'skel', inf);
    skelImage = bwmorph(skelImage, 'spur', 15);
    skelImage = bwmorph(skelImage, 'thin', 1);
    
    % Label the discovered centerlines
    [~, numCenterlines] = bwlabel(skelImage);
    
    % If we have a blood vessel with stenosis
    if numCenterlines > 2
        % We need to keep only the relevant centerlines
        skelImage = keepRelevantCenterline(skelImage, binaryImage);
        figure, imshow(skelImage)
    end
    
    % DEBUG
    figure,
    subplot(2,2,[1 2]), imshow(binaryImage), title('Blood vessel binary image');
    subplot(2,2,3), imshow(skelImage), title('Broken skeleton of the blood vesel');
    % DEBUG
    
    [~, numCenterlines] = bwlabel(skelImage);
    if numCenterlines == 2
        % We need to connect the relevant centerline which
        % is broken in two centerlines
        skelImage = reconstructCenterline(skelImage);    
    end
    
    % DEBUG
    subplot(2,2,4), imshow(skelImage), title('Skeleton after interpolation');
    % DEBUG
    
    branchPointsImage = bwmorph(skelImage, 'branchpoints');
    [yBP, xBP] = find(branchPointsImage);
    
    nrOfBranches = any(sum(branchPointsImage));
%     if nrOfBranches == 1
%         display('branchpoint')
%         skelImageWithoutBP = skelImage;
%         endpointsImage = bwmorph(skelImage, 'endpoints');
%         
%         skelImageWithoutBP(yBP, xBP) = 0;
%         figure, imshow(skelImage);
%         
%         skelImageWithoutBP(yBP, xBP + 1) = 0;
%         skelImageWithoutBP(yBP, xBP - 1) = 0;
%         skelImageWithoutBP(yBP + 1, xBP) = 0;
%         skelImageWithoutBP(yBP - 1, xBP) = 0;
%         skelImageWithoutBP(yBP + 1, xBP + 1) = 0;
%         skelImageWithoutBP(yBP + 1, xBP - 1) = 0;
%         skelImageWithoutBP(yBP - 1, xBP + 1) = 0;
%         skelImageWithoutBP(yBP - 1, xBP - 1) = 0;
%         figure, imshow(skelImageWithoutBP);
%         [~, paths] = bwlabel(skelImageWithoutBP);     
%     elseif nrOfBranches > 1
%         display('branchpoints')
%     else
%         features(k) = computeFeatures(skelImage, binaryImage);
%     end
end