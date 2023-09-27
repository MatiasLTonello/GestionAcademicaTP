package ar.edu.unlam;

public class Nota {

	private TipoNota tipoDeNota;
	private Integer valor;
	
	public TipoNota getTipoDeNota() {
		return tipoDeNota;
	}
	
	public void setTipoDeNota(TipoNota tipoDeNota) {
		this.tipoDeNota = tipoDeNota;
	}
	public Integer getValor() {
		return valor;
	}
	
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public Nota(TipoNota tipoDeNota, Integer valor) {
		super();
		this.tipoDeNota = tipoDeNota;
		this.valor = valor;
	}
	
	
	
	
}
