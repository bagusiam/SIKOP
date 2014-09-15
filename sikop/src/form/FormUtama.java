package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.UIManager;

import comp.SQLiteMan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Insets;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class FormUtama extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private FormNeraca formNeraca;
	private FormTambahAnggota formTambahAnggota;
	private FormDaftarAnggota formDaftarAnggota;
	private FormTambahTransaksi formTambahTransaksi;
	private FormTransaksiTabunganSimpedes formTransaksiTabunganSimpedes;
	private Random r = new Random();
	private int x = 0, y = 0;
	protected FormTransaksiPiutangPinjaman formTransaksiPiutangPinjaman;

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
		setAlwaysOnTop(true);
		setTitle("Sistem Informasi Koperasi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		SQLiteMan db = new SQLiteMan(getContentPane());
		db.insertDefaultMasterTransaksi();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(5, 5, 5, 5));
		setJMenuBar(menuBar);
		
		JMenu mnKoperasi = new JMenu("Koperasi");
		menuBar.add(mnKoperasi);
		
		JMenuItem mntmNeraca = new JMenuItem("Neraca");
		mntmNeraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(formNeraca==null){
					formNeraca = new FormNeraca();
					x = r.nextInt(desktopPane.getWidth() - formNeraca.getWidth() - 20) + 10;
					y = r.nextInt(desktopPane.getHeight() - formNeraca.getHeight() - 20) + 10;
					formNeraca.setLocation(x, y);
					desktopPane.add(formNeraca);
					formNeraca.setVisible(true);
				}else{
					if(!formNeraca.isVisible()){
						formNeraca.setVisible(true);
					}else{
						try {
							formNeraca.setSelected(true);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		mnKoperasi.add(mntmNeraca);
		
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
				if(formDaftarAnggota==null){
					formDaftarAnggota = new FormDaftarAnggota();
					x = r.nextInt(desktopPane.getWidth() - formDaftarAnggota.getWidth() - 20) + 10;
					y = r.nextInt(desktopPane.getHeight() - formDaftarAnggota.getHeight() - 20) + 10;
					formDaftarAnggota.setLocation(x, y);
					desktopPane.add(formDaftarAnggota);
					formDaftarAnggota.setVisible(true);
				}else{
					if(!formDaftarAnggota.isVisible()){
						formDaftarAnggota.setVisible(true);
					}else{
						try {
							formDaftarAnggota.setSelected(true);
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		mnAnggota.add(mntmDaftarAnggota);
		
		JMenuItem mntmTambahAnggota = new JMenuItem("Tambah Anggota");
		mntmTambahAnggota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(formTambahAnggota==null){
					formTambahAnggota = new FormTambahAnggota();
					x = r.nextInt(desktopPane.getWidth() - formTambahAnggota.getWidth() - 20) + 10;
					y = r.nextInt(desktopPane.getHeight() - formTambahAnggota.getHeight() - 20) + 10;
					formTambahAnggota.setLocation(x, y);
					desktopPane.add(formTambahAnggota);
					formTambahAnggota.setVisible(true);
				}else{
					if(!formTambahAnggota.isVisible()){
						formTambahAnggota.setVisible(true);
					}else{
						try {
							formTambahAnggota.setSelected(true);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		mnAnggota.add(mntmTambahAnggota);
		
		JMenu mnInventori = new JMenu("Inventori");
		menuBar.add(mnInventori);
		
		JMenuItem mntmDaftarInventori = new JMenuItem("Daftar Inventori");
		mnInventori.add(mntmDaftarInventori);
		
		JMenuItem mntmTambahInventori = new JMenuItem("Tambah Inventori");
		mnInventori.add(mntmTambahInventori);
		
		JMenu mnTransaksi = new JMenu("Transaksi");
		menuBar.add(mnTransaksi);
		
		JMenuItem mntmDaftarTransaksi = new JMenuItem("Daftar Transaksi");
		mnTransaksi.add(mntmDaftarTransaksi);
		
		JMenuItem mntmTambahTransaksi = new JMenuItem("Tambah Transaksi");
		mntmTambahTransaksi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(formTambahTransaksi==null){
					formTambahTransaksi = new FormTambahTransaksi();
					x = r.nextInt(desktopPane.getWidth() - formTambahTransaksi.getWidth() - 20) + 10;
					y = r.nextInt(desktopPane.getHeight() - formTambahTransaksi.getHeight() - 20) + 10;
					formTambahTransaksi.setLocation(x, y);
					desktopPane.add(formTambahTransaksi);
					formTambahTransaksi.setVisible(true);
				}else{
					if(!formTambahTransaksi.isVisible()){
						formTambahTransaksi.setVisible(true);
					}else{
						try {
							formTambahTransaksi.setSelected(true);
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		mnTransaksi.add(mntmTambahTransaksi);
		
		JMenu mnAktiva = new JMenu("Aktiva");
		mnTransaksi.add(mnAktiva);
		
		JMenuItem mntmTransaksiTabunganSimpedes = new JMenuItem("Transaksi Tabungan Simpedes");
		mntmTransaksiTabunganSimpedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(formTransaksiTabunganSimpedes==null){
					formTransaksiTabunganSimpedes = new FormTransaksiTabunganSimpedes();
					x = r.nextInt(desktopPane.getWidth() - formTransaksiTabunganSimpedes.getWidth() - 20) + 10;
					y = r.nextInt(desktopPane.getHeight() - formTransaksiTabunganSimpedes.getHeight() - 20) + 10;
					formTransaksiTabunganSimpedes.setLocation(x, y);
					desktopPane.add(formTransaksiTabunganSimpedes);
					formTransaksiTabunganSimpedes.setVisible(true);
				}else{
					if(!formTransaksiTabunganSimpedes.isVisible()){
						formTransaksiTabunganSimpedes.setVisible(true);
					}else{
						try {
							formTransaksiTabunganSimpedes.setSelected(true);
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		mnAktiva.add(mntmTransaksiTabunganSimpedes);
		
		JMenuItem mntmTransaksiPiutangPinjaman = new JMenuItem("Transaksi Piutang Pinjaman");
		mntmTransaksiPiutangPinjaman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(formTransaksiPiutangPinjaman==null){
					formTransaksiPiutangPinjaman = new FormTransaksiPiutangPinjaman();
					x = r.nextInt(desktopPane.getWidth() - formTransaksiPiutangPinjaman.getWidth() - 20) + 10;
					y = r.nextInt(desktopPane.getHeight() - formTransaksiPiutangPinjaman.getHeight() - 20) + 10;
					formTransaksiPiutangPinjaman.setLocation(x, y);
					desktopPane.add(formTransaksiPiutangPinjaman);
					formTransaksiPiutangPinjaman.setVisible(true);
				}else{
					if(!formTransaksiPiutangPinjaman.isVisible()){
						formTransaksiPiutangPinjaman.setVisible(true);
					}else{
						try{
							formTransaksiPiutangPinjaman.setSelected(true);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			}
		});
		mnAktiva.add(mntmTransaksiPiutangPinjaman);
		
		JMenu mnPasiva = new JMenu("Pasiva");
		mnTransaksi.add(mnPasiva);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
