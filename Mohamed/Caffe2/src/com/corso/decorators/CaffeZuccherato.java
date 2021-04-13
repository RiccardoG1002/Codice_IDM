package com.corso.decorators;

import com.corso.caffe.Caffe;

public class CaffeZuccherato extends CaffeDecorato{
	
	private Caffe caffe;

	public CaffeZuccherato(Caffe caffe) {
		super(caffe);
		this.caffe = caffe;
	}


	@Override
	void miaPreparazione() {
		System.out.println("aggiungo dello zucchero");
		
	} 
	
	

}
