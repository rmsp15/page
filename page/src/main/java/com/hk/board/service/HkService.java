package com.hk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hk.board.daos.IHkDao;
import com.hk.board.dtos.HkDto;

public class HkService implements IHkService {
	
	@Autowired
	private IHkDao HkDao;
	
	@Override
	public List<HkDto> getAllList() {
		return HkDao.getAllList();
	}
}
