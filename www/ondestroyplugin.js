module.exports = function() {

  exports.startService = function(title, description) {
    cordova.exec(undefined, undefined, "OnDestroyPlugin", "startService", [title, description]);
  };

  return exports
}();
