package dictionary;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import word.*;

/**
 * Dictionary: clase abstracta que implementa un
 * diccionario. Sirve de modelo a FileDictionary y
 * MemDictionary.
 * 
 *  @autor Bonader, Nicolás - neb0113@famaf.unc.edu.ar
 *  @autor Bonias, Melisa - mel.bonias@gmail.com
 *
 */
public abstract class Dictionary {

	protected WordSet set;

	/**
	 * Constructor, inicializa el conjunto
	 * de palabras como implementación
	 * del diccionario.
	 */
	public Dictionary() {
		this.set = new WordSet();
	}

	/**
	 * Añade una palabra al diccionario
	 * @param w  Palabra a en formato Word a agregar al diccionario
	 */
	public void add(Word w) {
		this.set.add(w);
	}

	/**
	 * Chequea si una palabra está en el diccionario
	 * @param w  Palabra en formato Word a chequear
	 * @return   Retorna true si la palabra está, false si no. 
	 */
	public boolean contains(Word w) {
		return this.set.contains(w);
	}

	/**
	 * Vacía el diccionario
	 */
	public void clear() {
		this.set.clear();
	}
	
	/**
	 * Añade una lista de palabras al diccionario 
	 * @param str Lista de String a añadir al diccionario
	 */
	public void fromStringList(List <String> str) {
		Word w;
		
		for(int i = 0; i < str.size(); i++){
			w = new Word(str.get(i));
			this.add(w);
		}
	}

	/**
	 * Retorna una lista con las palabras del diccionario
	 * @return lista de string con las palabras del diccionario
	 */
	public List <String>toStringList() {
		
		List <String> myList = new ArrayList <String>();

		for (Iterator<Word> iter = this.set.iterator(); iter.hasNext();) {
			Word elem = iter.next();
			myList.add(elem.getWord());
		}

		return myList;
	}
	
	/**
	 * Retorna el tamaño del diccionario
	 * @return número que representa la cantidad de palabras del diccionario
	 */
	public int size() {
		return this.set.size();
	}

}
