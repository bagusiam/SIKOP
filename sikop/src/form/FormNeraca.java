package form;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import classes.Aktiva;
import classes.Pasiva;

import comp.SQLiteMan;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FormNeraca extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblAktiva;
	private JTextField txtNamaAktiva;
	private JTextField txtJumlahAktiva;
	private SQLiteMan db;
	private DefaultTableModel dtmAktiva, dtmPasiva, dtmNeraca;
	private JLabel lblNTotalAktiva, lblNTotalPasiva;
	private JTable tblPasiva;
	private JTextField txtNamaPasiva;
	private JTextField txtJumlahPasiva;
	private JTable tblNeraca;
	private JLabel lblTAktiva;
	private JLabel lblTPasiva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNeraca frame = new FormNeraca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadNeraca(){
		DefaultTableCellRenderer ren = new DefaultTableCellRenderer();
		ren.setHorizontalAlignment(SwingConstants.RIGHT);
		dtmNeraca = new DefaultTableModel();
		dtmNeraca.addColumn("Aktiva");
		dtmNeraca.addColumn("");
		dtmNeraca.addColumn("");
		dtmNeraca.addColumn("Pasiva");
		dtmNeraca.addColumn("");
		ArrayList<Aktiva> a = new ArrayList<Aktiva>();
		a = db.listAktiva();
		ArrayList<Pasiva> p = new ArrayList<Pasiva>();
		p = db.listPasiva();
		String data[] = {"","","","",""};
		Double jumAktiva = 0.00;
		Double jumPasiva = 0.00;
		Double n = 0.00;
		if(a.size() > p.size()){
			for (int i = 0; i < p.size(); i++) {
				data[0] = a.get(i).getNama_aktiva();
				data[3] = p.get(i).getNama_pasiva();
				data[1] = a.get(i).getJumlah_aktiva();
				data[4] = p.get(i).getJumlah_pasiva();
				data[2] = "";
				n = Double.valueOf(a.get(i).getJumlah_aktiva().replace(",", "."));
				jumAktiva += n;
				n = Double.valueOf(p.get(i).getJumlah_pasiva().replace(",", "."));
				jumPasiva += n;
				dtmNeraca.addRow(data);
			}
			
			for (int i = p.size(); i < a.size(); i++) {
				data[0] = a.get(i).getNama_aktiva();
				data[3] = "";
				data[1] = a.get(i).getJumlah_aktiva();
				data[4] = "";
				data[2] = "";
				n = Double.valueOf(a.get(i).getJumlah_aktiva().replace(",", "."));
				jumAktiva += n;
				dtmNeraca.addRow(data);
			}
		}else if(a.size() < p.size()){
			for (int i = 0; i < a.size(); i++) {
				data[0] = a.get(i).getNama_aktiva();
				data[3] = p.get(i).getNama_pasiva();
				data[1] = a.get(i).getJumlah_aktiva();
				data[4] = p.get(i).getJumlah_pasiva();
				data[2] = "";
				n = Double.valueOf(a.get(i).getJumlah_aktiva().replace(",", "."));
				jumAktiva += n;
				n = Double.valueOf(p.get(i).getJumlah_pasiva().replace(",", "."));
				jumPasiva += n;
				dtmNeraca.addRow(data);
			}
			
			for (int i = a.size(); i < p.size(); i++) {
				data[0] = "";
				data[3] = p.get(i).getNama_pasiva();
				data[1] = "";
				data[4] = p.get(i).getJumlah_pasiva();
				data[2] = "";
				n = Double.valueOf(p.get(i).getJumlah_pasiva().replace(",", "."));
				jumPasiva += n;
				dtmNeraca.addRow(data);
			}
		}else{
			for (int i = 0; i < a.size(); i++) {
				data[0] = a.get(i).getNama_aktiva();
				data[3] = p.get(i).getNama_pasiva();
				data[1] = a.get(i).getJumlah_aktiva();
				data[4] = p.get(i).getJumlah_pasiva();
				data[2] = "";
				n = Double.valueOf(a.get(i).getJumlah_aktiva().replace(",", "."));
				jumAktiva += n;
				n = Double.valueOf(p.get(i).getJumlah_pasiva().replace(",", "."));
				jumPasiva += n;
				dtmNeraca.addRow(data);
			}
		}
		tblNeraca.setModel(dtmNeraca);
		tblNeraca.getColumnModel().getColumn(1).setCellRenderer(ren);
		tblNeraca.getColumnModel().getColumn(4).setCellRenderer(ren);
		tblNeraca.getColumnModel().getColumn(2).setMaxWidth(5);
		DecimalFormat df = new DecimalFormat("0.00");
		String t = df.format(jumAktiva);
		lblTAktiva.setText(t.replace(".", ","));
		t = df.format(jumPasiva);
		lblTPasiva.setText(t.replace(".", ","));
	}
	
	public void loadAktiva(){
		dtmAktiva = new DefaultTableModel();
		dtmAktiva.addColumn("Nama Aktiva");
		dtmAktiva.addColumn("Jumlah Aktiva");
		ArrayList<Aktiva> a = new ArrayList<Aktiva>();
		a = db.listAktiva();
		String data[] = {"",""};
		Double total = 0.00;
		Double nilai = 0.00;
		for (Aktiva b : a) {
			data[0] = b.getNama_aktiva();
			data[1] = b.getJumlah_aktiva().replace(".", ",");
			nilai = Double.valueOf(b.getJumlah_aktiva().replace(",", "."));
			total += nilai;
			dtmAktiva.addRow(data);
		}
		tblAktiva.setModel(dtmAktiva);
		DefaultTableCellRenderer ren = new DefaultTableCellRenderer();
		ren.setHorizontalAlignment(SwingConstants.RIGHT);
		tblAktiva.getColumnModel().getColumn(1).setCellRenderer(ren);
		DecimalFormat df = new DecimalFormat("0.00");
		String t = df.format(total);
		lblNTotalAktiva.setText(t.replace(".", ","));
	}
	
	public void loadPasiva(){
		dtmPasiva = new DefaultTableModel();
		dtmPasiva.addColumn("Nama Pasiva");
		dtmPasiva.addColumn("Jumlah Pasiva");
		ArrayList<Pasiva> a = new ArrayList<Pasiva>();
		a = db.listPasiva();
		String data[] = {"",""};
		Double total = 0.00;
		Double nilai = 0.00;
		for (Pasiva b : a) {
			data[0] = b.getNama_pasiva();
			data[1] = b.getJumlah_pasiva().replace(".", ",");
			nilai = Double.valueOf(b.getJumlah_pasiva().replace(",", "."));
			total += nilai;
			dtmPasiva.addRow(data);
		}
		tblPasiva.setModel(dtmPasiva);
		DefaultTableCellRenderer ren = new DefaultTableCellRenderer();
		ren.setHorizontalAlignment(SwingConstants.RIGHT);
		tblPasiva.getColumnModel().getColumn(1).setCellRenderer(ren);
		DecimalFormat df = new DecimalFormat("0.00");
		String t = df.format(total);
		lblNTotalPasiva.setText(t.replace(".", ","));
	}
	
	/**
	 * Create the frame.
	 */
	public FormNeraca() {
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if(arg0.getPropertyName().equals(IS_SELECTED_PROPERTY)){
					loadAktiva();
					loadNeraca();
					loadPasiva();
				}
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setResizable(true);
		setTitle("Form Neraca");
		setBounds(100, 100, 600, 350);
		
		db = new SQLiteMan(getContentPane());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnlNeraca = new JPanel();
		tabbedPane.addTab("Neraca", null, pnlNeraca, null);
		pnlNeraca.setLayout(null);
		
		JScrollPane scrPaneNeraca = new JScrollPane();
		scrPaneNeraca.setBounds(10, 10, 569, 230);
		pnlNeraca.add(scrPaneNeraca);
		
		tblNeraca = new JTable();
		scrPaneNeraca.setViewportView(tblNeraca);
		
		lblTAktiva = new JLabel("New label");
		lblTAktiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTAktiva.setBounds(10, 274, 280, 14);
		pnlNeraca.add(lblTAktiva);
		
		lblTPasiva = new JLabel("New label");
		lblTPasiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTPasiva.setBounds(299, 274, 280, 14);
		pnlNeraca.add(lblTPasiva);
		
		JLabel lblTotalAktiva = new JLabel("Total Aktiva");
		lblTotalAktiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAktiva.setBounds(144, 251, 146, 14);
		pnlNeraca.add(lblTotalAktiva);
		
		JLabel lblTotalPasiva = new JLabel("Total Pasiva");
		lblTotalPasiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPasiva.setBounds(442, 251, 137, 14);
		pnlNeraca.add(lblTotalPasiva);
		
		JPanel pnlAktiva = new JPanel();
		tabbedPane.addTab("Aktiva", null, pnlAktiva, null);
		pnlAktiva.setLayout(null);
		
		JScrollPane scrPaneAktiva = new JScrollPane();
		scrPaneAktiva.setBounds(10, 10, 350, 200);
		pnlAktiva.add(scrPaneAktiva);
		
		tblAktiva = new JTable();
		scrPaneAktiva.setViewportView(tblAktiva);
		
		JLabel lblTambahJenisAktiva = new JLabel("Tambah Jenis Aktiva");
		lblTambahJenisAktiva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTambahJenisAktiva.setBounds(370, 12, 209, 14);
		pnlAktiva.add(lblTambahJenisAktiva);
		
		JLabel lblNamaAktiva = new JLabel("Nama Aktiva");
		lblNamaAktiva.setBounds(370, 37, 209, 14);
		pnlAktiva.add(lblNamaAktiva);
		
		txtNamaAktiva = new JTextField();
		txtNamaAktiva.setBounds(370, 62, 209, 20);
		pnlAktiva.add(txtNamaAktiva);
		txtNamaAktiva.setColumns(50);
		
		JLabel lblJumlahAktiva = new JLabel("Jumlah Aktiva");
		lblJumlahAktiva.setBounds(370, 93, 209, 14);
		pnlAktiva.add(lblJumlahAktiva);
		
		txtJumlahAktiva = new JTextField();
		txtJumlahAktiva.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtJumlahAktiva.getText().toString().equals("0,00")){
					txtJumlahAktiva.setText(",00");
					txtJumlahAktiva.setCaretPosition(0);
				}else{
					if(txtJumlahAktiva.getText().toString().equals("")){
						
					}else{
						if(txtJumlahAktiva.getText().toString().contains(",")){
							txtJumlahAktiva.setCaretPosition(txtJumlahAktiva.getText().length() - 3);
						}else{
							txtJumlahAktiva.setCaretPosition(txtJumlahAktiva.getText().length());
						}
					}
				}
			}
		});
		txtJumlahAktiva.setHorizontalAlignment(SwingConstants.RIGHT);
		txtJumlahAktiva.setText("0,00");
		txtJumlahAktiva.setBounds(370, 118, 209, 20);
		pnlAktiva.add(txtJumlahAktiva);
		txtJumlahAktiva.setColumns(50);
		
		JButton btnSimpanAktiva = new JButton("Simpan");
		btnSimpanAktiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNamaAktiva.getText().toString().equals("")){
					JOptionPane.showMessageDialog(getContentPane(), 
							"Nama Aktiva tidak boleh kosong",
							"Peringatan",
							JOptionPane.WARNING_MESSAGE);
				}else{
					if(txtJumlahAktiva.getText().toString().equals("")){
						JOptionPane.showMessageDialog(getContentPane(), 
								"Jumlah Aktiva tidak boleh kosong",
								"Peringatan",
								JOptionPane.WARNING_MESSAGE);
					}else{
						Aktiva a = new Aktiva();
						a.setId_aktiva("0");
						a.setJumlah_aktiva(txtJumlahAktiva.getText().toString());
						a.setKeterangan("");
						a.setNama_aktiva(txtNamaAktiva.getText().toString());
						if(!db.checkAktiva(a)){
							db.insertAktiva(a);
						}else{
							JOptionPane.showMessageDialog(getContentPane(), 
									"Jenis aktiva sudah ada dalam dalam database. Tidak dapat menyimpan aktiva dengan nama yang sama",
									"Pemberitahuan",
									JOptionPane.INFORMATION_MESSAGE);
						}
						txtNamaAktiva.setText("");
						txtJumlahAktiva.setText("0,00");
						loadAktiva();
						loadNeraca();
					}
				}
			}
		});
		btnSimpanAktiva.setBounds(370, 149, 91, 23);
		pnlAktiva.add(btnSimpanAktiva);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(185, 221, 175, 14);
		pnlAktiva.add(lblTotal);
		
		lblNTotalAktiva = new JLabel("0,00");
		lblNTotalAktiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNTotalAktiva.setBounds(10, 246, 350, 14);
		pnlAktiva.add(lblNTotalAktiva);
		
		JButton btnBatalAktiva = new JButton("Batal");
		btnBatalAktiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNamaAktiva.setText("");
				txtJumlahAktiva.setText("0,00");
			}
		});
		btnBatalAktiva.setBounds(471, 149, 91, 23);
		pnlAktiva.add(btnBatalAktiva);
		
		JPanel pnlPasiva = new JPanel();
		tabbedPane.addTab("Pasiva", null, pnlPasiva, null);
		pnlPasiva.setLayout(null);
		
		JScrollPane scrPanePasiva = new JScrollPane();
		scrPanePasiva.setBounds(10, 10, 350, 200);
		pnlPasiva.add(scrPanePasiva);
		
		tblPasiva = new JTable();
		scrPanePasiva.setViewportView(tblPasiva);
		
		JLabel lblTambahPasiva = new JLabel("Tambah Jenis Pasiva");
		lblTambahPasiva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTambahPasiva.setBounds(370, 12, 209, 14);
		pnlPasiva.add(lblTambahPasiva);
		
		JLabel lblNamaPasiva = new JLabel("Nama Pasiva");
		lblNamaPasiva.setBounds(370, 37, 209, 14);
		pnlPasiva.add(lblNamaPasiva);
		
		txtNamaPasiva = new JTextField();
		txtNamaPasiva.setBounds(370, 62, 209, 20);
		pnlPasiva.add(txtNamaPasiva);
		txtNamaPasiva.setColumns(50);
		
		JLabel lblJumlahPasiva = new JLabel("Jumlah Pasiva");
		lblJumlahPasiva.setBounds(370, 93, 209, 14);
		pnlPasiva.add(lblJumlahPasiva);
		
		txtJumlahPasiva = new JTextField();
		txtJumlahPasiva.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtJumlahPasiva.getText().toString().equals("0,00")){
					txtJumlahPasiva.setText(",00");
					txtJumlahPasiva.setCaretPosition(0);
				}else{
					if(txtJumlahPasiva.getText().toString().equals("")){
						
					}else{
						if(txtJumlahPasiva.getText().toString().contains(",")){
							txtJumlahPasiva.setCaretPosition(txtJumlahPasiva.getText().length() - 3);
						}else{
							txtJumlahPasiva.setCaretPosition(txtJumlahPasiva.getText().length());
						}
					}
				}
			}
		});
		txtJumlahPasiva.setText("0,00");
		txtJumlahPasiva.setHorizontalAlignment(SwingConstants.RIGHT);
		txtJumlahPasiva.setBounds(370, 118, 209, 20);
		pnlPasiva.add(txtJumlahPasiva);
		txtJumlahPasiva.setColumns(50);
		
		JButton btnSimpanPasiva = new JButton("Simpan");
		btnSimpanPasiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNamaPasiva.getText().toString().equals("")){
					JOptionPane.showMessageDialog(getContentPane(), 
							"Nama Pasiva tidak boleh kosong",
							"Peringatan",
							JOptionPane.WARNING_MESSAGE);
				}else{
					if(txtJumlahPasiva.getText().toString().equals("")){
						JOptionPane.showMessageDialog(getContentPane(), 
								"Jumlah Pasiva tidak boleh kosong",
								"Peringatan",
								JOptionPane.WARNING_MESSAGE);
					}else{
						Pasiva a = new Pasiva();
						a.setId_pasiva("0");
						a.setJumlah_pasiva(txtJumlahPasiva.getText().toString());
						a.setKeterangan("");
						a.setNama_pasiva(txtNamaPasiva.getText().toString());
						if(!db.checkPasiva(a)){
							db.insertPasiva(a);
						}else{
							JOptionPane.showMessageDialog(getContentPane(), 
									"Jenis pasiva sudah ada dalam database. Tidak bisa menyimpan aktiva dengan nama yang sama", 
									"Pemberitahuan", 
									JOptionPane.INFORMATION_MESSAGE);
						}
						txtNamaPasiva.setText("");
						txtJumlahPasiva.setText("0,00");
						loadPasiva();
						loadNeraca();
					}
				}
			}
		});
		btnSimpanPasiva.setBounds(370, 149, 91, 23);
		pnlPasiva.add(btnSimpanPasiva);
		
		JButton btnBatalPasiva = new JButton("Batal");
		btnBatalPasiva.setBounds(471, 149, 91, 23);
		pnlPasiva.add(btnBatalPasiva);
		
		JLabel lblTotal_1 = new JLabel("Total");
		lblTotal_1.setBounds(185, 221, 175, 14);
		pnlPasiva.add(lblTotal_1);
		
		lblNTotalPasiva = new JLabel("0,00");
		lblNTotalPasiva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNTotalPasiva.setBounds(10, 246, 350, 14);
		pnlPasiva.add(lblNTotalPasiva);
		
		loadAktiva();
		loadNeraca();
		loadPasiva();
	}
}
