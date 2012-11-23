// This file was automatically generated from ui.soy.
// Please don't edit this file by hand.

goog.provide('bgm.hml.ui');

goog.require('soy');
goog.require('soy.StringBuilder');
goog.require('bgm.hml.ui.cards');


bgm.hml.ui.cardRender = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  if (opt_data.card) {
    bgm.hml.ui.cardZoom(opt_data, output);
  } else {
    output.append('<div class="card-back" />');
  }
  return opt_sb ? '' : output.toString();
};


bgm.hml.ui.cardZoom = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-container card-', soy.$$escapeHtml(opt_data.card.types[0]), '"><div class="card-info"><div class="card-name">', soy.$$escapeHtml(opt_data.card.name), '</div>');
  if (opt_data.card.requirement) {
    output.append('<div class="card-requirement">');
    bgm.hml.ui.cardRequirement(opt_data.card.requirement, output);
    output.append('</div>');
  }
  output.append('</div><div class="card-image card-image-', soy.$$escapeHtml(opt_data.card.name), '" /><div class="card-types">');
  bgm.hml.ui.cardTypes({types: opt_data.card.types}, output);
  output.append('</div><div class="card-description">');
  bgm.hml.ui.cards.description({set: opt_data.card.set, name: opt_data.card.name}, output);
  output.append('</div><div class="card-info-bottom"><div class="card-copies">', soy.$$escapeHtml(opt_data.card.copies), ' copies</div><div class="card-happiness" /></div></div>');
  return opt_sb ? '' : output.toString();
};


bgm.hml.ui.cardRequirement = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-requirement-count">', soy.$$escapeHtml(opt_data.requirement.count), '</div>');
  bgm.hml.ui.resource(opt_data.requirement.resource, output);
  return opt_sb ? '' : output.toString();
};


bgm.hml.ui.cardTypes = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var typeList44 = opt_data.types;
  var typeListLen44 = typeList44.length;
  for (var typeIndex44 = 0; typeIndex44 < typeListLen44; typeIndex44++) {
    var typeData44 = typeList44[typeIndex44];
    output.append((! (typeIndex44 == 0)) ? ' - ' : '', soy.$$escapeHtml(typeData44));
  }
  return opt_sb ? '' : output.toString();
};


bgm.hml.ui.cardBack = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-back" />');
  return opt_sb ? '' : output.toString();
};


bgm.hml.ui.cardEntity = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="card-entity card-', soy.$$escapeHtml(opt_data.card.types[0]), '" />');
  return opt_sb ? '' : output.toString();
};


bgm.hml.ui.resource = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="resource-', soy.$$escapeHtml(opt_data.resourceType), '"></div>');
  return opt_sb ? '' : output.toString();
};


bgm.hml.ui.energy = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="resource-energy"></div>');
  return opt_sb ? '' : output.toString();
};


bgm.hml.ui.globalInfo = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('Day ', soy.$$escapeHtml(opt_data.turn), ' of ', soy.$$escapeHtml(opt_data.totalTurn), ': ', soy.$$escapeHtml(opt_data.phase));
  return opt_sb ? '' : output.toString();
};
