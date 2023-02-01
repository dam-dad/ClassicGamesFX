package dad.classicgames;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;

public class PlayController {
	Titulos titulo;

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
			String emuexec = DescagaJuegos.Peticion(titulo);
			DescagaJuegos.unzipAndExecute(DescagaJuegos.download("https://archive.org/download/"
					+ titulo.getIdentifier() + "/" + DescagaJuegos.obtenerNombreZip(emuexec)),
					DescagaJuegos.ObtenerEmuExec(emuexec));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BorderPane getview() {
		return playView;
	}

	public void setDatos(Titulos nv) {
		this.titulo = nv;
	}

}
