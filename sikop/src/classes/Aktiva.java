package classes;

public class Aktiva {
	String id_aktiva;
	String nama_aktiva;
	String jumlah_aktiva;
	String keterangan;
	public Aktiva() {
		super();
	}
	public Aktiva(String id_aktiva, String nama_aktiva, String jumlah_aktiva,
			String keterangan) {
		super();
		this.id_aktiva = id_aktiva;
		this.nama_aktiva = nama_aktiva;
		this.jumlah_aktiva = jumlah_aktiva;
		this.keterangan = keterangan;
	}
	public String getId_aktiva() {
		return id_aktiva;
	}
	public void setId_aktiva(String id_aktiva) {
		this.id_aktiva = id_aktiva;
	}
	public String getNama_aktiva() {
		return nama_aktiva;
	}
	public void setNama_aktiva(String nama_aktiva) {
		this.nama_aktiva = nama_aktiva;
	}
	public String getJumlah_aktiva() {
		return jumlah_aktiva;
	}
	public void setJumlah_aktiva(String jumlah_aktiva) {
		this.jumlah_aktiva = jumlah_aktiva;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
}
