package com.example.application.card.impl;

import com.example.api.resource.request.CardRequest;
import com.example.application.card.CreateCardInteractor;
import com.example.domain.card.Card;
import com.example.infrastructure.repository.CardRepository;
import com.example.infrastructure.service.GithubService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class CreateCardInteractorImpl implements CreateCardInteractor {
    public CardRepository cardRepository;
    public GithubService githubService;
    @Inject
    public CreateCardInteractorImpl(GithubService githubService, CardRepository cardRepository){
        this.githubService = githubService;
        this.cardRepository = cardRepository;
    }

    @Override
    @Transactional
    public void createCard(CardRequest cardRequest) {
        Card card = cardRequest.toDomain();
        this.githubService.createCard(card);
        this.cardRepository.persist(card.toEntity());
    }
}
