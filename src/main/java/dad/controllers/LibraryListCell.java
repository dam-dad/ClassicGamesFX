package dad.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import org.apache.commons.io.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;

public class LibraryListCell extends ListCell<File> {
	@FXML
	private Button DeleteButton;

	@FXML
	private Label gameName;
	@FXML
	private BorderPane view;
	@FXML
	private Button playbtn;
	private File downloadedgames;

	public LibraryListCell() {
		super();
		try {
			FXMLLoader mLLoader = new FXMLLoader(getClass().getResource("/LibraryListCell.fxml"));
			mLLoader.setController(this);
			mLLoader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void updateItem(File file, boolean empty) {
		super.updateItem(file, empty);

		downloadedgames = file;

		setText(null);
		if (empty || file == null) {
			setGraphic(null);

		} else {
			gameName.setText(file.getName());
			setGraphic(view);
		}

	}

	@FXML
	void OnDeleteAction(ActionEvent event) throws IOException {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Confirmación");
		alert.setContentText("¿Estas seguro de confirmar la acción?");
		Optional<ButtonType> action = alert.showAndWait();
		if (action.get() == ButtonType.OK) {
			FileUtils.deleteDirectory(downloadedgames);
			DeleteButton.setDisable(true);
		}

	}

}
