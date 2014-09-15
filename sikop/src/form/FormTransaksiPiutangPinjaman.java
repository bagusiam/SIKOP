package form;

import item.ItemAnggota;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import classes.Anggota;
import classes.Transaksi;

import comp.SQLiteMan;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FormTransaksiPiutangPinjaman extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7639449407611459236L;
	private SQLiteMan db = new SQLiteMan(getContentPane());
	Date d = new Date();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTransaksiPiutangPinjaman frame = new FormTransaksiPiutangPinjaman();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected String selJenis;
	private JRadioButton rdbtnDebet;
	private JRadioButton rdbtnKredit;
	private JLabel lblAnggota;
	private JLabel lblJumlah;
	private JTextField txtJumlah;
	private JComboBox cmbAnggota;
	private JTextField txtTanggal;
	private JTextField txtBunga;
	private JTextArea txtKeterangan;

	private void loadAnggota(){
		ArrayList<Anggota> a = new ArrayList<Anggota>();
		a = db.listAnggota();
		for(Anggota b : a){
			cmbAnggota.addItem(new ItemAnggota(b.getId_anggota(),b.getNama_anggota()));
		}
	}
	
	/**
	 * Create the frame.
	 */
	public FormTransaksiPiutangPinjaman() {
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if(arg0.getPropertyName().equals(IS_SELECTED_PROPERTY)){
					cmbAnggota.removeAllItems();
					loadAnggota();
				}
			}
		});
		setTitle("Form Transaksi Piutang Pinjaman");
		setResizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblTransaksiPiutangPinjaman = new JLabel("Transaksi Piutang Pinjaman");
		lblTransaksiPiutangPinjaman.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTransaksiPiutangPinjaman.setBounds(10, 10, 424, 20);
		getContentPane().add(lblTransaksiPiutangPinjaman);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(10, 40, 424, 30);
		getContentPane().add(panel);
		
		rdbtnDebet = new JRadioButton("Debet");
		rdbtnDebet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selJenis = "debet";
				rdbtnDebet.setSelected(true);
				rdbtnKredit.setSelected(false);
			}
		});
		rdbtnDebet.setSelected(true);
		rdbtnDebet.setVerticalAlignment(SwingConstants.TOP);
		panel.add(rdbtnDebet);
		
		rdbtnKredit = new JRadioButton("Kredit");
		rdbtnKredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selJenis = "kredit";
				rdbtnDebet.setSelected(false);
				rdbtnKredit.setSelected(true);
			}
		});
		rdbtnKredit.setVerticalAlignment(SwingConstants.TOP);
		panel.add(rdbtnKredit);
		
		lblAnggota = new JLabel("Anggota");
		lblAnggota.setBounds(10, 81, 46, 14);
		getContentPane().add(lblAnggota);
		
		lblJumlah = new JLabel("Jumlah");
		lblJumlah.setBounds(10, 106, 46, 14);
		getContentPane().add(lblJumlah);
		
		cmbAnggota = new JComboBox();
		cmbAnggota.setBounds(66, 77, 368, 22);
		getContentPane().add(cmbAnggota);
		
		txtJumlah = new JTextField();
		txtJumlah.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtJumlah.getText().toString().equals("0,00")){
					txtJumlah.setText(",00");
					txtJumlah.setCaretPosition(0);
				}else{
					if(txtJumlah.getText().toString().equals("")){
						
					}else{
						if(txtJumlah.getText().toString().contains(",")){
							txtJumlah.setCaretPosition(txtJumlah.getText().length() - 3);
						}else{
							txtJumlah.setCaretPosition(txtJumlah.getText().length());
						}
					}
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtJumlah.getText().toString().equals("") || txtJumlah.getText().toString().equals(",00")){
					txtJumlah.setText("0,00");
				}
			}
		});
		txtJumlah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		txtJumlah.setText("0,00");
		txtJumlah.setHorizontalAlignment(SwingConstants.RIGHT);
		txtJumlah.setBounds(66, 103, 200, 20);
		getContentPane().add(txtJumlah);
		txtJumlah.setColumns(10);
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setBounds(10, 156, 46, 14);
		getContentPane().add(lblTanggal);
		
		txtTanggal = new JTextField();
		txtTanggal.setBounds(66, 153, 200, 20);
		getContentPane().add(txtTanggal);
		txtTanggal.setColumns(10);
		
		JLabel lblBunga = new JLabel("Bunga");
		lblBunga.setBounds(10, 131, 46, 14);
		getContentPane().add(lblBunga);
		
		txtBunga = new JTextField();
		txtBunga.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBunga.setText("1");
		txtBunga.setBounds(66, 128, 86, 20);
		getContentPane().add(txtBunga);
		txtBunga.setColumns(10);
		
		JLabel label = new JLabel("%");
		label.setBounds(162, 131, 46, 14);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Keterangan");
		lblNewLabel.setBounds(10, 181, 72, 14);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 206, 259, 57);
		getContentPane().add(scrollPane);
		
		txtKeterangan = new JTextArea();
		txtKeterangan.setWrapStyleWord(true);
		txtKeterangan.setLineWrap(true);
		txtKeterangan.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(txtKeterangan);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object item = cmbAnggota.getSelectedItem();
				if(item==null){
					JOptionPane.showMessageDialog(getContentPane(), "Anggota tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
				}else{
					if(txtJumlah.getText().toString().equals("")){
						JOptionPane.showMessageDialog(getContentPane(), "Jumlah tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
					}else{
						if(txtBunga.getText().toString().equals("")){
							JOptionPane.showMessageDialog(getContentPane(), "Bunga tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
						}else{
							if(txtTanggal.getText().toString().equals("")){
								JOptionPane.showMessageDialog(getContentPane(), "Tanggal tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
							}else{
								String id_anggota = ((ItemAnggota)item).getId_anggota();
								Transaksi t = new Transaksi();
								t.setId_master_transaksi("2");
								t.setJenis_transaksi(selJenis);
								t.setId_anggota(id_anggota);
								t.setJumlah_transaksi(txtJumlah.getText().toString());
								t.setWaktu(String.valueOf(System.currentTimeMillis()));
								t.setKeterangan("keterangan~" + txtKeterangan.getText().toString() + "|tanggal~" + txtTanggal.getText().toString());
								db.insertTransaksi(t);
							}
						}
					}
				}
			}
		});
		btnSimpan.setBounds(279, 205, 91, 23);
		getContentPane().add(btnSimpan);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJumlah.setText("0,00");
				txtKeterangan.setText("");
				txtBunga.setText("1");
				txtTanggal.setText(String.valueOf(d.getDate()) + "-" + String.valueOf(d.getMonth() + 1) + "-" + String.valueOf(d.getYear() + 1900));
				setVisible(false);
			}
		});
		btnBatal.setBounds(279, 239, 91, 23);
		getContentPane().add(btnBatal);

		loadAnggota();
		
		txtTanggal.setText(String.valueOf(d.getDate()) + "-" + String.valueOf(d.getMonth() + 1) + "-" + String.valueOf(d.getYear() + 1900));
	}
}
