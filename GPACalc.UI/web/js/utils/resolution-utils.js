/**
 * Resolution / aspect ratio detection
 */
var res = {};

res.ratioNames = ['16:9', '16:10', '3:2', '4:3', '1:1', '4:3', '3:2', '16:10', '16:9'];
res.ratioValues = [1.77, 1.6, 1.5, 1.33, 1, 0.75, 0.66, 0.625, 0.56];

/**
 * Update detected layout.
 */
res.updateLayout = function ()
{
    res.width = $(window).width();
    res.height = $(window).height();
    res.currentRatioFloat = res.width / res.height;
    res.matchedRatioFloat = parseFloat(closest(res.currentRatioFloat, res.ratioValues));
    res.matchedRatio = res.ratioNames[res.ratioValues.indexOf(res.matchedRatioFloat)];
    res.orientation = res.matchedRatioFloat === 1 ? 'square' : res.matchedRatioFloat > 1 ? 'landscape' : 'portrait';
};

/**
 * Update layout on window resize.
 */
$(window).resize(res.updateLayout());
res.updateLayout();