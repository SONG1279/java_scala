package com.song.thread.chapter7;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import scala.Option;

public class HelloWorld extends UntypedActor {

    ActorRef greeter;


    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        greeter = getContext().actorOf(Props.create(Greeter.class),"greeter");
        System.out.println("Greeter Actor Path:" + greeter.path());
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    public void onReceive(Object message){
        if (message == Greeter.Msg.DONE){
            greeter.tell(Greeter.Msg.GREET, getSelf());
            getContext().stop(getSelf());
        } else{
            unhandled(message);
        }
    }
}
