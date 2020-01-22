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
		System.out.println("Introdueix el numero de l'accio a realitzar");
		System.out.println("[1] - Entrenador enviar missatge a tots els jugadors de la pista");
		System.out.println("[2] - Entrenador amonesta a jugador");
		System.out.println("[3] - Canviar rol d'un jugador");
		System.out.println("[0] - Tancar aplicacio");
	}


	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Motor motor = new Motor();


		System.out.println("ENGINYERIA DEL SOFTWARE II");
		System.out.println("APLICACIO DE HANDBOL");
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
				System.err.println("OPCIO INCORRECTE");
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
		System.out.println("S'ha escollit la opcio 1. Enviar missatge a jugadors PISTA.");
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
		System.out.println("S'enviara el missatge: '"+missatge+"'");
		m.enviarMissatgeJugPista(equip,missatge);
	}
	
	
	
	private static void amonestarJug(Motor m) {
                Scanner lectura = new Scanner(System.in);
		System.out.println("S'ha escollit la opcio 2");
                System.out.println();
		System.out.println("Selecciona l'arbitre [0-1]");
                while(!lectura.hasNextInt()) {
			lectura.next();
			System.err.println("Entrada incorrecte");
		}
		int arbitre = lectura.nextInt();
                
                System.out.println("Entra IDEquip [0-1]");
                 while(!lectura.hasNextInt()) {
			lectura.next();
			System.err.println("Entrada incorrecte");
		}
		int equip = lectura.nextInt();
                
                System.out.println("Entra dorsal jugador [0-99]");
                while(!lectura.hasNextInt()) {
			lectura.next();
			System.err.println("Entrada incorrecte");
		}
		int dorsal = lectura.nextInt();
                m.generarAmonestacio(arbitre,equip,dorsal);
	}
	
	
	
	private static void canviarRolJug(Motor m) {
		System.out.println("S'ha escollit la opcio 3");
	}


}
