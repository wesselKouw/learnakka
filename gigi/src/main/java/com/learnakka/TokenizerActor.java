package com.learnakka;

import java.util.Arrays;
import java.util.List;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class TokenizerActor extends UntypedActor{

	@Override
	public void onReceive(Object arg0) throws Exception {
		List<List<String>> partition = tokenizeAndSplitup(Strings.nullToEmpty((String)arg0));
		
		for(Integer i:Arrays.asList(0,1,2)){
			getContext().system().actorSelection("akka://system/user/counting"+i).tell(partition.get(i),ActorRef.noSender());
		}
	}

	private List<List<String>> tokenizeAndSplitup(Object arg0) {
		String[] splitted = ((String)arg0).split(" ");
		List<String> listOfStrings = Arrays.asList(splitted);
		List<List<String>> partition = Lists.partition(listOfStrings, 3);
		return partition;
	}

}
