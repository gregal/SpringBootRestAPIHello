package restapists;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artigo
{
	@Id @GeneratedValue
	private Long id;
	private String titulo;
	private String autor;
	private String periodico;
	private String edicao;
	private Integer numero;
	private Integer ano;
	private Integer numpaginas;

	public Artigo()
	{
		super();
	}

	public Artigo(String titulo, String autor, int ano)
	{
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}
	
	public Artigo setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTitulo() {
		return titulo;
	}

	public Artigo setTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public String getAutor() {
		return autor;
	}

	public Artigo setAutor(String autor) {
		this.autor = autor;
		return this;
	}

	public String getPeriodico() {
		return periodico;
	}

	public Artigo setPeriodico(String periodico) {
		this.periodico = periodico;
		return this;
	}

	public String getEdicao() {
		return edicao;
	}

	public Artigo setEdicao(String edicao) {
		this.edicao = edicao;
		return this;
	}

	public Integer getNumero() {
		return numero;
	}

	public Artigo setNumero(Integer numero) {
		this.numero = numero;
		return this;
	}

	public Integer getAno() {
		return ano;
	}

	public Artigo setAno(Integer ano) {
		this.ano = ano;
		return this;
	}

	public Integer getNumpaginas() {
		return numpaginas;
	}

	public Artigo setNumpaginas(Integer numpaginas) {
		this.numpaginas = numpaginas;
		return this;
	}

	@Override
	public String toString()
	{
		return String.format("%s, %s. %s - %s, %d. %d. %d.",
				this.autor.toUpperCase(),
				this.titulo,
				this.periodico,
				this.edicao,
				this.ano,
				this.numero,
				this.numpaginas
				);
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