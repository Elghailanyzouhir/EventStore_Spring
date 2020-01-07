package com.example.demo.Controller;

import java.net.InetSocketAddress;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Status;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import eventstore.EsException;
import eventstore.EventData;
import eventstore.Settings;
import eventstore.WriteEvents;
import eventstore.WriteEventsCompleted;
import eventstore.j.EventDataBuilder;
import eventstore.j.SettingsBuilder;
import eventstore.j.WriteEventsBuilder;
import eventstore.tcp.ConnectionActor;
import com.example.demo.Model.*;
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/Event")
public class EcrireContoller {
	Event event=new Event();
	WriteEventExample wr =new WriteEventExample();
	@PostMapping("/ecrire")
	 public String authenticateUser(@Valid @RequestBody Event event) {
	   wr.ecrire(event);
		return "ook";
	}

}

