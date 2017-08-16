function fun(element) {
    var hash = {};
    var styleArgs = window.getComputedStyle(element, null);
    var len = styleArgs.length;
    for (var i = 0; i < len; i++) {
        var style = styleArgs[i];
        hash[style] = styleArgs.getPropertyValue(style);
    }
    return hash;
}
