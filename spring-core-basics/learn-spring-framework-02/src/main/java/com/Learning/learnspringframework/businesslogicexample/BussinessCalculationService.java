package com.Learning.learnspringframework.businesslogicexample;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BussinessCalculationService {
    private final DataService dataService;
    public BussinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }
    public int findMaX(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
