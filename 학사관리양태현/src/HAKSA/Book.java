package HAKSA;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Book extends JPanel {

	DefaultTableModel model;// �𵨵���Ÿ
	JTable table;// ���̺�

	public Book() {
		setLayout(null);
		JLabel l_dept = new JLabel("�а�");
		l_dept.setBounds(10, 10, 30, 30);
		add(l_dept);

		String[] dept = { "��ü", "��ǻ�ͽý���", "��Ƽ�̵��", "��ǻ�Ͱ���" };
		JComboBox cb_dept = new JComboBox(dept);
		cb_dept.setBounds(45, 10, 100, 20);
		add(cb_dept);

		String colName[] = { "�й�", "�̸�", "������", "������" };
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(470, 200));
		add(table);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10,40,460,250);
		add(sp);
		
		setSize(600,600);
		setVisible(true);
	}
}