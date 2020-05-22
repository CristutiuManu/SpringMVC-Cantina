package ro.pojo;

public class Meniu {

	private int id,pret;
	private String descriere, alergeni;
	public Meniu(int id, int pret, String descriere, String alergeni) {
		this.id = id;
		this.pret = pret;
		this.descriere = descriere;
		this.alergeni = alergeni;
	}
	
	public Meniu() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public String getAlergeni() {
		return alergeni;
	}
	public void setAlergeni(String alergeni) {
		this.alergeni = alergeni;
	}

	@Override
	public String toString() {
		return "Meniu [id=" + id + ", pret=" + pret + ", descriere=" + descriere + ", alergeni=" + alergeni + "]";
	}
	
	
}
