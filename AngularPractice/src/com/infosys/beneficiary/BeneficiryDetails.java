package com.infosys.beneficiary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.common.util.DBConnection;
import com.infosys.vo.Beneficiary;

@Path("beneficiary")
@Produces(MediaType.APPLICATION_JSON)
public class BeneficiryDetails {

	@GET
	@Path("getbeneficiarydetails")
	public List<Beneficiary> getBeneficiaries() {
		List<Beneficiary> beneficiaryList = new ArrayList();
		
		Connection con = DBConnection.getDBConnection().getConnection();
		try {
			PreparedStatement st = con
					.prepareStatement("select * from BENEFICIARy_ACCOUNT");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Beneficiary beneficiary = new Beneficiary();
				
				beneficiary.setAccountNo(rs.getString(1));
				beneficiary.setBeneficiaryName(rs.getString(2));
				beneficiary.setBranch(rs.getString(3));
				beneficiary.setBank(rs.getString(4));
				beneficiary.setLimit(rs.getString(5));
				
				beneficiaryList.add(beneficiary);
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

		return beneficiaryList;
	}

}
