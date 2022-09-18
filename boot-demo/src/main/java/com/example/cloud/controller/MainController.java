package com.example.cloud.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cloud.model.Account;
import com.example.cloud.service.AccountService;
import com.example.cloud.utils.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;

@RestController
@RequestMapping(value = "/main")
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/info")
    public Result<Object> info() {
        try {
            return Result.success(SystemInfoUtils.getInfo());
        } catch (UnknownHostException e) {
            return Result.fail(e.getMessage());
        }
    }


    @RequestMapping(value = "/ip")
    public Object main(HttpServletRequest request, HttpServletResponse response) {
        String ip = IpUtils.getIpAddr(request);
        String ip2 = RequestIpUtils.getIpAddress(request);
        log.info("main方法被执行了{}", ip);
        log.info("main方法被执行了{}", ip2);
        return ip2 + "这是项目工程的首页:" + ip;
    }

    @RequestMapping(value = "/video")
    public void aloneVideoPlay(HttpServletRequest request, HttpServletResponse response) {
        InputStream is;
        OutputStream os = null;
        try {
            response.setContentType("video/mp4");
            Resource resource = new ClassPathResource("01b99965df5abe829a6c170a86ebfb26.mp4");
            is = resource.getInputStream();
            response.addHeader("Content-Length", "" + is.available());
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        } catch (Exception e) {
            log.error("播放MP4失败", e);
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException ignore) {
                }
            }
        }
    }


    @RequestMapping(value = "/list")
    public Result<Object> selectPage() {
        return Result.success(accountService.list());
    }


    @PutMapping(value = "/add")
    public Result<Object> add(@RequestBody Account account, HttpServletRequest request, HttpServletResponse response) {
        return Result.success(accountService.save(account));
    }


    @DeleteMapping(value = "/delete/{id}")
    public Result<Object> add(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) {
        return Result.success(accountService.removeById(id));
    }

    @PostMapping(value = "/update")
    public Result<Object> update(@RequestBody Account account, HttpServletRequest request, HttpServletResponse response) {
        return Result.success(accountService.updateById(account));
    }


    @GetMapping(value = "/byId/{id}")
    public Result<Object> byId(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) {
        Account account = accountService.getById(id);
        return Result.success(account);
    }


    @RequestMapping(value = "/selectPage")
    public Result<Object> selectPage(@RequestBody PageParam param, HttpServletRequest request, HttpServletResponse response) {
        IPage<Account> page = new Page<>();
        page.setCurrent(param.getPageNum());
        page.setSize(param.getPageSize());
        return Result.success(accountService.selectAccountPage(page));
    }
}
