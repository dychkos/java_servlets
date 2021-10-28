package com.unrgo.javaee_1.helpers;

import java.util.Random;

@OddID
public class OddIdGenerator implements IdGenerator{
    @Produces @OddID
    public int getPrefix() {
        return 1;
    }
    @Produces @EvenID
    public int getPostfix() {
        return 2;
    }

    @Override
    public int generate() {
        int randID = Math.abs(new Random().nextInt());
        if(randID % 2 == 0){
            return randID + 1;
        }
        return randID;
    }
}
