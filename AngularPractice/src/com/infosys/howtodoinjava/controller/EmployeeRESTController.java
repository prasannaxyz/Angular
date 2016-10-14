package com.infosys.howtodoinjava.controller;

/*https://avaldes.com/restful-web-services-with-angularjs-bootstrap-and-java-using-jax-rs-and-jersey/
 */import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.infosys.vo.EmployeeVO;

@Path("employee")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class EmployeeRESTController {
	List<EmployeeVO> employeesList = new ArrayList<EmployeeVO>();

	public EmployeeRESTController() {
		System.out.println("Default Constructor");
		EmployeeVO empOne = new EmployeeVO(1, "Lokesh", "Gupta",
				"howtodoinjava@gmail.com");
		EmployeeVO empTwo = new EmployeeVO(2, "Amit", "Singhal",
				"asinghal@yahoo.com");
		EmployeeVO empThree = new EmployeeVO(3, "Kirti", "Mishra",
				"kmishra@gmail.com");

		employeesList.add(empOne);
		employeesList.add(empTwo);
		employeesList.add(empThree);
	}

	@GET
	@Path("All")
	public List<EmployeeVO> getAllEmployees() {
		//System.out.println("showing all employees");
		return employeesList;
	}

	@GET
	@Path("emp")
	public EmployeeVO getAllEmployee(@QueryParam("empId") int empId) {
		return employeesList.get(empId - 1);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String,String>  addEmployee(EmployeeVO emp) {
		Map<String,String> response=new HashMap<String, String>();
		//System.out.println(emp.getFirstName()+"  "+emp.getLastName()+"  "+emp.getEmail()+"   "+emp.getId());
		EmployeeVO empVO=new EmployeeVO();
		empVO.setId(employeesList.size()+1);
		empVO.setFirstName(emp.getFirstName());
		empVO.setLastName(emp.getLastName());
		empVO.setEmail(emp.getEmail());
		
		employeesList.add(empVO);
		response.put("statusCode", "200");
		response.put("message", "success");
		return response;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String,String> updateEmployee(EmployeeVO emp)
	{
		Map<String,String> response=new HashMap<String, String>();
		//System.out.println(emp.getFirstName() + "  " + emp.getLastName() + "  "+ emp.getEmail() + "   " + emp.getId());
		EmployeeVO empVO=employeesList.get(emp.getId()-1);
		empVO.setFirstName(emp.getFirstName());
		empVO.setLastName(emp.getLastName());
		empVO.setEmail(emp.getEmail());

		response.put("statusCode", "200");
		response.put("message", "success");
		return response;
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String,String> deleteEmployee(@PathParam("id") int id)
	{
		Map<String,String> response=new HashMap<String, String>();
		//System.out.println("emp Id:"+id+" to be deleted");
		employeesList.remove(id-1);
		response.put("statusCode", "200");
		response.put("message", "success");
		return response;
	}
	

}
