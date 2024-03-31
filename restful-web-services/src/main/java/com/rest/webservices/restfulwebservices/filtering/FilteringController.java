package com.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        SomeBean someBean = new SomeBean("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter",simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
    @GetMapping("/filtering-list")
    public MappingJacksonValue listFiltering(){
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("1","2","3"),
                new SomeBean("v1","v2","v3"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeans);
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter",simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
