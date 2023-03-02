package dad.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import dad.classicgames.api.ArchiveOrg;
import dad.classicgames.api.DownloadGames;
import dad.classicgames.api.model.Files;
import dad.classicgames.api.model.Item;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;

public class GameListCell extends ListCell<Item> {

	private Item data;

	@FXML
	private Button downloadButton;

	@FXML
	private Button playbutton;

	@FXML
	private Label title;

	@FXML
	private BorderPane view;

	@FXML
	private Label year;
	DownloadGames download = new DownloadGames();

	public GameListCell() {
		super();
		try {
			FXMLLoader mLLoader = new FXMLLoader(getClass().getResource("/GameListCell.fxml"));
			mLLoader.setController(this);
			mLLoader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void updateItem(Item item, boolean empty) {
		super.updateItem(item, empty);

		data = item;

		setText(null);

		if (empty || item == null) {

			setGraphic(null);

		} else {

			title.setText(item.getTitle());
			if (item.getYear() != null) {
				year.setText(item.getYear());
			} else {
				year.setText("Fecha desconocida");
			}
			setGraphic(view);

		}

	}

	public String getZipName() {
		String zipname = null;

		try {
			List<Files> files = new ArrayList<Files>();
			files.addAll(ArchiveOrg.getInstance().getItemMetadata(data.getIdentifier()).getFiles());
			for (Files file : files) {
				if (file.getFormat().contains("ZIP"))
					zipname = file.getName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return zipname;
	}

	@FXML
	void OnClickDownload(ActionEvent event) throws Exception {

		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("vas a jugar a" + data.getIdentifier());
		alert.setHeaderText("Jugar");

		Optional<ButtonType> result = alert.showAndWait();

		download.setGameVars("https://archive.org/download/" + data.getIdentifier() + "/" + getZipName());
		download.download();
		download.unzip();

	}

	@FXML
	void OnClickPlay(ActionEvent event) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("vas a jugar a" + data.getIdentifier());
		alert.setHeaderText("Jugar");
		Optional<ButtonType> result = alert.showAndWait();
		String emuexec;
		try {
			emuexec = ArchiveOrg.getInstance().getItemMetadata(data.getIdentifier()).getMetadata().getEmulatorStart();
			download.setGameVars("https://archive.org/download/" + data.getIdentifier() + "/" + getZipName());
			download.download();
			download.unzip();
			download.execute(emuexec);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
