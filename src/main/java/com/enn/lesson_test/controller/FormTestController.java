package com.enn.lesson_test.controller;

import com.enn.lesson_test.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**文件上传测试*/
@RestController
@Slf4j
public class FormTestController extends BaseController{
    @RequestMapping("/upload")
    public JsonResult<Map> from_layouts(@RequestPart("headerIma") MultipartFile headerIma,
                                   @RequestPart("photo") MultipartFile photo){
        Map<String,Object> map=new HashMap<>();
        log.info("是否有数据输入————***——{}",headerIma);
        map.put("headerImaSize",headerIma.getSize());
        map.put("photoLength",photo.getSize());
        return new JsonResult<Map>(Ok,"文件信息输出成功",map);

    }

}
