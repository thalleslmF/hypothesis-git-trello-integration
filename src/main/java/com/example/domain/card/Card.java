package com.example.domain.card;

import com.example.infrastructure.entity.CardEntity;

import java.util.UUID;

public class Card {
    private String name;
    private CardType cardType;
    private String authorId;
    private String description;

    public Card(String name, CardType cardType, String authorId, String description) {
        this.name = name;
        this.cardType = cardType;
        this.authorId = authorId;
        this.description = description;
    }
    public Card(){

    }

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

    public CardEntity toEntity() {
        return new CardEntity(this.name, this.cardType, this.authorId, this.description, UUID.randomUUID().toString());
    }
}
