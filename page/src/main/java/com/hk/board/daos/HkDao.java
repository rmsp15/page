package com.hk.board.daos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.hk.board.dtos.HkDto;

public class HkDao implements IHkDao {

	private String namespace = "com.hk.board.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<HkDto> getAllList() {
		return sqlSession.selectList(namespace+"getAllList");
	}
	
}
