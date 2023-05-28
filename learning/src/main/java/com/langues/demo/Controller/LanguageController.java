package com.langues.demo.Controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.langues.demo.Modele.Language;
import com.langues.demo.Repository.LanguageRepository;
import com.langues.demo.Service.LanguageServiceImpl;

@RestController
@RequestMapping("/")
public class LanguageController {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private LanguageServiceImpl languageServiceImpl;

    @CrossOrigin
    @RequestMapping(value = "/addLanguage", method = RequestMethod.POST)
    public ResponseEntity<String> addLanguage(@RequestBody Language language) {
        Language newCourse = new Language();
        newCourse.setName(language.getName());
        newCourse.setDescription(language.getDescription());
        newCourse.setHour(language.getHour());
        System.out.println("Nom de la langue : " + language.getName());
        System.out.println("Description de la langue : " + language.getDescription());
        System.out.println("Nombre d'heures : " + language.getHour());
        languageRepository.save(newCourse);

        try {
            String messageJson = objectMapper.writeValueAsString("objet créé");
            return ResponseEntity.ok(messageJson);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la sérialisation en JSON");
        }
    }

    @CrossOrigin
    @GetMapping("/languages")
    public List<Language> getLanguages() {
        // List<Language> allLanguages = languageServiceImpl.getAllLanguage();
        // return new ModelAndView("listLanguages");
        // modelAndView.addObject("languages", allLanguages); // Ajouter les langages à
        // l'objet ModelAndView si nécessaire

        return languageServiceImpl.getAllLanguage();

    }

}