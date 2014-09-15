package form;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

import comp.SQLiteMan;

import classes.Anggota;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FormDaftarAnggota extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6567174486039808091L;
	private JTable tblAnggota;
	private SQLiteMan db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDaftarAnggota frame = new FormDaftarAnggota();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loadAnggota(){
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("id Anggota");
		dtm.addColumn("Nama");
		ArrayList<Anggota> a = new ArrayList<Anggota>();
		a = db.listAnggota();
		String data[] = {"",""};
		for (Anggota b : a) {
			data[0] = b.getId_anggota();
			data[1] = b.getNama_anggota();
			dtm.addRow(data);
		}
		tblAnggota.setModel(dtm);
	}
	
	/**
	 * Create the frame.
	 */
	public FormDaftarAnggota() {
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if(arg0.getPropertyName().equals(IS_SELECTED_PROPERTY)){
					loadAnggota();
				}
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(true);
		setClosable(true);
		setTitle("Form Daftar Anggota");
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(null);
		
		db = new SQLiteMan(getContentPane());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 424, 200);
		getContentPane().add(scrollPane);
		
		tblAnggota = new JTable();
		scrollPane.setViewportView(tblAnggota);

		loadAnggota();
	}
}
