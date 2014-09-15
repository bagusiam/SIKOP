package classes;

public class Master {
	String id_master;
	String nama_master;
	String jumlah_master;
	String jenis_master;
	String keterangan;
	public Master() {
		super();
	}
	public Master(String id_master, String nama_master, String jumlah_master,
			String jenis_master, String keterangan) {
		super();
		this.id_master = id_master;
		this.nama_master = nama_master;
		this.jumlah_master = jumlah_master;
		this.jenis_master = jenis_master;
		this.keterangan = keterangan;
	}
	public String getId_master() {
		return id_master;
	}
	public void setId_master(String id_master) {
		this.id_master = id_master;
	}
	public String getNama_master() {
		return nama_master;
	}
	public void setNama_master(String nama_master) {
		this.nama_master = nama_master;
	}
	public String getJumlah_master() {
		return jumlah_master;
	}
	public void setJumlah_master(String jumlah_master) {
		this.jumlah_master = jumlah_master;
	}
	public String getJenis_master() {
		return jenis_master;
	}
	public void setJenis_master(String jenis_master) {
		this.jenis_master = jenis_master;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
}
