package classes;

public class Pasiva {
	String id_pasiva;
	String nama_pasiva;
	String jumlah_pasiva;
	String keterangan;
	public Pasiva() {
		super();
	}
	public Pasiva(String id_pasiva, String nama_pasiva, String jumlah_pasiva,
			String keterangan) {
		super();
		this.id_pasiva = id_pasiva;
		this.nama_pasiva = nama_pasiva;
		this.jumlah_pasiva = jumlah_pasiva;
		this.keterangan = keterangan;
	}
	public String getId_pasiva() {
		return id_pasiva;
	}
	public void setId_pasiva(String id_pasiva) {
		this.id_pasiva = id_pasiva;
	}
	public String getNama_pasiva() {
		return nama_pasiva;
	}
	public void setNama_pasiva(String nama_pasiva) {
		this.nama_pasiva = nama_pasiva;
	}
	public String getJumlah_pasiva() {
		return jumlah_pasiva;
	}
	public void setJumlah_pasiva(String jumlah_pasiva) {
		this.jumlah_pasiva = jumlah_pasiva;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
}
