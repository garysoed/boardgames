// This file was automatically generated from base.soy.
// Please don't edit this file by hand.

if (typeof bgm == 'undefined') { var bgm = {}; }
if (typeof bgm.hml == 'undefined') { bgm.hml = {}; }
if (typeof bgm.hml.hangout == 'undefined') { bgm.hml.hangout = {}; }
if (typeof bgm.hml.hangout.cards == 'undefined') { bgm.hml.hangout.cards = {}; }
if (typeof bgm.hml.hangout.cards.base == 'undefined') { bgm.hml.hangout.cards.base = {}; }


bgm.hml.hangout.cards.base.description = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  switch (opt_data.name) {
    case 'banana':
      output.append('Gains 2 <div class="resource-energy"></div>');
      break;
  }
  return opt_sb ? '' : output.toString();
};
