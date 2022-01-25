package com.hanwhalife.controller;

import com.hanwhalife.vo.InstanceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HomeController {

    @GetMapping("/instance1/get")
    public InstanceInfo index1(HttpServletRequest req){
        return generateInstanceInfo(req);
    }

    @GetMapping("/instance2/get")
    public InstanceInfo index2(HttpServletRequest req){
        return generateInstanceInfo(req);
    }

    public InstanceInfo generateInstanceInfo(HttpServletRequest request){
        InstanceInfo instanceInfo = new InstanceInfo();
        try {
            instanceInfo.setHostAddress(InetAddress.getLocalHost().getHostAddress());
            instanceInfo.setHostName(InetAddress.getLocalHost().getHostName());
            instanceInfo.setRequestPath(request.getRequestURI());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return instanceInfo;
    }
}
