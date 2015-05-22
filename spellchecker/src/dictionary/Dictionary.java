package dictionary;
import java.util.List;
import word.*;

public abstract class Dictionary {
	
	protected WordSet mySet; 

	public void dictionary() {
		mySet = new WordSet();
	}

	public void add(Word w) {
		mySet.add(w);
	}

	public boolean contains(Word w) {
		return mySet.contains(w);
	}
	
	public void clear() {
		mySet.clear();
	}
	
	public void fromStringList(List <String> str) {
		
		Word w;
		
		for(int i = 0; i < str.size(); i++){
			w = new Word(str.get(i));
			this.add(w);
		}
	}

	public List <String> toStringList() {
		return null;
	}
	
	public int size() {
		return mySet.size();
	}

}
