// This file was automatically generated from ui.soy.
// Please don't edit this file by hand.

if (typeof bgm == 'undefined') { var bgm = {}; }
if (typeof bgm.hml == 'undefined') { bgm.hml = {}; }
if (typeof bgm.hml.hangout == 'undefined') { bgm.hml.hangout = {}; }


bgm.hml.hangout.cardRender = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  if (opt_data.card) {
    bgm.hml.hangout.cardZoom(opt_data, output);
  } else {
    output.append('<div class="card-back" />');
  }
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.cardZoom = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-container card-', soy.$$escapeHtml(opt_data.card.types[0]), '"><div class="card-info"><div class="card-name">', soy.$$escapeHtml(opt_data.card.name), '</div>');
  if (opt_data.card.requirement) {
    output.append('<div class="card-requirement">');
    bgm.hml.hangout.cardRequirement(opt_data.card.requirement, output);
    output.append('</div>');
  }
  output.append('</div><div class="card-image card-image-', soy.$$escapeHtml(opt_data.card.name), '" /><div class="card-types">');
  bgm.hml.hangout.cardTypes({types: opt_data.card.types}, output);
  output.append('</div><div class="card-description">');
  bgm.hml.hangout.cards.description({set: opt_data.card.set, name: opt_data.card.name}, output);
  output.append('</div><div class="card-info-bottom"><div class="card-copies">', soy.$$escapeHtml(opt_data.card.copies), ' copies</div><div class="card-happiness" /></div></div>');
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.cardRequirement = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-requirement-count">', soy.$$escapeHtml(opt_data.requirement.count), '</div>');
  bgm.hml.hangout.resource(opt_data.requirement.resource, output);
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.cardTypes = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var typeList44 = opt_data.types;
  var typeListLen44 = typeList44.length;
  for (var typeIndex44 = 0; typeIndex44 < typeListLen44; typeIndex44++) {
    var typeData44 = typeList44[typeIndex44];
    output.append((! (typeIndex44 == 0)) ? ' - ' : '', soy.$$escapeHtml(typeData44));
  }
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.cardBack = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-back" />');
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.cardEntity = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-entity card-', soy.$$escapeHtml(opt_data.card.types[0]), '" />');
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.resource = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="resource-', soy.$$escapeHtml(opt_data.resourceType), '"></div>');
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.energy = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="resource-energy"></div>');
  return opt_sb ? '' : output.toString();
};


bgm.hml.hangout.globalInfo = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('Day ', soy.$$escapeHtml(opt_data.turn), ' of ', soy.$$escapeHtml(opt_data.totalTurn), ': ', soy.$$escapeHtml(opt_data.phase));
  return opt_sb ? '' : output.toString();
};
