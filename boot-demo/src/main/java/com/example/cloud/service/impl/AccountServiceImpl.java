package com.example.cloud.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.cloud.dao.AccountDao;
import com.example.cloud.model.Account;
import com.example.cloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public IPage<Account> selectAccountPage(IPage<Account> page) {
        return accountDao.selectAccountPage(page);
    }

}