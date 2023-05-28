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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.langues.demo.Modele.Language;
import com.langues.demo.Repository.LanguageRepository;
import com.langues.demo.Service.LanguageServiceImpl;

import jakarta.persistence.Id;

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
        // Language newCourse = new Language();
        // newCourse.setName(language.getName());
        // newCourse.setDescription(language.getDescription());
        // newCourse.setHour(language.getHour());
        // languageRepository.save(newCourse);
        languageServiceImpl.addLanguage(language);

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

    @CrossOrigin
    @GetMapping("/language/{id}")
    public Language getLanguage(@PathVariable long id) {
        return languageServiceImpl.getLanguage(id);
    }

    @CrossOrigin
    @PostMapping("/language/{id}")
    public ResponseEntity<String> ediLanguage(@RequestBody Language language) {
        languageServiceImpl.editLanguage(language);
        try {
            String messageJson = objectMapper.writeValueAsString("objet modifié");
            return ResponseEntity.ok(messageJson);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la sérialisation en JSON");
        }
    }

}