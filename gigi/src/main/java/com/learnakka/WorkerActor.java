package com.learnakka;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class WorkerActor extends UntypedActor{

	private Map<String,Integer> count = new HashMap<String,Integer>();
	
	@SuppressWarnings("unchecked")
	@Override
	public void onReceive(Object arg0) throws Exception {
		List<String> input = (List<String>) Optional.of(arg0).orElse(Collections.emptyList());
		for(String element:input){
			if(count.containsKey(element)){
				count.put(element,count.get(element)+1);
			}
			else{
				count.put(element, 1);
			}
		}

		getContext().system().actorSelection("akka://system/user/aggregator").tell(count,ActorRef.noSender());
	}

}
