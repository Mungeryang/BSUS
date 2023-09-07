package com.bsus.controller;

import com.bsus.service.ScoreService;
import com.bsus.service.ShoolService;
import com.bsus.vo.Score;
import com.bsus.vo.Shool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShoolController {

    @Autowired
    private ShoolService shoolService;

    @RequestMapping("/getShool")
    public String getShool(Model model,
                           @RequestParam(value = "score", required = false) Integer score,
                           @RequestParam(value = "order", required = false) Integer order,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        if (null != score) {
            score = score + 10;
        }
        List<Shool> shools = shoolService.selectShools(score,order,name);
        System.out.println(shools);
        model.addAttribute("listShools", shools);

        PageInfo<Shool> pageInfo = new PageInfo<>(shools);
        model.addAttribute("pageInfo", pageInfo);
        if (null != score) {
            score = score - 10;
        }
        model.addAttribute("score", score);
        model.addAttribute("order", order);
        model.addAttribute("name", name);
        return "shool";

    }
}
