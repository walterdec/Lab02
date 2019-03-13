package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<Word> dizionario = new LinkedList<Word>();
	
	public void addWord(String alienWord, String translation) {
		boolean parolaPresente = false;
		Word daRimuovere = null;
		for(Word w : dizionario) {
			if(w.getAlienWord().compareTo(alienWord)==0) {
				parolaPresente = true;
				daRimuovere = w;
			}
		}
		if(parolaPresente == true) {
			dizionario.remove(daRimuovere);
		}
		
		Word nuovaParola = new Word(alienWord, translation);
		dizionario.add(nuovaParola);
	}
	
	public String translateWord(String alienWord) {
		for(Word w : dizionario) {
			if(w.getAlienWord().compareTo(alienWord)==0) {
				return w.getTranslation();
			}
		}
		return null;
	}

}
