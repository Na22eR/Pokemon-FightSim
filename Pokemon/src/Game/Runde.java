package Game;

import static jsTools.Input.readInt;

public class Runde {
	
	Source daten = new Source();
	Pokemon inUse;
	Pokemon inUseG;
	
	public static void main(String args [] ) {
		System.out.println("Willkommen im Pokemon-Kampf-Simulator!");
		
		if(readInt("Möchtest du den 1 oder den 2 Spieler-Modus spielen: ") == 1) {
			Runde r1 = new Runde();
			r1.daten.nl2();
			r1.EinzelSp();
		}
		else {
			Runde r1 = new Runde();
			r1.daten.nl2();
			r1.ZweiSp();
		}
	
	}
	
	Pokemon auswP() {
	//Waehlt das Pokemon fuer deinen naechsten Zug aus
		
		int ausw;
		
		
		
		System.out.println("Waehle ein Pokemon für den nächsten Angriff aus: ");
		for(int i = 0; i < daten.team.length; i++) {
			if(daten.team[i].hp > 0) {
				System.out.println(i+1 + ". " + daten.team[i].getPkmName() + "\t" +  "HP: " + daten.team[i].getPkmHp() );
			}
		}
		
		ausw = readInt("Deine Auswahl: ")-1;
	
		System.out.println("Ausgewählt: " + daten.team[ausw].getPkmName() ); 
		daten.nl();
		return daten.team[ausw];
	}
	
	Attacke auswA() {
	//Waehlt die Attacke fuer den naechsten Zug	
		
		//Gibt das aktuelle Pokemon des Gegners aus
		System.out.println(daten.gegner[daten.gNr].getTrName() + " verwendet gerade: " + auswPG().getPkmName() + "     HP: " + auswPG().getPkmHp() );
		daten.nl();
		
		System.out.println("Waehle deine Attacke oder Wechsle dein Pokemon: ");
		System.out.println(inUse.getPkmName() + "     HP: " +  inUse.getPkmHp());
		System.out.println("1. " + inUse.attck1.name + "\t" + "Dmg: " + inUse.attck1.dmg + "\t" +  "Typ: " + inUse.attck1.printTyp() );
		System.out.println("2. " + inUse.attck2.name + "\t" + "Dmg: " + inUse.attck2.dmg + "\t" +  "Typ: " + inUse.attck2.printTyp() );
		System.out.println("3. " + inUse.attck3.name + "\t" + "Dmg: " + inUse.attck3.dmg + "\t" +  "Typ: " + inUse.attck3.printTyp() );
		System.out.println("4. " + inUse.attck4.name + "\t" + "Dmg: " + inUse.attck4.dmg + "\t" +  "Typ: " + inUse.attck4.printTyp() );
		System.out.println("5. Pokemon wechseln");
		
		int y = readInt("Nummer der Aktion: "); 
		daten.nl();
		switch (y) {
			case 1: return inUse.attck1;
			case 2: return inUse.attck2;
			case 3: return inUse.attck3;
			case 4: return inUse.attck4;
			case 5: return inUse.attck5;
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
		
		//If Case-Wechsel
		if(y == inUse.attck5 ) {
			inUse = auswP();
			
		}
		
		//If Case-Verfehlt
		else if(Math.random() > y.aim) {
			System.out.println(inUse.name + " setzt " + y.name + " ein.");
			System.out.println(y.name + " hat verfehlt!");
			daten.nl2();
		}
		
		//If Case-Resistenz
		else if(y.typ == inUseG.res1 || y.typ == inUseG.res2 || y.typ == inUseG.res3) {
			System.out.println(inUse.name + " setzt " + y.name + " ein.");
			System.out.println("Nicht sehr Effektiv!");
			inUseG.hp -= (y.dmg/2);
			if(inUseG.hp <= 0) { System.out.println(inUseG.name + " hat keine Leben mehr und kann nicht mehr weiter kaempfen."); }
			daten.nl2();
		}
		
		//If Case-Effective
		else if(y.typ == inUseG.wk1 || y.typ == inUseG.wk2) {
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
			z.hp -= (y.dmg/2);
			daten.nl2();
			if(z.hp <= 0) {
				System.out.println("Oh nein, " + z.name + " wurde besiegt, du kannst es jetzt nicht mehr verwenden... "); 
				daten.nl2();
				if(analyseEP() == false){	Verloren();	}
				else { inUse = auswP(); }
			}
		}
		
		//If Case-Effective
		else if(y.typ == z.wk1 || y.typ == z.wk2) {
			System.out.println(inUseG.name + " setzt " + y.name + " ein.");
			System.out.println("Sehr Effektiv!");
			z.hp -= (y.dmg*2);
			daten.nl();
			if(z.hp <= 0) {
				System.out.println("Oh nein, " + z.name + " wurde besiegt, du kannst es jetzt nicht mehr verwenden... "); 
				daten.nl2();
				if(analyseEP() == false){	Verloren();	}
				else { inUse = auswP(); }
			}	
		}
		
		//Else Case-Normal
		else{
			System.out.println(inUseG.name + " setzt " + y.name + " ein.");
			z.hp -= y.dmg;
			daten.nl2();
			if(z.hp <= 0) {
				System.out.println("Oh nein, " + z.name + " wurde besiegt, du kannst es jetzt nicht mehr verwenden... "); 
				daten.nl2();
				if(analyseEP() == false){	Verloren();	}
				else { inUse = auswP(); }	
			}
		}
	}
	
	boolean analyse() {
	//Ueberprueft ob noch Pokemon am Leben sind	
		
		boolean EP = (daten.team[0].hp > 0 || daten.team[1].hp > 0 || daten.team[2].hp > 0 || daten.team[3].hp > 0);
		boolean GP = (daten.gegner[daten.gNr].pokemon1.hp > 0 || daten.gegner[daten.gNr].pokemon2.hp > 0 || daten.gegner[daten.gNr].pokemon3.hp > 0 || daten.gegner[daten.gNr].pokemon4.hp > 0);
		return (EP && GP);
	}
	
	boolean analyseGP() {
		return (daten.gegner[daten.gNr].pokemon1.hp > 0 || daten.gegner[daten.gNr].pokemon2.hp > 0 || daten.gegner[daten.gNr].pokemon3.hp > 0 || daten.gegner[daten.gNr].pokemon4.hp > 0);
	}
	
	boolean analyseEP() {
		return (daten.team[0].hp > 0 || daten.team[1].hp > 0 || daten.team[2].hp > 0 || daten.team[3].hp > 0);
	}
	
	boolean analyseG2() {
		return (daten.teamG[0].hp > 0 || daten.teamG[1].hp > 0 || daten.teamG[2].hp > 0 || daten.teamG[3].hp > 0);
	}
	
	void Sieg() {
		double mrd = Math.random();
		String spruch = "";
		if(mrd > 0.0 && mrd <= 0.2) {spruch = "Dieses mal hast du gewonnen, doch die Rache wird mein sein...";}		
		if(mrd > 0.2 && mrd <= 0.4) {spruch = "Mehr Glueck als Verstand und doch gewonnen, und so jemand nennt sich Trainer...";}
		if(mrd > 0.4 && mrd <= 0.6) {spruch = "Schluss mit lustig, naechstes mal lege ich erst richtig los...";}
		if(mrd > 0.6 && mrd <= 0.8) {spruch = "Du hast gut gekaempft ich sollte erst noch mehr trainieren bevor ich wieder gegen dich antrete...";}
		if(mrd > 0.8 && mrd <= 1.0) {spruch = "Ich sehe schon mein Reserveteam reicht nicht gegen dich aus, doch nÃƒÂ¤chstes mal ist die erste Klasse dran... ";}
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
	
	void EinzelSp() {
		daten.cGegner();
		daten.cPokemon();
		daten.cTeam();
		inUse = daten.team[0];
		ISpRunde();
	}
	
	void ZweiSp() {
		daten.cPokemon();
		daten.cTeam();
		daten.cTeamG();
		inUse = daten.team[0];
		inUseG = daten.team[0];
		IISpRunde();
	}
	
	
	
	
	void ISpRunde() {
		
		angriff();
		if(analyseGP() == true) {	angriffG();	}
		else { Sieg(); }
		if(analyse()   == true) {	ISpRunde();	}
		
	}
	
void IISpRunde() {
		
		angriff();
		if(analyseGP() == true) {	angriffG();	}
		else { Sieg(); }
		if(analyse()   == true) {	IISpRunde();	}
		
	}
	
	
}
