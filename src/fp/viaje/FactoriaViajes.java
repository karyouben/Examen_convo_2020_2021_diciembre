package fp.viaje;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaViajes {
	public static List<Viaje> leeViajes(String fichero){
		Checkers.checkNoNull(fichero);
		List<String> lineas=Ficheros.leeFichero("Error al leer el fichero", fichero);
		lineas.remove(0);
		
		List<Viaje> res=new ArrayList<Viaje>();
		for(String linea:lineas) {
			Viaje v=parsearViaje(linea);
			res.add(v);
		}return res;
	}

	private static Viaje parsearViaje(String linea) {
		Checkers.checkNoNull(linea);
		String[] trozos=linea.split(";");
		Checkers.check("Formato no valido", trozos.length==6);
		Double precio=Double.parseDouble(trozos[0].trim());
		Integer distancia=Integer.parseInt(trozos[1].trim());
		Duration duracion=Duration.parse(trozos[2].trim());
		TipoViaje tipo=TipoViaje.valueOf(trozos[3].trim().toUpperCase());
		List<String> trayecto=parseaLista(trozos[4].trim());
		return new Viaje(precio, distancia, duracion, tipo, trayecto);
		
	}

	private static List<String> parseaLista(String cadena) {
		Checkers.checkNoNull(cadena);
		String[] arreglo=cadena.split(",");
		List<String> salida=new ArrayList<>();
		for(String l:arreglo) {
			salida.add(l);
		}return salida;
	}

}
