package com.langues.demo.Service;

import java.util.List;

import com.langues.demo.Modele.Language;

public interface LanguageService {

    Language addLanguage(Language langue);

    Language editLanguage(Language langue);

    void deleteLanguageById(Long id);

    Language getLanguage(Long id);

    List<Language> getAllLanguage();
}