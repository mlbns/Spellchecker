package dictionary;
import java.util.List;

import word.Word;

public abstract class Dictionary {

	public void dictionary() {
	}

	public void add(Word w) {
	}

	public boolean contains(Word w) {
		return true;
	}
	
	public void clear() {
	}
	
	public void fromStringList(List <String> str) {
	}

	public List <String> toStringList() {
		return null;
	}
	
	public int size() {
		return 0;
	}

}
