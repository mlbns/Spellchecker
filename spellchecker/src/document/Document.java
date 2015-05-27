package document;
import java.io.*;

import word.Word;

/** 
 * 
 * Document: clase encargada de gestionar los documentos
 * 
 *  @autor Bonader, Nicolás - neb0113@famaf.unc.edu.ar
 *  @autor Bonias, Melisa - mel.bonias@gmail.com
 * 
 */
public class Document {

	private BufferedReader input;
	private BufferedWriter output;
	private String lastSym;

	/**
	 * Inicializa los documentos 
	 * 
	 * @param fpIn 	un String que representa la ruta del
	 *             	documento de entrada
	 * @param fpOut un String que representa la ruta
	 * 				a donde se guardará el documento
	 * 				(puede ser igual a fpIn)
	 * @return		un objeto Document
	 * 
	 * */
	public Document(String fpIn, String fpOut) throws IOException {
	    FileReader frIn = new FileReader(fpIn);
	    input = new BufferedReader(frIn);
	    
	    FileWriter frOut = new FileWriter(fpOut);
	    output = new BufferedWriter(frOut);

	    lastSym = new String("");
	}

	/**
	 * Cierra los documentos
	 * */
	public void close() throws IOException {
		
		input.close();
		output.close();
	}

	/**
	 * Retorna una palabra del documento de entrada. En
	 * sucesivas llamadas, retorna las palabras siguientes.
	 * Cuando alcanza EOF, lanza una excepción EOFExcepction.
	 * 
	 * @return palabra en formato Word del documento de entrada.
	 * @throws EOFException
	 */
	public Word getWord() throws EOFException {
		Word w = new Word();
		String str = new String();
		int readCh;
		boolean prevSym = true;
		boolean haveWord = false;
		char[] aux, aux1;

		try {

			/* hasta que tengamos una palabra o alcancemos EOF */
			while(!haveWord && (readCh = input.read()) != -1) {
				
				/* imprimimos el ultimo simbolo */
				output.write(lastSym);
				lastSym = "";

				/* tenemos una palabra si leimos un simbolo y
				 * anteriormente leimos un caracter
				 * */
				haveWord = !(Character.isLetter(readCh)) && !prevSym;

				if(!Character.isLetter(readCh)) {
					if(!haveWord) {
						/* escribir simbolo en archivo de salida */
						output.write(readCh);
					} else {
						/* guardamos el ultimo simbolo */
						aux = Character.toChars(readCh);//evitar casteo(utf8)
						lastSym = Character.toString(aux[0]);
					}
				} else {
					/* si leimos caracter, acumulamos para formar
					 * ir formando la palabra. 
					 */
					aux1 = Character.toChars(readCh); //evitar casteo (utf8)
					str = str + Character.toString(aux1[0]);
				}
				
				prevSym = !Character.isLetter(readCh);
			}
			
			/* construimos la palabra o lanzamos la excepcion si EOF */
			if(haveWord) {
				w.setWord(str);
			} else
				throw new EOFException();

		} catch (EOFException e) {
			/* Re-lanzar excepcion, a causa de que IOException 
			 * atrapa EOFException.
			 * */
			throw new EOFException();			
		}catch (IOException e) {
			/* Error no recuperable */
			System.out.println("Ocurrió un error leyendo el documento"
							   + "de entrada");
			System.exit(1);
		}
		return w;
	}

	/**
	 * Recibe una palabra en formato Word y la escribe en el
	 * documento de salida.
	 * 
	 * @param w Palabra a escribir en el documento de salida.
	 * @throws IOException
	 */
	public void putWord(Word w) throws IOException {
		output.write(w.getWord());
	}
}
