package com.unrgo.javaee_1.helpers;

public class NumberProducer {
    @Produces @OddID
    public int getPrefix() {
        return 1;
    }
    @Produces @EvenID
    public int getPostfix() {
        return 2;
    }

}
