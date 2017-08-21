var app = angular.module('app',['ngRoute']);

app.directive('greeting',function () {
  return {
    restrict: 'A',
    link: function () {
      alert('Hey Yo!');
    }
  }
});