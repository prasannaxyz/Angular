angular.module("myModule",[]).controller("myController",function($scope,$http,$log){


	$http.get("service/EmployeeService/employeesList").then(
			function(response) {				
				$scope.employees  = response.data;
				//Used to print messages on the console
				$log.info(response);				
			});
	$scope.employeeView="EmployeeTable.html";
	
});
