package word;

import java.util.*;

public class WordSet {
	
	private Set<Word> set;
	
	public WordSet() {
		set = new HashSet<Word>();
	}

	public void add(Word w) {
		set.add(w);
	}

	public boolean contains(Word w) {
		return set.contains(w);
	}
	
	public void clear() {
		set.clear();
	}
	
	public Iterator<Word> iterator() {
		return set.iterator();
	}
	
	public int size() {
		return set.size();
	}
}
