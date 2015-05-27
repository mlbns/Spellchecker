package word;

/**
 * Word: Envoltorio de String, como formato de palabra 
 * 
 *  @autor Bonader, Nicolás - neb0113@famaf.unc.edu.ar
 *  @autor Bonias, Melisa - mel.bonias@gmail.com
 *
 */
public class Word {

	private String word;
	
	public Word() {
	}

	/**
	 * Constructor, inicializa la palabra
	 * @param w Palabra con la cual inicializar el envoltorio
	 */
	public Word(String w) {
		word = new String();
		setWord(w);
	}

	/**
	 * Retorna la palabra como String
	 * @return Palabra del envoltorio como String 
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Establece el envoltorio con una palabra
	 * @param word  String con el cual establecer el envoltorio
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Retorna el código hash de una palabra  
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	
	/**
	 * Comprueba si una palabra es identica a otra
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	 
}
