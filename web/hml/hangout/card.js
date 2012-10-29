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
