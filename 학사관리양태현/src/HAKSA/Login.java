package HAKSA;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import javafx.geometry.Orientation;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;





public class Login extends JFrame{
	private Connection conn; //�����ͺ��̽� �����ϴ°� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;
	JLabel lb1, la1, la2, la3,la4;
	JTextField id, password;
	JPasswordField passwd;
	JPanel idPanel, paPanel, loginPanel;
	JPanel allPanel;
	JButton b1, b2,b3;
	JTextArea content;
	MyDialog2 dialog2 = new MyDialog2();

	/* JTextField name; //이름
	JTextField dept; //학과
	JTextField id; //아이디
	JTextField address; //주소
	JTextField search; //검색
	JTextField list; //학생목록
	JButton selectBtn; //조회
	JButton insertBtn; //입력
	JButton updateBtn; //수정
	JButton deleteBtn; //삭제
	JButton idCheckBtn; //학번중복체크
	MyDialog dialog = new MyDialog();
	*/

	public Login(){

		setLayout( new FlowLayout());
		EtchedBorder eborder = new EtchedBorder();
		lb1 = new JLabel("아이디와 패스워드를 입력해 주세요");
		lb1.setBorder(eborder);
		
		add(lb1);
		
		idPanel = new JPanel();
		paPanel = new JPanel();
		la3 = new JLabel("아이디");
		la2 = new JLabel("패스워드");
		la4= new JLabel("sql테스트");
		
		id = new JTextField(10);
		password = new JTextField(10);
		//passwd = new JPasswordField(10);
		add(la3);
		add(id);
		add(la2);
		add(password);



		loginPanel = new JPanel();
		b1 = new JButton("로그인");
		b2 = new JButton("회원가입");
		b3= new JButton("sql테스트");

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String testId = id.getText();
				String testPassword = password.getText();
				UserDAO userDAO = new UserDAO();
				int result = userDAO.login(testId, testPassword);

					if(result ==  1) {
						System.out.println("로그인성공");
						dispose();
						//String SId = id.getText();
						dialog2.setVisible(true);
					}
					else if(result == 0) {
						System.out.println("비밀번호가 틀림");
						
					}
					else if(result == -1) {
						System.out.println("존재하지 않는 아이디입니다.");
					}

			}
		});
		
		b3.addActionListener(new ActionListener() { //회원가입 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
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
					}
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				
			}
		}); 
		loginPanel.add(b1);
		loginPanel.add(b2);
		loginPanel.add(b3);
		add(idPanel);
		add(paPanel);
		add(loginPanel);
		content = new JTextArea(3,20);
		JScrollPane s = new JScrollPane(content);
		add(s);
		setSize(230, 350);
		setVisible(true);
		


	}
	class MyDialog2 extends JDialog{
		JLabel dilabel = new JLabel("로그인이되셨습니다.");
		JButton okBtn = new JButton("확인");
		public MyDialog2() {

			setLayout(new FlowLayout());
			add(dilabel);
			add(okBtn);
			
			okBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					Main.idcheck = true;
					Main.sessionid = id.getText();
					new Main();
				}
			});

			setSize(500,300);
		}
	}
}