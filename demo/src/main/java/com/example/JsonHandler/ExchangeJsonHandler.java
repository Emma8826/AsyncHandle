package com.example.JsonHandler;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExchangeJsonHandler {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        HashMap<String, Object> map = new HashMap<>();
        map.put("date", "20240801");

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("creartetime", "20240801");

        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("age", "23");
        map3.put("rule", "manager");
        map3.put("salary", "70k");

        map.put("detail", map3);

        String json = mapper.writeValueAsString(map);

        System.out.println(json);

        System.out.println();
    }
}
