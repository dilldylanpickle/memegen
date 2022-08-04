package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class MainController {
    
    @FXML
    private StackPane contentArea;
    
    /*
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		try {
			Parent fxml = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			contentArea.getChildren().removeAll();
			contentArea.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getClass()).log(Level.SEVERE, null, ex);
		}
		
	}*/
	
	public void Home (javafx.event.ActionEvent actionEvent) throws IOException {
		Parent fxml = FXMLLoader.load(getClass().getResource("/application/Memes.fxml"));
		contentArea.getChildren().removeAll();
		contentArea.getChildren().setAll(fxml);
	}
	
	
	public void Button1 (javafx.event.ActionEvent actionEvent) throws IOException {
		Parent fxml = FXMLLoader.load(getClass().getResource("/application/create.fxml"));
		contentArea.getChildren().removeAll();
		contentArea.getChildren().setAll(fxml);
	}
	
	public void Button2 (javafx.event.ActionEvent actionEvent) throws IOException {
		Parent fxml = FXMLLoader.load(getClass().getResource("/application/Page2.fxml"));
		contentArea.getChildren().removeAll();
		contentArea.getChildren().setAll(fxml);
	}
	
	public void Button3 (javafx.event.ActionEvent actionEvent) throws IOException {
		Parent fxml = FXMLLoader.load(getClass().getResource("/application/Page3.fxml"));
		contentArea.getChildren().removeAll();
		contentArea.getChildren().setAll(fxml);
	}
	
		}
