package com.Learning.learnspringframework.businesslogicexample;

import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service
public class BusinessCalculationService {
    private final DataService dataService;
    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }
    public int findMaX(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
