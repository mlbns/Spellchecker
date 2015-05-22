package word;

public class Word {

	private String word;
	
	public Word() {
		word = new String();
		setWord("");
	}

	public Word(String w) {
		word = new String();
		setWord(w);
	}
	
	public void setWord(String w) {
		word = w;
	}
	
	public String getWord() {
		return word;	
	}

	 @Override
	 public int hashCode() {
		 
		 return 0;
		 
	 }
	 
	 @Override
	 public boolean equals(Object obj) {
		return (this == obj);
		 
	 }	 
	 
}
