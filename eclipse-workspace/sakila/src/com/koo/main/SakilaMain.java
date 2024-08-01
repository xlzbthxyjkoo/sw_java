package com.koo.main;

import com.koo.service.JobFactory;
import com.koo.service.SakilaService;

public class SakilaMain {

	public static void main(String[] args) {
		SakilaService service = new SakilaService(new JobFactory());
		service.doService();
	}
	
}
