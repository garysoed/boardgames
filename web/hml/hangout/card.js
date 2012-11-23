goog.provide('bgm.hml.Card')

goog.require('bgm.hml.ui');

bgm.hml.Card.render = function(cardData) {
  var element = $(bgm.hml.ui.cardEntity({ card: cardData }));
  $(element).hover(
    function() { // Handler in
      bgm.hml.showCardZoom(cardData);
    },
    function() { // Handler out
      bgm.hml.showCardZoom(null);
    }
  );
  return element;
};
