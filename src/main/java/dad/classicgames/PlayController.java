package dad.classicgames;

import java.io.IOException;
import java.util.Optional;

import dad.classicgames.api.DownloadGames;
import dad.classicgames.api.model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;

public class PlayController {
	Item titulo;

	@FXML
	private Button buttonJugar;

	@FXML
	private BorderPane playView;

	public PlayController() {
		// cargamos la vista desde el fichero FXML
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/VistaJuego.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unused")
	@FXML
	void OnClickJugar(ActionEvent event) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("vas a jugar a" + titulo.getIdentifier());
		alert.setHeaderText("Jugar");
		alert.setContentText("¡Que lo disfrutes!");

		Optional<ButtonType> result = alert.showAndWait();
		try {
			String emuexec = DownloadGames.Peticion(titulo);
			DownloadGames.unzipAndExecute(DownloadGames.download("https://archive.org/download/"
					+ titulo.getIdentifier() + "/" + DownloadGames.obtenerNombreZip(emuexec)),
					DownloadGames.ObtenerEmuExec(emuexec));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BorderPane getview() {
		return playView;
	}

	public void setDatos(Item nv) {
		this.titulo = nv;
	}

}
