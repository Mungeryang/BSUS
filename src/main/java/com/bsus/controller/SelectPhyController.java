package com.bsus.controller;

import com.bsus.mapper.Phy;
import com.bsus.vo.PhyScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.List;

/**
 * @ClassName SelectPhyController
 * @Description TODO
 * @Author @O_o
 * @Date 2022/12/2 14:52
 * @Version 1.0
 */
@Controller
public class SelectPhyController {
@Autowired
    private Phy phy;
@RequestMapping("/aaa")
    public ModelAndView aaa(String score){
    ModelAndView modelAndView = new ModelAndView();
    int i = Integer.parseInt(score);
    List<PhyScore> selectphy = phy.selectphy(i);
    modelAndView.addObject("aaa",selectphy);
    modelAndView.setViewName("selectPhy");
    return modelAndView;
}
}
