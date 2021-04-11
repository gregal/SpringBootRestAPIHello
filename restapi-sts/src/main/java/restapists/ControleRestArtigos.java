package restapists;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ControleRestArtigos
{
	@Autowired RepositorioDeArtigos repositorio;

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@GetMapping("/artigos")
	Collection<Artigo> obterArtigos()
	{
		System.out.println("GET /artigos");
		Collection<Artigo> artigos = this.repositorio.findAll();

		for (Artigo artigo : artigos)
			System.out.println(artigo);

		return artigos;
	}
	
	@GetMapping("/artigos/{id}")
	Artigo obterArtigo(@PathVariable Long id)
	{
		log.info("GET /artigos/" + id.toString());
		
		Artigo artigo = this.repositorio.findById(id)
    		.orElseThrow(() -> new ArtigoNotFoundException(id));
		
		log.info(artigo.toString());
		return artigo;
	}

	@DeleteMapping("/artigos/{id}")
	void excluirArtigo(@PathVariable Long id)
	{
	
		log.info("DELETE /artigos/" + id.toString());
		
		try
		{
			this.repositorio.deleteById(id);
		}
		catch (EmptyResultDataAccessException ex)
		{
			log.error("Artigo não encontrado.");
			throw new ArtigoNotFoundException(id);
		}
	}
	
	@PostMapping("/artigos")
	Artigo criarArtigo(@RequestBody Artigo artigo)
	{
	
		log.info("POST /artigos");
		log.info(artigo.toString());
		
		return this.repositorio.save(artigo);
	}
	
	@PutMapping("/artigos/{id}")
	Artigo alterarArtigo(@RequestBody Artigo novoArtigo, @PathVariable Long id) {
	
		log.info("PUT /artigos");
		log.info(novoArtigo.toString());
	    
		return this.repositorio.findById(id)
    		.map(artigo -> {
    			artigo.setTitulo(novoArtigo.getTitulo());
    			artigo.setAutor(novoArtigo.getAutor());
    			artigo.setPeriodico(novoArtigo.getPeriodico());
    			artigo.setEdicao(novoArtigo.getEdicao());
    			artigo.setAno(novoArtigo.getAno());
    			artigo.setNumero(novoArtigo.getNumero());
    			artigo.setNumpaginas(novoArtigo.getNumpaginas());
    			return this.repositorio.save(artigo);
    		})
    		.orElseGet(() -> {
    			novoArtigo.setId(id);
    			return this.repositorio.save(novoArtigo);
    		});
	  }
	
}