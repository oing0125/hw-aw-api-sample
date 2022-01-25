package com.hanwhalife.controller;

import com.hanwhalife.vo.InstanceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HomeController {

    @GetMapping("/")
    public InstanceInfo index(){
        InstanceInfo instanceInfo = new InstanceInfo();
        try {
            instanceInfo.setHostAddress(InetAddress.getLocalHost().getHostAddress());
            instanceInfo.setHostName(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return instanceInfo;
    }
}
