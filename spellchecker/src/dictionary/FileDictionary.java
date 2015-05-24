package dictionary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import word.*;
import dictionary.*;

public class FileDictionary extends Dictionary {
	
	private String filePath;  

	
	public FileDictionary() {
		load("dict.txt");
	}

	public FileDictionary(String str) {

		load(str);
	}
	
	public void load(String str) {
		String line;
		boolean validLine;

		/* intentamos cargar el archivo, linea por linea */
		try {
			BufferedReader br = new BufferedReader(new FileReader(str));
			
			/* si la linea es invalida, la salteamos, else, añadimos la palabra */
			while((line = br.readLine()) != null) {
				validLine = true;
				for(int i = 0; i < line.length(); i++) {
					validLine = validLine && Character.isLetter(line.charAt(i));
				}
				if(!validLine)
					continue;
				this.add(new Word(line));
			}
		}catch (IOException e) {
			System.out.println("No se pudo abrir el diccionario especificado. Usando uno vacío.");
		}
	}
	
	public void save() {
		save(this.filePath);
	}

	public void save(String str) {
	}
}
