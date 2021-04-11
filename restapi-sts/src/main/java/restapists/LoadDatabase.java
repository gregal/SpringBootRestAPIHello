package restapists;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(RepositorioDeArtigos repositorio)
	{

		Collection<Artigo> artigos = new ArrayList<Artigo>();
		
		artigos.add(new Artigo("Domain-Driven Design", "Eric Evans", 2004));
		artigos.add(new Artigo("From monolith to microservices", "Sam Newman", 2008));
		artigos.add(new Artigo("TCC: Arquitetura de microsserviços da NASA", "Gustavo Regal", 2021)
				.setPeriodico("TCC's Engenharia de Software e Inovação 2021")
				.setEdicao(null)
				.setNumpaginas(47));
		artigos.add(new Artigo("Arquiteturas orientadas a serviço", "Leandro Wives", 2005)
				.setPeriodico("Congresso Internacional de SOA")
				.setEdicao("7")
				.setNumero(1)
				.setNumpaginas(68));
		artigos.add(new Artigo("Estudo de caso sobre interfaces de usuário", "Marcelo Pimenta", 1998)
				.setPeriodico("Maganize Française de Usabilité")
				.setEdicao("1")
				.setNumero(2)
				.setNumpaginas(81));
		
		return args -> {
			for (Artigo a : artigos)
				log.info("Preloading data: " + a.toString());
			repositorio.saveAll(artigos);
			log.info("Done preloading data.");
		};
	}
}