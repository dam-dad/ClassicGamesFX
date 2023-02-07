package dad.classicgames.test;

import java.util.ArrayList;

import dad.classicgames.api.GamesList;
import dad.classicgames.api.model.Item;

public class Tests {

	public static void main(String[] args) {
		ArrayList<Item> titulos = GamesList.getGamesList();
		for (Item titulo : titulos) {
			titulo.getTitle();
		}
	}

}
