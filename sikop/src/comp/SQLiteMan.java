package comp;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Aktiva;
import classes.Anggota;
import classes.Neraca;
import classes.Pasiva;
import classes.Transaksi;

public class SQLiteMan {

	Container kontainer = null;
	Connection koneksi;
	private static String CREATE_TABEL_MASTER = "CREATE TABLE IF NOT EXISTS master(" +
			"id_master INTEGER PRIMARY KEY AUTOINCREMENT," +
			"nama_master TEXT," +
			"jumlah_master TEXT DEFAULT 0 NOT NULL," +
			"jenis_master TEXT," +
			"keterangan TEXT)";
	private static String CREATE_TABEL_DETAIL = "CREATE TABLE IF NOT EXISTS detail(" +
			"id_detail INTEGER PRIMARY KEY AUTOINCREMENT," +
			"id_master INTEGER DEFAULT 0 NOT NULL," +
			"id_anggota INTEGER DEFAULT 0 NOT NULL," +
			"jenis_detail TEXT," +
			"jumlah_detail TEXT DEFAULT 0 NOT NULL," +
			"waktu_detail TEXT," +
			"keterangan TEXT)";
	private static String CREATE_TABEL_ANGGOTA = "CREATE TABLE IF NOT EXISTS anggota(" +
			"id_anggota INTEGER PRIMARY KEY AUTOINCREMENT," +
			"nama_anggota TEXT)";
	
	public SQLiteMan(){
		try {
			Class.forName("org.sqlite.JDBC");
			koneksi = DriverManager.getConnection("jdbc:sqlite:sikop.db");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public SQLiteMan(Container c){
		try {
			Class.forName("org.sqlite.JDBC");
			koneksi = DriverManager.getConnection("jdbc:sqlite:sikop.db");
			kontainer = c;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void openDB(){
		try {
			if(koneksi.isClosed()){
				Class.forName("org.sqlite.JDBC");
				koneksi = DriverManager.getConnection("jdbc:sqlite:sikop.db");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void insertDefaultMasterTransaksi(){
		openDB();
		Statement s = null;
		try {
			s = koneksi.createStatement();
			String q = "";
			ResultSet r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Tabungan Simpedes'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('1','Tabungan Simpedes','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Piutang Pinjaman'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('2','Piutang Pinjaman','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Piutang Sewa-Beli BRI'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('3','Piutang Sewa-Beli BRI','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Pinjaman Barang'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('4','Pinjaman Barang','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Persediaan Barang Dagangan'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('5','Persediaan Barang Dagangan','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Bangunan'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('6','Bangunan','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Akumulasi Penyusutan Bangunan'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('7','Akumulasi Penyusutan Bangunan','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Mesin-Mesin'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('8','Mesin-Mesin','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Akumulasi Penyusutan Mesin-Mesin'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('9','Akumulasi Penyusutan Mesin-Mesin','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Inventaris'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('10','Inventaris','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Akumulasi Penyusutan Inventaris'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('11','Akumulasi Penyusutan Inventaris','0','aktiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Simpanan Pokok'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('12','Simpanan Pokok','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Simpanan Wajib'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('13','Simpanan Wajib','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Titipan Pajak Sewa Beli'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('14','Titipan Pajak Sewa Beli','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Titipan Lainnya'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('15','Titipan Lainnya','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Cadangan SHU'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('16','Cadangan SHU','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Cadangan Koperasi'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('17','Cadangan Koperasi','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Jasa Pengurus'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('18','Jasa Pengurus','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Jasa Karyawan'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('19','Jasa Karyawan','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Cadangan Pendidikan'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('20','Cadangan Pendidikan','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='Cadangan Dana Sosial'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('21','Cadangan Dana Sosial','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			r = s.executeQuery("SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='SHU Dibagikan'");
			if(r.getInt("jumlah") < 1){
				q = "INSERT INTO master(id_master, nama_master, jumlah_master, jenis_master) " +
						"VALUES('22','SHU Dibagikan','0','pasiva')";
				s.executeUpdate(q);
			}
			r.close();
			
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(), "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE);
		}
		closeDB();
	}
	
	public void closeDB(){
		try {
			if(!koneksi.isClosed()){
				koneksi.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ArrayList<Neraca> listNeraca(){
		openDB();
		ArrayList<Neraca> a = new ArrayList<Neraca>();
		Statement s = null;
		try {
			s = koneksi.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM master ORDER BY jenis_master ASC");
			Neraca b;
			while (r.next()) {
				b = new Neraca();
				b.setId_neraca(r.getString("id_master"));
				b.setJenis_neraca(r.getString("jenis_master"));
				b.setJumlah_neraca(r.getString("jumlah_master"));
				b.setKeterangan(r.getString("keterangan"));
				b.setNama_neraca(r.getString("nama_master"));
				a.add(b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
		closeDB();
		return a;
	}
	
	public ArrayList<Anggota> listAnggota(){
		ArrayList<Anggota> a = new ArrayList<Anggota>();
		openDB();
		Statement s = null;
		try {
			s = koneksi.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM anggota");
			Anggota b;
			while (r.next()) {
				b = new Anggota();
				b.setId_anggota(r.getString("id_anggota"));
				b.setNama_anggota(r.getString("nama_anggota"));
				a.add(b);
			}
			r.close();
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
		closeDB();
		return a;
	}
	
	public ArrayList<Pasiva> listPasiva(){
		ArrayList<Pasiva> a = new ArrayList<Pasiva>();
		openDB();
		Statement s = null;
		try {
			s = koneksi.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM master WHERE jenis_master='pasiva'");
			Pasiva b;
			while (r.next()) {
				b = new Pasiva();
				b.setId_pasiva(r.getString("id_master"));
				b.setJumlah_pasiva(r.getString("jumlah_master"));
				b.setKeterangan(r.getString("keterangan"));
				b.setNama_pasiva(r.getString("nama_master"));
				a.add(b);
			}
			r.close();
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
		closeDB();
		return a;
	}
	
	public ArrayList<Aktiva> listAktiva(){
		ArrayList<Aktiva> a = new ArrayList<Aktiva>();
		openDB();
		Statement s = null;
		try {
			s = koneksi.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM master WHERE jenis_master='aktiva'");
			Aktiva b;
			while (r.next()) {
				b = new Aktiva();
				b.setId_aktiva(r.getString("id_master"));
				b.setJumlah_aktiva(r.getString("jumlah_master"));
				b.setKeterangan(r.getString("keterangan"));
				b.setNama_aktiva(r.getString("nama_master"));
				a.add(b);
			}
			r.close();
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		closeDB();
		return a;
	}
	
	public void insertAnggota(Anggota a){
		openDB();
		Statement s = null;
		try {
			s = koneksi.createStatement();
			String q = "INSERT INTO anggota(nama_anggota) " +
					"VALUES('"+ a.getNama_anggota() +"')";
			s.executeUpdate(q);
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
		if(kontainer!=null){
			JOptionPane.showMessageDialog(kontainer, "Transaksi berhasil disimpan");
		}
		closeDB();
	}
	
	public void insertPasiva(Pasiva p){
		openDB();
		Statement s = null;
		try {
			s = koneksi.createStatement();
			String q = "INSERT INTO master(nama_master, jumlah_master, jenis_master, keterangan) " +
					"VALUES('"+ p.getNama_pasiva() + "', '" + p.getJumlah_pasiva() + "', 'pasiva', '" + p.getKeterangan() + "')";
			s.executeUpdate(q);
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
		if(kontainer!=null){
			JOptionPane.showMessageDialog(kontainer, "Transaksi berhasil disimpan");
		}
		closeDB();
	}
	
	public void insertAktiva(Aktiva a){
		openDB();
		Statement s = null;
		try {
			s = koneksi.createStatement();
			String q = "INSERT INTO master(nama_master, jumlah_master, jenis_master, keterangan) " +
					"VALUES('" + a.getNama_aktiva() + "', '" + a.getJumlah_aktiva() + "', 'aktiva', '" + a.getKeterangan() + "')";
			s.executeUpdate(q);
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
		if(kontainer!=null){
			JOptionPane.showMessageDialog(kontainer, "Transaksi berhasil disimpan");
		}
		closeDB();
	}
	
	public void insertTransaksi(Transaksi t){
		openDB();
		Statement s = null;
		try {
			s = koneksi.createStatement();
			String q = "INSERT INTO detail(id_master, id_anggota, jenis_detail, jumlah_detail, waktu_detail, keterangan) " +
					"VALUES('"+t.getId_master_transaksi()+"','"+t.getId_anggota()+"','"+t.getJenis_transaksi()+"','"+
					t.getJumlah_transaksi()+"','"+t.getWaktu()+"','"+t.getKeterangan()+"')";
			s.executeUpdate(q);
			ResultSet r;
			Double jum, n, akhir;
			if(t.getJenis_transaksi().equals("kredit")){
				q = "SELECT * FROM master WHERE id_master='"+t.getId_master_transaksi()+"'";
				r = s.executeQuery(q);
				jum = Double.valueOf(r.getString("jumlah_master").replace(",", "."));
				n = Double.valueOf(t.getJumlah_transaksi().replace(",", "."));
				akhir = jum + n;
			}else{
				q = "SELECT * FROM master WHERE id_master='"+t.getId_master_transaksi()+"'";
				r = s.executeQuery(q);
				jum = Double.valueOf(r.getString("jumlah_master").replace(",", "."));
				n = Double.valueOf(t.getJumlah_transaksi().replace(",", "."));
				akhir = jum - n;
			}
			DecimalFormat df = new DecimalFormat("0.00");
			String save = df.format(akhir).replace(".", ",");
			q = "UPDATE master SET jumlah_master='"+save+"' WHERE id_master='"+t.getId_master_transaksi()+"'";
			s.executeUpdate(q);
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(), "Terjadi kesalahan", JOptionPane.ERROR_MESSAGE);
		}
		if(kontainer!=null){
			JOptionPane.showMessageDialog(kontainer, "Transaksi berhasil disimpan");
		}
		closeDB();
	}
	
	public boolean checkPasiva(Pasiva p){
		openDB();
		boolean hasil = false;
		Statement s = null;
		try {
			s = koneksi.createStatement();
			String q = "SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='" + p.getNama_pasiva() + "'";
			ResultSet r = s.executeQuery(q);
			if(r.getInt("jumlah") > 0){
				hasil = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
		closeDB();
		return hasil;
	}
	
	public boolean checkAktiva(Aktiva a){
		openDB();
		boolean hasil = false;
		Statement s = null;
		try {
			s = koneksi.createStatement();
			String q = "SELECT COUNT(*) AS jumlah FROM master WHERE nama_master='" + a.getNama_aktiva() + "'";
			ResultSet r = s.executeQuery(q);
			if(r.getInt("jumlah") > 0){
				hasil = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
		closeDB();
		return hasil;
	}
	
	public boolean checkAnggota(Anggota a){
		openDB();
		boolean hasil = false;
		Statement s = null;
		try {
			s = koneksi.createStatement();
			String q = "SELECT COUNT(*) AS jumlah FROM anggota WHERE nama_anggota='" + a.getNama_anggota() + "'";
			ResultSet r = s.executeQuery(q);
			if(r.getInt("jumlah") > 0){
				hasil = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}
		closeDB();
		return hasil;
	}
	
	public void buatTabel(){
		openDB();
		try {
			Statement query = koneksi.createStatement();
			query.execute(CREATE_TABEL_ANGGOTA);
			query.execute(CREATE_TABEL_MASTER);
			query.execute(CREATE_TABEL_DETAIL);
			query.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(kontainer, e.toString(),"Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
		}finally{
			closeDB();
		}
	}
	
}
