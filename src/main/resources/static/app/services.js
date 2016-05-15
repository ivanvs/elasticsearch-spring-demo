  angular.module("myApp").factory("TweetServices", ["$http", function($http) {
  var url = "http://localhost:8080/tweets";
  
  var searchSql = function(query) {
	  var request = {query: query};
	  
	  return $http.post('http://localhost:8080/tweets/sql', request).then(function(data) {
		  return data.data;
	  });
  };
  
  var searchEs = function(query) {
	  var request = {query: query};
	  return $http.post('http://localhost:8080/tweets/es', request).then(function(data) {
			  return data.data.content;
		  });
	  };
	  
	  return {
		searchSql: searchSql,
		searchEs: searchEs
	  };
  }]);