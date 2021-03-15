package erp.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import erp.dto.Title;
import erp.ui.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class TitlePanel extends InterfaceItem<Title> {
	private JTextField tfNo;
	private JTextField tfName;

	public TitlePanel() {
		initialize();
	}

	@Override
	public void initialize() {
		setBorder(new TitledBorder(null, "직책정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 0));

		JLabel lblNo = new JLabel("직책번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);

		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);

		JLabel lblName = new JLabel("잭책명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);

		tfName = new JTextField();
		add(tfName);
		tfName.setColumns(10);
	}

	@Override
	public void setItem(Title item) {
		tfNo.setText(String.valueOf(item.gettNo()));
		tfName.setText(item.gettName());

		tfNo.setEditable(false);
	}

	@Override
	public Title getItem() {
		int tNo = Integer.parseInt(tfNo.getText().trim());
		String tName = tfName.getText().trim();
		return new Title(tNo, tName);
	}

	@Override
	public void validChek() {
		if (tfNo.getText().contentEquals("") || tfName.getText().equals("")) {
			throw new InvalidCheckException();
		}
	}

	@Override
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");

		if (!tfNo.isEditable()) {
			tfNo.setEditable(true);
		}
	}
}
