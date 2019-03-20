module.exports = function() {

  exports.startService = function() {
    cordova.exec(undefined, undefined, "OnDestroyPlugin", "startService", []);
  };

  return exports
}();
