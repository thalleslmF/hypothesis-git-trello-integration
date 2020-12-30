package com.example.infrastructure.client;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;

@RegisterRestClient
public class GithubClient {

    @POST("/issues")
    @ClientHeaderParam(name="Authorization", value="token {github.token}")
    public void createIssue(CreateIssueRequest createIssueRequest){

    }
}
