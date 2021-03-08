package HAKSA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame{
	JPanel panel, page1;
	JButton b1, b2, b3, b4, b5;
	ImageIcon icon;
	JLabel label1;
	public static boolean idcheck = false;
	public static String sessionid = "";
	public Main() {
		setTitle("학사관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon("file:///E:/포트폴리오/HAKSA/학사관리양태현/src/images/background.jpg");
		JMenuBar bar = new JMenuBar();
		JMenu main = new JMenu("메인화면");
		bar.add(main);
		JMenu m_student = new JMenu("학생관리"); //메뉴
		bar.add(m_student);
		JMenu m_book = new JMenu("도서관리"); // 2번째 메뉴
		bar.add(m_book);	
		JMenu m_index = new JMenu("학생정보"); // 3목차
		bar.add(m_index);	
		/*page1 = new JPanel() {
			ImageIcon background = new ImageIcon("E:/포트폴리오/HAKSA/학사관리양태현/src/images/background.jpg");
			public void paint(Graphics g) {
				g.drawImage(background.getImage(),0,0,200,200, null);
			}
		}; */
		b1 = new JButton("학생로그인");
		b2 = new JButton("회원가입");
		b3 = new JButton("교사로그인");
		b5 = new JButton("로그아웃");
		label1 = new JLabel("로그인을해주세요");
		if(sessionid == "") {
			b5.setVisible(false);
		} else {
			b1.setVisible(false);
			b2.setVisible(false);
			b3.setVisible(false);
			b5.setVisible(true);
			if (idcheck == true) {
				label1.setText(sessionid + "님 환영합니다.");
			}
		}
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//panel.removeAll(); // 모든 컴포넌트 삭제
				//panel.revalidate(); // 다시활성화
				//panel.repaint(); // 다시그리기
				//panel.add(new Join()); // 학생정보에 대한 화면을 구현한 클래스를 생성
				dispose();
				new Login();
				//panel.setLayout(null); // 레이아웃 적용 안함
			}
		});
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//panel.removeAll(); // 모든 컴포넌트 삭제
				//panel.revalidate(); // 다시활성화
				//panel.repaint(); // 다시그리기
				//panel.add(new Join()); // 학생정보에 대한 화면을 구현한 클래스를 생성
				new Join();
				setVisible(false);
				//panel.setLayout(null); // 레이아웃 적용 안함
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
		
		JMenuItem mi_index = new JMenuItem("로그인한 내 정보");
		m_index.add(mi_index);

		JMenuItem mi_bookRent = new JMenuItem("대출현황");
		m_book.add(mi_bookRent);
		
		
		gomain.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.removeAll(); // 모든 컴포넌트 삭제
				panel.revalidate(); // 다시활성화
				panel.repaint(); // 다시그리기
				//add(panel); // 학생정보에 대한 화면을 구현한 클래스를 생성
				panel.setLayout(null); // 레이아웃 적용 안함
			}
			
		});
		mi_list.addActionListener(new ActionListener() { //학생 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든 컴포넌트 삭제
				panel.revalidate(); // 다시활성화
				panel.repaint(); // 다시그리기
				//page1.setVisible(false);
				panel.add(new Student()); // 학생정보에 대한 화면을 구현한 클래스를 생성

				panel.setLayout(null); // 레이아웃 적용 안함
			}
		});

		// 대출현황아이템 이벤트 처리
		mi_bookRent.addActionListener(new ActionListener() {// 강좌 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든 컴포넌트 삭제
				panel.revalidate(); // 다시활성화
				panel.repaint(); // 다시그리기
				panel.add(new Book()); // 학생정보에 대한 화면을 구현한 클래스를 생성
				panel.setLayout(null); // 레이아웃 적용 안함
			}
		});
		mi_index.addActionListener(new ActionListener() { //목록 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든 컴포넌트 삭제
				panel.revalidate(); // 다시활성화
				panel.repaint(); // 다시그리기
				panel.add(new Info()); // 학생정보에 대한 화면을 구현한 클래스를 생성
				panel.setLayout(null); // 레이아웃 적용 안함
			}
		});
		
		panel = new JPanel();
		panel.add(b1);
		panel.add(b3);
		panel.add(b2);
		panel.add(label1);
		panel.add(b5);
		add(panel);
		//add(page1);
		//add(page1,BorderLayout.CENTER);
		setJMenuBar(bar);
		setSize(900, 900);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//new Main();
		
	}
}
