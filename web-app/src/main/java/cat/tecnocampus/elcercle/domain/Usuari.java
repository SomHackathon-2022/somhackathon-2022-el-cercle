package cat.tecnocampus.elcercle.domain;

public abstract class Usuari {

	protected String nom;
	protected String cognom1;
	protected String cognom2;
	protected String id;
	protected String correu;
	protected String adreca;

	public abstract void consultarSubscripcions();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}
}
