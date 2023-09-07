package com.bsus.vo;

import lombok.Data;

/**
 * @ClassName Info
 * @Description TODO
 * @Author @O_o
 * @Date 2022/12/3 19:57
 * @Version 1.0
 */
@Data
public class Info {
    private String name;
    private String score;
    private String school;
    private String major1;
    private String major2;
    private String major3;

    public Info(String name, String score, String school, String major1, String major2, String major3) {
        this.name = name;
        this.score = score;
        this.school = school;
        this.major1 = major1;
        this.major2 = major2;
        this.major3 = major3;
    }
}
