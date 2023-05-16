package com.langues.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.langues.demo.Modele.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}