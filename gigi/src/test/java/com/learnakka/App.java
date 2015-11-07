package com.learnakka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class App 
{
    @SuppressWarnings("unused")
	public static void main( String[] args )
    {
    	ActorSystem system = ActorSystem.create("system");
    	ActorRef tokenizer = system.actorOf(Props.create(TokenizerActor.class), "tokenizer");
    	ActorRef aggregator = system.actorOf(Props.create(AggregatingActor.class), "aggregator");
    	ActorRef counting1 = system.actorOf(Props.create(CountingActor.class), "counting1");
		ActorRef counting2 = system.actorOf(Props.create(CountingActor.class), "counting2");
		ActorRef counting3 = system.actorOf(Props.create(CountingActor.class), "counting3");
    	tokenizer.tell("this is all the text for which the word count should be displayed", ActorRef.noSender());
    }
}
