package pe.edu.i202112261.cl1_jpa_data_talaverano_jesus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202112261.cl1_jpa_data_talaverano_jesus.entity.Country;
import pe.edu.i202112261.cl1_jpa_data_talaverano_jesus.repository.CountryRepository;

import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataTalaveranoJesusApplication {

	@Autowired
	CountryRepository countryRepository;
	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataTalaveranoJesusApplication.class, args);
	}

	@SuppressWarnings("unused")
	public void run(String... args) throws Exception {

		Optional<Country> optionalArg = countryRepository.findById("ARG");
		optionalArg.ifPresentOrElse((argCountry) -> {argCountry.getLanguages().forEach(language -> System.out.println("Idioma: " + language.getLanguage()));
				},
				() -> {Optional<Country> optionalPer = countryRepository.findById("PER");
					optionalPer.ifPresent(perCountry -> perCountry.getLanguages().forEach(language -> System.out.println("Idioma: " + language.getLanguage())));
				}
		);

	}

}
