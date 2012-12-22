/**
 * Represents a collection of cards with random access
 */
goog.provide('bgm.hml.Hand');

goog.require('bgm.hml.Card');
goog.require('bgm.hml.storage.client');

bgm.hml.Hand = function(id) {
  this.id = id;

  this.add = function(cardKey) {
    $('#' + id).append(new bgm.hml.Card.render(cardKey));
  };
};
