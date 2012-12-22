/**
 * Simple implementation of storage system. This only works locally.
 */
goog.provide('bgm.hml.storage.impl.Simple');

bgm.hml.storage.impl.Simple = { };

bgm.hml.storage.impl.Simple.data = { };

bgm.hml.storage.impl.Simple.get = function(key) {
  return this.data[key];
}

bgm.hml.storage.impl.Simple.set = function(key, value) {
  this.data[key] = value;
}
