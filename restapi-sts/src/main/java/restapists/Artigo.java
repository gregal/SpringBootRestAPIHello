package restapists;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

//import lombok.Data;

@Entity
//@Data
public class Artigo implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = -3987744595210216858L;

//	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id @GeneratedValue
	private Long id;
	private String titulo;
	// private String autor;
	// private String periodico;
	// private String edicao;
	// private String numero;
	private Integer ano;
	// private Integer numpaginas;

	public Artigo()
	{
		super();
	}

	public Artigo(String tituloDoArtigo)
	{
		super();
		this.titulo = tituloDoArtigo;
	}

	public Artigo(String titulo, int anoPublicacao)
	{
		super();
		this.titulo = titulo;
		this.ano = anoPublicacao;
	}

	public Long getId() {
		return this.id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public int getAno() {
		return this.ano;
	}

	@Override
	public String toString()
	{
		return this.titulo;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
	    if (!(o instanceof Artigo)) return false;
	    
	    Artigo artigo = (Artigo) o;
	    return Objects.equals(this.id, artigo.id) 
    		&& Objects.equals(this.titulo, artigo.titulo)
	        && Objects.equals(this.ano, artigo.ano);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.titulo, this.ano);
	}
}