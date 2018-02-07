package com.skcc.dataanalysis.woolim.service;

import org.springframework.stereotype.Service;

import com.skcc.dataanalysis.woolim.vo.WoolimVO;

@Service("woolimService")
public class WoolimService {

	public void woolimTest(WoolimVO woolimVO){
		
		String aibrilText = woolimVO.getAibrilText();
		System.out.println("TEST!!" + aibrilText);
		
	}
}
