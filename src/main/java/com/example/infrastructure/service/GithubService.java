package com.example.infrastructure.service;

import com.example.domain.card.Card;
import com.example.infrastructure.client.github.Branch;
import com.example.infrastructure.client.github.CreateBranchRequest;
import com.example.infrastructure.client.github.CreateIssueRequest;
import com.example.infrastructure.client.github.GithubClient;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        try {
            String token = ConfigProvider.getConfig().getValue("github.token", String.class);
            this.githubClient.createIssue(issueRequest, token);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            throw new RuntimeException("Error creating issue...");
        }

    }

    private void createBranch(Card card) {
        try {
            String token = ConfigProvider.getConfig().getValue("github.token", String.class);
            var branches = this.githubClient.findBranches(token).stream().findFirst();
            System.out.println(branches);

            if (branches.isPresent()) {
                System.out.println(branches);
                this.githubClient.createBranch(branches.get().toRequest(card.getName()),token);
            }
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException("Error creating branch...");
        }
    }
}
