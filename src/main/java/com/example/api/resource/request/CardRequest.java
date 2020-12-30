package com.example.api.resource.request;

import com.example.domain.card.Card;
import com.example.domain.card.CardType;

import java.util.UUID;

public class CardRequest {
    private String name;
    private CardType cardType;
    private String authorId;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Card toDomain() {
        return new Card( this.name, this.cardType, this.authorId, this.description);
    }
}
