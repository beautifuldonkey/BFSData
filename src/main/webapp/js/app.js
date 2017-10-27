var app = angular.module('app',['ngRoute']);

app.directive('greeting',function () {
  return {
    restrict: 'C',
    link: function () {
      alert('Hey Yo!');
    }
  }
})

.controller('database',function () {
  var self = this;

  self.checkStatus = function () {
    alert('Checking status');
  }
});