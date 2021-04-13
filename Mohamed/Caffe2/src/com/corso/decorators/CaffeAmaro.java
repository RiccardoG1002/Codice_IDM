package com.corso.decorators;

import com.corso.caffe.Caffe;

public class CaffeAmaro extends CaffeDecorato {
    private Caffe caffe;
    
    
	public CaffeAmaro(Caffe caffe) {
		super(caffe);
		this.caffe = caffe;
	}


	@Override
	void miaPreparazione() {
		System.out.println("non aggiungo zucchero");
		
	}




}
