package com.github.hoilayloi.filter;

import com.github.hoilayloi.aop.ExecuteTimeLogged;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * author halab
 */
@Component
public class StringFilter implements CollectionFilter<String> {

    @Override
//    @ExecuteTimeLogged
    public Collection<String> filter(Collection<String> collection) {
        System.out.println("[TARGET CLASS] StringFilter.filter(Collection<String> collection) running");
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        return collection.stream().filter("halab"::equals).collect(Collectors.toList());
    }

    @Override
    public Collection<String> filter(Collection<String> collection, Predicate<String> predicateFunction) {
        System.out.println("[TARGET CLASS] StringFilter.filter(Collection<String> collection, Predicate<String> predicateFunction) running");
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        return collection.stream().filter(predicateFunction).collect(Collectors.toList());
    }
}
