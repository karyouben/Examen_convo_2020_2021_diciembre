package fp.viaje;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class Viaje {
	
	private Double precio;
	private Integer distancia;
	private Duration duracion;
	private TipoViaje tipo;
	private List<String> trayecto;
	
	// constructor 1
	public Viaje(Double precio,Integer distancia,Duration duracion,TipoViaje tipo,
			String origen,String destino) {
		Checkers.check("El trayecto debe tener al menos dos paradas", trayecto.size()>=2);
		Checkers.check("La distancia y la duracion y el precio deben ser mayor que cero",
				distancia>=0 && precio>=0.0 && duracion.getSeconds()>=0);
		Checkers.check("El tipo de viaje de un viaje con solo un origen y un destino no pueden"
				+ "ser TRANSBORDO", trayecto.size()==2 && tipo!=TipoViaje.TRANSBORDO);
		this.precio=precio;
		this.distancia=distancia;
		this.duracion=duracion;
		this.tipo=tipo;
		this.trayecto=new ArrayList<String>();
		trayecto.add(origen);
		trayecto.add(destino);
		
	}
	
	// constructor 2
	public Viaje(Double precio,Integer distancia,Duration duracion,TipoViaje tipo,
			List<String> trayecto) {
		Checkers.check("El trayecto debe tener al menos dos paradas", trayecto.size()>=2);
		Checkers.check("La distancia y la duracion y el precio deben ser mayor que cero",
				distancia>=0 && precio>=0.0 && duracion.getSeconds()>=0);
		Checkers.check("El tipo de viaje de un viaje con solo un origen y un destino no pueden"
				+ "ser TRANSBORDO", trayecto.size()==2 && tipo!=TipoViaje.TRANSBORDO);

		this.precio=precio;
		this.distancia=distancia;
		this.duracion=duracion;
		this.tipo=tipo;
		this.trayecto=new ArrayList<String>();
		
	}
	
	public Double velocidadMedia() {
		return getDistancia()/getDuracion().toHours()*1.0;
	}
	
	public Integer numParadas() {
		return trayecto.size()-2-numTransbordos();
		
	}
	
	public List<String> paradas(){
		List<String> paradas=null;
		if(trayecto.size()>2) {
			paradas=new ArrayList<>();
			for(int i =1;i<trayecto.size()-2;i++) {
				paradas.add(trayecto.get(i));
		}
		}return paradas;	
	}
	
	public String origen() {
		return trayecto.get(0);
	}
	public String destino() {
		Integer m =trayecto.size();
		return trayecto.get(m-1);
	}
	
	public Integer numTransbordos() {
		Integer t =0;
			if(getTipo().equals(TipoViaje.TRANSBORDO)) {
				t=calcularRepetidosConsecutivos(getTrayecto());
		}return t;
		
	}


	private Integer calcularRepetidosConsecutivos(List<String> trayecto) {
		Integer cont=0;
		for(int i =0;i<trayecto.size()-2;i++) {
			if(trayecto.get(i).equals(trayecto.get(i+1))) {
				cont++;
			}
		}
		return cont;
	}

	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		Checkers.check("El precio debe ser mayor que cero", precio>=0.0 );
		this.precio = precio;
	}


	public Integer getDistancia() {
		return distancia;
	}


	public void setDistancia(Integer distancia) {
		Checkers.check("La distancia debe ser mayor que cero", distancia>=0);
		this.distancia = distancia;
	}


	public Duration getDuracion() {
		return duracion;
	}


	public void setDuracion(Duration duracion) {
		Checkers.check("La duracion debe ser mayor que cero", duracion.getSeconds()>=0);
		this.duracion = duracion;
	}


	public TipoViaje getTipo() {
		return tipo;
	}


	public void setTipo(TipoViaje tipo) {
		this.tipo = tipo;
	}


	public List<String> getTrayecto() {
		return trayecto;
	}


	public void setTrayecto(List<String> trayecto) {
		this.trayecto = trayecto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trayecto == null) ? 0 : trayecto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Viaje))
			return false;
		Viaje other = (Viaje) obj;
		if (trayecto == null) {
			if (other.trayecto != null)
				return false;
		} else if (!trayecto.equals(other.trayecto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + trayecto + "]";
	}
	


}
