/**
 * Contains functions to manage card data
 */
goog.provide('bgm.hml.CardData');

goog.require('bgm.hml.ui');

bgm.hml.CardData = function(name, types, set, requirement, copies) {
  this.name = name;
  this.types = types;
  this.set = set;
  this.requirement = requirement;
  this.copies = copies;
};

/**
 * Creates bgm.hml.CardData objects from provided data. Data provided is a
 * mapping of card set name to an array of card data. A card data is a mapping
 * of card name to an object containing types, requirement, and copies.
 * So:
 * { setName =>
 *     { cardName => { type, requirement, copies } } }
 */
bgm.hml.CardData.compile = function(dataSets) {
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

