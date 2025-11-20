package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Card;

public interface CardService {
    List<Card> getCardAll();

    Card getCardById(String crId);

    List<Card> getCardByCard(Card card);

    int insert(Card card);

    int updateByPrimaryKey(Card card);

    int deleteByPrimaryKey(String crId);
}
