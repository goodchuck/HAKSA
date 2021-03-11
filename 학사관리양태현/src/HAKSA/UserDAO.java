package HAKSA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection conn; //�����ͺ��̽� �����ϴ°� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/HAKSA?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "yth502100";
			//Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {

		String SQL = "SELECT Pw,St FROM USER WHERE Id = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					Main.sessionst = rs.getString("St");
					return 1; //로그인 완료
				}
				else
					return 0; //비밀번호 틀림
			}
			return -1; // 데이터베이스 오류
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // �����ͺ��̽� ����
	}
	
	/*public int join(User user) {
		String SQL = "INSERT INTO USER VALUES (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  user.getUserID());
			pstmt.setString(2,  user.getUserPassword());
			pstmt.setString(3,  user.getUserName());
			pstmt.setString(4,  user.getUserGender());
			pstmt.setString(5,  user.getUserEmail());
			return pstmt.executeUpdate(); 
			pstmt = conn.prepareStatement(SQL);
			//pstmt.setString(1, );
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	} */
	public int join(String id, String Password, String name, String sex, String age, String dept, String st) {
		String SQL = "INSERT INTO USER VALUES (?,?,?,?,?,?,?)";
		try {

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, Password);
			pstmt.setString(3, name);
			pstmt.setString(4, sex);
			pstmt.setString(5, age);
			pstmt.setString(6, dept);
			pstmt.setString(7, st);
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}


