package com.song.thread.chapter7;

import akka.actor.UntypedActor;

public class Greeter extends UntypedActor {

    public static enum Msg{
        GREET,DONE;
    }

    public void onReceive(Object message) {
        if (message == Msg.GREET){
            System.out.println("hello");
            getSender().tell(Msg.DONE, getSelf());
        }else{
            unhandled(message);
        }
    }
}
