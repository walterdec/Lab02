package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<WordEnhanced> dizionario = new LinkedList<WordEnhanced>();
	
	public void addWord(String alienWord, String translation) {
		boolean parolaPresente = false;
		for(WordEnhanced w : dizionario) {
			if(w.getAlienWord().compareTo(alienWord)==0) {
				w.addTranslation(translation);
				parolaPresente=true;
			}
		}
		if(parolaPresente == false) {
			WordEnhanced w = new WordEnhanced(alienWord);
			dizionario.add(w);
			w.addTranslation(translation);
		}
	}
	
	public String translateWord(String alienWord) {
		String traduzioni="";
		for(WordEnhanced w : dizionario) {
			if(w.getAlienWord().compareTo(alienWord)==0) {
				for(String t : w.getTranslation()) {
					traduzioni+=t+"\n";
				}
				return traduzioni;
			}
		}
		return null;
	}

}
