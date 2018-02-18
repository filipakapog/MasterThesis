%% Extracts the features

for k=1
	% computes centerline
    binaryImage = imagesBWSten{k};
    skelImage = bwmorph(binaryImage, 'skel', inf); % nu prea inteleg
    skelImage = bwmorph(skelImage, 'spur', 15); % nu prea inteleg
    
    % Label the discovered centerlines
    [labeledImage, numCenterlines] = bwlabel(skelImage);
    
    if numCenterlines > 2
        % We need to only the relevant centerline
        skelImage = keepRelevantCenterline(skelImage, binaryImage); 
    end
    
    [labeledImage, numCenterlines] = bwlabel(skelImage);
    if numCenterlines == 2
        % We need to connect the relevant centerline which
        % is broken in two centerlines
%         skelImage = reconstructCenterline(skelImage);

        [y, x] = find(skelImage == 1);

        % determine the unique values from array x
        % e.g. 
        %     if we have 
        %         x = [21, 24, 25, 26, 26, 30]
        %     We want to find the idices of unique values:
        %         pozs = [1, 2, 3, 4, 5]
        notRepeating = x(diff(x) >= 1);
        [member, pozs] = ismember(int8(notRepeating), int8(x));
        
        % determine the position from where we have a discontinuity in the
        % skeleton
        notConsecutive = diff(x) > 1;
        poz = find(x == x(notConsecutive));
        
        % try to interpolate the missing values
        missingXValues = x(poz):1:x(poz + 1) - 1;

skelImage1 = func_DrawLine(skelImage, y(poz-1),x(poz-1),y(poz+1), x(poz+1), 1);
figure;imshow(skelImage1)
figure;imshow(skelImage)
missingXValues = x;
missingYValues = pchip(x(pozs), y(pozs), missingXValues);
hold on
plot(missingXValues,missingYValues)
    skelImage1=plotCoordinatesToImagePixels(missingXValues, missingYValues,(skelImage));
%          for t=1:length(missingXValues)
%         skelImage(missingYValues(t),missingXValues(t)) = 1;
%     end

    end
%     % Display data
%     figure
%     subplot(2, 1, 1), imshow(binaryImage);  
%     subplot(2, 1, 2), imshow(skelImage);
end