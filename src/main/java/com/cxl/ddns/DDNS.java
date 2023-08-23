package com.cxl.ddns;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 动态域名解析
 */
public class DDNS {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        DDNSRunable runable = new DDNSRunable();
        executorService.scheduleAtFixedRate(runable, 0,1, TimeUnit.MINUTES);
    }
}