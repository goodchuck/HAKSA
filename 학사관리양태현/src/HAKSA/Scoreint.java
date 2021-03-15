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

public class Scoreint extends JPanel{
	
	
	JLabel lb1, la1, la2, la3, la4, la5, la6, la7, la8, la9;
	JTextField id, ko, en, ma;
	//JPasswordField passwd;
	JTextField passwd;
	JButton b1, b2;
	JTextArea content;
	
	public Scoreint(){
		setLayout(new FlowLayout());
		EtchedBorder eborder = new EtchedBorder();
		lb1 = new JLabel("아이디와 성적을 입력해 주세요");
		lb1.setBorder(eborder);
		
		add(lb1);
		
		la3 = new JLabel("아이디");
		la2 = new JLabel("국어");
		la4 = new JLabel("영어");
		la5 = new JLabel("수학");
		id = new JTextField(10);
		//passwd = new JPasswordField(10);
		ko = new JTextField(10);
		en = new JTextField(10);
		ma = new JTextField(10);

		add(la3);
		add(id);
		add(la2);
		add(ko);
		add(la4);
		add(en);
		add(la5);
		add(ma);

		b2 = new JButton("성적 입력");
		add(b2);

		
		//JScrollPane s = new JScrollPane(content);
		//add(s);
		setSize(400, 300);
		setVisible(true);
			
		b2.addActionListener(new ActionListener() { //회원가입 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (id.getText() == null || en.getText() == null || ko.getText() == null || ma.getText() == null) {
					System.out.println("입력 안된 사항이 있습니다.");	
					MyDialog2 dialog = new MyDialog2();
					dialog.setVisible(true);
			} else {
				UserDAO userDAO = new UserDAO();				
				int result = userDAO.scoreinttest(ko.getText(), en.getText(), ma.getText(), id.getText());
				if(result == -1) {
					MyDialog dialog = new MyDialog();
					dialog.setVisible(true);
				}
				else {
					System.out.println("성적입력이 성공적으로 되셨습니다.");
					removeAll();
					revalidate();
					repaint();
					add(new Score());
					setLayout(null);
				}
			}
			}
		});
		
	}
	class MyDialog extends JDialog{
		JLabel dilabel = new JLabel("이미성적이 입력되어있습니다.");
		JButton okBtn = new JButton("확인");
		public MyDialog() {

			setLayout(new FlowLayout());
			add(dilabel);
			add(okBtn);
			
			okBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Scoreint();
				}
			});

			setSize(500,300);
		}
	}
	class MyDialog2 extends JDialog{
		JLabel dilabel = new JLabel("입력이 안된 사항이 있습니다.");
		JButton okBtn = new JButton("확인");
		public MyDialog2() {

			setLayout(new FlowLayout());
			add(dilabel);
			add(okBtn);
			
			okBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Scoreint();
				}
			});

			setSize(500,300);
		}
	}
}