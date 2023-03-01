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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dad.classicgames.api.ArchiveOrg;
import dad.classicgames.api.DownloadGames;
import dad.classicgames.api.model.Files;
import dad.classicgames.api.model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ListCellController extends ListCell<Item> {

	@FXML
	private Button DownloadButton;

	@FXML
	private Button Playbutton;

	@FXML
	private Label Title;

	@FXML
	private BorderPane listcomp;

	@FXML
	private Label year;

	private FXMLLoader mLLoader;
	private Item data;
	ArchiveOrg archive = new ArchiveOrg();

	@Override
	protected void updateItem(Item game, boolean empty) {
		super.updateItem(game, empty);
		data = game;
		if (empty || game == null) {
			
			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("/ListComp.fxml"));
				mLLoader.setController(this);

				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			Title.setText(game.getTitle());
			if (game.getYear() != null) {
				year.setText(game.getYear());
			} else {
				year.setText("Fecha desconocida");
			}

			setText(null);
			setGraphic(listcomp);
		}

	}

	@FXML
	void OnClickDownload(ActionEvent event) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("vas a jugar a" + data.getIdentifier());
		alert.setHeaderText("Jugar");
		alert.setContentText("¡Que lo disfrutes!");
		Optional<ButtonType> result = alert.showAndWait();
		try {
			String zipname = null;
			String emuexec = archive.getItemMetadata(data.getIdentifier()).getMetadata().getEmulatorStart();
			List<Files> files = new ArrayList<Files>();
			files.addAll(archive.getItemMetadata(data.getIdentifier()).getFiles());
			for (Files file : files) {
				if (file.getFormat().contains("ZIP"))
					zipname = file.getName();
			}
			java.io.File downloaded = DownloadGames
					.download("https://archive.org/download/" + data.getIdentifier() + "/" + zipname);
			java.io.File gamedir = DownloadGames.unzip(downloaded);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void OnClickPlay(ActionEvent event) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("vas a jugar a" + data.getIdentifier());
		alert.setHeaderText("Jugar");
		alert.setContentText("¡Que lo disfrutes!");
		Optional<ButtonType> result = alert.showAndWait();
		try {
			String zipname = null;
			String emuexec = archive.getItemMetadata(data.getIdentifier()).getMetadata().getEmulatorStart();
			List<Files> files = new ArrayList<Files>();
			files.addAll(archive.getItemMetadata(data.getIdentifier()).getFiles());
			for (Files file : files) {
				if (file.getFormat().contains("ZIP"))
					zipname = file.getName();
			}
			java.io.File downloaded = DownloadGames
					.download("https://archive.org/download/" + data.getIdentifier() + "/" + zipname);
			java.io.File gamedir = DownloadGames.unzip(downloaded);
			DownloadGames.execute(gamedir, emuexec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
