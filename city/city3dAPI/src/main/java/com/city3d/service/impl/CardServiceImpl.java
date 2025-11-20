package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.CardMapper;
import com.city3d.dao.entry.Card;
import com.city3d.dao.entry.CardExample;
import com.city3d.dao.entry.CardExample.Criteria;
import com.city3d.service.CardService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;

    @Override
    public List<Card> getCardAll() {
        return cardMapper.selectByExample(null);
    }

    @Override
    public Card getCardById(String crId) {
        return cardMapper.selectByPrimaryKey(crId);
    }

    @Override
    public List<Card> getCardByCard(Card card) {
        CardExample example = new CardExample();
        Criteria criteriaResult = example.or();
        if (card.getCrCardnum() != null) {
            criteriaResult = criteriaResult.andCrCardnumEqualTo(card.getCrCardnum());
        }
        return cardMapper.selectByExample(example);
    }

    @Override
    public int insert(Card card) {
        return cardMapper.insert(card);
    }

    @Override
    public int updateByPrimaryKey(Card card) {
        return cardMapper.updateByPrimaryKey(card);
    }

    @Override
    public int deleteByPrimaryKey(String crId) {
        return cardMapper.deleteByPrimaryKey(crId);
    }
}
