package word;

public class Word {

	private String word;
	
	public Word() {
		System.out.println("algo");
	}

	public Word(String w) {
		Word word = new Word();
	}
	
	public void setWord(String w) {
		
		System.out.println(w);
		
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
		return false;
		 
	 }
	 
	 
}
