'use strict';

/**
 * @ngdoc function
 * @name ClientApp.controller:EBooksCtrl
 * @description
 * # EBooksCtrl
 * Controller of the ClientApp
 */

ClientApp.controller('EBooksCtrl', ['$scope', 'Restangular', '$uibModal', '$log', '_',
                                function($scope, Restangular, $uibModal, $log, _) {

    //Restangular koristimo za rest pozive
	
	//eBooks
    Restangular.all("ebooks").getList().then(function(entries) {
      $scope.ebooks = entries;
      check(entries);
    });
    //Categories
    Restangular.all("categories").getList().then(function(entries) {
      $scope.categories = entries;
      check(entries);
    });
    
    
  }]);

