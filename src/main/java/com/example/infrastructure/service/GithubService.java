package com.example.infrastructure.service;

import com.example.domain.card.Card;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GithubService {

    public void createCard(Card card) {
        switch(card.getCardType()) {
            case FEATURE:
                this.createBranch();
                break;
            case BUG:
                this.createIssue();
                break;
            case HOTFIX:
                this.createBranch();
                this.createIssue();
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    private void createIssue() {

    }

    private void createBranch() {
    }
}
