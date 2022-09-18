package com.example.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.cloud.model.Account;

public interface AccountService extends IService<Account> {

    IPage<Account> selectAccountPage(IPage<Account> page);
}