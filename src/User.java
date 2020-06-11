
public class User {
	String nom,prenom,username;
	int password;
    int ID;
	public User(int ID,String n,String p,String un,int pwd) {
		this.ID=ID;
		this.nom=n;
		this.password=pwd;
		this.prenom=p;
		this.username=un;	
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	

}
