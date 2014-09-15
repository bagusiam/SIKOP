package item;

public class ItemJenisTransaksi {
	private String id_item;
	private String nama_item;
	public ItemJenisTransaksi() {
		super();
	}
	public ItemJenisTransaksi(String id_item, String nama_item) {
		super();
		this.id_item = id_item;
		this.nama_item = nama_item;
	}
	public String getId_item() {
		return id_item;
	}
	public void setId_item(String id_item) {
		this.id_item = id_item;
	}
	public String getNama_item() {
		return nama_item;
	}
	public void setNama_item(String nama_item) {
		this.nama_item = nama_item;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nama_item;
	}
}
