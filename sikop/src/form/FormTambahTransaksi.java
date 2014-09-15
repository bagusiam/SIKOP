package form;

import item.ItemAnggota;
import item.ItemJenisTransaksi;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;

import classes.Anggota;
import classes.Neraca;
import classes.Transaksi;

import comp.SQLiteMan;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTambahTransaksi extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5828617755347515756L;
	private JComboBox cmbJenisTransaksi;
	private SQLiteMan db;
	private JTextField txtJumlah;
	private JTextArea txtKeterangan;
	private JComboBox cmbAnggota;
	private JRadioButton rdbtnKredit;
	private JRadioButton rdbtnDebet;
	private String selJenis = "kredit";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTambahTransaksi frame = new FormTambahTransaksi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadComboAnggota(){
		ArrayList<Anggota> a = new ArrayList<Anggota>();
		a = db.listAnggota();
		cmbAnggota.addItem(new ItemAnggota("0", "0"));
		for (Anggota t : a) {
			cmbAnggota.addItem(new ItemAnggota(t.getId_anggota(), t.getNama_anggota()));
		}
	}
	
	public void loadComboJenisTransaksi(){
		ArrayList<Neraca> a = new ArrayList<Neraca>();
		a = db.listNeraca();
		for (Neraca n : a) {
			cmbJenisTransaksi.addItem(new ItemJenisTransaksi(n.getId_neraca(),n.getNama_neraca() + " ("+n.getJenis_neraca()+")"));
		}
	}
	
	/**
	 * Create the frame.
	 */
	public FormTambahTransaksi() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {
				txtJumlah.setText("0,00");
				txtKeterangan.setText("");
			}
		});
		setClosable(true);
		setResizable(true);
		setTitle("Form Tambah Transaksi");
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(null);
		
		db = new SQLiteMan(getContentPane());
		
		JLabel lblNewLabel = new JLabel("Tambah Transaksi");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 150, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblJenisTransaksi = new JLabel("Jenis Transaksi");
		lblJenisTransaksi.setBounds(10, 35, 100, 14);
		getContentPane().add(lblJenisTransaksi);
		
		cmbJenisTransaksi = new JComboBox();
		cmbJenisTransaksi.setBounds(120, 31, 314, 22);
		getContentPane().add(cmbJenisTransaksi);
		
		JLabel lblAnggota = new JLabel("Anggota");
		lblAnggota.setBounds(10, 60, 46, 14);
		getContentPane().add(lblAnggota);
		
		cmbAnggota = new JComboBox();
		cmbAnggota.setBounds(120, 56, 314, 22);
		getContentPane().add(cmbAnggota);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setBounds(10, 85, 46, 14);
		getContentPane().add(lblJumlah);
		
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
						if(txtJumlah.getText().contains(",")){
							txtJumlah.setCaretPosition(txtJumlah.getText().length() - 3);
						}else{
							txtJumlah.setCaretPosition(txtJumlah.getText().length());
						}
					}
				}
			}
		});
		txtJumlah.setHorizontalAlignment(SwingConstants.RIGHT);
		txtJumlah.setText("0,00");
		txtJumlah.setBounds(120, 82, 314, 20);
		getContentPane().add(txtJumlah);
		txtJumlah.setColumns(10);
		
		JLabel lblKeterangan = new JLabel("Keterangan");
		lblKeterangan.setBounds(10, 142, 100, 14);
		getContentPane().add(lblKeterangan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 139, 314, 100);
		getContentPane().add(scrollPane);
		
		txtKeterangan = new JTextArea();
		txtKeterangan.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtKeterangan.setWrapStyleWord(true);
		txtKeterangan.setLineWrap(true);
		scrollPane.setViewportView(txtKeterangan);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtJumlah.getText().toString().equals("")){
					JOptionPane.showMessageDialog(getContentPane(), 
							"Jumlah tidak boleh kosong", "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
				}else{
					Transaksi t = new Transaksi();
					Object jnsTrans = cmbJenisTransaksi.getSelectedItem();
					String idMasterTrans = ((ItemJenisTransaksi)jnsTrans).getId_item();
					t.setId_master_transaksi(idMasterTrans);
					Object ang = cmbAnggota.getSelectedItem();
					String idAnggota = ((ItemAnggota)ang).getId_anggota();
					t.setId_anggota(idAnggota);
					t.setJenis_transaksi(selJenis);
					t.setJumlah_transaksi(txtJumlah.getText().toString());
					t.setKeterangan(txtKeterangan.getText().toString());
					t.setWaktu(String.valueOf(System.currentTimeMillis()));
					db.insertTransaksi(t);
					txtJumlah.setText("0,00");
					txtKeterangan.setText("");
				}
			}
		});
		btnSimpan.setBounds(120, 250, 91, 23);
		getContentPane().add(btnSimpan);
		
		rdbtnKredit = new JRadioButton("Kredit");
		rdbtnKredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnKredit.setSelected(true);
				rdbtnDebet.setSelected(false);
				selJenis = "kredit";
			}
		});
		rdbtnKredit.setSelected(true);
		rdbtnKredit.setBounds(120, 109, 109, 23);
		getContentPane().add(rdbtnKredit);
		
		rdbtnDebet = new JRadioButton("Debet");
		rdbtnDebet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDebet.setSelected(true);
				rdbtnKredit.setSelected(false);
				selJenis = "debet";
			}
		});
		rdbtnDebet.setBounds(231, 109, 109, 23);
		getContentPane().add(rdbtnDebet);

		loadComboAnggota();
		loadComboJenisTransaksi();
	}
}
