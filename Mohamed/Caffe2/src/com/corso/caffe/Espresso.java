package com.corso.caffe;

public class Espresso implements Caffe {

	private String miscela; 

           public Espresso (String miscela){
            this.miscela = miscela; 
           }
           
           @Override
          public void prepara(){
                System.out.println("preparazione di un caffe espresso con miscela: " + miscela);
          }

		
  }
