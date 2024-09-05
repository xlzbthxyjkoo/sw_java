package com.koo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.koo.concert.IUConcert;
import com.koo.concert.Performance;
import com.koo.concert.PianoConcert;
import com.koo.config.ConcertConfig;

public class ConcertMain {
	public static void main(String[] args) throws Exception{
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConcertConfig.class);
		
		System.out.println("--------------------<Piano Concert>-------------------");
		Performance performance = ctx.getBean("pianoConcert", PianoConcert.class);
		performance.perform();
		System.out.println();
		
		System.out.println("--------------------<IU Concert>-------------------");
		performance = ctx.getBean("iuConcert", IUConcert.class);
		performance.perform();
		System.out.println();
		ctx.close();
	}

}
