package HAKSA;

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


public class Info extends JPanel{
	JLabel label1, label2;
	private Connection conn; //�����ͺ��̽� �����ϴ°� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	
	Info(){
		if(Main.sessionid != null) {
			String sql;
			sql = "SELECT * from user";
			ResultSet rs;
			
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
					String name = rs.getString("username");
					System.out.println("userID :" + userID);
					System.out.println("name :" + name);
					label1.setText(userID);
					label2.setText(name);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		
		
		add(label1);
		add(label2);

		
		setSize(600,600);
		setVisible(true);
		
		
	}
}