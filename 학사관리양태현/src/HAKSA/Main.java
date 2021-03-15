package HAKSA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame{
	JPanel panel, buttonpanel, sessionidpanel;
	JButton b1, b2, b3, b4, b5;
	ImageIcon icon;
	JLabel label1, idlabel, pwlabel, sessionidlabel, sessionstlabel;
	JTextField id, password;
	private Connection conn; //�����ͺ��̽� �����ϴ°� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;
	MyDialog dialog = new MyDialog();
	MyDialog2 dialog2 = new MyDialog2();
	public static boolean idcheck = false;
	public static String sessionid = "";
	public static String sessionst = "";
	
	public Main() {
		setTitle("학사관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon("file:///E:/포트폴리오/HAKSA/학사관리양태현/src/images/background.jpg");
		
		JMenuBar bar = new JMenuBar();
		JMenu main = new JMenu("메인화면");
		bar.add(main);
		JMenu m_student = new JMenu("학생관리"); //메뉴
		bar.add(m_student);
		JMenu m_score = new JMenu("성적관리"); // 2번째 메뉴
		bar.add(m_score);	
		JMenu m_index = new JMenu("학생정보"); // 3목차
		bar.add(m_index);	
		/*buttonpanel = new JPanel() {
			ImageIcon background = new ImageIcon("E:/포트폴리오/HAKSA/학사관리양태현/src/images/background.jpg");
			public void paint(Graphics g) {
				g.drawImage(background.getImage(),0,0,200,200, null);
			}
		}; */
		idlabel = new JLabel("아이디");
		pwlabel = new JLabel("비밀번호");
		id = new JTextField(10);
		password = new JTextField(10);
		b1 = new JButton("로그인");
		b2 = new JButton("회원가입");
		b5 = new JButton("로그아웃");
		panel = new JPanel();
		buttonpanel = new JPanel();
		sessionidpanel = new JPanel();
		sessionidlabel = new JLabel("로그인을해주세요");
		sessionstlabel = new JLabel("");
		if(sessionid == "") {
			b5.setVisible(false);
		} else {
			b1.setVisible(false);
			b2.setVisible(false);
			idlabel.setVisible(false);
			pwlabel.setVisible(false);
			id.setVisible(false);
			password.setVisible(false);
			b5.setVisible(true);
			if (idcheck == true) {
				sessionidlabel.setText(sessionid + " 	님 환영합니다.");
				//sessionstlabel.setText(sessionst + " 	교사는0 학생은1");
				if(sessionst.equals("0")) {
					sessionstlabel.setText("학생이시군요 오늘도 열심히 공부합시다!");
				} else if (sessionst.equals("1")) {
					sessionstlabel.setText("교사이시군요 오늘도 활기차게 근무합시다!");
				}
			} 
		}
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//panel.removeAll(); // 모든 컴포넌트 삭제
				//panel.revalidate(); // 다시활성화
				//panel.repaint(); // 다시그리기
				//panel.add(new Join()); // 학생정보에 대한 화면을 구현한 클래스를 생성
				
				//panel.setLayout(null); // 레이아웃 적용 안함
				String testId = id.getText();
				String testPassword = password.getText();
				UserDAO userDAO = new UserDAO();
				dispose();
				int result = userDAO.login(testId, testPassword);

					if(result ==  1) {
						System.out.println("로그인성공");
						//String SId = id.getText();
						dialog.setVisible(true);
					}
					else if(result == 0) {
						System.out.println("비밀번호가 틀림");
						password.setText("");
					}
					else if(result == -1) {
						System.out.println("존재하지 않는 아이디입니다.");
						id.setText("");
						password.setText("");
					}
			}
		});
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든 컴포넌트 삭제
				panel.revalidate(); // 다시활성화
				panel.repaint(); // 다시그리기
				panel.add(new Join()); // 학생정보에 대한 화면을 구현한 클래스를 생성
				//setVisible(false);
				buttonpanel.setVisible(false);
				panel.setLayout(null); // 레이아웃 적용 안함
				
			}
		});
		
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				sessionid = "";
				idcheck = false;
				new  Main();
			}
		});
		
		
		JMenuItem gomain = new JMenuItem("메인화면으로");
		main.add(gomain);
		
		JMenuItem mi_list = new JMenuItem("학생정보");
		m_student.add(mi_list);
		
		JMenuItem mi_studentlist = new JMenuItem("전체학생목록");
		m_student.add(mi_studentlist);
		
		JMenuItem mi_index = new JMenuItem("내 정보");
		m_index.add(mi_index);

		JMenuItem mi_score = new JMenuItem("성적");
		m_score.add(mi_score);
		
		
		gomain.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main();
				
			}
			
		});
		mi_list.addActionListener(new ActionListener() { //학생정보 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든 컴포넌트 삭제
				panel.revalidate(); // 다시활성화
				panel.repaint(); // 다시그리기
				buttonpanel.setVisible(false);
				panel.add(new Student()); // 학생정보에 대한 화면을 구현한 클래스를 생성
				panel.setLayout(null); // 레이아웃 적용 안함
			}
		});

		mi_studentlist.addActionListener(new ActionListener() { //전체학생목록 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든 컴포넌트 삭제
				panel.revalidate(); // 다시활성화
				panel.repaint(); // 다시그리기
				buttonpanel.setVisible(false);
				panel.add(new Studentlist()); // 학생정보에 대한 화면을 구현한 클래스를 생성

				panel.setLayout(null); // 레이아웃 적용 안함
			}
		});

		mi_index.addActionListener(new ActionListener() { //내정보 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(sessionid);
				if(sessionid.equals("")){
					dispose();
					dialog2.setVisible(true);
				} else {
					panel.removeAll(); // 모든 컴포넌트 삭제
					panel.revalidate(); // 다시활성화
					panel.repaint(); // 다시그리기
					buttonpanel.setVisible(false);
					panel.add(new Info()); // 학생정보에 대한 화면을 구현한 클래스를 생성
					panel.setLayout(null); // 레이아웃 적용 안함
				}
			}
		});
		// 대출현황아이템 이벤트 처리
		mi_score.addActionListener(new ActionListener() {// 성적 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든 컴포넌트 삭제
				panel.revalidate(); // 다시활성화
				panel.repaint(); // 다시그리기
				panel.add(new Score()); // 학생정보에 대한 화면을 구현한 클래스를 생성
				panel.setLayout(null); // 레이아웃 적용 안함
			}
		});

		panel.add(idlabel);
		panel.add(id);
		panel.add(pwlabel);
		panel.add(password);
		buttonpanel.add(b1);
		buttonpanel.add(b2);
		panel.add(b5);
		sessionidpanel.add(sessionidlabel);
		sessionidpanel.add(sessionstlabel);
		add(sessionidpanel,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		add(buttonpanel,BorderLayout.SOUTH);
		setJMenuBar(bar);
		setSize(500, 500);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();	
	}
	class MyDialog extends JDialog{
		JLabel dilabel = new JLabel("로그인이되셨습니다.");
		JButton okBtn = new JButton("확인");
		public MyDialog() {

			setLayout(new FlowLayout());
			add(dilabel);
			add(okBtn);
			
			okBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					idcheck = true;
					sessionid = id.getText();
					new Main();
				}
			});

			setSize(500,300);
		}
	}
	class MyDialog2 extends JDialog{
		JLabel dilabel = new JLabel("로그인이안되어있습니다. 로그인을 해주세요");
		JButton okBtn = new JButton("확인");
		public MyDialog2() {

			setLayout(new FlowLayout());
			add(dilabel);
			add(okBtn);
			
			okBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Main();
				}
			});

			setSize(800,300);
		}
	}
}
