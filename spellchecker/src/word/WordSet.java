package word;

import java.util.*;

public class WordSet {
	
	private Set<Word> wordSet;
	
	public WordSet() {
		wordSet = new HashSet<Word>();
	}

	public void add(Word w) {
		wordSet.add(w);
	}

	public boolean contains(Word w) {
		return wordSet.contains(w);
	}
	
	public void clear() {
		wordSet.clear();
	}
	
	public Iterator<Word> iterator() {
		return wordSet.iterator();
	}
	
	public int size() {
		return wordSet.size();
	}
}
