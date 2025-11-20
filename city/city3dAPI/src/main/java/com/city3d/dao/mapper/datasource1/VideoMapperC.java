package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.Video;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapperC extends VideoMapper {
    List<Video> getRHPCVideo(String positionStr);
}
