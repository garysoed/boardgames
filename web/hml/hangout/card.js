bgm.namespace("bgm.hml.hangout.Card")

bgm.hml.hangout.Card = function(name, types, set, requirement, copies) {
  this.name = name;
  this.types = types;
  this.set = set;
  this.requirement = requirement;
  this.copies = copies;
};

bgm.hml.hangout.Card.Requirement = function(count, resourceType) {
  this.count = count;
  this.resourceType = resourceType;
};

bgm.hml.hangout.Card.entity = function(card) {
  var element = $(bgm.hml.hangout.cardEntity({ card: card }));
  $(element).hover(
    function() { // Handler in
      bgm.hml.hangout.showCardZoom(card);
    },
    function() { // Handler out
      bgm.hml.hangout.showCardZoom(null);
    }
  );
  return element;
};
