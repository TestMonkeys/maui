var hash = {};
styleArgs = window.getComputedStyle(arguments[0], null);
var len = styleArgs.length;
for (var i = 0; i < len; i++) {
    var style = styleArgs[i];
    hash[style] = styleArgs.getPropertyValue(style);
}
return hash;