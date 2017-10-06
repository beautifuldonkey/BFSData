var app = angular.module('app',['ngRoute']);

app.directive('greeting',function () {
  return {
    restrict: 'C',
    link: function () {
      alert('Hey Yo!');
    }
  }
});