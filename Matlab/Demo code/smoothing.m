function s=smoothing(imagetosmooth)
    [r,c,p]=size(imagetosmooth);
    [x,y]=meshgrid(1:c,1:r);
    [xi,yi]=meshgrid(1:0.5:c,1:0.5:r);
    for k=1:3
        smh(:,:,k)=interp2(x,y,double(imagetosmooth(:,:,k)),xi,yi,'spline');
    end
    s=uint8(smh);
end