package com.bsus.controller;

import com.bsus.service.ScoreService;
import com.bsus.vo.Score;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
//jia  wo   q   37276705  na li  bu  rang  jia  hao  you
@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/getInfo")
    public String getInfo( Model model,
                           @RequestParam(value = "className",required = false) String className,
                           @RequestParam(value = "major",required = false) String major,
                           @RequestParam(value = "year",required = false) Integer year,
                           @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Score> scors = scoreService.selectScores(className,major,year);
        System.out.println(scors);
        model.addAttribute("listScores",scors);

        PageInfo<Score> pageInfo = new PageInfo<>(scors);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("className", className);
        model.addAttribute("major", major);
        model.addAttribute("year", year);
        return "info";

    }

}
