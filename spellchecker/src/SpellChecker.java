import java.util.List;

import word.*;
import dictionary.*;


public class SpellChecker {

	public SpellChecker() {
	}
	
	public static Word consultUser(Word w, Dictionary dict, Dictionary ign) {
		return w;
			
	}


	public static void processDocument(String str, String str2, Dictionary dict, Dictionary ign) {
		
	}

	public static void main(String[] args) {
		MemDictionary ignDict;
		FileDictionary accDict;

		/* debug ......... */
		System.out.print("args: [");
		for(int i = 0; i < args.length; i++)
			System.out.print((" "+args[i]));
		System.out.println(" ]");
		/* fin debug ......*/
		
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

		/* debug, mostrando diccionario ppal*/

		List <String> myList = accDict.toStringList();
		System.out.print("accdict: [ ");
		for (String s : myList) {
			System.out.print(" "+s);
		}
		System.out.print(" ]");
		/* debug */
		
	}
	
	

}