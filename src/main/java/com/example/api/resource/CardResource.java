package com.example.api.resource;

import com.example.api.resource.request.CardRequest;
import com.example.application.card.CreateCardInteractor;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/card")
public class CardResource {

    private CreateCardInteractor createCardInteractor;

    @Inject
    public CardResource(CreateCardInteractor createCardInteractor){
        this.createCardInteractor = createCardInteractor;
    }
    @POST
    public void createCard(@Valid  CardRequest cardRequest ){
        this.createCardInteractor.createCard(cardRequest);
    }
}
