package com.example.infrastructure.service;

import com.example.domain.card.Card;
import com.example.infrastructure.client.github.CreateIssueRequest;
import com.example.infrastructure.client.github.GithubClient;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GithubService {
    @Inject
    @RestClient
    private GithubClient githubClient;

    public void createCard(Card card) {
        System.out.println(card);
        switch(card.getCardType()) {
            case FEATURE:
                this.createBranch(card);
                break;
            case BUG:
                this.createIssue(card);
                break;
            case HOTFIX:
                this.createBranch(card);
                this.createIssue(card);
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    private void createIssue(Card card) {
        var issueRequest = new CreateIssueRequest(card.getName(), card.getDescription());

        try{
            String token = ConfigProvider.getConfig().getValue("github.token", String.class);
            this.githubClient.createIssue(issueRequest, token);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw new RuntimeException("Error creating issue...");
        }
    }

    private void createBranch(Card card) {

    }
}
