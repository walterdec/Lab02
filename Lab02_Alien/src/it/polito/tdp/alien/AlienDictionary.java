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
	
	public String wildcard (String p1, String p2, int i) {
		List<WordEnhanced> paroleCoincidenti = new LinkedList<WordEnhanced>();
		for(WordEnhanced w : dizionario) {
			String word1 = w.getAlienWord().substring(0, i);
			String word2 = w.getAlienWord().substring(i+1, w.getAlienWord().length()-1);
			if(p1.compareTo(word1)==0 && p2.compareTo(word2)==0) {
				paroleCoincidenti.add(w);
			}
		}
		if(paroleCoincidenti.isEmpty()) {
			return "Wildcard non presente!\n";
		}
		String result="";
		for(WordEnhanced w : paroleCoincidenti) {
			result+=w.getTranslation()+"\n";
		}
		return "Wildcards:\n"+result;
	}

}
