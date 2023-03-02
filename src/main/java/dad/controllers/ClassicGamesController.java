package dad.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dad.classicgames.api.ArchiveOrg;
import dad.classicgames.api.model.Item;
import dad.classicgames.api.model.Result;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ClassicGamesController implements Initializable {
	@FXML
	private Menu Classicmenu;

	@FXML
	private ListView<Item> gameList;

	@FXML
	private ListView<Item> libraryList;

	@FXML
	private Button MosaicView;

	@FXML
	private Button SearchButton;

	@FXML
	private TextField SearchText;

	@FXML
	private Button ViewList;

	@FXML
	private MenuItem closemenu;

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

	public String NextCursor = null;
	private final int COUNT = 100;
	private ArrayList<String> page = new ArrayList<String>();
	private int pageCounter = 0;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			previous.setVisible(false);
			gameList.setCellFactory(nameListView -> new GameListCell());
			Result result = ArchiveOrg.getInstance().getGames(COUNT, null);
			page.add(result.getPrevious());
			page.add(result.getCursor());
			gameList.getItems().setAll(result.getItems());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public BorderPane getview() {
		return root;
	}

	@FXML
	void loadNext(ActionEvent event) throws Exception {
		pageCounter++;
		if (pageCounter > 0) {
			previous.setVisible(true);
		}
		Result result = ArchiveOrg.getInstance().getGames(this.COUNT, page.get(pageCounter));
		if (!page.contains(result.getCursor())) {
			page.add(result.getCursor());
		}
		System.out.println(pageCounter);
		gameList.getItems().setAll(result.getItems());

	}

	@FXML
	void loadPrevious(ActionEvent event) throws Exception {
		pageCounter--;
		if (pageCounter <= 0) {
			previous.setVisible(false);
		}
		Result result = ArchiveOrg.getInstance().getGames(COUNT, page.get(pageCounter));
		gameList.getItems().setAll(result.getItems());
	}

	@FXML
	void OnClickListView(ActionEvent event) {
		gameList.setDisable(false);
	}

	@FXML
	void OnClickMosaicView(ActionEvent event) {

	}

	@FXML
	void OnClickSearch(ActionEvent event) throws Exception {
		String search = SearchText.getText();
		Result result;
		if (search.isEmpty() || search.isBlank()) {
			result = ArchiveOrg.getInstance().getGames(COUNT, null);
		} else {
			result = ArchiveOrg.getInstance().searchGames(null, null, search);
		}
		gameList.getItems().setAll(result.getItems());
		pageCounter=0;
	}

}
