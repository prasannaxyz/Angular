package com.infosys.pagination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.common.util.Constants;
import com.common.util.DBConnection;
import com.infosys.vo.Beneficiary;
import com.infosys.vo.Person;

@Path("person")
@Produces(MediaType.APPLICATION_JSON)
public class Persons {

	@GET
	@Path("getPersons/{page}")
	public List<Person> getBeneficiaries(@PathParam("page") int page) {
		int offSet=16+(page-1)*Constants.pageSize;
		List<Person> personsList = new ArrayList();
		Connection con = DBConnection.getDBConnection().getConnection();
		try {
			PreparedStatement st = con
					.prepareStatement("select * from persons where age>="+offSet+" "+"and age<="+(offSet+Constants.pageSize));
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Person person = new Person();
				
				person.setName(rs.getString(1));
				person.setAge(Integer.parseInt(rs.getString(2)));
				person.setDesignation(rs.getString(3));
				
				personsList.add(person);
			}

			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return personsList;
	}

}
