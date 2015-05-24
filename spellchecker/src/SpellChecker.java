import java.io.EOFException;
import java.io.IOException;
import java.util.*;

import word.*;
import dictionary.*;
import dictionary.Dictionary;
import document.*;


public class SpellChecker {
	
	private static Scanner input;

	public SpellChecker() {
	}
	
	private static String scanStdin() {
		String answer;

		input = new Scanner(System.in); 
		answer = input.nextLine();

		return answer;
	}
	
	public static Word consultUser(Word w, dictionary.Dictionary dict, dictionary.Dictionary ign) {
		String str = w.getWord();
		String answer;
		
		do {
			System.out.print("Palabra no reconocida:\"" + str + "\"\n Aceptar (a) - Ignorar (i) - Reemplazar (r): ");
			answer = scanStdin();
		} while((answer.compareTo("a") != 0) && (answer.compareTo("i") != 0) && (answer.compareTo("r") != 0));
		
		if(answer.compareTo("a") == 0) {
			dict.add(w);
		} else if(answer.compareTo("i") == 0) {
			ign.add(w);
		} else {
			System.out.print("Reemplazar por: ");
			answer = scanStdin();

			while(!answer.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜ]+")) {
				System.out.print("Palabra invalida. Ingrese una palabra sin simbolos: ");
				answer = scanStdin();

			}	
			w.setWord(answer);
		}
		
		return w;

	}


	public static void processDocument(String docPath, String outPath, dictionary.Dictionary dict, Dictionary ign) {
		
		Document doc;
		Word w;


		try {
			doc = new Document(docPath, outPath);
		} catch (IOException e2) {
			System.out.println("No se pudo abrir los documentos");
			System.exit(1);
			return;
		}

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
		String str;
		
		if(args.length == 0 || args.length > 2){
			System.out.println("Nro de argumentos erróneo. Deben ser <documento> [<diccionario>]");
			return;
		}

		/* cargando diccionarios */
		if(args.length == 1)
			accDict = new FileDictionary();
		else
			accDict = new FileDictionary(args[1]);
		ignDict = new MemDictionary();
		
		processDocument(args[0], "out.txt", accDict, ignDict);

		if(args.length == 2){
			System.out.println("Guardar diccionario en [ " + args[1] + " ]: ");
			str = scanStdin();
			accDict.save(str);
		} else
			accDict.save();
		
		System.out.println("El documento " + args[0] + " ha sido procesado. Resultados en out.txt");
		
		if(input != null) input.close();
	}
}