package ro.pojo;

public class Comanda {

	private int id;
	private String userId, meniuId, dataComanda;
	public Comanda(int id, String userId, String meniuId, String dataComanda) {
		this.id = id;
		this.userId = userId;
		this.meniuId = meniuId;
		this.dataComanda = dataComanda;
	}
	public Comanda() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMeniuId() {
		return meniuId;
	}
	public void setMeniuId(String meniuId) {
		this.meniuId = meniuId;
	}
	public String getDataComanda() {
		return dataComanda;
	}
	public void setDataComanda(String dataComanda) {
		this.dataComanda = dataComanda;
	}
	
	@Override
	public String toString() {
		return "Comanda [id=" + id + ", userId=" + userId + ", meniuId=" + meniuId + ", dataComanda=" + dataComanda
				+ "]";
	}
	
}
