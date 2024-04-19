package com.example.mockito.mockitodemo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class SomeBusinessImpl {
    public SomeBusinessImpl(DataService dataService) {
        super();
        this.dataService = dataService;
    }
    private DataService dataService;
    public int findTheGreatestFromAllData(){
        int [] data = dataService.retrieveData();
        int greaterValue = Integer.MIN_VALUE;
        for(int value:data){
            if(value > greaterValue){
                greaterValue = value;
            }
        }
        return greaterValue;
    }
}

@Service
interface DataService{
    int[] retrieveData();
}