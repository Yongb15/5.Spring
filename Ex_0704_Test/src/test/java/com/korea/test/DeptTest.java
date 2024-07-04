package com.korea.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import context.Context_1_mybatis;
import context.Context_2_dao;
import dao.DeptDAO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {Context_1_mybatis.class, Context_2_dao.class})
@Log4j
public class DeptTest {
	@Autowired
	private DeptDAO deptDAO;
	
	@Test
	public void getListTest() {
		deptDAO.selectList().forEach(log::info);
	}
}
