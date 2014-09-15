package classes;

public class Transaksi {
	private String id_transaksi;
	private String id_anggota;
	private String id_master_transaksi;
	private String jenis_transaksi;
	private String jumlah_transaksi;
	private String waktu;
	private String keterangan;
	public Transaksi(String id_transaksi, String id_anggota,
			String id_master_transaksi, String jenis_transaksi,
			String jumlah_transaksi, String waktu, String keterangan) {
		super();
		this.id_transaksi = id_transaksi;
		this.id_anggota = id_anggota;
		this.id_master_transaksi = id_master_transaksi;
		this.jenis_transaksi = jenis_transaksi;
		this.jumlah_transaksi = jumlah_transaksi;
		this.waktu = waktu;
		this.keterangan = keterangan;
	}
	public Transaksi() {
		super();
	}
	public String getId_transaksi() {
		return id_transaksi;
	}
	public void setId_transaksi(String id_transaksi) {
		this.id_transaksi = id_transaksi;
	}
	public String getId_anggota() {
		return id_anggota;
	}
	public void setId_anggota(String id_anggota) {
		this.id_anggota = id_anggota;
	}
	public String getId_master_transaksi() {
		return id_master_transaksi;
	}
	public void setId_master_transaksi(String id_master_transaksi) {
		this.id_master_transaksi = id_master_transaksi;
	}
	public String getJenis_transaksi() {
		return jenis_transaksi;
	}
	public void setJenis_transaksi(String jenis_transaksi) {
		this.jenis_transaksi = jenis_transaksi;
	}
	public String getJumlah_transaksi() {
		return jumlah_transaksi;
	}
	public void setJumlah_transaksi(String jumlah_transaksi) {
		this.jumlah_transaksi = jumlah_transaksi;
	}
	public String getWaktu() {
		return waktu;
	}
	public void setWaktu(String waktu) {
		this.waktu = waktu;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
}
