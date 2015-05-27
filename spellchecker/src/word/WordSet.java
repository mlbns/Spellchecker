package word;
import java.util.*;

/**
 * WordSet: Conjunto de elementos palabras Word
 * 
 *  @autor Bonader, Nicolás - neb0113@famaf.unc.edu.ar
 *  @autor Bonias, Melisa - mel.bonias@gmail.com
 *
 */
public class WordSet {
	
	/**
	 * La representación interna de WordSet es un elemento
	 * de tipo Set<Word>.
	 */
	private Set<Word> set;
	
	/**
	 * El constructor inicializa al Set<Word> a través
	 * de uno de sus constructores HashSet<Word>.
	 */
	public WordSet() {
		set = new HashSet<Word>();
	}

	/**
	 * Añade una palabra al conjunto
	 * @param w Palabra en formato Word a ser añadida.
	 */
	public void add(Word w) {
		set.add(w);
	}

	/**
	 * Comprueba si una palabra pertenece al conjunto
	 * @param w Palabra de la que se comprobará su pertenencia.
	 * @return  Retorna true si y solo si la palabra pertenece.
	 */
	public boolean contains(Word w) {
		return set.contains(w);
	}

	/**
	 * Vacía el diccionario
	 */
	public void clear() {
		set.clear();
	}
	
	/**
	 * Retorna un Iterator de Word
	 * @return Retorna un elemento de tipo Iterator<Word> para
	 * 		   iterar sobre el conjunto de elementos <Word>.
	 */
	public Iterator<Word> iterator() {
		return set.iterator();
	}

	/**
	 * Retorna el tamaño del diccionario
	 * @return  Retorna un elemento de tipo Int que representa
	 * 	        la cantidad de palabras del diccionario.
	 */
	public int size() {
		return set.size();
	}
}
