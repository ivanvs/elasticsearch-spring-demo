
  angular.module("myApp").controller("AppController", 
		  ["$scope", "TweetServices", function($scope, TweetServices) {
	    $scope.vm = {};
	    $scope.vm.query = "";
	    $scope.vm.selectedDb = "sql";
	    $scope.vm.tweets = [];
	    
	    $scope.search = function() {
	    	if ($scope.vm.selectedDb === "sql") {
	    		TweetServices.searchSql($scope.vm.query).then(function(results) {
	    			$scope.vm.tweets = results;
	    		}, function() {
	    			$scope.vm.tweets = [];
	    		});
	    	} else {
	    		TweetServices.searchEs($scope.vm.query).then(function(results) {
	    			$scope.vm.tweets = results;
	    		}, function() {
	    			$scope.vm.tweets = [];
	    		});
	    	}
	    };
  }]);