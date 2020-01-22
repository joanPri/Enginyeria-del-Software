

/**
 * @author julian
 *
 */
public interface SubjectEntrenadorPista {
	public void registerObserverPista(ObserverEntrenadorPista o);
	public void removeObserverPista(ObserverEntrenadorPista o);
	public void notifyObserverPista(String missatge);
	

}
