package com.ly.controller;


import com.ly.BaseResponse;
import com.ly.service.AddService;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    AddService addService;

    @GetMapping("/add")
    public BaseResponse add(Integer id){
        BaseResponse baseResponse = new BaseResponse(200,"添加成功");
        try {
            addService.add(id);
        }catch (Exception e){
            logger.error("--添加数据失败：",e.fillInStackTrace());
            baseResponse.setCode(400);
            baseResponse.setMsg("添加失败");
        }
        return baseResponse;
    }
}
