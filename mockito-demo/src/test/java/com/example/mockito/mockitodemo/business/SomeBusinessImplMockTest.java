package com.example.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {
    @Mock
    private DataService dataServiceMock;
    @InjectMocks
    private SomeBusinessImpl someBusiness;
    @Test
    public void test(){
//        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveData()).thenReturn(new int[]{25,15,5});
//        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceMock);
        assertEquals(25, someBusiness.findTheGreatestFromAllData());
    }
    @Test
    public void test1(){
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveData()).thenReturn(new int[]{55});
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceMock);
        assertEquals(55, someBusiness.findTheGreatestFromAllData());
    }
}

