package dad.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MosaicComp {

	@FXML
	private Button Playbtn;

	@FXML
	private Button Removebtn;

	@FXML
	private Text description;

	@FXML
	private ImageView logo;

	@FXML
	private Label title;

	public MosaicComp() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MosaicComp.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
