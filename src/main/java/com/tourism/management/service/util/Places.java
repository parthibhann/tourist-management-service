package com.tourism.management.service.util;

public enum Places {
	ANDAMAN(50000),
	THAILAND(60000),
	DUBAI(70000),
	SINGAPORE(80000),
	MALASIYA(90000);
	
	public final Integer tariff;

	Places(Integer tariff) {
		this.tariff  = tariff;
	}
	
	public int getTariff() {
	      return this.tariff;
	   }
}

