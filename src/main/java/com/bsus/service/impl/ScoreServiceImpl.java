package com.bsus.service.impl;

import com.bsus.mapper.ScoreMapper;
import com.bsus.mapper.UserMapper;
import com.bsus.service.ScoreService;
import com.bsus.vo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> selectScores(String className,String major,Integer year) {

        return scoreMapper.selectScores(className,major,year);
    }
}
