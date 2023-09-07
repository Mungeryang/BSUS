package com.bsus.service;

import com.bsus.vo.Score;
import com.bsus.vo.Shool;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ShoolService {
    List<Shool> selectShools(Integer score, Integer order,String name);
}
