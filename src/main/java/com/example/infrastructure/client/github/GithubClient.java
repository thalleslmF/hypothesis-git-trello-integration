package com.example.infrastructure.client.github;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@RegisterRestClient
public interface GithubClient {
    @Path("/issues")
    @POST
    @ClientHeaderParam(name="User-Agent", value="thalleslmf")
    void createIssue(CreateIssueRequest createIssueRequest, @HeaderParam("Authorization") String token);

    @Path("/git/refs")
    @POST
    @ClientHeaderParam(name="User-Agent", value="thalleslmf")
    void createBranch(CreateBranchRequest createBranchRequest, @HeaderParam("Authorization") String token);

    @Path("/branches")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ClientHeaderParam(name="User-Agent", value="thalleslmf")
    List<Branch> findBranches(@HeaderParam("Authorization") String token);


}
