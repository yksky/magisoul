package org.magisoul.admin.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public JSONObject test(){
        JSONObject json = new JSONObject();
        json.put("code","200");
        json.put("message","success");
        return json ;
    }

}
