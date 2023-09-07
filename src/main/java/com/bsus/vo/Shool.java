package com.bsus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Shool {

    private Integer id;

    private String name;

    private String major;

    private String score;

    private String orders;
}
