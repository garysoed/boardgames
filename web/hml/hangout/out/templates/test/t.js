// This file was automatically generated from t.soy.
// Please don't edit this file by hand.

goog.provide('bgm.hml.hangout.ui');

goog.require('soy');
goog.require('soy.StringBuilder');


bgm.hml.hangout.ui.test = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('Turn ', soy.$$escapeHtml(opt_data.turn), ' of ', soy.$$escapeHtml(opt_data.totalTurn));
  return opt_sb ? '' : output.toString();
};
