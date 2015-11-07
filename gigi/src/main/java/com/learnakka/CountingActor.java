package com.learnakka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class CountingActor extends UntypedActor{

	private Map<String,Integer> count;
	
	public CountingActor(){
		count = new HashMap<String,Integer>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onReceive(Object arg0) throws Exception {
		List<String> inputList;
		if(arg0 instanceof List){
			inputList = (List<String>) arg0;
		}
		else
			return;
		
		for(String element:inputList){
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
