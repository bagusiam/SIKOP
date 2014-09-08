package comp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteMan {

	Connection koneksi;
	private static String TABEL_KAS = "CREATE TABLE IF NOT EXISTS kas(" +
			"id)";
	
	public SQLiteMan(){
		try {
			Class.forName("org.sqlite.JDBC");
			koneksi = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Sukses konek DB");
	}
	
	public void buatTabel(){
		try {
			Statement query = koneksi.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS anggota(" +
					"ID_ANGGOTA INT PRIMARY KEY NOT NULL," +
					"NAMA TEXT NOT NULL)";
			query.execute(sql);
			System.out.println("Tabel anggota created");
			query.close();
			sql = "CREATE TABLE IF NOT EXISTS transaksi(" +
					"ID_TRANSAKSI INT PRIMARY KEY NOT NULL," +
					"ID_ANGGOTA INT NOT NULL," +
					"JENIS_TRANSAKSI TEXT NOT NULL," +
					"WAKTU TEXT NOT NULL)";
			query.execute(sql);
			System.out.println("Tabel transaksi created");
			query.close();
			koneksi.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
