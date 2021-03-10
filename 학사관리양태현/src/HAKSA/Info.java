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
	JTextField idlabel, pwlabel,namelabel,sexlabel,emaillabel;
	JLabel idtext, pwtext, nametext, sextext, emailtext;
	//JPanel mainpanel;
	private Connection conn; //�����ͺ��̽� �����ϴ°� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	
	Info(){
		System.out.println("info진입확인");
		idtext= new JLabel("아이디 = ");
		pwtext = new JLabel("비밀번호 = ");
		nametext = new JLabel("이름= ");
		sextext = new JLabel("성별= ");
		emailtext = new JLabel("이메일= ");
		
		
		//mainpanel = new JPanel();
		
		idlabel = new JTextField();
		idlabel.setEditable(false);
		pwlabel = new JTextField();
		pwlabel.setEditable(false);
		namelabel = new JTextField();
		namelabel.setEditable(false);
		sexlabel = new JTextField();
		sexlabel.setEditable(false);
		emaillabel = new JTextField();
		emaillabel.setEditable(false);
		System.out.println(Main.sessionid);
		if(Main.sessionid != null) {
			String sql;
			sql = "SELECT * from user where userID=" +Main.sessionid +"";
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
					String userPassword = rs.getString("userPassword");
					String userName = rs.getString("userName");
					String userGender = rs.getString("userGender");
					String userEmail = rs.getString("userEmail");
					idlabel.setText(userID);
					pwlabel.setText(userPassword);
					namelabel.setText(userName);
					sexlabel.setText(userGender);
					emaillabel.setText(userEmail);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		add(idtext);
		add(idlabel);
		add(pwtext);
		add(pwlabel);
		add(nametext);
		add(namelabel);
		add(sextext);
		add(sexlabel);
		add(emailtext);
		add(emaillabel);

		setSize(600,600);
		setVisible(true);
		
		
	}
}