package com.bsus.controller;

import com.bsus.mapper.InfoMapper;
import com.bsus.vo.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName InfoController
 * @Description TODO
 * @Author @O_o
 * @Date 2022/12/3 20:20
 * @Version 1.0
 */
@Controller
public class InfoController {
    @Autowired
    private InfoMapper infoMapper;
    @RequestMapping("/getComputer")
    public String getComputer(){
        return "computer";
    }
    @RequestMapping("/bbb")
    public String bbb(String name,String score,String school,String major1,String major2,String major3){
        Info info = new Info(name, score, school, major1, major2, major3);
        infoMapper.addInfo(info);
        return "lead";
    }
}
