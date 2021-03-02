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

public class Login extends JFrame{
	
	
	JLabel lb1, la1, la2, la3;
	JTextField id;
	JPasswordField passwd;
	JPanel idPanel, paPanel, loginPanel;
	JPanel allPanel;
	JButton b1, b2;
	JTextArea content;
	
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
		
		id = new JTextField(10);
		passwd = new JPasswordField(10);
		add(la3);
		add(id);
		add(la2);
		add(passwd);
		
		loginPanel = new JPanel();
		b1 = new JButton("로그인");
		b2 = new JButton("회원가입");
		loginPanel.add(b1);
		loginPanel.add(b2);
		add(idPanel);
		add(paPanel);
		add(loginPanel);
		
		content = new JTextArea(3,20);
		JScrollPane s = new JScrollPane(content);
		add(s);
		setSize(230, 350);
		setVisible(true);
		
		
	/*	add(new JLabel("이름"));
		name = new JTextField(20);
		add(name);//이름 textfield추가
		
		add(new JLabel("학과"));
		dept = new JTextField(20);
		add(dept);//학과 textfield추가

		add(new JLabel("학번"));
		id = new JTextField(20);
		add(id);//학번 textfield추가
		
		idCheckBtn = new JButton("학번중복체크");
		add(idCheckBtn);
		idCheckBtn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		
		
		add(new JLabel("주소"));
		address = new JTextField(20);
		add(address);//이름 textfield추가
		
		String colName[] = {"학번","이름","학과"};
		DefaultTableModel model = new DefaultTableModel(colName,0);
		
		JTable table = new JTable(model);
		
		table.setPreferredScrollableViewportSize(new Dimension(250, 200)); //테이블 사이즈 맞춰줌
		add(new JScrollPane(table));
		
		insertBtn = new JButton("입력");
		add(insertBtn);
		
		updateBtn = new JButton("수정");
		add(updateBtn);
		
		deleteBtn = new JButton("삭제");
		add(deleteBtn);
		
		setSize(250,600);
		setVisible(true);
		
		*/
	}
}