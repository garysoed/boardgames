goog.provide('bgm.hml.main');

goog.require('bgm.hml');
goog.require('bgm.hml.Card');
goog.require('bgm.hml.data.card.base');
goog.require('bgm.hml.GlobalInfo');

bgm.hml.main = function() {
  // Compile all the card data
  bgm.hml.compileCardData(bgm.hml.data.card);

  $(document).ready(function() {
    bgm.hml.GlobalInfo($('#globalinfo'));

    var renderedCard = bgm.hml.Card.render(
        bgm.hml.data.card.base.banana);
    $('#hand').append(renderedCard);
  });
}

// Ensures the symbol will be visible after compiler renaming.
goog.exportSymbol('bgm.hml.main', bgm.hml.main);
