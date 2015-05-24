package document;

import java.io.*;

import word.Word;

public class Document {

	private BufferedReader input;
	private BufferedWriter output;
	private String lastSym;

	
	public Document(String str1, String str2) throws IOException {
	    FileReader fr1 = new FileReader(str1);
	    input = new BufferedReader(fr1);
	    
	    FileWriter fr2 = new FileWriter(str2);
	    output = new BufferedWriter(fr2);

	    lastSym = new String("");
	}

	public void close() throws IOException {
		
		input.close();
		output.close();
		
	}
	
	public Word getWord() throws EOFException {
		Word w = new Word();
		String str = new String();
		int readCh;
		boolean prevSym = true, haveWord = false;
		char[] aux, aux1;
		
		try {
			
			while((readCh = input.read()) != -1) {
				
				// imprimimos el ultimo simbolo
				output.write(lastSym);
				// tenemos palabra?
				haveWord = !Character.isLetter(readCh) && prevSym;
				
				if(!Character.isLetter(readCh)) {
					if(!haveWord) {
						// escribir simbolo en archivo de salida
						output.write(readCh);
					} else {
						// guardamos el ultimo simbolo
						aux = Character.toChars(readCh);
						lastSym = Character.toString(aux[0]);
					}
				} else {
					// 
					aux1 = Character.toChars(readCh);
					str = str + Character.toString(aux1[0]);
				}
				
				prevSym = !Character.isLetter(readCh);
			}
			if(haveWord) {
				w.setWord(str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return w;
	}

	public void putWord(Word w) throws IOException {
		output.write(w.getWord());
	}
}
