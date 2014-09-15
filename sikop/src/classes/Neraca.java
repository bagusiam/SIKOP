package classes;

public class Neraca {
	String id_neraca;
	String nama_neraca;
	String jenis_neraca;
	String jumlah_neraca;
	String keterangan;
	public Neraca() {
		super();
	}
	public Neraca(String id_neraca, String nama_neraca, String jenis_neraca,
			String jumlah_neraca, String keterangan) {
		super();
		this.id_neraca = id_neraca;
		this.nama_neraca = nama_neraca;
		this.jenis_neraca = jenis_neraca;
		this.jumlah_neraca = jumlah_neraca;
		this.keterangan = keterangan;
	}
	public String getId_neraca() {
		return id_neraca;
	}
	public void setId_neraca(String id_neraca) {
		this.id_neraca = id_neraca;
	}
	public String getNama_neraca() {
		return nama_neraca;
	}
	public void setNama_neraca(String nama_neraca) {
		this.nama_neraca = nama_neraca;
	}
	public String getJenis_neraca() {
		return jenis_neraca;
	}
	public void setJenis_neraca(String jenis_neraca) {
		this.jenis_neraca = jenis_neraca;
	}
	public String getJumlah_neraca() {
		return jumlah_neraca;
	}
	public void setJumlah_neraca(String jumlah_neraca) {
		this.jumlah_neraca = jumlah_neraca;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
}
