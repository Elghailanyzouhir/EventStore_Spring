package com.example.demo.Model;

import akka.actor.UntypedActor;
import akka.actor.Status.Failure;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import eventstore.Content;
import eventstore.EsException;
import eventstore.Event;
import eventstore.ReadEventCompleted;

public  class ReadResult extends UntypedActor {
	final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public void onReceive(Object message) throws Exception {
       
            final ReadEventCompleted completed = (ReadEventCompleted) message;
            final Event event = completed.event();
            System.out.println(event.data().copy$default$3());
            log.info("event: {}", event);
//        context().system().shutdown();
    }
}