package com.sample.search.controller;

import com.sample.search.model.Suggestion;
import com.sample.search.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    @Autowired
    private SuggestionRepository suggestionRepository;

    @GetMapping
    public List<Suggestion> getSuggestions() {
        return suggestionRepository.findAll();
    }


    @GetMapping(value = "/{userId}")
    public List<Suggestion> getSuggestionsByUserId(@PathVariable("userId") String userId) {
        return suggestionRepository.findByUserId(userId);
    }

    @PostMapping
    public Suggestion saveSuggestion(@RequestBody Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    @DeleteMapping
    public void deleteSuggestion(@RequestBody Suggestion suggestion) {
        suggestionRepository.delete(suggestion);
    }


}
