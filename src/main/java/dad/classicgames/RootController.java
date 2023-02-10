package dad.classicgames;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.classicgames.api.ArchiveOrg;
import dad.classicgames.api.model.Item;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class RootController implements Initializable {
	// controllers

	private PlayController PlayController = new PlayController();

	@FXML
	private TableView<Item> Tablajuegos;

	@FXML
	private TableColumn<Item, String> Columnanombre;
	@FXML
	private BorderPane juegoBorderPane;
	@FXML
	private Label noSelectedLabel;
	@FXML
	private TextField filter;

	@FXML
	private SplitPane view;
	private ArchiveOrg archive = new ArchiveOrg();
	public RootController() {
		// cargamos la vista desde el fichero FXML
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaz.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	ObservableList<Item> getTitulos() {
		ObservableList<Item> titulos = FXCollections.observableArrayList();
		try {
			titulos.addAll(archive.getGames());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titulos;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// listeners
		Tablajuegos.getSelectionModel().selectedItemProperty().addListener(this::onSelectedItem);
//		filter.textProperty().addListener(this::onSearchItem);

		Columnanombre.setCellValueFactory(new PropertyValueFactory<>("title"));
		Tablajuegos.setItems(getTitulos());
	}

	private void onSelectedItem(ObservableValue<? extends Item> o, Item ov, Item nv) {

		if (nv != null) {

			PlayController = new PlayController();
			PlayController.setDatos(nv);
			juegoBorderPane.setTop(PlayController.getview());
			noSelectedLabel.setVisible(false);

		} else {

			juegoBorderPane.setTop(null);
			noSelectedLabel.setVisible(true);

		}

	}

	public SplitPane getview() {
		return view;
	}
}
