package com.app.test;

import com.app.test.Model.*;
import com.app.test.Service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@EnableSwagger2
@SpringBootApplication
public class TestTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTechApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(IUserService userService, IProduitService produitService, ICommandeService commandeService, ILigneCommandeService ligneCommandeService,
										 ICategorieService categorieService) {
		return args -> {
			Client c= new Client("45","mezghani","racem","racem.mezghani@gmail.com",LocalDate.of(1997,11,9),
					"chihya","sfax",3041L,"29488883","29488883","29488883");
			userService.addUser(c);

			Commande commande= new Commande("1",LocalDate.now(),null);

			Produit produit=new Produit("25","NIKE","Jordan","",BigDecimal.valueOf(499),50L);
			Produit produit2=new Produit("85","NIKE","Air Force","",BigDecimal.valueOf(399),50L);


			Categorie categorie= new Categorie("558","shoes");
			produit.setCategorie(categorie);
			produit2.setCategorie(categorie);
			commande.setClient(c);

			Produit_Commande_Ids id =new Produit_Commande_Ids(produit.getCode(),commande.getNumero());
			Produit_Commande_Ids id2 =new Produit_Commande_Ids(produit2.getCode(),commande.getNumero());

			LigneCommande ligneCommande= new LigneCommande(id,1L,produit.getPrixUnitaire(),null);
			LigneCommande ligneCommande2= new LigneCommande(id2,2L,produit2.getPrixUnitaire(),null);

			ligneCommande.setCommande(commande);
			ligneCommande.setProduit(produit);

			ligneCommande2.setCommande(commande);
			ligneCommande2.setProduit(produit2);

			categorieService.addCategorie(categorie);
			produitService.addProduit(produit);
			produitService.addProduit(produit2);
			commandeService.addCommande(commande);
			ligneCommandeService.addLigneCommande(ligneCommande);
			ligneCommandeService.addLigneCommande(ligneCommande2);

		};
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
