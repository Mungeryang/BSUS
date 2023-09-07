package com.bsus.mapper;

import com.bsus.vo.PhyScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @ClassName Phy
 * @Description TODO
 * @Author @O_o
 * @Date 2022/12/2 15:21
 * @Version 1.0
 */

@Mapper
@Repository
public interface Phy {
    List<PhyScore> selectphy(int scope);
}
