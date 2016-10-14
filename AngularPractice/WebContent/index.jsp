<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/angular.min.js"></script>
<title>AngularJS Practice</title>
</head>
<body>
 
 <div ng-app="">
  <input type="number" placeholder="product" ng-model="product" /><br/>
  <input type="number" placeholder="price" ng-model="price"/><br/>
  
  <span>Total Price:{{product*price | currency}}</span>
  </div>
</body>
</html>