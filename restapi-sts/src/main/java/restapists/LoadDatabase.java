package restapists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(RepositorioDeArtigos repositorio) {

    return args -> {
      log.info("Preloading " + repositorio.save(new Artigo("Domain-Driven Design", 2004)));
      log.info("Preloading " + repositorio.save(new Artigo("From monolith to microservices", 2008)));
      log.info("Done preloading data.");
    };
  }
}