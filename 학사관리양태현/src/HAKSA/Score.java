package HAKSA;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Score extends JPanel {
	private Connection conn; //�����ͺ��̽� �����ϴ°� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;
	JButton b1, b2, b3;
	DefaultTableModel model;// 모델데이터
	JTable table;// 테이블
	JLabel la1;
	int i = 0;
	public Score() {
		la1 = new JLabel("학생은 성적 보기만하실수있습니다.");
		String sql;
		//sql = "SELECT * from scoretest";
		sql = "select * from user join scoretest on user_Id = Id";
		ResultSet rs;
		String colName[] = {"아이디","이름","국어","영어","수학"};
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
				String userID = rs.getString("user_Id");
				String userName = rs.getString("Name");
				String userKo = rs.getString("Ko");
				String userEn = rs.getString("En");
				String userMa = rs.getString("Ma");
				model.insertRow(i, new Object[] {userID, userName, userKo, userEn, userMa});
				i++;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Main.sessionid);
		b1 = new JButton("성적 입력");
		b2 = new JButton("성적 수정");
		b3 = new JButton("성적 삭제");
		if(Main.sessionst.equals("0") || Main.sessionst.equals("")) {
			b1.setVisible(false);
			b2.setVisible(false);
			b3.setVisible(false);
		} else if (Main.sessionst.equals("1")) {
			b1.setVisible(true);
			b2.setVisible(true);
			b3.setVisible(true);
		}
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				revalidate();
				repaint();
				add(new Scoreint());
				setLayout(null);
				
			}
		});
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				revalidate();
				repaint();
				add(new ScoreUpdate());
				setLayout(null);
				
			}
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				revalidate();
				repaint();
				add(new ScoreDelete());
				setLayout(null);
				
			}
		});
		add(b1);
		add(b2);
		add(b3);
		add(la1);
		setSize(450,450);
		setVisible(true);
	}
}