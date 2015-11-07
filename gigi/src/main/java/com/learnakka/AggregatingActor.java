package com.learnakka;

import akka.actor.UntypedActor;

public class AggregatingActor extends UntypedActor{

	@Override
	public void onReceive(Object arg0) throws Exception {
		//aggregator receives the output of the counters and assembles the result		
	}

}
