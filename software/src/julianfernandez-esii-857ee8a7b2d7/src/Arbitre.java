
import java.util.ArrayList;


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
        
        public void amonestarJugador(int equip,String m) {
		//System.out.println("Soc el motor del joc i enviare el missatge: '"+m+"'");

		Entrenador entrenador = equips.get(equip).getEntrenador();	
		
		entrenador.notifyObserverPista(m);
	}
        
        public void crearAmonestacio(Equip eq, Jugador jug){
            
            Amonestacio amon = new Amonestacio(idArbitre, jug.getDorsal(), eq.getID());
            
            ArrayList<Amonestacio> t = new ArrayList<>();
            t=jug.getTaulaAmonestacions();
            if(t.size()==1){//excloure 2 minuts
                System.out.println("Jugador exclos 2 minuts");
            }
            else if(t.size()==2){//expulsar jugador
                System.out.println("Jugador expuulsat");
            }
            
            jug.afegirAmonestacio(amon);
            System.out.println("S'ha afegit l'amonestacio correctament");
            
        }
}
