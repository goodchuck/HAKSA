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


public class Studentlist extends JPanel{
	private Connection conn; //�����ͺ��̽� �����ϴ°� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;
	int i= 0;
	Studentlist(){
		String sql;
		sql = "SELECT * from user";
		ResultSet rs;
		String colName[] = {"아이디","이름","성별","나이","학과","교사여부"};
		DefaultTableModel model = new DefaultTableModel(colName,0);
		
		JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(350, 300)); //테이블 사이즈 맞춰줌
		add(new JScrollPane(table));
		try {
			String dbURL = "jdbc:mysql://localhost:3306/HAKSA?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "yth502100";
			//Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String userID = rs.getString("Id");
				//String userPassword = rs.getString("Pw");
				String userName = rs.getString("Name");
				String userSex = rs.getString("Sex");
				String userAge = rs.getString("Age");
				String userDept = rs.getString("Dept");
				String userSt = rs.getString("St");
				model.insertRow(i, new Object[] {userID,userName, userSex,userAge,userDept,userSt});
				i++;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setSize(600,600);
		setVisible(true);
	}
}