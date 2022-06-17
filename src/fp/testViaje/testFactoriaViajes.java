package fp.testViaje;

import java.util.List;

import fp.viaje.FactoriaViajes;
import fp.viaje.Viaje;

public class testFactoriaViajes {

	public static void main(String[] args) {
		testLeeViajes("data/Viajes.csv");
	}

	private static void testLeeViajes(String fichero) {
		System.out.println("\nTestLeeViajes ============");
		List<Viaje> viajes=FactoriaViajes.leeViajes(fichero);
		System.out.println(" Viaje: ");
		for(Viaje v:viajes) {
			System.out.println(v);
		}
	}

}
