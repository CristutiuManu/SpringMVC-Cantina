package ro.pojo;

public class User {

	private int id;
	private String nume, email, telefon, adresa;
	public User(int id, String nume, String email, String telefon, String adresa) {
		super();
		this.id = id;
		this.nume = nume;
		this.email = email;
		this.telefon = telefon;
		this.adresa = adresa;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nume=" + nume + ", email=" + email + ", telefon=" + telefon + ", adresa=" + adresa
				+ "]";
	}
	
}
