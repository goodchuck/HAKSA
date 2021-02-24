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


class MyDialog extends JDialog{
	JTextField idText = new JTextField(10);
	JButton okBtn = new JButton("Ȯ��");
	
	public MyDialog() {
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

public class Student extends JPanel{
	
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
	MyDialog dialog = new MyDialog();
	
	Student(){
		add(new JLabel("�̸�"));
		name = new JTextField(20);
		add(name);//�̸� textfield�߰�
		
		add(new JLabel("�а�"));
		dept = new JTextField(20);
		add(dept);//�а� textfield�߰�

		add(new JLabel("�й�"));
		id = new JTextField(20);
		add(id);//�й� textfield�߰�
		
		idCheckBtn = new JButton("�й��ߺ�üũ");
		add(idCheckBtn);
		idCheckBtn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		
		
		add(new JLabel("�ּ�"));
		address = new JTextField(20);
		add(address);//�̸� textfield�߰�
		
		String colName[] = {"�й�","�̸�","�а�"};
		DefaultTableModel model = new DefaultTableModel(colName,0);
		
		JTable table = new JTable(model);
		
		table.setPreferredScrollableViewportSize(new Dimension(250, 200)); //���̺� ������ ������
		add(new JScrollPane(table));
		
		insertBtn = new JButton("�Է�");
		add(insertBtn);
		
		updateBtn = new JButton("����");
		add(updateBtn);
		
		deleteBtn = new JButton("����");
		add(deleteBtn);
		
		setSize(250,600);
		setVisible(true);
		
		
	}
}