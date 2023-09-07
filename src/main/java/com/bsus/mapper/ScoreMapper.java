package com.bsus.mapper;

import com.bsus.vo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScoreMapper {
    List<Score> selectScores(@Param("className") String className, @Param("major") String major,@Param("year")  Integer year);

}
