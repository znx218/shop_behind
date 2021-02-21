package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.EduiDao;
import com.fh.shop_behind.entity.po.Edui;
import com.fh.shop_behind.service.EduiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EduiServiceImpl implements EduiService {
    @Resource
    private EduiDao eduiDao;


    @Override
    public List<Edui> selectEdui() {
        List<Edui> list=eduiDao.selectEdui();
        return list;
    }
}
