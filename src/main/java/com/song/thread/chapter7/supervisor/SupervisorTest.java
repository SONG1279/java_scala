package com.song.thread.chapter7.supervisor;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

public class SupervisorTest {
    public static void customStrategy(ActorSystem system) {
        ActorRef a = system.actorOf(Props.create(Supervisor.class),"Supervisor");
        a.tell(Props.create(RestartActor.class), ActorRef.noSender());
        ActorSelection sel = system.actorSelection("akka://lifecycle/user/Supervisor/restartActor");
        for (int i = 0; i < 100; i++) {
            sel.tell(RestartActor.Msg.RESTART, ActorRef.noSender());
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("lifecycle", ConfigFactory.load("../samplehello.conf"));
        customStrategy(system);
    }
}
