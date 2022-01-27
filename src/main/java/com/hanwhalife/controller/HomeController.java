package com.hanwhalife.controller;

import com.hanwhalife.vo.InstanceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HomeController {

    @GetMapping("/service-info")
    public InstanceInfo info(HttpServletRequest req){
        return generateInstanceInfo(req);
    }

    @GetMapping("/test")
    public String test(HttpServletRequest req){
        return "test";
    }

    public InstanceInfo generateInstanceInfo(HttpServletRequest request){
        InstanceInfo instanceInfo = new InstanceInfo();
        try {
            instanceInfo.setServiceName(System.getenv("SERVICE_NAME"));
            instanceInfo.setHostAddress(InetAddress.getLocalHost().getHostAddress());
            instanceInfo.setHostName(InetAddress.getLocalHost().getHostName());
            instanceInfo.setRequestPath(request.getRequestURI());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return instanceInfo;
    }
}
