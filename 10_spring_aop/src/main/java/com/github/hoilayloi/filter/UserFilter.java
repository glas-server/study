package com.github.hoilayloi.filter;

import com.github.hoilayloi.domain.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * author halab
 */
@Component
public class UserFilter implements CollectionFilter<User> {

    @Override
    public Collection<User> filter(Collection<User> collection) {
        System.out.println("[TARGET CLASS] UserFilter.filter(Collection<String> collection) running");
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        return collection.stream().filter(user -> "halab".equals(user.getName())).collect(Collectors.toList());
    }

    @Override
    public Collection<User> filter(Collection<User> collection, Predicate<User> predicateFunction) {
        System.out.println("[TARGET CLASS] UserFilter.filter(Collection<String> collection, Predicate<String> predicateFunction) running");
        if (collection == null) {
            throw new IllegalArgumentException("Collection is null");
        }
        return collection.stream().filter(predicateFunction).collect(Collectors.toList());
    }
}
