package fp.viaje;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AgenciaBus {
	private List<Viaje> viajes;
	private String nombre;
	
	
	public List<Viaje> getViajes() {
		return viajes;
	}
	public String getNombre() {
		return nombre;
	}
	
	public AgenciaBus(Stream<Viaje> viajes) {
		this.viajes=viajes.collect(Collectors.toList());
	}
	public AgenciaBus() {
		viajes=new ArrayList<>();
	}
	
	public AgenciaBus(List<Viaje> viajes) {
		this.viajes=new ArrayList<>(viajes);
	}
	
	public AgenciaBus(Collection<Viaje> viajes) {
		this.viajes=new ArrayList<>(viajes);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((viajes == null) ? 0 : viajes.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AgenciaBus))
			return false;
		AgenciaBus other = (AgenciaBus) obj;
		if (viajes == null) {
			if (other.viajes != null)
				return false;
		} else if (!viajes.equals(other.viajes))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AgenciaBus [viajes=" + viajes + ", nombre=" + nombre + "]";
	}
	
	//ejercicio 1
	public Boolean hayViajesCirculares() {
		return viajes.stream()
				.anyMatch(c->c.origen().equals(c.destino()));
	}
	
	//ejercicio 2
	
	public Duration getMaximaDuracion() {
		return viajes.stream()
				.max(Comparator.comparing(Viaje::numParadas))
				.map(Viaje::getDuracion)
				.orElse(Duration.ZERO);
				
	}
	
	//ejercicio 3
	
	public void añadirTiempoDescanso(String parada, Integer minutos) {
		 viajes.stream()
				.filter(c->c.paradas().contains(parada))
				.forEach(v->v.setDuracion(v.getDuracion().plusMinutes(minutos)));
		
	}
	
	//ejercicio 4
	
	public SortedSet<String> getParadas(){
		return viajes.stream()
				.flatMap(c->c.paradas().stream())
				.collect(Collectors.toCollection(TreeSet::new));
	}
	
	//ejercicio 5
	public Map<String,Viaje> ViajeDuracionMinimaPorDestinoPorParadas(){
		return viajes.stream()
				.collect(Collectors.groupingBy(Viaje::destino,
						Collectors.collectingAndThen(Collectors.minBy(
								Comparator.comparing(Viaje::getDuracion)), c->c.get())));
	}
	
	
	
	

}
