package com.roombooker.service;

import java.util.Random;

public class RoomBookServiceImpl implements RoomBookerService{
	
	
	/**Generate Random Email */
	public String getRandomEmail(String prefix,String sufix,boolean needRand) {
		if(needRand) {
			Random randEmail = new Random();
			return prefix+randEmail.nextInt(100)+sufix;
		}else {
			return prefix+sufix;
		}
		
	}

}
