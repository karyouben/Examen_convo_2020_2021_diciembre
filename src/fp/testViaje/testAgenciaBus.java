package fp.testViaje;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import fp.viaje.AgenciaBus;
import fp.viaje.FactoriaViajes;
import fp.viaje.Viaje;

public class testAgenciaBus {

	public static void main(String[] args) {
		List<Viaje> viajes=FactoriaViajes.leeViajes("data/viajes.csv");
		AgenciaBus v=new AgenciaBus(viajes);
		System.out.println("\nTestHayViajesCirculares");
		System.out.println("=========================");
		testHayViajesCirculares(v);
		System.out.println("\nTestGetMaximaDuracion");
		System.out.println("=======================");
		testGetMaximaDuracion(v);
		System.out.println("\nTestAñadirTiempoDescanso");
		System.out.println("==========================");
		TestAñadirTiempoDescanso(v,"Sevilla", 25);
		System.out.println("\nTestGetParadas");
		System.out.println("=================");
		testGetParadas(v);
		System.out.println("\nTestViajeDuracionMinimaPorDestinoPorParadas");
		System.out.println("=============================================");
		testViajeDuracionMinimaPorDestinoPorParadas(v);
		
		
	}




	private static void testHayViajesCirculares(AgenciaBus v) {
		try {
			String msg=String.format("¿Hay algun viaje circular? %d",
					v.hayViajesCirculares());
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Capturada Excepción Inesesperada " + e.getMessage());
		}
	}
	
	private static void testGetMaximaDuracion(AgenciaBus v) {
		try {
			String msg=String.format("La duracion del viaje mas largo es de: %d",
					v.getMaximaDuracion());
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Capturada Excepción Inesesperada " + e.getMessage());
		}
	}
	
	private static void TestAñadirTiempoDescanso(AgenciaBus v, String parada, Integer minutos) {
		try {
			String msg=String.format("Añadimos %d minutos a la parada "+parada+" por lo que tenemos: %s",
					v.añadirTiempoDescanso(parada, minutos));
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Capturada Excepción Inesesperada " + e.getMessage());
		}
	}
	

	private static void testGetParadas(AgenciaBus v) {
		try {
			String msg=String.format("El conjunto de paradas es el siguiente: %d",
					v.getParadas());
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Capturada Excepción Inesesperada " + e.getMessage());
		}
	}
	

	private static void testViajeDuracionMinimaPorDestinoPorParadas(AgenciaBus v) {
		try {
			String msg=String.format("La menor duracion por destino es la siguiente: ");
			System.out.println(msg);
			Map<String,Viaje> p=v.ViajeDuracionMinimaPorDestinoPorParadas();
			p.entrySet().stream().forEach(System.out::println);
		}catch(Exception e) {
			System.err.println("Capturada Excepción Inesesperada " + e.getMessage());
		}
	}

}
