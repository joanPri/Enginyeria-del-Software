import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * No se si fa falta
 * @author julian
 *
 */
public class Motor {
	//TODO: Arbitres
	private static final String DADES_ARBITRES = "iniciA.txt";
	private static final String DADES_EQUIP_U = "iniciE1.txt";
	private static final String DADES_EQUIP_DOS = "iniciE2.txt";
	
	
	private static final String NOM_EQUIP_1 = "Dalinians";
	private static final String CIUTAT_EQUIP_1 = "FIGUERES";
	private static final String NOM_EQUIP_2 = "Catedrals";
	private static final String CIUTAT_EQUIP_2 = "GIRONA";

	private ArrayList<Equip> equips = new ArrayList<Equip>();
	private ArrayList<Arbitre> arbitres = new ArrayList<Arbitre>();


	public void mostrarDades() {
		System.out.println(equips.get(0).toString());
		System.out.println(equips.get(1).toString());

	}

	/**
	 * Obté les dades de mostra del programa de fitxers de text.
	 * 
	 */
	public  void inicialitzacio() {
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Jugador> jugadors= null;
		Entrenador entrenador = null;

		try(BufferedReader br = new BufferedReader(new FileReader(DADES_EQUIP_U))){
			jugadors = new ArrayList<Jugador>();
			while((line=br.readLine()) != null) {
				String[] dades = line.split(cvsSplitBy);
				if(dades.length >0) {
					if(Integer.parseInt(dades[0])== 0) {
						//Es entrenador
						entrenador =new Entrenador(Integer.parseInt(dades[0]), dades[1], dades[2],Integer.parseInt(dades[3]));
					}else {
						Jugador j = new Jugador(Integer.parseInt(dades[0]), dades[1], dades[2],Integer.parseInt(dades[3]),entrenador);
						jugadors.add(j);
						
					}

				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		Equip e1 = new Equip(1,NOM_EQUIP_1,CIUTAT_EQUIP_1,jugadors,entrenador);
		equips.add(e1);


		try(BufferedReader br = new BufferedReader(new FileReader(DADES_EQUIP_DOS))){
			jugadors = new ArrayList<Jugador>();
			while((line=br.readLine()) != null) {
				String[] dades = line.split(cvsSplitBy);
				if(dades.length >0) {
					if(Integer.parseInt(dades[0])== 0) {
						//Es entrenador
						entrenador =new Entrenador(Integer.parseInt(dades[0]), dades[1], dades[2],Integer.parseInt(dades[3]));
					}else {
						Jugador j = new Jugador(Integer.parseInt(dades[0]), dades[1], dades[2],Integer.parseInt(dades[3]),entrenador);

						jugadors.add(j);
					}

				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

		Equip e2 = new Equip(2,NOM_EQUIP_2,CIUTAT_EQUIP_2,jugadors,entrenador);


		equips.add(e2);


		try(BufferedReader br = new BufferedReader(new FileReader(DADES_ARBITRES))){

			while((line=br.readLine()) != null) {
				String[] dades = line.split(cvsSplitBy);
				if(dades.length >0) {

					Arbitre arbitre = new Arbitre(Integer.parseInt(dades[0]), dades[1], dades[2],Integer.parseInt(dades[3]));
					arbitres.add(arbitre);

				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}




	}
	
	public boolean esEquipValid(int i) {
		return (i>=0 && i<equips.size());
	}

	public void enviarMissatgeJugPista(int equip,String m) {
		//System.out.println("Soc el motor del joc i enviare el missatge: '"+m+"'");

		Entrenador entrenador = equips.get(equip).getEntrenador();	
		
		entrenador.notifyObserverPista(m);
	}
}
