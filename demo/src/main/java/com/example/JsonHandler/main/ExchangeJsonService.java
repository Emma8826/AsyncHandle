package com.example.JsonHandler.main;

import com.example.JsonHandler.main.dto.JsonObjectDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class ExchangeJsonService {

    private final ObjectMapper objectMapper;

    @Autowired
    public ExchangeJsonService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String exchangeJsonToObject(String jsonString)throws JsonProcessingException {
        JsonObjectDto JsonObjectDto = new JsonObjectDto();
        JsonObjectDto result = new JsonObjectDto();

        if (Objects.isNull(jsonString)) {
            log.error("Input JSON string is null or empty");
            return null;
        }

        try{
            result = objectMapper.readValue(jsonString, JsonObjectDto.getClass());
        }catch (JsonProcessingException e){
            log.error(e.getMessage());
        }

        return result.toString();
    }
}
