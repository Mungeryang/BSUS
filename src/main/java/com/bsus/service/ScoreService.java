package com.bsus.service;

import com.bsus.vo.Score;

import java.util.List;

public interface ScoreService {

    List<Score> selectScores(String className,String major,Integer year);


//    Page<Score> getScoresList(int pageNum, int pageSize);
}
