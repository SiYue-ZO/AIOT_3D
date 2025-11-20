package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Viewtag;

public interface TagService {
    List<Viewtag> getTag();

    int deleteByPrimaryKey(String tagId);

    int insert(Viewtag tag);
}
