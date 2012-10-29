// This file was automatically generated from description.soy.
// Please don't edit this file by hand.

if (typeof bgm == 'undefined') { var bgm = {}; }
if (typeof bgm.hml == 'undefined') { bgm.hml = {}; }
if (typeof bgm.hml.hangout == 'undefined') { bgm.hml.hangout = {}; }
if (typeof bgm.hml.hangout.cards == 'undefined') { bgm.hml.hangout.cards = {}; }


bgm.hml.hangout.cards.description = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  switch (opt_data.set) {
    case 'base':
      bgm.hml.hangout.cards.base.description(opt_data, output);
      break;
  }
  return opt_sb ? '' : output.toString();
};
