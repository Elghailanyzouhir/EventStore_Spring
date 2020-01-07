package com.example.demo.Model;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import eventstore.*;
import eventstore.j.EventDataBuilder;
import eventstore.j.SettingsBuilder;
import eventstore.j.WriteEventsBuilder;
import eventstore.tcp.ConnectionActor;

import java.net.InetSocketAddress;
import java.util.UUID;

public class WriteEventExample {
	public  void ecrire(Event event0) {
		

        final ActorSystem system = ActorSystem.create();
        final Settings settings = new SettingsBuilder()
                .address(new InetSocketAddress("127.0.0.1", 1113))
                .defaultCredentials("admin", "changeit")
                .build();
        final ActorRef connection = system.actorOf(ConnectionActor.getProps(settings));
        final ActorRef writeResult = system.actorOf(Props.create(WriteResult.class));

        final EventData event = new EventDataBuilder("event-type")
                .eventId(UUID.randomUUID())
                .jsonData("{"+event0.getV1()+":"+event0.getV2()+"}")
                .build();
      

        final WriteEvents writeEvents = new WriteEventsBuilder("newstream")
                .addEvent(event)
                .expectAnyVersion()
                .build();
   
        

        connection.tell(writeEvents, writeResult);
	}

}