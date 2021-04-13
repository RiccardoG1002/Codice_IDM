package com.corso.decorators;

import com.corso.caffe.Caffe;

public class CaffeCorretto extends CaffeDecorato {
	
	private Caffe caffe;
	private String liquore;
	

	public CaffeCorretto(Caffe caffe, String liquore) {
		super(caffe);
		this.caffe = caffe;
		this.liquore = liquore;
	}



	@Override
	void miaPreparazione() {
		System.out.println("aggiungo "+ liquore);
	}

}
