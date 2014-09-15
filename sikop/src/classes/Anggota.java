package classes;

public class Anggota {
	String id_anggota;
	String nama_anggota;
	public Anggota(String id_anggota, String nama_anggota) {
		super();
		this.id_anggota = id_anggota;
		this.nama_anggota = nama_anggota;
	}
	public Anggota() {
		super();
	}
	public String getId_anggota() {
		return id_anggota;
	}
	public void setId_anggota(String id_anggota) {
		this.id_anggota = id_anggota;
	}
	public String getNama_anggota() {
		return nama_anggota;
	}
	public void setNama_anggota(String nama_anggota) {
		this.nama_anggota = nama_anggota;
	}
}
