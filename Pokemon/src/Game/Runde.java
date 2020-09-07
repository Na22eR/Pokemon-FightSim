package Game;

import static jsTools.Input.readInt;

public class Runde {
	
	Source daten = new Source();
	Pokemon inUse;
	Pokemon inUseG;
	
	public static void main(String args [] ) {
		
		Runde r1 = new Runde();
		r1.daten.cGegner();
		r1.daten.cPokemon();
		r1.daten.cTeam();
		r1.rundeTry();
	
	}
	
	Pokemon auswP() {
	//Waehlt das Pokemon fuer deinen naechsten Zug aus
		
		int ausw;
		
		//Gibt das aktuelle Pokemon des Gegners aus
		System.out.println(daten.gegner[daten.gNr].getTrName() + " verwendet gerade: " + auswPG().getPkmName() + "     HP: " + auswPG().getPkmHp() );
		daten.nl();
		
		System.out.println("Waehle ein Pokemon f�r den Angriff aus: ");
		for(int i = 0; i < daten.team.length; i++) {
			if(daten.team[i].hp > 0) {
				System.out.println(i+1 + ". " + daten.team[i].getPkmName() + "\t" +  "HP: " + daten.team[i].getPkmHp() );
			}
		}
		
		ausw = readInt("Deine Auswahl: ")-1;
	
		System.out.println("Ausgew�hlt: " + daten.team[ausw].getPkmName() ); 
		daten.nl();
		return daten.team[ausw];
	}
	
	Attacke auswA() {
	//Waehlt die Attacke fuer den naechsten Zug	
		
		inUse = auswP();
		
		System.out.println("Waehle deine Attacke: ");
		System.out.println("1. " + inUse.attck1.name);
		System.out.println("2. " + inUse.attck2.name);
		System.out.println("3. " + inUse.attck3.name);
		System.out.println("4. " + inUse.attck4.name);
		
		
		int y = readInt("Nummer der Attacke: "); 
		daten.nl();
		switch (y) {
			case 1: return inUse.attck1;
			case 2: return inUse.attck2;
			case 3: return inUse.attck3;
			case 4: return inUse.attck4;
			default: return null;
		}
		
	}
	
	Pokemon auswPG() {
	//Waehlt das Pokemon des Gegners aus
		
		if(daten.gegner[daten.gNr].pokemon1.hp > 0) {	return daten.gegner[daten.gNr].pokemon1;	}
		if(daten.gegner[daten.gNr].pokemon2.hp > 0) {	return daten.gegner[daten.gNr].pokemon2;	}
		if(daten.gegner[daten.gNr].pokemon3.hp > 0) {	return daten.gegner[daten.gNr].pokemon3;	}
		if(daten.gegner[daten.gNr].pokemon4.hp > 0) {	return daten.gegner[daten.gNr].pokemon4;	}
		else { return null; }		
		
	}
	
	void angriff() {
	//Methode die den Gegner angreift	
		
		Attacke y = auswA();
		inUseG = auswPG();
		
		//If Case-Resistenz
		if(y.typ == inUseG.res1 || y.typ == inUseG.res2 || y.typ == inUseG.res3) {
			System.out.println(inUse.name + " setzt " + y.name + " ein.");
			System.out.println("Nicht sehr Effektiv!");
			inUseG.hp -= (y.dmg/2);
			if(inUseG.hp <= 0) { System.out.println(inUseG.name + " hat keine Leben mehr und kann nicht mehr weiter kaempfen."); }
			daten.nl2();
		}
		
		//If Case-Effective
		if(y.typ == inUseG.wk1 || y.typ == inUseG.wk2) {
			System.out.println(inUse.name + " setzt " + y.name + " ein.");
			System.out.println("Sehr Effektiv!");
			inUseG.hp -= (y.dmg*2);
			if(inUseG.hp <= 0) { System.out.println(inUseG.name + " hat keine Leben mehr und kann nicht mehr weiter kaempfen."); }
			daten.nl2();
		}
		
		//Else Case-Normal
		else{
			System.out.println(inUse.name + " setzt " + y.name + " ein.");
			inUseG.hp -= y.dmg;
			if(inUseG.hp <= 0) { System.out.println(inUseG.name + " hat keine Leben mehr und kann nicht mehr weiter kaempfen."); }
			daten.nl2();
		}
		
	}
	
	Attacke auswAG() {
	//Waehlt die Attacke des Gegner Pokemon aus
		
		inUseG = auswPG();
		double auswAttck = Math.random();
		if(auswAttck >= 0.00 && auswAttck <= 0.25) {	return inUseG.attck1;	}
		if(auswAttck >  0.25 && auswAttck <= 0.5)  {	return inUseG.attck2;	}
		if(auswAttck >  0.5  && auswAttck <= 0.75) {	return inUseG.attck3;	}
		if(auswAttck >  0.75 && auswAttck <= 1)    {	return inUseG.attck4;	}
		else {	return null;}
		
	}
	
	void angriffG() {
	//Methode mit welcher der Gegner angreift
		
		Attacke y = auswAG();
		Pokemon z = inUse;
		
		//If Case-Resistenz
		if(y.typ == z.res1 || y.typ == z.res2 || y.typ == z.res3) {
			System.out.println(inUseG.name + " setzt " + y.name + " ein.");
			System.out.println("Nicht sehr Effektiv!");
			if(z.hp <= 0) {System.out.println("Oh nein, " + z.name + " wurde besiegt, du kannst es jetzt nicht mehr verwenden... "); }
			z.hp -= (y.dmg/2);
			daten.nl2();
		}
		
		//If Case-Effective
		if(y.typ == z.wk1 || y.typ == z.wk2) {
			System.out.println(inUseG.name + " setzt " + y.name + " ein.");
			System.out.println("Sehr Effektiv!");
			if(z.hp <= 0) {System.out.println("Oh nein, " + z.name + " wurde besiegt, du kannst es jetzt nicht mehr verwenden... "); }
			z.hp -= (y.dmg*2);
			daten.nl2();
		}
		
		//Else Case-Normal
		else{
			System.out.println(inUseG.name + " setzt " + y.name + " ein.");
			if(z.hp <= 0) {System.out.println("Oh nein, " + z.name + " wurde besiegt, du kannst es jetzt nicht mehr verwenden... "); }
			z.hp -= y.dmg;
			daten.nl2();
		}
	}
	
	boolean analyse() {
	//Ueberprueft ob noch Pokemon am Leben sind	
		
		boolean EP = (daten.team[1].hp > 0 || daten.team[2].hp > 0 || daten.team[3].hp > 0 || daten.team[4].hp > 0);
		boolean GP = (daten.gegner[daten.gNr].pokemon1.hp > 0 || daten.gegner[daten.gNr].pokemon2.hp > 0 || daten.gegner[daten.gNr].pokemon3.hp > 0 || daten.gegner[daten.gNr].pokemon4.hp > 0);
		return (EP && GP);
	}
	
	boolean analyseGP() {
		return (daten.gegner[daten.gNr].pokemon1.hp > 0 || daten.gegner[daten.gNr].pokemon2.hp > 0 || daten.gegner[daten.gNr].pokemon3.hp > 0 || daten.gegner[daten.gNr].pokemon4.hp > 0);
	}
	
	boolean analyseEP() {
		return (daten.team[1].hp > 0 || daten.team[2].hp > 0 || daten.team[3].hp > 0 || daten.team[4].hp > 0);
	}
	
	void Sieg() {
		double mrd = Math.random();
		String spruch = "";
		if(mrd > 0.0 && mrd <= 0.2) {spruch = "Dieses mal hast du gewonnen, doch die Rache wird mein sein...";}		
		if(mrd > 0.2 && mrd <= 0.4) {spruch = "Mehr Glueck als Verstand und doch gewonnen, und so jemand nennt sich Trainer...";}
		if(mrd > 0.4 && mrd <= 0.6) {spruch = "Schluss mit lustig, naechstes mal lege ich erst richtig los...";}
		if(mrd > 0.6 && mrd <= 0.8) {spruch = "Du hast gut gekaempft ich sollte erst noch mehr trainieren bevor ich wieder gegen dich antrete...";}
		if(mrd > 0.8 && mrd <= 1.0) {spruch = "Ich sehe schon mein Reserveteam reicht nicht gegen dich aus, doch nÃ¤chstes mal ist die erste Klasse dran... ";}
		System.out.println("Herzlichen Glueckwunsch, du hast " + daten.gegner[daten.gNr].name + " besiegt!"); 
		System.out.println(daten.gegner[daten.gNr].name + ": " + spruch);
	
	}
	
	void Verloren() {
		double mrd = Math.random();
		String spruch = "";
		if(mrd > 0.0 && mrd <= 0.2) {spruch = "Netter Versuch, du solltest dich naechstes mal mehr anstrengen wenn du gewinnen willst...";}		
		if(mrd > 0.2 && mrd <= 0.4) {spruch = "Mach erst mal die Besics bevor du mich wieder herausforderst...";}
		if(mrd > 0.4 && mrd <= 0.6) {spruch = "Das war ja klar, wieder nur ein Neuling der denkt er koenne mich besiegen...";}
		if(mrd > 0.6 && mrd <= 0.8) {spruch = "Hochmut kommt vor dem Fall, Anfangs denken alle sie haben eine Chance...";}
		if(mrd > 0.8 && mrd <= 1.0) {spruch = "Uebung macht den Meister und wie ich sehe hast du davon noch zu wenig...";}
		System.out.println("Oh nein, du wurdest von " + daten.gegner[daten.gNr].name + " besiegt");
		System.out.println(daten.gegner[daten.gNr].name + ": " + spruch);
	}
	
	//Nicht sicher ob das nur copy waste ist oder noch was wichtiges dabei ist
	/*
	Pokemon auswP() {
		
		int ausw;
		
		System.out.println("WÃƒÂ¤hle dein Pokemon: ");
		for(int i = 0; i < daten.team.length; i++) {
			if(daten.team[i].hp > 0) {
				System.out.println(i+ ". " + daten.team[i].getPkmName() + "\t" +  "HP: " + daten.team[i].getPkmHp() );
			}
		}
		
		ausw = readInt("Deine Auswahl: (1/2/3/4)");
		inUse = daten.team[ausw];
		return daten.team[ausw];
	}
	
	Attacke auswA() {
		
		Pokemon x = auswP();
		
		System.out.println("WÃƒÂ¤hle deine Attacke: ");
		for(int i = 0; i < 5; i++) {
			System.out.println(i+ ". " + x.attck1.name);
		}
		
		int y = readInt("Nummer der Attacke: "); 
		
		switch (y) {
			case 1: return x.attck1;
			case 2: return x.attck2;
			case 3: return x.attck3;
			case 4: return x.attck4;
			default: return null;
		}
		
	}
	
	Pokemon auswPG() {
		if(daten.gegner[daten.gNr].pokemon1.hp > 0) {	return daten.gegner[daten.gNr].pokemon1;	}
		if(daten.gegner[daten.gNr].pokemon2.hp > 0) {	return daten.gegner[daten.gNr].pokemon2;	}
		if(daten.gegner[daten.gNr].pokemon3.hp > 0) {	return daten.gegner[daten.gNr].pokemon3;	}
		if(daten.gegner[daten.gNr].pokemon4.hp > 0) {	return daten.gegner[daten.gNr].pokemon4;	}
		else { return null; }		
		
	}
	
	void angriff() {
		Attacke y = auswA();
		Pokemon z = auswPG();
		
		if(y.typ == z.res1 || y.typ == z.res2 || y.typ == z.res3) {
			System.out.println(inUse.name + "setzt" + y.name + "ein.");
			System.out.println("Nicht sehr Effektiv!");
			z.hp -= (y.dmg/2);
			if(z.hp <= 0) { System.out.println(z.name + " hat keine Leben mehr und kann nicht mehr weiter kÃƒÂ¤mpfen."); }
		}
		
		if(y.typ == z.wk1 || y.typ == z.wk2) {
			System.out.println(inUse.name + "setzt" + y.name + "ein.");
			System.out.println("Sehr Effektiv!");
			z.hp -= (y.dmg*2);
			if(z.hp <= 0) { System.out.println(z.name + " hat keine Leben mehr und kann nicht mehr weiter kÃƒÂ¤mpfen."); }
		}
		
		if(y.typ == z.typ) {
			System.out.println(inUse.name + "setzt" + y.name + "ein.");
			z.hp -= y.dmg;
			if(z.hp <= 0) { System.out.println(z.name + " hat keine Leben mehr und kann nicht mehr weiter kÃƒÂ¤mpfen."); }
		}
		
	}
	
	Attacke auswAG() {
		Pokemon x = auswPG();
		double auswAttck = Math.random();
		if(auswAttck >= 0.00 && auswAttck <= 0.25) {	return x.attck1;	}
		if(auswAttck >  0.25 && auswAttck <= 0.5)  {	return x.attck1;	}
		if(auswAttck >  0.5  && auswAttck <= 0.75) {	return x.attck1;	}
		if(auswAttck >  0.75 && auswAttck <= 1)    {	return x.attck1;	}
		else {	return null;}
		
	}
	
	void angriffG() {
		Attacke y = auswAG();
		Pokemon z = inUse;
		
		if(y.typ == z.res1 || y.typ == z.res2 || y.typ == z.res3) {
			System.out.println(inUse.name + "setzt" + y.name + "ein.");
			System.out.println("Nicht sehr Effektiv!");
			System.out.println("Oh nein, " + z.name + " wurde besiegt, du kannst es jetzt nicht mehr verwenden... ");
			z.hp -= (y.dmg/2);
		}
		
		if(y.typ == z.wk1 || y.typ == z.wk2) {
			System.out.println(inUse.name + "setzt" + y.name + "ein.");
			System.out.println("Sehr Effektiv!");
			System.out.println("Oh nein, " + z.name + " wurde besiegt, du kannst es jetzt nicht mehr verwenden... ");
			z.hp -= (y.dmg*2);
		}
		
		if(y.typ == z.typ) {
			System.out.println(inUse.name + "setzt" + y.name + "ein.");
			System.out.println("Oh nein, " + z.name + " wurde besiegt, du kannst es jetzt nicht mehr verwenden... ");
			z.hp -= y.dmg;
		}
	}
	
	boolean analyse() {
		boolean EP = (daten.team[1].hp > 0 || daten.team[2].hp > 0 || daten.team[3].hp > 0 || daten.team[4].hp > 0);
		boolean GP = (daten.gegner[daten.gNr].pokemon1.hp > 0 || daten.gegner[daten.gNr].pokemon2.hp > 0 || daten.gegner[daten.gNr].pokemon3.hp > 0 || daten.gegner[daten.gNr].pokemon4.hp > 0);
		return (EP && GP);
	}
	
	boolean analyseGP() {
		return (daten.gegner[daten.gNr].pokemon1.hp > 0 || daten.gegner[daten.gNr].pokemon2.hp > 0 || daten.gegner[daten.gNr].pokemon3.hp > 0 || daten.gegner[daten.gNr].pokemon4.hp > 0);
	}
	
	boolean analyseEP() {
		return (daten.team[1].hp > 0 || daten.team[2].hp > 0 || daten.team[3].hp > 0 || daten.team[4].hp > 0);
	}
	
	void Sieg() {
		double mrd = Math.random();
		String spruch = "";
		if(mrd > 0.0 && mrd <= 0.2) {spruch = "Dieses mal hast du gewonnen, doch die Rache wird mein sein...";}		
		if(mrd > 0.2 && mrd <= 0.4) {spruch = "Mehr GlÃƒÂ¼ck als Verstand und doch gewonnen, und so jemand nennt sich Trainer...";}
		if(mrd > 0.4 && mrd <= 0.6) {spruch = "Schluss mit lustig, nÃƒÂ¤chstes mal lege ich erst richtig los...";}
		if(mrd > 0.6 && mrd <= 0.8) {spruch = "Du hast gut gekÃƒÂ¤mpft ich sollte erst noch mehr trainieren bevor ich wieder gegen dich antrete...";}
		if(mrd > 0.8 && mrd <= 1.0) {spruch = "Ich sehe schon mein Reserveteam reicht nicht gegen dich aus, doch nÃƒÂ¤chstes mal ist die erste Klasse dran... ";}
		System.out.println("Herzlichen GlÃƒÂ¼ckwunsch, du hast " + daten.gegner[daten.gNr].name + " besiegt!"); 
		System.out.println(daten.gegner[daten.gNr].name + ": " + spruch);
	
	}
	
	void Verloren() {
		double mrd = Math.random();
		String spruch = "";
		if(mrd > 0.0 && mrd <= 0.2) {spruch = "Netter Versuch, du solltest dich nÃƒÂ¤chstes mal mehr anstrengen wenn du gewinnen willst...";}		
		if(mrd > 0.2 && mrd <= 0.4) {spruch = "Mach erst mal die Besics bevor du mich wieder herausforderst...";}
		if(mrd > 0.4 && mrd <= 0.6) {spruch = "Das war ja klar, wieder nur ein Neuling der denkt er kÃƒÂ¶nne mich besiegen...";}
		if(mrd > 0.6 && mrd <= 0.8) {spruch = "Hochmut kommt vor dem Fall, Anfangs denken alle sie haben eine Chance...";}
		if(mrd > 0.8 && mrd <= 1.0) {spruch = "ÃƒÂœbung macht den Meister und wie ich sehe hast du davon noch zu wenig...";}
		System.out.println("Oh nein, du wurdest von " + daten.gegner[daten.gNr].name + " besiegt");
		System.out.println(daten.gegner[daten.gNr].name + ": " + spruch);
		
		
	}
	*/
	
	void rundeTry() {
		
		angriff();
		if(analyseGP() == true) {	angriffG();	}
		else { Sieg(); }
		if(analyseEP() == false){	Verloren();	}
		if(analyse()   == true) {	rundeTry();	}
		
	}
	
}
