package com.posjavajdbc.posjavajdbc;

import org.junit.jupiter.api.Test;

import com.posjavajdbc.posjavajdbc.model.UserPosJava;
import com.posjavajdbc.posjavajdbc.userPosDAO.UserPosDAO;

import junit.framework.TestCase;

public class TesteBancoJdbc extends TestCase {
	
	@Test
	public void initBanco() {				
		UserPosDAO userPosDao = new UserPosDAO();
		UserPosJava userposJava = new UserPosJava();
		
		userposJava.setId(2L);
		userposJava.setNome("Carlos2");
		userposJava.setEmail("Carlos2@Carlos2.com");
		
		
		userPosDao.salvar(userposJava);
	}

}
