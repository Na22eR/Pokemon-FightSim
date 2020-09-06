package Game;

public class Pokemon {

	String name;
	int hp;
	int typ;
	int res1;
	int res2;
	int res3;
	int wk1;
	int wk2;
	Attacke attck1;
	Attacke attck2;
	Attacke attck3;
	Attacke attck4;
	
	
	Pokemon(String n, int h, int t, int r1, int r2, int r3, int w1, int w2, Attacke atk1, Attacke atk2, Attacke atk3, Attacke atk4){
		name = n;
		hp = h;
		typ = t;
		res1 = r1;
		res2 = r2;
		res3 = r3;
		wk1 = w1;
		wk2 = w2;
		attck1 = atk1;
		attck2 = atk2;
		attck3 = atk3;
		attck4 = atk4;
	}
	
	
	public String getPkmName() {
		return name;
	}
	
	public int getPkmHp() {
		return hp;
	}
	
	public int getPkmTyp() {
		return typ;
	}
	
	public int getPkmRes1() {
		return res1;
	}
	
	public int getPkmRes2() {
		return res2;
	}
	
	public int getPkmRes3() {
		return res2;
	}
	
	public int getPkmWk1() {
		return wk1;
	}
	
	public int getPkmWk2() {
		return wk2;
	}
	
	public Attacke getPkmAtck1() {
		return attck1;
	}
	
	public Attacke getPkmAtck2() {
		return attck2;
	}
	
	public Attacke getPkmAtck3() {
		return attck3;
	}
	
	public Attacke getPkmAtck4() {
		return attck4;
	}
	
	public int doPkmDmg(int i) {
		hp -= i;
		return hp;
	}
	
	public static String printTyp(int i) {
	
		String TypTxt = "";
	
		switch (i) {
			case 1: TypTxt = "Normal";
			case 2: TypTxt = "Feuer";
			case 3: TypTxt = " Wasser";
			case 4: TypTxt = " Elektro";
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