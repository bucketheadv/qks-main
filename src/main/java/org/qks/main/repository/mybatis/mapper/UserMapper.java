package org.qks.main.repository.mybatis.mapper;

import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.qks.main.repository.mybatis.po.UserEntity;

@Mapper
@MapperDataSource("<default>")
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE id = #{id}")
    UserEntity findById(Long id);
}
