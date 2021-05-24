package jeu.user.model;


public class LoginDTO {
	private String name;
	private String mdp;
	
	
	public LoginDTO() {
		
	}

	public LoginDTO(String name , String mdp) {
		this.name = name;
		this.mdp = mdp;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getmdp() {
		return mdp;
	}
	public void setmdp(String mdp) {
		this.mdp = mdp;
	}
	
	

}
