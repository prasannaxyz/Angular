angular.module("myModule",["ngRoute"]).config(function($routeProvider){
	
	$routeProvider.when("/employeesTable",{
		templateUrl:"EmployeeTable.html",
	    controller:"employeeController"
	}).when("/employeesList",{
		templateUrl:"EmployeeList.html",
	    controller:"employeeController"
	}).when("/home",{
		templateUrl:"home.html",
	}).when("/employees",{
		templateUrl:"EmployeeNames.html",
		controller:"employeeController"
	}).when("/employees/:id/:name",{
		templateUrl:"EmployeeDetails.html",
		controller:"employeeDetailController"
	}).otherwise({
		redirectTo:"/home"
	})
	
}).controller("employeeDetailController",function($scope,$http,$routeParams){
	$http({
		url:"service/EmployeeService/empDetails/"+$routeParams.id+"/"+$routeParams.name,	
		//params:{id:$routeParams.id,name:$routeParams.name},
		method:"get"
		
	}).then(function(response){
		$scope.employee=response.data;
	});
		
}).controller("employeeController",function($scope,$http){
	$http.get("service/EmployeeService/employeesList").then(
			function(response) {				
				$scope.employees  = response.data;
								
			});
		
}).controller("myController",
		function($scope){
	$scope.header="Website Header";
	$scope.footer="Website Footer";
});