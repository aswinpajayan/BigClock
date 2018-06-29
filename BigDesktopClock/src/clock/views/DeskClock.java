package clock.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

import brunoLowagie.itext.MyFirstTable;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JCheckBox;

public class DeskClock {

	private JFrame frame;
	private static int index = 0;
	private JTextArea txtResults;
	String text;
	private static Document doc = new Document();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeskClock window = new DeskClock();
					window.frame.setVisible(true);
					doc.close();
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
		
	
		
		ClockLabel lblTime = new ClockLabel("time");
		lblTime.setBackground(Color.BLACK);
		lblTime.setFont(new Font("Arial Black", Font.PLAIN, 150));
		gridConstTime.weighty = 0.4;
		gridConstTime.weightx = 1;
		gridConstTime.fill = GridBagConstraints.BOTH;
		gridConstTime.anchor = GridBagConstraints.CENTER;
		gridConstTime.gridx = 0;
		gridConstTime.gridy = 1;
		frame.getContentPane().add(lblTime,gridConstTime);
		
		
		ClockLabel lblDate = new ClockLabel("dateDay");
		gridConstDate.weighty = 0.1;
		gridConstDate.weightx = 0.2;
		gridConstDate.anchor = GridBagConstraints.LAST_LINE_START;
		gridConstDate.gridx = 0;
		gridConstDate.gridy = 0;
		frame.getContentPane().add(lblDate,gridConstDate);
		
		JPanel pnlSetTime = new JPanel();
		//pnlSetTime.setSize(300,300);
		pnlSetTime.setOpaque(true);
		pnlSetTime.setBackground(Color.BLACK);
		//pnlSetTime.setBackground(Color.WHITE);
		pnlSetTime.setForeground(Color.WHITE);
		pnlSetTime.setLayout(null);
		GridBagConstraints gridConstSetTime = new GridBagConstraints();
		gridConstSetTime.fill = GridBagConstraints.BOTH;
		gridConstSetTime.weightx = 1;
		gridConstSetTime.weighty = 0.4;
		gridConstSetTime.gridx = 0;
		gridConstSetTime.gridy = 3;
		frame.getContentPane().add(pnlSetTime,gridConstSetTime);
		
		JSpinner spnHour = new JSpinner();
		
		spnHour.setModel(new SpinnerNumberModel(new Date().getHours(), 0, 23, 1));
		spnHour.setForeground(Color.RED);
		spnHour.setBackground(Color.WHITE);
		spnHour.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spnHour.setBounds(335, 11, 78, 34);
		pnlSetTime.add(spnHour);
		
		JSpinner spnMinute = new JSpinner();
		spnMinute.setModel(new SpinnerNumberModel(new Date().getMinutes(), 0, 59, 1));
		spnMinute.setForeground(Color.RED);
		spnMinute.setBounds(500, 11, 78, 34);
		pnlSetTime.add(spnMinute);
		
		JSpinner spnSecond = new JSpinner();
		spnSecond.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spnSecond.setForeground(Color.RED);
		spnSecond.setBounds(664, 11, 78, 34);
		pnlSetTime.add(spnSecond);
		
		JLabel lblMm = new JLabel("MM:");
		lblMm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMm.setForeground(Color.RED);
		lblMm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMm.setBounds(453, 11, 46, 34);
		pnlSetTime.add(lblMm);
		
		JLabel lblSs = new JLabel("SS:");
		lblSs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSs.setForeground(Color.RED);
		lblSs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSs.setBounds(620, 11, 46, 34);
		pnlSetTime.add(lblSs);
		
		JLabel lblHh = new JLabel("HH:");
		lblHh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHh.setForeground(Color.RED);
		lblHh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHh.setBounds(292, 11, 46, 34);
		pnlSetTime.add(lblHh);
		
		
		txtResults = new JTextArea();
		txtResults.setEditable(false);
		txtResults.setRows(5);
		txtResults.setLineWrap(true);
		txtResults.setForeground(Color.WHITE);
		//pnl_1.setSize(1266,200);
		txtResults.setOpaque(true);
		txtResults.setBackground(Color.BLACK);
		//pnl_1.setBackground(Color.RED);
		//pnl_1.setForeground(Color.RED);
		txtResults.setLayout(null);
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.insets = new Insets(0, 20, 0, 20);
		gbc_lblResult.fill = GridBagConstraints.BOTH;
		gbc_lblResult.weightx = 1;
		gbc_lblResult.weighty = 1;
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 4;
		frame.getContentPane().add(txtResults,gbc_lblResult); 
		
		JCheckBox chckbxGeneratePdf = new JCheckBox("Generate PDF");
		chckbxGeneratePdf.setSelected(true);
		chckbxGeneratePdf.setForeground(Color.WHITE);
		chckbxGeneratePdf.setBackground(Color.BLACK);
		chckbxGeneratePdf.setBounds(906, 17, 97, 23);
		pnlSetTime.add(chckbxGeneratePdf);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text = "";
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				if(index%6 == 0) {
					text.concat( " l \n\n l");System.out.println("break");}
				if(index == 0) {
					if(chckbxGeneratePdf.isSelected())
					{
						
						
						try {
							SimpleDateFormat sdf2 = new SimpleDateFormat("YYYYMMdd");
							MyFirstTable.createTableHeaders();
					        new MyFirstTable().createPdf(MyFirstTable.REPORT + sdf2.format(new Date()) + ".pdf");
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					text = "\n\n";
					chckbxGeneratePdf.setEnabled(false);
				}else {
					text = txtResults.getText();
					
				}
				text += "  " + (++index) + " -> " + sdf.format(lblTime.adjustTime(new Date(),lblTime.hour,lblTime.minute,lblTime.second));
				
				int temp;
				temp = index%16;
				temp = (temp==0)?16:temp;
				if(index<51) {
					PdfPCell cell_temp = new PdfPCell(new Phrase(String.valueOf(index),FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					cell_temp.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					MyFirstTable.tableLeft.addCell(cell_temp);
					
					cell_temp = new PdfPCell(new Phrase(String.valueOf(temp) ,FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					cell_temp.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					MyFirstTable.tableLeft.addCell(cell_temp);
					MyFirstTable.tableLeft.addCell(new Phrase(sdf.format(lblTime.adjustTime(new Date(),lblTime.hour,lblTime.minute,lblTime.second)),FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					MyFirstTable.tableLeft.addCell(new Phrase("        ",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					MyFirstTable.tableLeft.addCell(new Phrase("        ",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					SimpleDateFormat sdf2 = new SimpleDateFormat("YYYYMMdd");
			        try {
						new MyFirstTable().createPdf(MyFirstTable.REPORT + sdf2.format(new Date()) + ".pdf");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					PdfPCell cell_temp = new PdfPCell(new Phrase(String.valueOf(index),FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					cell_temp.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					MyFirstTable.tableRight.addCell(cell_temp);
					
					cell_temp = new PdfPCell(new Phrase(String.valueOf(temp) ,FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					cell_temp.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					MyFirstTable.tableRight.addCell(cell_temp);
					MyFirstTable.tableRight.addCell(new Phrase(sdf.format(lblTime.adjustTime(new Date(),lblTime.hour,lblTime.minute,lblTime.second)),FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					MyFirstTable.tableRight.addCell(new Phrase("        ",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					MyFirstTable.tableRight.addCell(new Phrase("        ",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
					SimpleDateFormat sdf2 = new SimpleDateFormat("YYYYMMdd");
			        try {
						new MyFirstTable().createPdf(MyFirstTable.REPORT + sdf2.format(new Date()) + ".pdf");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(text);
				txtResults.setText(text);
					
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
		btnSet.setBounds(781, 11, 65, 34);
		pnlSetTime.add(btnSet);
		
		
		
		
		//pnlSetTime.setLayout(new GridLayout(1,));
		
		
		
//		txtResults = new JTextArea();
//		
//		txtResults.setBounds(616, 28, 556, 131);
//		lblResult.add(txtResults);
//		txtResults.setColumns(10);
		
		frame.setBounds(0, 0, 1266, 720);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
