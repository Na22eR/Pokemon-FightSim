package Game;

public class Attacke {

	String name;
	int typ;
	int dmg;
	double aim;
	
		
	
	Attacke(String n, int t, int d, double a){
		name = n;
		typ = t;
		dmg = d;
		aim = a;
	}
	
	Attacke(String n){
		name = n;
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
	
	public String printTyp() {
		
		String TypTxt = "";
	
		switch (typ) {
			case 1: TypTxt = "Normal";
			case 2: TypTxt = "Feuer";
			case 3: TypTxt = "Wasser";
			case 4: TypTxt = "Elektro";
			case 5: TypTxt = "Pflanze";
			case 6: TypTxt = "Flug";
			case 7: TypTxt = "Käfer";
			case 8: TypTxt = "Gift";
			case 9: TypTxt = "Gestein";
			case 10: TypTxt = "Boden";
			case 11: TypTxt = "Kampf";
			case 12: TypTxt = "Eis";
			case 13: TypTxt = "Psycho";
			case 14: TypTxt = "Geist";
			case 15: TypTxt = "Drache";
		}
	
		return TypTxt;
	}
}