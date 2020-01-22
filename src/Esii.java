import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jofut
 */
public class Esii {



	private static void menu() {
		System.out.println("Introdueix el número de l'acció a realitzar");
		System.out.println("[1] - Entrenador enviar missatge a tots els jugadors de la pista");
		System.out.println("[2] - Entrenador amonesta a jugador");
		System.out.println("[3] - Canviar rol d'un jugador");
		System.out.println("[0] - Tancar aplicació");
	}


	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Motor motor = new Motor();


		System.out.println("ENGINYERIA DEL SOFTWARE II");
		System.out.println("APLICACIÓ DE HANDBOL");
		motor.inicialitzacio();

		motor.mostrarDades();



		System.out.println();

		int opcio = -1;
		Scanner sc = new Scanner(System.in);
		while(opcio!=0) {
			menu();
			while(!sc.hasNextInt()) {
				sc.next();
				System.err.println("ENTRADA INCORRECTE");
				menu();
			}
			opcio = sc.nextInt();


			switch (opcio) {
			case 1:
				enviarMissatgeJug(motor);
				break;
			case 2:
				amonestarJug(motor);
				break;
			case 3:
				canviarRolJug(motor);
				break;
			case 0:
				System.out.println("ADEU");
				break;
			default:
				System.err.println("OPCIÓ INCORRECTE");
				break;
			}
		}
		sc.close();


	}

	
	/**
	 * 
	 * @param m Motor del joc.
	 */
	private static void enviarMissatgeJug(Motor m) {
		Scanner lectura = new Scanner(System.in);
		System.out.println("S'ha escollit la opció 1. Enviar missatge a jugadors PISTA.");
		System.out.println();
		System.out.println("A quin equip vol enviar el missatge? [0-1]");
		while(!lectura.hasNextInt()) {
			lectura.next();
			System.err.println("Entrada incorrecte");
		}
		int equip = lectura.nextInt();
		lectura.nextLine();
		while(!m.esEquipValid(equip)) {
			System.err.println("Entrada incorrecte. Repeteixi.");
			equip = lectura.nextInt();
			lectura.nextLine();
		}

		
		System.out.println("Indiqui el missatge que vol enviar als jugadors");
		String missatge = lectura.nextLine();
		System.out.println("S'enviarà el missatge: '"+missatge+"'");
		m.enviarMissatgeJugPista(equip,missatge);
	}
	
	
	
	private static void amonestarJug(Motor m) {
		System.out.println("S'ha escollit la opció 2");
	}
	
	
	
	private static void canviarRolJug(Motor m) {
		System.out.println("S'ha escollit la opció 3");
	}


}
