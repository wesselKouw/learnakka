package com.learnakka;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

import akka.actor.UntypedActor;

public class AggregatingActor extends UntypedActor{

	private HashMap<String, Integer> aggregated;
	
	public AggregatingActor(){
		aggregated = new HashMap<String,Integer>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onReceive(Object arg0) throws Exception {
		HashMap<String,Integer> input = (HashMap<String, Integer>) Optional.of(arg0).orElse(Collections.emptyMap());
		for(String word:input.keySet()){
			if(aggregated.containsKey(word)){
				aggregated.put(word, aggregated.get(word)+input.get(word));
			}
			else{
				aggregated.put(word, input.get(word));
			}
		}
		
	}
	public void postStop(){
		System.out.println("Final result:"+aggregated);
	}
	
}
