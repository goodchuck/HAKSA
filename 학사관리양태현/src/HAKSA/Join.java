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

import DAO.UserDAO;
import javafx.geometry.Orientation;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Join extends JPanel{
	
	
	JLabel lb1, la1, la2, la3, la4, la5, la6, la7, la8, la9;
	JTextField id, name, sex, age, dept, st;
	//JPasswordField passwd;
	JTextField passwd;
	JButton b1, b2;
	JTextArea content;
	
	public Join(){
		setLayout(new FlowLayout());
		EtchedBorder eborder = new EtchedBorder();
		lb1 = new JLabel("아이디와 패스워드를 입력해 주세요");
		lb1.setBorder(eborder);
		
		add(lb1);
		
		la3 = new JLabel("아이디");
		la2 = new JLabel("패스워드");
		la4 = new JLabel("이름");
		la5 = new JLabel("성별");
		la6 = new JLabel("나이");
		la7 = new JLabel("학과");
		la9 = new JLabel("기입예시 ex) 컴공, 경영, 전자");
		la8 = new JLabel("교사여부 학생은 0, 교사는 1 입력");
		id = new JTextField(10);
		//passwd = new JPasswordField(10);
		passwd = new JTextField(10);
		name = new JTextField(10);
		sex = new JTextField(10);
		age = new JTextField(10);
		dept = new JTextField(10);
		st = new JTextField(10);
		add(la3);
		add(id);
		add(la2);
		add(passwd);
		add(la4);
		add(name);
		add(la5);
		add(sex);
		add(la6);
		add(age);
		add(la7);
		add(la9);
		add(dept);
		add(la8);
		add(st);
		b2 = new JButton("회원가입");
		add(b2);

		
		//JScrollPane s = new JScrollPane(content);
		//add(s);
		setSize(200, 600);
		setVisible(true);
			
		b2.addActionListener(new ActionListener() { //회원가입 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {

				if(Main.sessionid !=null) {
					System.out.println("이미 로그인이 되어있습니다.");
				}
				
				if (id.getText() == null || passwd.getText() == null || name.getText() == null || age.getText() == null || 
					dept.getText() == null || st.getText() == null) {
					System.out.println("입력 안된 사항이 있습니다.");	
			} else {
				UserDAO userDAO = new UserDAO();				
				int result = userDAO.join(id.getText(), passwd.getText(), name.getText(), sex.getText(), age.getText(), dept.getText(), st.getText());
				if(result == -1) {
					System.out.println("이미존재하는 아이디입니다.");
					removeAll(); // 모든 컴포넌트 삭제
					revalidate(); // 다시활성화
					repaint(); // 다시그리기
					add(new Join()); // 학생정보에 대한 화면을 구현한 클래스를 생성
					//setVisible(false);
					setLayout(null); // 레이아웃 적용 안함
				}
				else {
					System.out.println("회원가입이 되셨습니다.");
					setVisible(false);
					new Main(); // 학생정보에 대한 화면을 구현한 클래스를 생성
				}
			}
			}
		});
		

	}
}