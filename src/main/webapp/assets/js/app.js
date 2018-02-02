var app = angular.module('app',['ngRoute']);

app.directive('greeting',function () {
  return {
    restrict: 'C',
    link: function () {
      alert('Hey Yo!');
    }
  }
});

app.factory('bfsDataService', function ($http) {
  return {
    checkStatus: function () {
      return $http.get('/db/checkStatus')
          .then(function (value) {
            return value.data;
          });
    }
  }
});

app.controller('bfsDataController', function ($scope, bfsDataService) {
  var self = this;
  bfsDataService.checkStatus().then(function (value) {
    $scope.dbStatus = value;
  });

  self.getDbStatus = function () {
    console.log('checking status');
    bfsDataService.checkStatus();
  }

});