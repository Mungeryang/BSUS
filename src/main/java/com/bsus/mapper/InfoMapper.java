package com.bsus.mapper;

import com.bsus.vo.Info;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName InfoMapper
 * @Description TODO
 * @Author @O_o
 * @Date 2022/12/3 20:01
 * @Version 1.0
 */
@Mapper
@Repository
public interface InfoMapper {
     void addInfo(Info info);
     List<Info> select();
}
