
public class Arbitre {
	private int idArbitre;
	private String nom;
	private String cognom;
	private int numLlicencia;
	
	
	public Arbitre(int idArbitre, String nom, String cognom, int numLlicencia) {
		this.idArbitre = idArbitre;
		this.nom = nom;
		this.cognom = cognom;
		this.numLlicencia = numLlicencia;
	}
	
	public String toString() {
		return "*Arbitre* ["+idArbitre+"]"+" - " +nom+" "+cognom+" ---"+numLlicencia+"---";
		

	}
	

}
