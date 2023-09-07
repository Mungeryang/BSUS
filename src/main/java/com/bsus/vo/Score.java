package com.bsus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Score {
    private String className;

    private String  orders;

    private String  major;

    private Integer  max;

    private Integer  min;

    private Integer  mean;

    private Integer  year;

}
