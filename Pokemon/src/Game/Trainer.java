package Game;

public class Trainer {

	String name;
	Pokemon pokemon1;
	Pokemon pokemon2; 
	Pokemon pokemon3;
	Pokemon pokemon4;
	
	
	Trainer(String n, Pokemon pk1, Pokemon pk2, Pokemon pk3, Pokemon pk4){	
		name = n;
		pokemon1=pk1;
		pokemon2=pk2;
		pokemon3=pk3;
		pokemon4=pk4;
	}
	
	Trainer(String n, Pokemon pk1){	
		name = n;
		pokemon1=pk1;
	}
	
	
	public String getTrName() {
		return name;
	}
	
	public Pokemon getTrPkm1() {
		return pokemon1;
	}
	
	public Pokemon getTrPkm2() {
		return pokemon1;
	}
	
	public Pokemon getTrPkm3() {
		return pokemon1;
	}
	
	public Pokemon getTrPkm4() {
		return pokemon1;
	}


}