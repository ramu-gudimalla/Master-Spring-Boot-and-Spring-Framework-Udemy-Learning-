package com.example.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplStubTest {
    @Test
    public void test(){
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(25,result);
    }
    @Test
    public void test1(){
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(5,result);
    }
}


class DataServiceStub1 implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{25,15,5};
    }
}
class DataServiceStub2 implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{5};
    }
}