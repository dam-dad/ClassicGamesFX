package dad.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.classicgames.api.ArchiveOrg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import net.lingala.zip4j.model.ArchiveExtraDataRecord;

public class MosaicController implements Initializable {
	@FXML
	private FlowPane flowview;

	public MosaicController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MosaicController.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArchiveOrg game=
	}
	
	
}
