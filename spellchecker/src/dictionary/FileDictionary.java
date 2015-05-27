package dictionary;
import java.io.*;
import java.util.List;

import word.*;

/**
 * 
 * FileDictionary: clase encargada de gestionar los diccionarios
 * 
 *  @autor Bonader, Nicolás - neb0113@famaf.unc.edu.ar
 *  @autor Bonias, Melisa - mel.bonias@gmail.com
 *
 */
public class FileDictionary extends Dictionary {

	/**
	 * Ruta del diccionario original 
	 */
	private String filePath;  

	/**
	 * Construye el diccionario
	 */
	public FileDictionary() {
	}

	/**
	 * Construye el diccionario y lo inicializa cargando las palabras
	 * desde el archivo en la ruta str 
	 * @param str  Ruta del diccionario a cargar
	 */
	public FileDictionary(String str) {
		load(str);
	}

	/**
	 * Carga el diccionario desde el archivo en la ruta str 
	 * @param path Ruta del diccionario a cargar
	 */
	public void load(String path) {
		String line;
		
		/* guardar archivo origen */
		this.filePath = path;
		
		/* intentamos cargar el archivo, linea por linea */
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			/* agregamos las lineas validas */
			while((line = br.readLine()) != null) {

				if(line.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜ]+"))
					this.add(new Word(line));
			}

			br.close();
		}catch (IOException e) {
			System.out.println("No se pudo abrir el diccionario especificado. Usando uno vacío.");
		}
	}
	
	public void save() {
		/* usar archivo de origen por defecto */
		save(this.filePath);
	}

	public void save(String path) {
	
		List <String> myList;
		PrintWriter writer;

		/* guardar las palabras en path*/
		try {
			writer = new PrintWriter(path);
			myList = this.toStringList();
			for(String str : myList)
				writer.println(str);
			
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo guardar el diccionario.");
		}

	
	}
}
