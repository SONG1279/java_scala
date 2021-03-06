package com.song.thread.chapter7.supervisor;

import akka.actor.UntypedActor;
import scala.Option;

public class RestartActor extends UntypedActor {

    public enum Msg {
        DONE, RESTART;
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("preStart hashcode:" + this.hashCode());
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("postStop hashcode:" + this.hashCode());
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
        System.out.println("postRestart hashcode:" + this.hashCode());
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        System.out.println("preRestart hashcode:" + this.hashCode());
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message == Msg.DONE) {
            getContext().stop(getSelf());
        } else if (message == Msg.RESTART) {
            System.out.println(((Object) null).toString());

            double a = 0 / 0;
        }
        unhandled(message);
    }
}
