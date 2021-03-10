package HAKSA;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javafx.geometry.Orientation;


public class Studentlist extends JFrame{
	private Connection conn; //�����ͺ��̽� �����ϴ°� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;
	int i= 0;
	JPanel mainpanel;
	Studentlist(){
		setTitle("전체학생목록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainpanel = new JPanel();
		String sql;
		sql = "SELECT * from user";
		ResultSet rs;
		String colName[] = {"아이디","비밀번호","이름","성별","이메일"};
		DefaultTableModel model = new DefaultTableModel(colName,0);
		
		JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(250, 200)); //테이블 사이즈 맞춰줌
		mainpanel.add(new JScrollPane(table));
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "yth502100";
			//Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String userID = rs.getString("userID");
				String userPassword = rs.getString("userPassword");
				String userName = rs.getString("userName");
				String userGender = rs.getString("userGender");
				String userEmail = rs.getString("userEmail");
				model.insertRow(i, new Object[] {userID, userPassword, userName, userGender, userEmail});
				i++;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		add(mainpanel);
		setSize(600,600);
		setVisible(true);
	}
}