goog.provide('bgm.hml');

goog.require('bgm.hml.ui');

bgm.hml.CardData = function(name, types, set, requirement, copies) {
  this.name = name;
  this.types = types;
  this.set = set;
  this.requirement = requirement;
  this.copies = copies;
};

bgm.hml.compileCardData = function(dataSets) {
  for (var setName in dataSets) {
    var set = dataSets[setName];
    var compiledSet = {};
    for (var name in set) {
      var data = set[name];
      compiledSet[name] = new bgm.hml.CardData(
        name,
        data.types,
        set,
        data.requirement,
        data.copies);
    }
    dataSets[setName] = compiledSet;
  }
};

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
