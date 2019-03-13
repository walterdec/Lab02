package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dictionary;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    	dictionary = new AlienDictionary();
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String testoInserito = txtWord.getText().toLowerCase();
    	
    	if(!testoInserito.matches("[a-zA-Z\\s\\?]+")) {
    		txtResult.appendText("Le parole possono contenere solo caratteri!\n");
    		return;
    	}
    		
    	String [] testo = testoInserito.split(" ");
    	String [] testoWildcard = testoInserito.split("\\?");
    	
    	if (testoWildcard.length==2) {
    		int i = testoInserito.indexOf("?");
    		String primaParte = testoInserito.substring(0, i);
    		String secondaParte = testoInserito.substring(i+1, testoInserito.length()-1);
    		txtResult.appendText(dictionary.wildcard(primaParte, secondaParte, i));
    		return;
    	}
    	if(testo.length==1) {
    		if(dictionary.translateWord(testo[0])== null) {
    			txtResult.appendText("Parola inesistente!\n");
    		}
    		else {
    			txtResult.appendText("\nTraduzioni per la parola "+testo[0]+":\n"+dictionary.translateWord(testo[0])+"\n");
    		}
    		
    	}
    	if(testo.length==2) {
    		dictionary.addWord(testo[0], testo[1]);
    		txtResult.appendText("Traduzione aggiunta!\n"+testo[0]+"->"+testo[1]+"\n");
    	}
    	txtWord.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtWord.clear();
    }
    
}
