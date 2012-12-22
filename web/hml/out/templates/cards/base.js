// This file was automatically generated from base.soy.
// Please don't edit this file by hand.

goog.provide('bgm.hml.ui.cards.base');

goog.require('soy');
goog.require('soy.StringBuilder');


bgm.hml.ui.cards.base.description = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  switch (opt_data.name) {
    case 'banana':
      output.append('Gains 2 <div class="resource-energy"></div>');
      break;
    case 'sad-memory':
      output.append('When you draw this, discard this card.');
      break;
  }
  return opt_sb ? '' : output.toString();
};
