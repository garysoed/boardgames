// This file was automatically generated from ui.soy.
// Please don't edit this file by hand.

if (typeof bgm == 'undefined') { var bgm = {}; }
if (typeof bgm.hml == 'undefined') { bgm.hml = {}; }
if (typeof bgm.hml.hangout == 'undefined') { bgm.hml.hangout = {}; }
if (typeof bgm.hml.hangout.ui == 'undefined') { bgm.hml.hangout.ui = {}; }


bgm.hml.hangout.ui.cardZoom = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-container card-', soy.$$escapeHtml(opt_data.card.types[0]), '"><div class="card-info"><div class="card-name">', soy.$$escapeHtml(opt_data.card.name), '</div>');
  if (opt_data.card.requirement) {
    output.append('<div class="card-requirement">');
    bgm.hml.hangout.ui.cardRequirement(opt_data.card.requirement, output);
    output.append('</div>');
  }
  output.append('</div><div class="card-image card-image-', soy.$$escapeHtml(opt_data.card.name), '" /><div class="card-types">');
  bgm.hml.hangout.ui.cardTypes({types: opt_data.card.types}, output);
  output.append('</div><div class="card-description">');
  bgm.hml.hangout.cards.description({set: opt_data.card.set, name: opt_data.card.name}, output);
  output.append('</div><div class="card-info-bottom"><div class="card-copies">', soy.$$escapeHtml(opt_data.card.copies), ' copies</div><div class="card-happiness" /></div></div>');
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.ui.cardRequirement = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-requirement-count">', soy.$$escapeHtml(opt_data.requirement.count), '</div>');
  bgm.hml.hangout.ui.resource(opt_data.requirement.resource, output);
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.ui.cardTypes = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var typeList37 = opt_data.types;
  var typeListLen37 = typeList37.length;
  for (var typeIndex37 = 0; typeIndex37 < typeListLen37; typeIndex37++) {
    var typeData37 = typeList37[typeIndex37];
    output.append((! (typeIndex37 == 0)) ? ' - ' : '', soy.$$escapeHtml(typeData37));
  }
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.ui.resource = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="resource-', soy.$$escapeHtml(opt_data.resourceType), '"></div>');
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.ui.energy = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="resource-energy"></div>');
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.ui.globalInfo = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('Day ', soy.$$escapeHtml(opt_data.turn), ' of ', soy.$$escapeHtml(opt_data.totalTurn), ': ', soy.$$escapeHtml(opt_data.phase));
  return opt_sb ? '' : output.toString();
};
