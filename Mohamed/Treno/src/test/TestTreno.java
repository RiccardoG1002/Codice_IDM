package test;

import com.corso.treno.BuilderTreni;
import com.corso.treno.BuilderTreniB;
import com.corso.treno.BuilderTreniA;
import com.corso.treno.Treno;

public class TestTreno {
	
	public static void main(String[] args) {
		
		Treno t = new BuilderTreniA("HPPPPPPPPPPPPPPPPPP").getTreno();
		
		
		System.out.println(t.toString());
		
	}

}
