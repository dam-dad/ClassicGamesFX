package dad.controllers;

import java.awt.TextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.classicgames.api.ArchiveOrg;
import dad.classicgames.api.DownloadGames;
import dad.classicgames.api.model.Files;
import dad.classicgames.api.model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class PlayController implements Initializable {
	private Item game;
	private ArchiveOrg archive = new ArchiveOrg();

	@FXML
	private Button buttonJugar;

	@FXML
	private TextArea description;

	@FXML
	private ImageView logo;

	@FXML
	private BorderPane playView;

	@FXML
	private Text title;

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
		alert.setContentText("vas a jugar a" + game.getIdentifier());
		alert.setHeaderText("Jugar");
		alert.setContentText("¡Que lo disfrutes!");

		Optional<ButtonType> result = alert.showAndWait();
		try {
			String zipname = null;
			String emuexec = archive.getItemMetadata(game.getIdentifier()).getMetadata().getEmulatorStart();
			List<Files> files = new ArrayList<Files>();
			files.addAll(archive.getItemMetadata(game.getIdentifier()).getFiles());
			for (Files file : files) {
				if (file.getFormat().contains("ZIP"))
					zipname = file.getName();
			}

			java.io.File downloaded = DownloadGames
					.download("https://archive.org/download/" + game.getIdentifier() + "/" + zipname);
			java.io.File gamedir = DownloadGames.unzip(downloaded);
			DownloadGames.execute(gamedir, emuexec);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BorderPane getview() {
		return playView;
	}

	public void setDatos(Item nv) {
		this.game = nv;
		title.setText(game.getTitle());
		logo.setImage((new Image(getClass().getResource("/Images/foto.png").toString())));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}