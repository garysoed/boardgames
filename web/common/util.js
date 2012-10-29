var bgm = bgm || { };

bgm.namespace = function(namespace) {
  var parts = namespace.split('.');
  var outerPart = window;
  for (var i in parts) {
    outerPart[parts[i]] = outerPart[parts[i]] || { };
    outerPart = outerPart[parts[i]];
  }
};

bgm.vertCenter = function(jQueryElement, height) {
  var floater = $(document.createElement('div'))
      .css({
        'float': 'left',
        'height': '50%',
        'width': '100%',
        'margin-bottom': height / -2 + 'px'
      });
  
  jQueryElement
      .css({
        clear: 'both',
        height: height + 'px',
        position: 'relative',
      })
      .wrap(floater);
};
