package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScoreDAO {
	private Connection conn; //�����ͺ��̽� �����ϴ°� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ScoreDAO() {
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
	public int scoreint(String ko, String en, String ma, String id) {
		String SQL = "INSERT INTO SCORE (ko,en,ma,user_Id) VALUES (?,?,?,?)";
		try {

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, ko);
			pstmt.setString(2, en);
			pstmt.setString(3, ma);
			pstmt.setString(4, id);
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int scoreinttest(String ko, String en, String ma, String id) {
		String SQL = "INSERT INTO SCORETEST (ko,en,ma,user_Id) VALUES (?,?,?,?)";
		try {

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, ko);
			pstmt.setString(2, en);
			pstmt.setString(3, ma);
			pstmt.setString(4, id);
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int update(String ko, String en, String ma, String id) {
		String SQL = "UPDATE scoretest SET Ko = ?, En = ?, Ma = ? WHERE user_Id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL); //���� ����Ǿ��ִ� ��ü �̿��ؼ� �����غ�ܰ�θ���
			pstmt.setString(1, ko);
			pstmt.setString(2, en);
			pstmt.setString(3, ma);
			pstmt.setString(4, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽� ����
	}
	public int delete(String id) {
		String SQL = "DELETE FROM scoretest WHERE user_ID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL); //���� ����Ǿ��ִ� ��ü �̿��ؼ� �����غ�ܰ�θ���
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽� ����
	}
}


