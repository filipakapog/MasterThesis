function rez = reconstructCenterline(skelImage)
%     [y, x] = find(skelImage == 1);
% 
%     % Determine the unique values from array x
%     % e.g. 
%     %     if we have 
%     %         x = [21, 24, 25, 26, 26, 30]
%     %     We want to find the idices of unique values:
%     %         unqXIds = [1, 2, 3, 4, 6]
%     unqX = unique(x);
%     [~, unqXIds] = ismember(unqX, x, 'R2012a');

%     % Try to interpolate the missing values
%     xx = x(1):x(end);
%     yy = pchip(x(unqXIds).', y(unqXIds).', xx);
    
    [yEP, xEP] = computeEndpoints(skelImage);
    
    rez = func_DrawLine(skelImage, yEP(1),xEP(1),yEP(2), xEP(2), 1);

%     yy = int8(yy);
%     xx = int8(xx);
% 
%     for j=1:size(xx,2)
%         skelImage(yy(j), xx(j)) = 1;
%     end
%     rez = skelImage;
end