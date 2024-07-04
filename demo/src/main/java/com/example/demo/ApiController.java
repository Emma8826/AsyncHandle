package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @RequestMapping("/test")
    public ApiTestDto index(@RequestParam Integer id) throws Exception {
        ApiTestDto dto = new ApiTestDto();
        dto.setName("Api");
        return dto;
    }

    @RequestMapping("/testSending")
    public String testSending(@RequestBody Student student) throws Exception {
        System.out.println("send test");
        System.out.println("Student name :" + student.getName());
        System.out.println("Student id : " + student.getId());
        return student.getName() + " : " + student.getId();
    }
}
