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
	JTextField idlabel, pwlabel,namelabel,sexlabel,agelabel, deptlabel, stlabel, kolabel, enlabel, malabel;
	JLabel idtext, pwtext, nametext, sextext, agetext, depttext, sttext, kotext, entext, matext;
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
		agetext = new JLabel("나이= ");
		depttext = new JLabel("학과= ");
		sttext = new JLabel("교사여부= ");
		kotext = new JLabel("국어성적= ");
		entext = new JLabel("영어성적= ");
		matext = new JLabel("수학성적= ");
		
		//mainpanel = new JPanel();
		
		idlabel = new JTextField();
		idlabel.setEditable(false);
		pwlabel = new JTextField();
		pwlabel.setEditable(false);
		namelabel = new JTextField();
		namelabel.setEditable(false);
		sexlabel = new JTextField();
		sexlabel.setEditable(false);
		agelabel = new JTextField();
		agelabel.setEditable(false);
		deptlabel = new JTextField();
		deptlabel.setEditable(false);
		stlabel = new JTextField();
		stlabel.setEditable(false);
		kolabel = new JTextField();
		kolabel.setEditable(false);
		enlabel = new JTextField();
		enlabel.setEditable(false);
		malabel = new JTextField();
		malabel.setEditable(false);
		System.out.println(Main.sessionid);
		if(Main.sessionid != null) {
			String sql;
			sql = "SELECT * from user where Id='" +Main.sessionid +"'";
			ResultSet rs;
			
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
					String userPassword = rs.getString("Pw");
					String userName = rs.getString("Name");
					String userGender = rs.getString("Sex");
					String userAge = rs.getString("Age");
					String userDept = rs.getString("Dept");
					String userSt = rs.getString("St");
					idlabel.setText(userID);
					pwlabel.setText(userPassword);
					namelabel.setText(userName);
					sexlabel.setText(userGender);
					agelabel.setText(userAge);
					deptlabel.setText(userDept);
					stlabel.setText(userSt);
				}
				if(stlabel.equals("0")) {
					sql = "SELECT * from scoretest where user_Id=" +Main.sessionid +"";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						String Ko = rs.getString("Ko");
						String En = rs.getString("En");
						String Ma = rs.getString("Ma");
						kolabel.setText(Ko);
						enlabel.setText(En);
						malabel.setText(Ma);
						stlabel.setText("학생");
					}	
				} else {
					kotext.setVisible(false);
					entext.setVisible(false);
					matext.setVisible(false);
					kolabel.setVisible(false);
					enlabel.setVisible(false);
					malabel.setVisible(false);
					stlabel.setText("교사");
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
		add(agetext);
		add(agelabel);
		add(depttext);
		add(deptlabel);
		add(sttext);
		add(stlabel);
		add(kotext);
		add(kolabel);
		add(entext);
		add(enlabel);
		add(matext);
		add(malabel);
		setSize(450,500);
		setVisible(true);
		
		
	}
}