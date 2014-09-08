package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.UIManager;

import comp.SQLiteMan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormUtama extends JFrame {

	private JPanel contentPane;
	private FormTambahAnggota formTambahAnggota;
	private FormDaftarAnggota formDaftarAnggota;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SQLiteMan db = new SQLiteMan();
				db.buatTabel();
				try {
					FormUtama frame = new FormUtama();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public FormUtama() {		
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Sistem Informasi Koperasi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnKoperasi = new JMenu("Koperasi");
		menuBar.add(mnKoperasi);
		
		JMenuItem mntmPengaturan = new JMenuItem("Pengaturan");
		mnKoperasi.add(mntmPengaturan);
		
		JMenuItem mntmKeluar = new JMenuItem("Keluar");
		mntmKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnKoperasi.add(mntmKeluar);
		
		JMenu mnAnggota = new JMenu("Anggota");
		menuBar.add(mnAnggota);
		
		JMenuItem mntmDaftarAnggota = new JMenuItem("Daftar Anggota");
		mntmDaftarAnggota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formDaftarAnggota = new FormDaftarAnggota();
				formDaftarAnggota.setVisible(true);
				desktopPane.add(formDaftarAnggota);
			}
		});
		mnAnggota.add(mntmDaftarAnggota);
		
		JMenuItem mntmTambahAnggota = new JMenuItem("Tambah Anggota");
		mntmTambahAnggota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formTambahAnggota = new FormTambahAnggota();
				formTambahAnggota.setVisible(true);
				desktopPane.add(formTambahAnggota);
			}
		});
		mnAnggota.add(mntmTambahAnggota);
		
		JMenu mnTransaksi = new JMenu("Transaksi");
		menuBar.add(mnTransaksi);
		
		JMenuItem mntmDaftarTransaksi = new JMenuItem("Daftar Transaksi");
		mnTransaksi.add(mntmDaftarTransaksi);
		
		JMenuItem mntmTambahTransaksi = new JMenuItem("Tambah Transaksi");
		mnTransaksi.add(mntmTambahTransaksi);
		
		JMenu mnInventori = new JMenu("Inventori");
		menuBar.add(mnInventori);
		
		JMenuItem mntmDaftarInventori = new JMenuItem("Daftar Inventori");
		mnInventori.add(mntmDaftarInventori);
		
		JMenuItem mntmTambahInventori = new JMenuItem("Tambah Inventori");
		mnInventori.add(mntmTambahInventori);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

}
