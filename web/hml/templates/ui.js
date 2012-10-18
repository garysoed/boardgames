// This file was automatically generated from ui.soy.
// Please don't edit this file by hand.

if (typeof bgm == 'undefined') { var bgm = {}; }
if (typeof bgm.hml == 'undefined') { bgm.hml = {}; }
if (typeof bgm.hml.hangout == 'undefined') { bgm.hml.hangout = {}; }
if (typeof bgm.hml.hangout.ui == 'undefined') { bgm.hml.hangout.ui = {}; }


bgm.hml.hangout.ui.globalinfo = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('Turn ', soy.$$escapeHtml(opt_data.turn), ' of ', soy.$$escapeHtml(opt_data.totalTurn));
  return opt_sb ? '' : output.toString();
};
