package ar.edu.unlam;

public class Aula {
    private String idAula;
    private Integer capacidadMaxima;
    private Integer cantidadAlumnosInscritos;

    public Aula(String idAula, int capacidadMaxima) {
        this.idAula = idAula;
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadAlumnosInscritos = 0;
    }

    public String getIdAula() {
        return idAula;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getCantidadAlumnosInscritos() {
        return cantidadAlumnosInscritos;
    }

    public void incrementarCantidadAlumnosInscritos() {
        if (cantidadAlumnosInscritos < capacidadMaxima) {
            cantidadAlumnosInscritos++;
        }
    }

    public void decrementarCantidadAlumnosInscritos() {
        if (cantidadAlumnosInscritos > 0) {
            cantidadAlumnosInscritos--;
        }
    }
    
    public Boolean verificiarDisponibilidad() {
    	return capacidadMaxima > cantidadAlumnosInscritos;
    }
    
}
