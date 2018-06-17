function [yEP xEP] = computeEndpoints(skelImage)
    [y, x] = find(bwmorph(skelImage, 'endpoints'));
    
    if issorted(x)
        chosen = x;
    elseif issorted(y)
        chosen = y;
    else
        error(message('MATLAB:computeEndpoints: not sorted x or y'))
    end
    
    szX = numel(x);
    % We compute the distances between the values in chosen.
    df = diff(chosen);
    if szX < 3
       % We need to have at least 3 values in x.
       error(message('MATLAB:computeEndpoints:Too few points for x'))
    else
        idMax = find(df == max(df));
        if idMax == 1
            s = 1;
            e = 2;
        elseif idMax == numel(df)
            % it is the last element
            s = szX - 1;
            e = szX;
        else
            % it is middle
            c1 = chosen(idMax);     % left
            c2 = chosen(idMax + 1); % the max value
            c3 = chosen(idMax + 2); % right
            leftDf = abs(c2 - c1);
            rightDf = abs(c2 - c3);
            
            maxVal = max(leftDf, rightDf);
            
            if maxVal == leftDf
                s = idMax;
                e = idMax + 1;
            else
                s = idMax + 1;
                e = idMax + 2;
            end
        end
        % the endpoints are: the one with the distance between consecutive
        % elements and the one which is the closest to this one.
    end
    
   xEP(1) = x(s);
   xEP(2) = x(e);
   yEP(1) = y(s);
   yEP(2) = y(e);
    
        
        
%         if df(1) == 1
%             % We are in situation [3 4 20].
%             xEP = x(2:3);
%             yEP = y(2:3);
%         else
%             % We are in situation [3 21 22] or in situation [3 4 5].
%             xEP = x(1:2);
%             yEP = y(1:2);
%         end
%     elseif szX < 5
%         xEP = x(2:3);
%         yEP = y(2:3);
%     else
%        % Don't know a better solution for now
%        xEP = x(2:3);
%        yEP = y(2:3);
%     end
end