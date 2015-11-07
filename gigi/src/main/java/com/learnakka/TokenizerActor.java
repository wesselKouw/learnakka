package com.learnakka;


import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class TokenizerActor extends UntypedActor{

	@Override
	public void onReceive(Object arg0) throws Exception {
		List<List<String>> partition = tokenizeAndSplitup(arg0);
		
		getContext().system().actorSelection("akka://system/user/counting1").tell(partition.get(0),ActorRef.noSender());
		getContext().system().actorSelection("akka://system/user/counting2").tell(partition.get(1),ActorRef.noSender());
		getContext().system().actorSelection("akka://system/user/counting3").tell(partition.get(2),ActorRef.noSender());
	}

	private List<List<String>> tokenizeAndSplitup(Object arg0) {
		String[] splitted = ((String)arg0).split(" ");
		List<String> listOfStrings = Arrays.asList(splitted);
		List<List<String>> partition = Lists.partition(listOfStrings, 3);
		return partition;
	}

}
