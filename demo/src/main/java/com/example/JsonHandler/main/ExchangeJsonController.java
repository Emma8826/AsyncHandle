package com.example.JsonHandler.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/jsonHandler/"))
public class ExchangeJsonController {
    @Autowired
    ExchangeJsonService exchangeJsonService;

    @GetMapping("exchangeJsonToObject")
    public String exchangeJsonToObject(@RequestBody String jsonString) throws JsonProcessingException {
        return exchangeJsonService.exchangeJsonToObject(jsonString);
    }
}
