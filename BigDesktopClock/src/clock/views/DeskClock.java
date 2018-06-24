package clock.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class DeskClock {

	private JFrame frame;
	private int index = 0;
	private JTextArea txtResults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeskClock window = new DeskClock();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeskClock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstDate = new GridBagConstraints();
		GridBagConstraints gridConstTime = new GridBagConstraints();
		GridBagConstraints gridConstDay = new GridBagConstraints();
		
		ClockLabel lblDate = new ClockLabel("date");
		gridConstDate.weighty = 0.1;
		gridConstDate.weightx = 0.2;
		gridConstDate.anchor = GridBagConstraints.FIRST_LINE_START;
		gridConstDate.gridx = 0;
		gridConstDate.gridy = 0;
		frame.getContentPane().add(lblDate,gridConstDate);
		
		ClockLabel lblTime = new ClockLabel("time");
		gridConstTime.weighty = 1;
		gridConstTime.weighty = 1;
		gridConstTime.fill = GridBagConstraints.BOTH;
		gridConstTime.anchor = GridBagConstraints.CENTER;
		gridConstTime.gridx = 0;
		gridConstTime.gridy = 1;
		frame.getContentPane().add(lblTime,gridConstTime);
		
		ClockLabel lblDay = new ClockLabel("day");
		gridConstDay.weighty = 0.05;
		gridConstDay.weighty = 0.1;
		gridConstDay.fill = GridBagConstraints.NONE;
		gridConstDay.gridx = 0;
		gridConstDay.gridy = 2;
		gridConstDay.anchor = GridBagConstraints.LAST_LINE_END;
		frame.getContentPane().add(lblDay,gridConstDay);
		
		JPanel pnlSetTime = new JPanel();
		//pnlSetTime.setSize(300,300);
		pnlSetTime.setOpaque(true);
		pnlSetTime.setBackground(Color.BLACK);
		//pnlSetTime.setForeground(Color.WHITE);
		pnlSetTime.setLayout(null);
		GridBagConstraints gridConstSetTime = new GridBagConstraints();
		gridConstSetTime.fill = GridBagConstraints.BOTH;
		gridConstSetTime.weightx = 1;
		gridConstSetTime.weighty = 0.4;
		gridConstSetTime.gridx = 0;
		gridConstSetTime.gridy = 3;
		frame.getContentPane().add(pnlSetTime,gridConstSetTime);
		
		JSpinner spnHour = new JSpinner();
		spnHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spnHour.setForeground(Color.RED);
		spnHour.setBackground(Color.WHITE);
		spnHour.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnHour.setBounds(431, 11, 78, 34);
		pnlSetTime.add(spnHour);
		
		JSpinner spnMinute = new JSpinner();
		spnMinute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spnMinute.setForeground(Color.RED);
		spnMinute.setBounds(596, 11, 78, 34);
		pnlSetTime.add(spnMinute);
		
		JSpinner spnSecond = new JSpinner();
		spnSecond.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spnSecond.setForeground(Color.RED);
		spnSecond.setBounds(760, 11, 78, 34);
		pnlSetTime.add(spnSecond);
		
		JLabel lblMm = new JLabel("MM:");
		lblMm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMm.setForeground(Color.RED);
		lblMm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMm.setBounds(549, 11, 46, 34);
		pnlSetTime.add(lblMm);
		
		JLabel lblSs = new JLabel("SS:");
		lblSs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSs.setForeground(Color.RED);
		lblSs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSs.setBounds(716, 11, 46, 34);
		pnlSetTime.add(lblSs);
		
		JLabel lblHh = new JLabel("HH:");
		lblHh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHh.setForeground(Color.RED);
		lblHh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHh.setBounds(388, 11, 46, 34);
		pnlSetTime.add(lblHh);
		
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(index == 0)
					txtResults.setText(++index + lblTime.adjustTime(new Date(),lblTime.hour,lblTime.minute,lblTime.second).toString());
				else {
					String text = txtResults.getText();
					text += " , " + (++index) + lblTime.adjustTime(new Date(),lblTime.hour,lblTime.minute,lblTime.second).toString();
					txtResults.setText(text);
				}
					
			}
		});
		btnGo.setBackground(Color.BLACK);
		btnGo.setForeground(Color.GREEN);
		btnGo.setEnabled(false);
		btnGo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnGo.setBounds(1021, 11, 97, 34);
		pnlSetTime.add(btnGo);
		
		JButton btnSet = new JButton("SET");
		btnSet.setBackground(Color.BLACK);
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long sec_,set_,diff_;
				Date d = new Date();
				sec_ = d.getHours()*3600 + d.getMinutes() * 60 + d.getSeconds();
				set_ = ((int)spnHour.getValue())*3600 + ((int)spnMinute.getValue()) * 60 + ((int)spnSecond.getValue());
				diff_ = set_ - sec_;
				lblTime.second = (int) (diff_ % 60);
				diff_ /= 60;
				lblTime.minute = (int)(diff_ % 60);
				diff_ /= 60;
				lblTime.hour = (int)(diff_ % 60);
				btnSet.setEnabled(false);
				btnGo.setEnabled(true);
			}
		});
		btnSet.setForeground(Color.RED);
		btnSet.setFont(new Font("Calibri", Font.BOLD, 11));
		btnSet.setBounds(887, 11, 55, 34);
		pnlSetTime.add(btnSet);
		
		
		//pnlSetTime.setLayout(new GridLayout(1,));
		
		
		JPanel pnl_1 = new JPanel();
		pnl_1.setSize(300,300);
		pnl_1.setOpaque(true);
		pnl_1.setBackground(Color.BLACK);
		//pnl_1.setForeground(Color.RED);
		pnl_1.setLayout(null);
		GridBagConstraints gridConstPnl_1 = new GridBagConstraints();
		gridConstPnl_1.fill = GridBagConstraints.BOTH;
		gridConstPnl_1.weightx = 1;
		gridConstPnl_1.weighty = 1;
		gridConstPnl_1.gridx = 0;
		gridConstPnl_1.gridy = 4;
		frame.getContentPane().add(pnl_1,gridConstPnl_1);
		
		txtResults = new JTextArea();
		
		txtResults.setBounds(616, 28, 556, 131);
		pnl_1.add(txtResults);
		txtResults.setColumns(10);
		
		JPanel pnl_2 = new JPanel();
		pnl_2.setSize(300,300);
		pnl_2.setOpaque(true);
		pnl_2.setBackground(Color.BLACK);
		//pnl_2.setForeground(Color.RED);
		pnl_2.setLayout(null);
		GridBagConstraints gridConstpnl_2 = new GridBagConstraints();
		gridConstpnl_2.fill = GridBagConstraints.BOTH;
		gridConstpnl_2.weightx = 1;
		gridConstpnl_2.weighty = 1;
		gridConstpnl_2.gridx = 0;
		gridConstpnl_2.gridy = 5;
		frame.getContentPane().add(pnl_2,gridConstpnl_2);
		
		frame.setBounds(0, 0, 1266, 720);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
