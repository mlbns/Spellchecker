package dictionary;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import word.*;

public abstract class Dictionary {

	protected WordSet set;

	public Dictionary() {
		this.set = new WordSet();
	}

	public void add(Word w) {
		this.set.add(w);
	}

	public boolean contains(Word w) {
		return this.set.contains(w);
	}
	
	public void clear() {
		this.set.clear();
	}
	
	public void fromStringList(List <String> str) {
		
		Word w;
		
		for(int i = 0; i < str.size(); i++){
			w = new Word(str.get(i));
			this.add(w);
		}
	}

	public List <String>toStringList() {
		
		List <String> myList = new ArrayList <String>();

		for (Iterator<Word> iter = this.set.iterator(); iter.hasNext();) {
			Word elem = iter.next();
			myList.add(elem.getWord());
		}

		return myList;
	}
	
	public int size() {
		return this.set.size();
	}

}
