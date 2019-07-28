package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.ExibirMoradia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Categoria;
import util.Message;

public class AppController implements Initializable{

	@FXML
	private Label labelResultado;
	
    @FXML
    private TextField txtFieldOla;
    
    @FXML
    private ComboBox<Categoria> comboBoxCategorias;
    
    private List <Categoria>listaCategorias = new ArrayList<Categoria>();
    private ObservableList<Categoria> obsCategorias ;
    
    @FXML
    private CheckBox checkBoxSim;

    @FXML
    private CheckBox checkBoxNao;
    
    @FXML
    private ToggleGroup grupoMoradia;
    
    @FXML
    private Label traceMoradia;

    @FXML
    private Label traceFinanca;

    @FXML
    private Label traceNome;
    
    @FXML
    private Label traceCategoria;
    
    @FXML
    private Label traceExecutar;
    
    @FXML
    private ImageView imgMoradia;
    
    @FXML
    private ImageView imgFinancas;
    
    @FXML
    private Rectangle desenhoRetangulo;
    
    @FXML
    private Label retanguloLabel;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.carregarCategoria();
		retanguloLabel.setVisible(false);
		desenhoRetangulo.setVisible(false);
		
		imgMoradia.setOnMouseClicked((MouseEvent e)->{
			ExibirMoradia em = new ExibirMoradia();
			em.start(new Stage());
		});
	}
	
	@FXML
	private void executeButton(ActionEvent event) {
		
		String  resultado = "";
		if(checkBoxSim.selectedProperty().getValue())
			resultado = "rico";
		if(checkBoxNao.selectedProperty().getValue())
			resultado = "milhonário";
		
		RadioButton radio = (RadioButton)grupoMoradia.getSelectedToggle();
		
		labelResultado.setText("Olá: " + txtFieldOla.getText() + 
		         ", você anda de " +  comboBoxCategorias.getValue() + 
		         ", você é " + resultado + 
		         " e você mora em um " + radio.getText());
		
		traceExecutar.setText("Os dados foram montados. ");
		Message.showMsg(AlertType.INFORMATION, "Ai está o resultado.", "Resultado", "Informação");
	}
	
	@FXML
	private void onChangeCoboBox(ActionEvent event) {
		//ComboBox<Categoria> cb = (ComboBox<Categoria>) event.getSource();
		//String valor = ((ComboBox)event.getSource()).getValue().toString();
		//Categoria ct = cb.getValue();
		
		String  resultado = "";
		if(checkBoxSim.selectedProperty().getValue())
			resultado = "rico";
		if(checkBoxNao.selectedProperty().getValue())
			resultado = "milhonário";
		
		RadioButton radio = (RadioButton)grupoMoradia.getSelectedToggle();
		
		labelResultado.setText("Olá: " + txtFieldOla.getText() + 
				         ", você anda de " +  comboBoxCategorias.getValue() + 
				         ", você é " + resultado + 
				         " e você mora em um " + radio.getText());
		
		traceCategoria.setText("Categoria foi selecionada: " + comboBoxCategorias.getValue());
		
	}
	
	@FXML
	private void carregarCategoria() {
		
		listaCategorias.add(new Categoria(1, "Carro"));
		listaCategorias.add(new Categoria(2, "Moto"));
		listaCategorias.add(new Categoria(3, "Caminhão"));
		listaCategorias.add(new Categoria(4, "Trator"));
		
		obsCategorias = FXCollections.observableArrayList(listaCategorias);
		comboBoxCategorias.setItems(obsCategorias);
	}
	
	@FXML
    void actionRadio(ActionEvent event) {
		RadioButton radio = (RadioButton)grupoMoradia.getSelectedToggle();
		traceMoradia.setText("Moradia foi selecionada: " + radio.getText());
		imgMoradia.setVisible(true);
		retanguloLabel.setVisible(true);
		desenhoRetangulo.setVisible(true);
    }

    @FXML
    void actionFinancas(ActionEvent event) {
    	String  resultado = "";
    	if(checkBoxSim.selectedProperty().getValue())
			resultado = "rico";
		if(checkBoxNao.selectedProperty().getValue())
			resultado = "milhonário";
		
		traceFinanca.setText("Situação financeira foi selecionada: " + resultado);
		imgFinancas.setVisible(true);

    }
    
    @FXML
    void actionNome(KeyEvent event) {
		TextField tx = (TextField)event.getSource();
		traceNome.setText("O nome foi digitado: " + tx.getText());
    }
}
