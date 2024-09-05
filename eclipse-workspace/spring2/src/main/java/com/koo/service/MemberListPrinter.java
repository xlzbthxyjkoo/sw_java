package com.koo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.koo.model.Member;

@Component("listPrinter")
public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter() {
	}
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		super();
		this.memberDao = memberDao;
		this.printer = printer;
	}
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Autowired
	@Qualifier("summaryPrinter")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	

}
