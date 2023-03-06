/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.Ex_IndovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	private int numSegreto;
	private final int maxTentativi = 8;
	private final int range = 100 ;
	private int tentativiFatti;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuovaPartita"
    private Button btnNuovaPartita; // Value injected by FXMLLoader

    @FXML // fx:id="btnProva"
    private Button btnProva; // Value injected by FXMLLoader
    
    @FXML // fx:id="hBox"
    private HBox hBox; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtRisposta"
    private TextField txtRisposta; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativi"
    private TextField txtTentativi; // Value injected by FXMLLoader

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	//GESTIONE DI UNA NUOVA PARTITA
    	this.numSegreto = (int)((Math.random() * range ) +1);
    	this.tentativiFatti = 0;
    	
    	//GESTIONE INTERFACCIA
    	txtTentativi.setText(Integer.toString(maxTentativi));
    	hBox.setDisable(false);
    	txtRisultato.clear();
    }

    @FXML
    void doTentativo(ActionEvent event) {
    	//CONTROLLO CHE ILTENTATIVO INSERITO SIA UN NUMERO
    	String r = txtRisposta.getText();
    	int tentativo;
    	try {
    		tentativo = Integer.parseInt(r);
    	}
    	catch(NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un tentativo numerico tra 1-100!");
    		return;
    	}
    	this.tentativiFatti++;
    	//CONTROLLO SE HA INDOVINATO
    	if(tentativo == numSegreto) {
    		txtRisultato.setText("HAI INDOVINATO IN " + this.tentativiFatti+" TENTATIVI!!");
    		hBox.setDisable(true);
    		return;
    	}
    	//CONTROLLO SE HA ESAURITO I TENTATIVI
    	if(this.tentativiFatti == maxTentativi) {
    		hBox.setDisable(true);
    		txtRisultato.setText("HAI PERSO! IL NUMERO SEGRETO ERA: " + this.numSegreto);
    		return;
    	}
    	if(tentativo < this.numSegreto) {
    		txtRisultato.setText("Tentativo troppo basso");
    	}
    	else {
    		txtRisultato.setText("Tentativo troppo alto");
    	}
    	
    	txtTentativi.setText(Integer.toString(this.maxTentativi - tentativiFatti));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisposta != null : "fx:id=\"txtRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
