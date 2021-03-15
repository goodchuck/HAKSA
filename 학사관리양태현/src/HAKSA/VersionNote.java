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
import javax.swing.table.DefaultTableModel;

import javafx.geometry.Orientation;


class MyDialog2 extends JDialog{
	JTextField idText = new JTextField(10);
	JButton okBtn = new JButton("Ȯ��");
	
	public MyDialog2() {
		setLayout(new FlowLayout());
		add(idText);
		add(okBtn);
		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setSize(200,300);
	}
}

public class VersionNote extends JPanel{
	
	JTextField name; //�̸�
	JTextField dept; //�а�
	JTextField id; //���̵�
	JTextField address; //�ּ�
	JTextField search; //�˻�
	JTextField list; //�л����
	JButton selectBtn; //��ȸ
	JButton insertBtn; //�Է�
	JButton updateBtn; //����
	JButton deleteBtn; //����
	JButton idCheckBtn; //�й��ߺ�üũ 
	
	VersionNote(){
		
		JButton test = new JButton("1�� ����");
		
		test.setBounds(30,170,122,30);
		add(test);
		
		JLabel test2 = new JLabel();
		test2.setText("01 ���� 02 �Լ��� ���� 03 ���Ѱ��� ��� 04 �ʿ��Լ��� ���� �� ���Ѱ� e�� ���� 05 �Լ��ǿ���-�ҿ���");
		test2.setHorizontalAlignment(JLabel.CENTER);
		add(test2);
		test2.setVisible(false);
		

		
		// �� ����
        JLabel lbl = new JLabel();
        lbl.setBounds(30, 200, 274, 50);
        lbl.setText("������ �����մϴ�");
        lbl.setHorizontalAlignment(JLabel.CENTER); // ���� ��� ����
        add(lbl);
		

		
		test.addActionListener(event -> {
			lbl.setText("�׽�Ʈ Ȯ��");
			test2.setVisible(true);
		});
		

		
		setSize(600,600);
		setVisible(true);
		
		
	}
}