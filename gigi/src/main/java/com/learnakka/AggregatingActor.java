package com.learnakka;

import akka.actor.UntypedActor;

public class AggregatingActor extends UntypedActor{

	@Override
	public void onReceive(Object arg0) throws Exception {
		System.out.println(arg0);	
	}

}
