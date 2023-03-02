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
		super();
		// carga la vista desde FXML (MonthCalendar es controlador y vista a la vez [porque es un componente])
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MosaicComp.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
