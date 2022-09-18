package com.example.cloud.dao;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.cloud.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountDao extends BaseMapper<Account> {

    IPage<Account> selectAccountPage(@Param(value = "page") IPage<Account> page);
}