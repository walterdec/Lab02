package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	private String alienWord;
	
	private List<String> translation = new LinkedList<String>();
	
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public Collection<String> getTranslation() {
		return translation;
	}
	
	public void addTranslation(String t) {
		translation.add(t);
	}
	
	public boolean equals(Word w) {
		if(this.equals(w)) {
			return true;
		}
		else
			return false;
	}
}
