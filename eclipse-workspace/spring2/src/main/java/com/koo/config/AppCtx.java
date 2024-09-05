package com.koo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.koo.service.ChangePasswordService;
import com.koo.service.MemberDao;
import com.koo.service.MemberInfoPrinter;
import com.koo.service.MemberListPrinter;
import com.koo.service.MemberPrinter;
import com.koo.service.MemberRegisterService;
import com.koo.service.MemberSummaryPrinter;
import com.koo.service.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"com.koo.service"})
public class AppCtx {
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
