package com.bsus.service.impl;

import com.bsus.mapper.ShoolMapper;
import com.bsus.service.ShoolService;
import com.bsus.vo.Shool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoolServiceImpl implements ShoolService {
    @Autowired
    private ShoolMapper shoolMapper;

    @Override
    public List<Shool> selectShools(Integer score, Integer order,String name) {
        return shoolMapper.selectShools(score,order,name);
    }
}
