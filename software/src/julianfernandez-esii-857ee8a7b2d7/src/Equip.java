import java.util.ArrayList;

public class Equip {
	private int idEquip;
	private String nom;
	private String ciutat;
	private ArrayList<Jugador> jugadors;
	private Entrenador entrenador;
	
	public Equip(int idEquip,String nom, String ciutat,ArrayList<Jugador> jugadors, Entrenador entrenador) {
		this.idEquip = idEquip;
		this.nom = nom;
		this.ciutat = ciutat;
		this.jugadors = jugadors;
		this.entrenador = entrenador;
	}
	
	public Entrenador getEntrenador() {
		return entrenador;
	}
	
	public String toString() {
		String retorn = "*Equip* ["+idEquip+"]"+" - " +nom+" CIUTAT "+ciutat+"\n"+entrenador.toString()+"\n";
		
		for(int i = 0;i<jugadors.size();i++) {
			retorn= retorn+"    " + jugadors.get(i).toString()+"\n";
		}
		retorn+="\n";
		
		
		return retorn;
		

	}
        
        public int getID() {
		return idEquip;
	}        
        
        public Jugador getJugador(int dorsal) {
		return jugadors.get(dorsal);
	}
        
}
