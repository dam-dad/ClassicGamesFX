package dad.classicgames;

import java.util.ArrayList;

public class pruebas {

	public static void main(String[] args) {
ArrayList<Titulos> titulos = ListaJuegos.ObtenerListaJuegos();
for (Titulos titulo : titulos) {
	titulo.getTitle();
}
	}

}
