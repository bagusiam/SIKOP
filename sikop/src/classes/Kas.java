package classes;

public class Kas {
	String id;
	String jenis;
	String jumlah;
	public Kas(String id, String jenis, String jumlah) {
		super();
		this.id = id;
		this.jenis = jenis;
		this.jumlah = jumlah;
	}
	public Kas() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public String getJumlah() {
		return jumlah;
	}
	public void setJumlah(String jumlah) {
		this.jumlah = jumlah;
	}
	
}
