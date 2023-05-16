package com.langues.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.langues.demo.Modele.Language;
import com.langues.demo.Repository.LanguageRepository;

@SpringBootTest
class ElearningApplicationTests {

	// @Test
	// void contextLoads() {
	// }

	// Tester la création d'un produit
	@Autowired
	private LanguageRepository languageRepository;

	public void testCreateProduit() {
		Language newLanguage = new Language();
		newLanguage.setName("Swahili");
		newLanguage.setDescription("language of cameroon");
		newLanguage.setHour(48);
		languageRepository.save(newLanguage);
		System.out.println("lyp");
	}

	public void testFindLanguage() {
		Language lang = languageRepository.findById(1L).get();
		// System.out.println(lang);
		System.out.println("lyp");
	}

	public void testUpdateLanguage() {
		Language lang = languageRepository.findById(2L).get();
		lang.setName("ghomalah");
		languageRepository.save(lang);
		System.out.println("modifications");
	}

	public void testDeleteLanguage() {
		languageRepository.deleteById(2L);
	}

	@Test
	public void testFindAllLanguages() {
		List<Language> Languages = languageRepository.findAll();
		for (Language l : Languages) {
			System.out.println(l.getName());
		}
	}
}
