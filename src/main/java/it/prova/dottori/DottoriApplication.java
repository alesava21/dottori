package it.prova.dottori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.dottori.model.Dottore;
import it.prova.dottori.service.DottoreService;

@SpringBootApplication
public class DottoriApplication implements CommandLineRunner{
	
	@Autowired
	DottoreService dottoreService;

	public static void main(String[] args) {
		SpringApplication.run(DottoriApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		dottoreService.inserisciNuovo(Dottore.builder()
				.nome("Mariano")
				.cognome("miconos")
				.codiceDottore("THSNBDYWBSU")
				.build());
		
		dottoreService.inserisciNuovo(Dottore.builder()
				.nome("Ross")
				.cognome("Bolt")
				.codiceDottore("ASFGDRDFDGS")
				.build());
	}

}
