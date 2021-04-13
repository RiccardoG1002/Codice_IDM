package com.corso.decorators;

import com.corso.caffe.Caffe;

public abstract class CaffeDecorato implements Caffe {
	
	private Caffe caffe;
	
	
	
	public CaffeDecorato(Caffe caffe) {
		super();
		this.caffe = caffe;
	}



	@Override
	public final void prepara() {
		caffe.prepara();
		miaPreparazione();
	}
	
	abstract void miaPreparazione();

}
