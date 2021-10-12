package org.magisoul.admin.controller.system;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysUserInfoApi;
import org.magisoul.system.entity.SysUserInfo;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ISysUserInfoApi sysUserInfoApi ;

    @RequestMapping("/login")
    public String login(String username,String password){
        RespData<SysUserInfoDto> resp = this.sysUserInfoApi.login(username,password);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/logout")
    public String logout(){
        return "";
    }
}
