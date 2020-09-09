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
			case 1: TypTxt = "Normal"; break;
			case 2: TypTxt = "Feuer"; break;
			case 3: TypTxt = "Wasser"; break;
			case 4: TypTxt = "Elektro"; break;
			case 5: TypTxt = "Pflanze"; break;
			case 6: TypTxt = "Flug"; break;
			case 7: TypTxt = "Käfer"; break;
			case 8: TypTxt = "Gift"; break;
			case 9: TypTxt = "Gestein"; break;
			case 10: TypTxt = "Boden"; break;
			case 11: TypTxt = "Kampf"; break;
			case 12: TypTxt = "Eis"; break;
			case 13: TypTxt = "Psycho"; break;
			case 14: TypTxt = "Geist"; break;
			case 15: TypTxt = "Drache"; break;
		}
	
		return TypTxt;
	}
}