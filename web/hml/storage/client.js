/**
 * Provides client for managing storage locally and globally. This provides an
 * abstraction from the implementation so it can be switched easily.
 */
goog.provides('bgm.hml.storage.client');

bgm.hml.storage.client._Client = function() { };

/**
 * Binds the local storage client to an implementation
 */
bgm.hml.storage.client._Client.bindTo = function(impl) {
  this.impl = impl;
};

bgm.hml.storage.client._Client.set = function(key, value) {
  if (!this.impl) {
    throw "impl not defined. Call bindTo first"
  }

  this.impl.set(key, value);
}

bgm.hml.storage.client._Client.get = function(key) {
  if (!this.impl) {
    throw "impl not defined. Call bindTo first"
  }

  return this.impl.get(key);
}

/**
 * Manages storage in the local browser
 */
bgm.hml.storage.client.Local = new bgm.hml.storage.client._Client();

/**
 * Manages storage that can be shared across network
 */
bgm.hml.storage.client.Global = new bgm.hml.storage.client._Client();
