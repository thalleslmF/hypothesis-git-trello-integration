package com.example.infrastructure.repository;

import com.example.domain.card.Card;
import com.example.infrastructure.entity.CardEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CardRepository implements PanacheRepository<CardEntity> {

}
