package com.corso.bar;

import com.corso.caffe.*;
import com.corso.decorators.*;


public class bar {
	
	public static void main(String[] vars) {
		Caffe espresso = new Espresso("arabica");
		
		CaffeZuccherato cz = new CaffeZuccherato(espresso);
		CaffeCorretto cc = new CaffeCorretto(cz, "sambuca");
		
		cc.prepara();
		
		
		
	}

}
