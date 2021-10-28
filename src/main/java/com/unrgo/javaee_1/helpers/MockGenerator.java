package com.unrgo.javaee_1.helpers;

@javax.enterprise.inject.Alternative

public class MockGenerator implements IdGenerator {
    @Override
    public int generate() {
        return 1000000;
    }
}
