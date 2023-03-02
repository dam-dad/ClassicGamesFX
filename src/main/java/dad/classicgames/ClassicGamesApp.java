package dad.classicgames;

import dad.controllers.ClassicGamesController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClassicGamesApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		ClassicGamesController controller = new ClassicGamesController();

		Scene scene = new Scene(controller.getview());

		primaryStage.setTitle("juego");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
