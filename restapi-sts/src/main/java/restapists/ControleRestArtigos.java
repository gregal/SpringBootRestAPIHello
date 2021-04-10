package restapists;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ControleRestArtigos
{
	@Autowired RepositorioDeArtigos repositorioDeArtigos;

	// @RequestMapping("/artigos")
	// Collection<Artigo> artigos()
	// {
	// 	return this.repositorioDeArtigos.findAll();
	// }

	// Aggregate root
  	// tag::get-aggregate-root[]
	@GetMapping("/artigos")
	Collection<Artigo> artigos()
	{
		System.out.println("GET /artigos");
		Collection<Artigo> artigos = this.repositorioDeArtigos.findAll();

		for (Artigo artigo : artigos)
		{
			System.out.println("Artigo "   + artigo.getId());
			System.out.println("\tTítulo: \"" + artigo.getTitulo() + "\"");
		}

		return artigos;
	}
	// end::get-aggregate-root[]
}