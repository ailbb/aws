package com.ailbb.aws.mybatis.mapper;

import com.ailbb.aws.mybatis.table.Ailbb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Mybatis方式1去查询数据。（Mapper方式）
 * Created by Wz on 2019/4/15.
 */
@Mapper
public interface AilbbMapper {

    @Select("select * from ailbb where user = #{userName}")
    Ailbb getAilbbByJavaMapper(@Param("userName") String userName);
}
