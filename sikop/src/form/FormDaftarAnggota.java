package form;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import comp.SQLiteMan;

import classes.Kas;

public class FormDaftarAnggota extends JInternalFrame {

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

	/**
	 * Create the frame.
	 */
	public FormDaftarAnggota() {
		setTitle("Form Daftar Anggota");
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
	}

}
