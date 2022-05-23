

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao extends DBAccess {
	
	//idとパスワードから名前を取得する
	public String getName(String id, String pass) {
		String sql = "select name from user where id = ? and pass = ?";
		String name = null;
		ResultSet rs = null;
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
			name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return name;
	}


}
