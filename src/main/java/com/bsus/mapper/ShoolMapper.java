package com.bsus.mapper;

import com.bsus.vo.Score;
import com.bsus.vo.Shool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShoolMapper {
    List<Shool> selectShools(@Param("score") Integer score ,@Param("order") Integer order,@Param("name") String name);

}
