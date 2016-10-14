/*var myApp=angular.module("myModule",[]);
var myController=function($scope,$http){
	$http.get("service/beneficiary/getbeneficiarydetails").then(function(response){
		$scope.beneficiaries=response.data;
	});
}
myApp.controller("myController", myController);(OR)*/

angular.module("myModule", []).controller("myController",function($scope, $http) {
			$http.get("service/beneficiary/getbeneficiarydetails").then(
					function(response) {
						$scope.beneficiaries = response.data;
						$scope.sortColumn="beneficiaryName";
						$scope.sortOrder=false;
						$scope.sortData=function(column){
							
							$scope.sortOrder=(column==$scope.sortColumn)?!$scope.sortOrder:false;
							//alert($scope.sortOrder);
							$scope.sortColumn=column;
							//alert($scope.sortColumn);
						}
						
					});
			
		});
