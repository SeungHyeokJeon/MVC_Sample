package userTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBConnector;

public class usertableDAO {
	//DB Connector
	DBConnector dbcp = new DBConnector();
	
	/**************************************
	 * @name getUserData()
	 * @author Jeon SeungHyuck
	 * @param 
	 * @return void
	 * @throws SQLException 
	 * @throws NullPointerException
	 * @remark userInfo/userInfo.jsp
	 **************************************/
	public ArrayList<usertableDTO> getUserData() throws NullPointerException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<usertableDTO> list = new ArrayList<usertableDTO>();
		
		try {
			con = dbcp.getConnection();
			//user 테이블의 모든 데이터를 가져온다
			String sql = "select * from usertable";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//만약 맨 첫번재만 가져올거면 while대신 if 사용
			while (rs.next()) {
				usertableDTO tmpDto = new usertableDTO();
				tmpDto.setUserId(rs.getString("userid"));
				tmpDto.setUserName(rs.getString("username"));
				tmpDto.setUserAuth(rs.getString("userauth"));
				tmpDto.setFarmId(rs.getString("farmid"));
				list.add(tmpDto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
