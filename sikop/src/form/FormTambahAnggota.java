package form;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormTambahAnggota extends JInternalFrame {
	private JTextField txtNama;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTambahAnggota frame = new FormTambahAnggota();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		setResizable(true);
		setClosable(true);
		setTitle("Tambah Anggota");
		setBounds(100, 100, 296, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(10, 36, 46, 14);
		getContentPane().add(lblNama);
		
		txtNama = new JTextField();
		txtNama.setBounds(66, 33, 192, 20);
		getContentPane().add(txtNama);
		txtNama.setColumns(10);
		
		JLabel lblNomor = new JLabel("Nomor");
		lblNomor.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNomor);
		
		JLabel lblNo = new JLabel("No");
		lblNo.setBounds(66, 11, 46, 14);
		getContentPane().add(lblNo);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setBounds(66, 64, 91, 23);
		getContentPane().add(btnSimpan);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setBounds(167, 64, 91, 23);
		getContentPane().add(btnBatal);

	}
}
