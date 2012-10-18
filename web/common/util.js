var bgm = bgm || { };

bgm.namespace = function(namespace) {
  var parts = namespace.split(".");
  var outerPart = window;
  for (var i in parts) {
    outerPart[parts[i]] = outerPart[parts[i]] || { };
    outerPart = outerPart[parts[i]];
  }
};
