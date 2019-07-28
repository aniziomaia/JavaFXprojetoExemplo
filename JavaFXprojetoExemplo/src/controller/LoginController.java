package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Login;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable{

	@FXML
    private Button btLogin;

    @FXML
    private TextField txSenha;

    @FXML
    private Button btSair;

    @FXML
    private TextField txLogin;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btLogin.setOnMouseClicked((MouseEvent e)->{
			login();
		});
		
		btLogin.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				login();
			}
		});
		
		btSair.setOnMouseClicked((MouseEvent e)->{
			fechar();
		});
		
		btSair.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				fechar();
			}
		});
		
		txSenha.setOnKeyPressed((KeyEvent e)->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				login();
			}
		});
		
	}
	
	private void fechar() {
		Login.getStage().close();
	}
	
	private void login() {
		if(txLogin.getText().equals("root") && txSenha.getText().equals("root")) {
			Main m = new Main();
			fechar();
			m.start(new Stage());
		}else {
			util.Message.showMsg(AlertType.ERROR, "Login ou senha inválidos", "Erro", "Falha de autenticação");
		}
	}

}
