package com.example.cloud.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class RequestIpUtils {
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader(" X-Real-IP");
        if (StringUtils.isBlank(ip)){
            ip = request.getHeader("forwarded");
            if (StringUtils.isNotBlank(ip)) {
                String[] ips = ip.split(";");
                if (Optional.ofNullable(ips).isPresent() && ips.length > 0) {
                    ip = Arrays.stream(ips).filter(s -> !StringUtils.isBlank(s) && s.startsWith("for")).filter(s -> s.startsWith("for")).findFirst().map(s -> s.substring(5)).orElse(ip);
                    if (StringUtils.isNotBlank(ip) && ip.indexOf(":") > 0) {
                        int index = ip.indexOf(":");
                        ip = ip.substring(0,index);
                    }
                }
            }
        }
        return ip;
    }
}
