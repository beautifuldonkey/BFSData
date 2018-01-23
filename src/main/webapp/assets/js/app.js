var app = angular.module('app',['ngRoute']);

// app.directive('greeting',function () {
//   return {
//     restrict: 'C',
//     link: function () {
//       alert('Hey Yo!');
//     }
//   }
// });

app.factory('bfsDataService', function ($http) {
  return {
    checkStatus: function () {
      debugger;
      return $http.get('/main/db/checkStatus')
          .then(function (value) {
            debugger;
            return value.data;
          });
    }
  }
});

app.controller('bfsDataController', function ($scope, bfsDataService) {
  var self = this;
  bfsDataService.checkStatus().then(function (value) {
    debugger;
    $scope.dbStatus = value;
  });

  self.getDbStatus = function () {
    debugger;
    console.log('checking status');
    bfsDataService.checkStatus();
  }

});