/**
 * Contains global readonly variables. 
 */
bgm.namespace("bgm.hml.hangout.events");
bgm.hml.hangout.events.Global = { };

bgm.namespace("bgm.hml.hangout");
bgm.hml.hangout.ResourceType = {
  ENERGY: "energy",
};

bgm.hml.hangout.Phase = {
  DRAFT: "draft",
};

/**
 * Show card zoomed at the card zoom panel.
 * 
 * @param {bgm.hml.hangout.Card} card the card to be shown. Null to show the
 *     back size of the card.
 */
bgm.hml.hangout.showCardZoom = function(card) {
  var cardZoom = $(bgm.hml.hangout.cardRender({ card: card }));
  $('#cardinfo').html(cardZoom);
}
