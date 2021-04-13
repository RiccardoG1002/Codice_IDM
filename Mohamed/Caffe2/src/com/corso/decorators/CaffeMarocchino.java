package com.corso.decorators;

import com.corso.caffe.Caffe;

public class CaffeMarocchino extends CaffeDecorato {
    
    private Caffe caffe;
    
    public CaffeMarocchino(Caffe caffe) {
    	super(caffe);
   	 	this.caffe = caffe;
    }

    

	@Override
	void miaPreparazione() {
		System.out.println("aggginugo cacao");
		
	}

}

