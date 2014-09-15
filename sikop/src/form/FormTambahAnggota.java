package form;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JFrame;

import comp.SQLiteMan;

import classes.Anggota;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTambahAnggota extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2629813346107643735L;
	private JTextField txtNama;
	private SQLiteMan db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTambahAnggota frame = new FormTambahAnggota();
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
	public FormTambahAnggota() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {
				
			}
		});
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(true);
		setClosable(true);
		setTitle("Form Tambah Anggota");
		setBounds(100, 100, 300, 135);
		getContentPane().setLayout(null);
		
		db = new SQLiteMan(getContentPane());
		
		JLabel lblNewLabel = new JLabel("Tambah Anggota");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 127, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(10, 45, 46, 14);
		getContentPane().add(lblNama);
		
		txtNama = new JTextField();
		txtNama.setBounds(66, 42, 218, 20);
		getContentPane().add(txtNama);
		txtNama.setColumns(10);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNama.getText().toString().equals("")){
					JOptionPane.showMessageDialog(getContentPane(), 
							"Nama Anggota tidak boleh kosong",
							"Terjadi kesalahan",
							JOptionPane.ERROR_MESSAGE);
				}else{
					Anggota a = new Anggota();
					a.setId_anggota("");
					a.setNama_anggota(txtNama.getText().toString());
					if(!db.checkAnggota(a)){
						db.insertAnggota(a);
					}else{
						JOptionPane.showMessageDialog(getContentPane(), 
								"Anggota sudah ada dalam database. Tidak bisa menyimpan anggota dengan nama yang sama", 
								"Pemberitahuan", 
								JOptionPane.INFORMATION_MESSAGE);
					}
					txtNama.setText("");
				}
			}
		});
		btnSimpan.setBounds(10, 70, 91, 23);
		getContentPane().add(btnSimpan);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNama.setText("");
				setVisible(false);
			}
		});
		btnBatal.setBounds(111, 70, 91, 23);
		getContentPane().add(btnBatal);

	}
}
