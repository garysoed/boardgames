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

    var renderedCard = new bgm.hml.Card.render(
        bgm.hml.data.card.base.banana);
    $('#hand').append(renderedCard);
  });
}

