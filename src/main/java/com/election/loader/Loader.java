package com.election.loader;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;


@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

   private Logger log = Logger.getLogger(Loader.class);

	 
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		// tu dodawac obiekty i zapisywac na starcie aplikacji do repozytorium
		
	}
	

}
