package dad.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dad.classicgames.api.ArchiveOrg;
import dad.classicgames.api.model.Files;
import dad.classicgames.api.model.Item;
import dad.classicgames.api.model.ItemMetadata;
import dad.classicgames.api.model.Metadata;
import dad.classicgames.api.model.Result;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import dad.classicgames.api.model.Result;
import retrofit2.Response;

public class ClassicGamesController implements Initializable {

	@FXML
	private Menu Classicmenu;

	@FXML
	private MenuItem closemenu;

	@FXML
	private ListView<Item> GameList;

	@FXML
	private MenuBar menu;

	@FXML
	private Button next;

	@FXML
	private Button previous;

	@FXML
	private BorderPane root;

	@FXML
	private Tab tabiblio;

	@FXML
	private Tab tabjuegos;

	@FXML
	private TabPane tabpane;
	@FXML
	private BorderPane borderpane;
	@FXML
	private Label noselectedlabel;

	private PlayController PlayController;
	private String previouscursor = null;
	public String NextCursor = null;
	private final String COUNT = "100";

	private ArchiveOrg archive = new ArchiveOrg();

	public ClassicGamesController() {
		// cargamos la vista desde el fichero FXML
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClassicGames.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public BorderPane getview() {
		return root;
	}

	ObservableList<Item> getpreviousItems() {
		ObservableList<Item> titulos = FXCollections.observableArrayList();
		try {
			Response<Result> response = archive.getGames(this.COUNT, this.previouscursor);
			titulos.addAll(response.body().getItems());
			this.previouscursor = response.body().getPrevious();
			System.out.println(this.previouscursor);
			this.NextCursor = response.body().getCursor();
			System.out.println(this.NextCursor);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return titulos;

	}

	ObservableList<Item> getnextItems() {
		ObservableList<Item> titulos = FXCollections.observableArrayList();
		try {
			Response<Result> response = archive.getGames(this.COUNT, this.NextCursor);
			titulos.addAll(response.body().getItems());
			this.previouscursor = response.body().getPrevious();
			System.out.println(this.previouscursor);
			this.NextCursor = response.body().getCursor();
			System.out.println(this.NextCursor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(titulos.size());
		return titulos;

	}

	@FXML
	void loadnexts(ActionEvent event) {
		GameList.setItems(getnextItems());
	}

	@FXML
	void loadprevious(ActionEvent event) {
		GameList.setItems(getpreviousItems());
	}

	private void onSelectedItem(ObservableValue<? extends Item> o, Item ov, Item nv) {

		if (nv != null) {

			PlayController = new PlayController();
			PlayController.setDatos(nv);
			borderpane.setTop(PlayController.getview());
			noselectedlabel.setVisible(false);

		} else {

			borderpane.setTop(null);
			noselectedlabel.setVisible(true);

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			GameList.getSelectionModel().selectedItemProperty().addListener(this::onSelectedItem);
			GameList.setItems(getnextItems());
			GameList.setCellFactory(GameListView -> new ListCellController());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
