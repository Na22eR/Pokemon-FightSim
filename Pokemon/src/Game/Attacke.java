package Game;

public class Attacke {

	String name;
	int typ;
	int dmg;
	
		
	
	Attacke(String n, int t, int d){
		name = n;
		typ = t;
		dmg = d;
	}
	
	
	public String getAtckName() {
		return name;
	}
	
	public int getAtckDmg() {
		return dmg;
	}
	
	public int getAtckTyp() {
		return typ;
	}
	
	
}