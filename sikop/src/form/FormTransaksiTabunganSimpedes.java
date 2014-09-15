package form;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import comp.SQLiteMan;

import classes.Transaksi;

public class FormTransaksiTabunganSimpedes extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -77235883282532801L;
	private JTextField txtJumlah;
	private JTextField txtTanggal;
	private JTextArea txtDeskripsi;
	protected Date d;
	private JRadioButton rdbtnDebet;
	private JRadioButton rdbtnKredit;
	private String selJenis = "debet";
	private SQLiteMan db = new SQLiteMan(getContentPane());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTransaksiTabunganSimpedes frame = new FormTransaksiTabunganSimpedes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormTransaksiTabunganSimpedes() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {
			}
			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				rdbtnDebet.setSelected(true);
				rdbtnKredit.setSelected(false);
				selJenis = "debet";
				txtJumlah.setText("0,00");
				txtDeskripsi.setText("");
				txtTanggal.setText(String.valueOf(d.getDate()) + "-" + String.valueOf(d.getMonth() + 1) + "-" + String.valueOf(d.getYear() + 1900));
			}
		});
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if(arg0.getPropertyName().equals(IS_SELECTED_PROPERTY)){
					
				}else if(arg0.getPropertyName().equals(IS_CLOSED_PROPERTY)){
					
				}
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Form Transaksi Tabungan Simpedes");
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(null);
		
		JLabel lblTransaksiTabunganSimpedes = new JLabel("Transaksi Tabungan Simpedes");
		lblTransaksiTabunganSimpedes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTransaksiTabunganSimpedes.setBounds(10, 10, 424, 18);
		getContentPane().add(lblTransaksiTabunganSimpedes);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(10, 39, 424, 30);
		getContentPane().add(panel);
		
		rdbtnDebet = new JRadioButton("Debet");
		rdbtnDebet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDebet.setSelected(true);
				rdbtnKredit.setSelected(false);
				selJenis = "debet";
			}
		});
		rdbtnDebet.setSelected(true);
		panel.add(rdbtnDebet);
		
		rdbtnKredit = new JRadioButton("Kredit");
		rdbtnKredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDebet.setSelected(false);
				rdbtnKredit.setSelected(true);
				selJenis = "kredit";
			}
		});
		panel.add(rdbtnKredit);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setBounds(10, 80, 46, 14);
		getContentPane().add(lblJumlah);
		
		txtJumlah = new JTextField();
		txtJumlah.setHorizontalAlignment(SwingConstants.RIGHT);
		txtJumlah.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtJumlah.getText().toString().equals("0,00")){
					txtJumlah.setText(",00");
					txtJumlah.setCaretPosition(0);
				}else{
					if(txtJumlah.getText().toString().contains(",")){
						txtJumlah.setCaretPosition(txtJumlah.getText().length() - 3);
					}else{
						if(txtJumlah.getText().toString().equals("")){
							
						}else{
							txtJumlah.setCaretPosition(txtJumlah.getText().length());
						}
					}
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtJumlah.getText().toString().equals("") || txtJumlah.getText().toString().equals(",00")){
					txtJumlah.setText("0,00");
				}
			}
		});
		txtJumlah.setText("0,00");
		txtJumlah.setBounds(66, 77, 160, 20);
		getContentPane().add(txtJumlah);
		txtJumlah.setColumns(10);
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setBounds(10, 105, 46, 14);
		getContentPane().add(lblTanggal);
		
		JLabel lblDeskripsi = new JLabel("Deskripsi");
		lblDeskripsi.setBounds(10, 130, 46, 14);
		getContentPane().add(lblDeskripsi);
		
		txtTanggal = new JTextField();
		txtTanggal.setBounds(66, 102, 160, 20);
		getContentPane().add(txtTanggal);
		txtTanggal.setColumns(10);
		d = new Date();
		txtTanggal.setText(String.valueOf(d.getDate()) + "-" + String.valueOf(d.getMonth() + 1) + "-" + String.valueOf(d.getYear() + 1900));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 130, 362, 133);
		getContentPane().add(scrollPane);
		
		txtDeskripsi = new JTextArea();
		txtDeskripsi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDeskripsi.setWrapStyleWord(true);
		txtDeskripsi.setLineWrap(true);
		scrollPane.setViewportView(txtDeskripsi);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtJumlah.getText().toString().equals("")){
					JOptionPane.showMessageDialog(getContentPane(), 
							"Jumlah tidak boleh kosong", 
							"Peringatan", 
							JOptionPane.WARNING_MESSAGE);
				}else{
					if(txtTanggal.getText().toString().equals("")){
						JOptionPane.showMessageDialog(getContentPane(), 
								"Tanggal tidak boleh kosong", 
								"Peringatan", 
								JOptionPane.WARNING_MESSAGE);
					}else{
						Transaksi t = new Transaksi();
						t.setId_master_transaksi("1");
						t.setJenis_transaksi(selJenis);
						t.setJumlah_transaksi(txtJumlah.getText().toString());
						t.setId_anggota("0");
						String keterangan = "deskripsi~" + txtDeskripsi.getText().toString() + "|tanggal~" + txtTanggal.getText().toString();
						t.setKeterangan(keterangan);
						t.setWaktu(String.valueOf(System.currentTimeMillis()));
						db.insertTransaksi(t);
						txtJumlah.setText("0,00");
						txtTanggal.setText(String.valueOf(d.getDate()) + "-" + String.valueOf(d.getMonth() + 1) + "-" + String.valueOf(d.getYear() + 1900));
						txtDeskripsi.setText("");
					}
				}
			}
		});
		btnSimpan.setBounds(66, 274, 91, 23);
		getContentPane().add(btnSimpan);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				rdbtnDebet.setSelected(true);
				rdbtnKredit.setSelected(false);
				selJenis = "debet";
				txtJumlah.setText("0,00");
				txtDeskripsi.setText("");
				txtTanggal.setText(String.valueOf(d.getDate()) + "-" + String.valueOf(d.getMonth() + 1) + "-" + String.valueOf(d.getYear() + 1900));
				setVisible(false);
			}
		});
		btnBatal.setBounds(167, 274, 91, 23);
		getContentPane().add(btnBatal);

	}
}
