import java.util.ArrayList;

public class Entrenador implements SubjectEntrenadorPista {
	private int idEntrenador;
	private String nom;
	private String cognom;
	private int numLlicencia;
	private ArrayList<ObserverEntrenadorPista> jugadorsPista;
	
	public Entrenador(int idEntrenador, String nom, String cognom, int numLlicencia) {
		this.idEntrenador = idEntrenador;
		this.nom = nom;
		this.cognom = cognom;
		this.numLlicencia = numLlicencia;
		this.jugadorsPista = new ArrayList<ObserverEntrenadorPista>();
	}
	
	
	@Override
	public String toString() {
		return "*Entrenador* ["+idEntrenador+"]"+" - " +nom+" "+cognom+" ---"+numLlicencia+"---";
		

	}

	@Override
	public void registerObserverPista(ObserverEntrenadorPista o) {
		jugadorsPista.add(o);
	}

	@Override
	public void removeObserverPista(ObserverEntrenadorPista o) {
		int i = jugadorsPista.indexOf(o);
		if(i>=0) {
			jugadorsPista.remove(i);
		}
	}

	@Override
	public void notifyObserverPista(String missatge) {
		for(ObserverEntrenadorPista o : jugadorsPista) {
			o.updateEntrenadorPista(missatge);
		}
		
	}
}
