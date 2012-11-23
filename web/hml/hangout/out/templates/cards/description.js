// This file was automatically generated from description.soy.
// Please don't edit this file by hand.

goog.provide('bgm.hml.ui.cards');

goog.require('soy');
goog.require('soy.StringBuilder');
goog.require('bgm.hml.ui.cards.base');


bgm.hml.ui.cards.description = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  switch (opt_data.set) {
    case 'base':
      bgm.hml.ui.cards.base.description(opt_data, output);
      break;
  }
  return opt_sb ? '' : output.toString();
};
