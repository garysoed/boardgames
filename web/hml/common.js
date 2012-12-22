/**
 * Contains common functions for HML
 */
goog.provide('bgm.hml');

goog.require('bgm.hml.ui');

/**
 * Show card zoomed at the card zoom panel.
 * 
 * @param {bgm.hml.Card} card the card to be shown. Null to show the
 *     back size of the card.
 */
bgm.hml.showCardZoom = function(card) {
  var cardZoom = $(bgm.hml.ui.cardRender({ card: card }));
  $('#cardinfo').html(cardZoom);
};
