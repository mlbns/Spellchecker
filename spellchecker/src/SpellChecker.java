import java.io.EOFException;
import java.io.IOException;
import java.util.*;

import word.*;
import dictionary.*;
import dictionary.Dictionary;
import document.*;

/** 
 * SpellChecker: ésta es la clase que ejecuta
 * el algoritmo principal.
 * 
 *  @autor Bonader, Nicolás - neb0113@famaf.unc.edu.ar
 *  @autor Bonias, Melisa - mel.bonias@gmail.com
 * 
 * Corrector de palabras
 * 
 */
public class SpellChecker {
	
	public SpellChecker() {}

	/** Consulta al usuario qué hacer con una palabra desconocida */
	public static Word consultUser(Word w, dictionary.Dictionary dict,
								   dictionary.Dictionary ign) {
		String str = w.getWord();
		String answer;
		
		do {
			System.out.print("Palabra no reconocida:\"" + str +"\"\n Ace"
							 + "ptar (a) - Ignorar (i) - Reemplazar (r): ");
			answer = scanStdin();
		} while((answer.compareTo("a") != 0) && (answer.compareTo("i") != 0)
				&& (answer.compareTo("r") != 0));
		
		if(answer.compareTo("a") == 0) {
			dict.add(w);
		} else if(answer.compareTo("i") == 0) {
			ign.add(w);
		} else {
			System.out.print("Reemplazar por: ");
			answer = scanStdin();

			while(!answer.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜ]+")) {
				System.out.print("Palabra invalida. Ingrese una palabra sin"
						         + "simbolos: ");
				answer = scanStdin();
			}
			
			w.setWord(answer);
		}		
		return w;
	}

	/** Itera sobre el documento revisando las palabras y 
	 * escribiendo en el documento de salida. Si la palabra
	 * es desconocida, consulta al usuario antes de escribir.
	 * */
	public static void processDocument(String docPath, String outPath,
									   dictionary.Dictionary dict,
									   Dictionary ign) {
		Document doc;
		Word w;

		/* abrir los documentos */
		try {
			doc = new Document(docPath, outPath);
		} catch (IOException e2) {
			System.out.println("No se pudo abrir los documentos");
			System.exit(1);
			return;
		}

		/* recorrer el documento, terminamos con una
		 * excepción al llegar a EOF */
		try {
			while(true) {
				w = doc.getWord();
				if(!dict.contains(w) && !ign.contains(w)) {
					consultUser(w, dict, ign);
				}
				doc.putWord(w);
			}
		} catch (EOFException e){
			try {
				doc.close();
			} catch (IOException e1) {
				System.out.println("Error al cerrar los documentos.");
			}
		}
		catch (IOException e) {
			System.out.println("Error al leer el documento de entrada.");
			System.exit(1);
			return;
		}


	}

	public static void main(String[] args) {
		MemDictionary ignDict;
		FileDictionary accDict;

		/* Verificamos el nro dqe argumentos. */
		if(args.length == 0 || args.length > 2){
			System.out.println("Nro de argumentos erróneo. Deben ser "
					           + "<documento> [<diccionario>]");
			return;
		}

		/* si se especifico un diccionario lo usamos  */
	    /* caso contrario usamos el diccionario por defecto */
		if(args.length > 1)
			accDict = new FileDictionary(args[1]);
		else {
			accDict = new FileDictionary();
			accDict.load("dict.txt");
		}

		/* inicializar diccionario ignoradas */
		ignDict = new MemDictionary();

		/* processDocument recibe los diccionarios, pero
		 * abre los documentos */
		processDocument(args[0], "out.txt", accDict, ignDict);

		/* actualizamos el diccionario con las posibles nuevas palabras*/
		accDict.save();

		System.out.println("El documento " + args[0] + " ha sido procesado."
				           + "Resultados en out.txt");

		/* cerramos en caso de haber leido de stdin */
		if(input != null) input.close();
	}

	/**
	 *  Para leer de la stdin 
	 **/
	private static Scanner input; 

	private static String scanStdin() {
		String answer;

		input = new Scanner(System.in); 
		answer = input.nextLine();

		/* no cerramos input para no cerrar el stdin */

		return answer;
	}
}