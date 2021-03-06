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

import DAO.ScoreDAO;
import javafx.geometry.Orientation;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class ScoreDelete extends JPanel{
	
	
	JLabel lb1, la1, la2, la3, la4, la5, la6, la7, la8, la9;
	JTextField id, ko, en, ma;
	//JPasswordField passwd;
	JTextField passwd;
	JButton b1, b2;
	JTextArea content;
	
	public ScoreDelete(){
		setLayout(new FlowLayout());
		EtchedBorder eborder = new EtchedBorder();
		lb1 = new JLabel("삭제하실 아이디를 입력해주세요");
		lb1.setBorder(eborder);
		
		add(lb1);
		
		la3 = new JLabel("아이디");
		id = new JTextField(10);
		//passwd = new JPasswordField(10);

		add(la3);
		add(id);

		b2 = new JButton("성적 삭제");
		add(b2);

		
		//JScrollPane s = new JScrollPane(content);
		//add(s);
		setSize(450, 450);
		setVisible(true);
			
		b2.addActionListener(new ActionListener() { //회원가입 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (id.getText() == null) {
					System.out.println("입력 안된 사항이 있습니다.");	
					MyDialog2 dialog = new MyDialog2();
					dialog.setVisible(true);
			} else {
				ScoreDAO scoreDAO = new ScoreDAO();				
				int result = scoreDAO.delete(id.getText());
				if(result == -1) {
					MyDialog dialog = new MyDialog();
					dialog.setVisible(true);
				}
				else {
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
		JLabel dilabel = new JLabel("성적을 수정하실수 없습니다. 아이디를 다시 확인해주세요");
		JButton okBtn = new JButton("확인");
		public MyDialog() {

			setLayout(new FlowLayout());
			add(dilabel);
			add(okBtn);
			
			okBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new ScoreDelete();
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
					new ScoreDelete();
				}
			});

			setSize(500,300);
		}
	}
}