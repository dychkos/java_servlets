package com.unrgo.javaee_1.helpers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.Random;

@EvenID
public class EvenIdGenerator implements IdGenerator{

    @Inject
    @EvenID
    private int prefix;

    @Inject
    @OddID
    private int postfix;

    @PostConstruct
    private void init() {
        System.out.println("\n=> EvenGenerator PostConstruct");
        System.out.println("================");
    }

    @PreDestroy
    private void release() {
        System.out.println("================");
        System.out.println("=> ODDGenerator PreDestroy");
    }

    @Override
    public int generate() {
        int randID = Math.abs(new Random().nextInt());
        int editedID = prefix + randID + postfix;
        if(randID % 2 == 0){
            return editedID;
        }
        return editedID + 1;
    }
}
