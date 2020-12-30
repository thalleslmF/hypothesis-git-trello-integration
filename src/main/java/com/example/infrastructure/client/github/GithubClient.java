package com.example.infrastructure.client.github;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@RegisterRestClient
public interface GithubClient {
    @Path("/issues")
    @POST
    @ClientHeaderParam(name="User-Agent", value="thalleslmf")
    void createIssue(CreateIssueRequest createIssueRequest, @HeaderParam("Authorization") String token);


}
