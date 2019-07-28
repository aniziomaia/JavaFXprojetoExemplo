package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.ExibirMoradia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ExibirMoradiaController implements Initializable{

	@FXML
    private Button btFechar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btFechar.setOnMouseClicked((MouseEvent e)->{
			ExibirMoradia.getStage().close();
		});
		
	}
}
