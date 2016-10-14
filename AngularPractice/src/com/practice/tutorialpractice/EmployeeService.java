package com.practice.tutorialpractice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("EmployeeService")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class EmployeeService {
	@GET
	@Path("employeesList")
	public List<EmployeeVO> getEmployees()
	{
		
		List<EmployeeVO> employeesList=new ArrayList<EmployeeVO>();
		
		EmployeeVO employeeV1=new EmployeeVO(1,"Ben", "Male", "Hyderabad", 10000d);
		EmployeeVO employeeV2=new EmployeeVO(2,"Sara", "Female", "Bangalore", 12000d);
		EmployeeVO employeeV3=new EmployeeVO(3,"Mark", "Male", "Chennai", 13500d);
		EmployeeVO employeeV4=new EmployeeVO(4,"Pam", "Female", "Addanki", 14000d);
		EmployeeVO employeeV5=new EmployeeVO(5,"Todd", "Male", "Vijayawada", 95000d);
		
		employeesList.add(employeeV1);
		employeesList.add(employeeV2);
		employeesList.add(employeeV3);
		employeesList.add(employeeV4);
		employeesList.add(employeeV5);
		
		return employeesList;
	}
	
	@GET
	//@Path("empDetails")
	@Path("empDetails/{id}/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	//public EmployeeVO getEmployeeInfo(@QueryParam("id") int id,@QueryParam("name") String name)
	public EmployeeVO getEmployeeInfo(@PathParam("id") int id,@PathParam("name") String name)
	{
		System.out.println(id+"   "+name);
		EmployeeVO employeeVO=null;
		switch(id){
		case 1:
			employeeVO=new EmployeeVO(1,"Ben", "Male", "Hyderabad", 10000d);
			break;
		case 2:
			employeeVO=new EmployeeVO(2,"Sara", "Female", "Bangalore", 12000d);
			break;
		case 3:
			employeeVO=new EmployeeVO(3,"Mark", "Male", "Chennai", 13500d);
			break;
		case 4:
			employeeVO=new EmployeeVO(4,"Pam", "Female", "Addanki", 14000d);
			break;
		case 5:
			employeeVO=new EmployeeVO(5,"Todd", "Male", "Vijayawada", 95000d);
			break;
		
		}
		
		
		return employeeVO;
	}

}
