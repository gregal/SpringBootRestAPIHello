package restapists;

import org.springframework.data.jpa.repository.JpaRepository;

interface RepositorioDeArtigos extends JpaRepository<Artigo, Long>
{
	//Collection<Artigo> EncontrarPeloTitulo(String titulo);
}

