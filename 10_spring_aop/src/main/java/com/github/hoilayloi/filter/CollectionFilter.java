package com.github.hoilayloi.filter;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * author halab
 */
public interface CollectionFilter<T> {

    Collection<T> filter(Collection<T> collection);


    Collection<T> filter(Collection<T> collection, Predicate<T> predicateFunction);
}
