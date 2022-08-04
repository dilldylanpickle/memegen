package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	double x,y = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			
			/*primaryStage.initStyle(StageStyle.UNDECORATED);
			
			root.setOnMousePressed(event -> {
				x = event.getSceneX();
				y = event.getSceneY();
			});
			
			root.setOnMouseDragged(event -> {
				primaryStage.setX(event.getScreenX() - x);
				primaryStage.setX(event.getScreenY() - y);
			});
			*/
			
			
			Scene scene = new Scene(root,1024,768);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
