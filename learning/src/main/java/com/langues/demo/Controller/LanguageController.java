package com.langues.demo.Controller;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.langues.demo.Modele.Language;
import com.langues.demo.Repository.LanguageRepository;

@RestController
@RequestMapping("/")
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @RequestMapping(value = "/language", method = RequestMethod.POST)
    public String addLanguage() {
        Language medumba = new Language();
        medumba.setName("medumba");
        medumba.setDescription("language of cameroon");
        medumba.setHour(48);
        languageRepository.save(medumba);
        return "objet crée";
    }

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }

}