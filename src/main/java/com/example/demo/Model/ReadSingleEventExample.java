package com.example.demo.Model;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Status.Failure;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import eventstore.*;
import eventstore.Event;
import eventstore.j.ReadEventBuilder;
import eventstore.j.SettingsBuilder;
import eventstore.tcp.ConnectionActor;

import java.net.InetSocketAddress;

public class ReadSingleEventExample{
	
	

    public String lire(int id) {
        final ActorSystem system = ActorSystem.create();
        final Settings settings = new SettingsBuilder()
                .address(new InetSocketAddress("127.0.0.1", 1113))
                .defaultCredentials("admin", "changeit")
                .build();
        final ActorRef connection = system.actorOf(ConnectionActor.getProps(settings));
        final ActorRef readResult = system.actorOf(Props.create(ReadResult.class));
        
        final ReadEvent readEvent = new ReadEventBuilder("newstream")
                .number(id)
                .resolveLinkTos(false)
                .build();
        connection.tell(readEvent, readResult);
       return readEvent.toString();
    }
}