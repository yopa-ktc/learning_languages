package com.langues.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.langues.demo.Modele.Language;
import com.langues.demo.Repository.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public Language addLanguage(Language L) {
        return languageRepository.save(L);
    }

    @Override
    public Language editLanguage(Language L) {
        return languageRepository.save(L);
    }

    @Override
    public void deleteLanguageById(Long id) {
        languageRepository.deleteById(id);
    }

    @Override
    public Language getLanguage(Long id) {
        return languageRepository.findById(id).get();
    }

    @Override
    public List<Language> getAllLanguage() {
        return languageRepository.findAll();
    }
}