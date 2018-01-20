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

    $.ajax({
      url: 'db/checkStatus',
      method: 'GET',
      contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
      success: function () {
        alert('success');
      },
      error: function () {
        alert('error');
      }
    });

  }
});