goog.provide('bgm.hml.main');

goog.require('bgm.hml.data.card.base');
goog.require('bgm.hml.CardData');
goog.require('bgm.hml.GlobalInfo');
goog.require('bgm.hml.Hand');

bgm.hml.main = function() {
  // Compile all the card data
  bgm.hml.CardData.compile(bgm.hml.data.card);

  $(document).ready(function() {
    bgm.hml.GlobalInfo($('#globalinfo'));
    var hand = new bgm.hml.Hand('hand');
    hand.add(bgm.hml.data.card.base.banana);
  });
}

