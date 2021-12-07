package com.itheima.service.impl;

import com.itheima.dao.LogDao;
import com.itheima.pojo.log.MethodLogInfo;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public void log(MethodLogInfo methodLogInfo) {
        int i = logDao.insert(methodLogInfo);
        System.out.println(i>0?"日志记录成功":"失败");
    }
}
