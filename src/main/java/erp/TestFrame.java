package erp;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp.dto.Employee;
import erp.dto.EmployeeDetail;
import erp.service.EmployeeDetailService;
import erp.service.EmployeeService;
import erp.ui.content.EmployeeDetailPanel;
import erp.ui.list.EmployeeTablePanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TestFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private EmployeeDetailPanel pDetail;
	private EmployeeTablePanel pList;
	private EmployeeService service;
	private JPanel panel;
	private JButton btnGet;
	private JButton btnSet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestFrame() {
		service = new EmployeeService();
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		EmployeeService service = new EmployeeService();

		pList = new EmployeeTablePanel();
		pList.setService(service);
		pList.loadData();		
		contentPane.add(pList);

		pDetail = new EmployeeDetailPanel();
		pDetail.setTfEmpno(new Employee(1003));
		contentPane.add(pDetail);
		
		panel = new JPanel();
		contentPane.add(panel);
		
		btnGet = new JButton("가져오기");
		btnGet.addActionListener(this);
		panel.add(btnGet);
		
		btnSet = new JButton("불러오기");
		btnSet.addActionListener(this);
		panel.add(btnSet);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGet) {
			actionPerformedBtnGet(e);
		}
		if (e.getSource() == btnSet) {
			actionPerformedBtnSet(e);
		}
	}

	protected void actionPerformedBtnGet(ActionEvent e) {
		EmployeeDetail employeeDetail = pDetail.getItem();
		JOptionPane.showMessageDialog(null, employeeDetail);
	}
	
	private void actionPerformedBtnSet(ActionEvent e) {
		EmployeeDetailService service = new EmployeeDetailService();
		EmployeeDetail empDetail = service.selectEmployeeDetailByEmpNo(new Employee(1003));
		pDetail.setItem(empDetail);
	}
}
