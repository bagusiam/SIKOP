package item;

public class ItemAnggota {
	private String id_anggota;
	private String nama_anggota;
	public ItemAnggota(String id_anggota, String nama_anggot) {
		super();
		this.id_anggota = id_anggota;
		this.nama_anggota = nama_anggot;
	}
	public ItemAnggota() {
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nama_anggota;
	}
}
