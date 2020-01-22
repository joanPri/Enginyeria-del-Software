import java.util.ArrayList;


public class Jugador implements ObserverEntrenadorPista{
	private final static String MA_DRETA = "DRETA"; 
	private final static String MA_ESQ = "ESQUERRA";
	private static final int NUM_JUG_PISTA = 7;
	
	private int dorsal;
	private String nom;
	private String cognom;
	private int numLlicencia;
	private String maBona = MA_DRETA;
	private double pes = 75.0;
	private double alcada = 1.80;
	private SubjectEntrenadorPista subjectEntrenadorPista;
        
        private ArrayList<Amonestacio> taulaAmonestacions = new ArrayList<Amonestacio>();

	


	public Jugador(int dorsal, String nom, String cognom, int numLlicencia, SubjectEntrenadorPista subject) {
		this.dorsal = dorsal;
		this.nom = nom;
		this.cognom = cognom;
		this.numLlicencia = numLlicencia;
		
		this.subjectEntrenadorPista = subject;
		if(dorsal<=NUM_JUG_PISTA) {
			subjectEntrenadorPista.registerObserverPista(this);
		}

	}
	public String toString() {
		return "*Jugador* ["+dorsal+"]"+" - " +nom+" "+cognom+" ---"+numLlicencia+"---";


	}
	@Override
	public void updateEntrenadorPista(String missatge) {
		System.out.println("El jugador "+toString()+" ha rebut un missatge de l'entrenador: "+missatge);
	}

        public int getDorsal(){
            return dorsal;
        }
        
        public void afegirAmonestacio(Amonestacio amon){
                taulaAmonestacions.add(amon);
        }

        public ArrayList<Amonestacio> getTaulaAmonestacions(){
            return taulaAmonestacions;
        }


}

