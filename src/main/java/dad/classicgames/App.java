package dad.classicgames;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	 public void start(Stage primaryStage) throws Exception {
		
		RootController controller = new RootController();
		
		Scene scene = new Scene(controller.getview());
		
		primaryStage.setTitle("juego");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}


}
