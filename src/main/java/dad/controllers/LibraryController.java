package dad.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.classicgames.api.DownloadGames;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class LibraryController implements Initializable {

	@FXML
	private BorderPane libraryView;

	@FXML
	private ListView<File> libraryList;

	public LibraryController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/LibrarytabView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public ObservableList<File> installedgames() {
		ObservableList<File> installedGames = FXCollections.observableArrayList();
		File file = DownloadGames.GAMES_DIR;
		for (File ficheroEntraFile : file.listFiles()) {
			installedGames.add(ficheroEntraFile);
		}

		return installedGames;
	}

	public BorderPane getview() {
		return libraryView;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		libraryList.getItems().setAll(installedgames());
		libraryList.setCellFactory(nameListView -> new LibraryListCell());
	}
}
