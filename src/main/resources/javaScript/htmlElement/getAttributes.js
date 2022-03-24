function fun(element){
    var hash={};
    var atts=element.attributes;
    for (i = 0; i < atts.length; i++){
        var att = atts[i];
        hash[att.nodeName]=att.nodeValue;
    };
    return hash;
}
