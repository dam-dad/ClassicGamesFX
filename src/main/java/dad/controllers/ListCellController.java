package dad.controllers;

/*
 @Override
	protected void updateItem(Metadata metadata, boolean empty) {
		super.updateItem(metadata, empty);

		if (empty || metadata == null) {

			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("/ComponenteLista.fxml"));
				mLLoader.setController(this);

				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} 
			titleGame.setText(String.valueOf(metadata.getTitle()));
			DescriptionGame.setText(String.valueOf(metadata.getDescription()));
			 if(metadata.getLogo()!=null) {
				 Image image= new Image("https://archive.org/download/" + metadata.getIdentifier() + "/" + metadata.getLogo());
	                logoGame.setImage(image);
	            } else {
	            	Image classicimage=new Image("/resources/Images/foto.png");
	            	logoGame.setImage(classicimage);
	            }
	            setText(null);
	            setGraphic(component);
		}
		
	}
	*/
import java.io.IOException;

import dad.classicgames.api.model.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ListCellController extends ListCell<Item> {

	@FXML
	private VBox VBox;

	@FXML
	private ImageView logoGame;

	@FXML
	private Label titleGame;

	private FXMLLoader mLLoader;
	Item data;

//	public ListCellController() {
//		// cargamos la vista desde el fichero FXML
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ComponenteLista.fxml"));
//			loader.setController(this);
//			loader.load();
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}

	@Override
	protected void updateItem(Item game, boolean empty) {
		super.updateItem(game, empty);

		if (empty || game == null) {

			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("/ComponenteLista.fxml"));
				mLLoader.setController(this);

				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			titleGame.setText(game.getTitle());
			logoGame.setImage(new Image(getClass().getResource("/Images/foto.png").toString()));
			VBox.setMinHeight(220);
			setText(null);
			setGraphic(VBox);
		}

	}

}
