package Game;

import static jsTools.Input.*;

public class Source {

	int gNr;
	
	//Erstellen des Trainer Arrays
	Trainer gegner [] = new Trainer [16];
		
	//Erstellen des Team Arrays
	Pokemon team [] = new Pokemon [4];
		
	//Erstellen des Eigenen Spielers & zuweisen der Team-Slots den Pokemon-Slots
	Trainer Trainer0 = new Trainer("Ashe", team[0], team[1], team[2], team[3]);
	
	//Erstellen des Pokemon Arrays
	Pokemon pokemons [] = new Pokemon [4];
	

	Attacke Elektroball = new Attacke("Elektroball", 4, 10);
	Attacke Donnerschock = new Attacke("Donnerschock", 4, 30);
	Attacke Donnerwelle = new Attacke("Donnerwelle", 4, 20);
	Attacke Funkensprung = new Attacke("Funkensprung", 4, 20);
	Attacke Rankenhieb = new Attacke("Rankenhieb", 5, 25);
	Attacke Rasierblatt = new Attacke("Rasierblatt", 5, 25);
	Attacke Solarstrahl = new Attacke("Solarstrahl", 5, 10);
	Attacke Giftpuder = new Attacke("Giftpuder", 8, 35);
	Attacke Glut = new Attacke("Glut", 2, 25);
	Attacke Flammenblitz = new Attacke("Flammenblitz", 2, 15);
	Attacke Feuerodem = new Attacke("Feuerodem", 15, 20);
	Attacke Schlitzer = new Attacke("Schlitzer", 1, 20);
	Attacke Aquaknarre = new Attacke("Aquaknarre", 3, 25);
	Attacke Aquawelle = new Attacke("Aquawelle", 3, 20);
	Attacke Biss = new Attacke("Biss", 1, 25);
	Attacke Turbodreher = new Attacke("Turbodreher", 1, 40);
	
	Pokemon Pikachu = new Pokemon("Pikachu", 142, 4, 4, 6, 0, 10, 0, Elektroball, Donnerschock, Donnerwelle, Funkensprung );
	Pokemon Bisasam  = new Pokemon("Bisasam", 152, 5, 3, 4, 11, 2, 0, Rankenhieb,  Rasierblatt, Solarstrahl, Giftpuder );
	Pokemon Glumanda = new Pokemon("Glumanda", 146, 2, 5, 12, 2, 3, 10, Glut, Flammenblitz, Feuerodem, Schlitzer );
	Pokemon Shiggy  = new Pokemon("Shiggy", 151, 3, 3, 2, 12, 5, 4, Aquaknarre, Aquawelle, Biss, Turbodreher );
	
	Trainer Trainer1 = new Trainer("Gary    ", Bisasam, Glumanda, Shiggy, Bisasam);	
	Trainer Trainer2 = new Trainer("Richie  ", Bisasam, Bisasam, Bisasam, Bisasam);
	Trainer Trainer3 = new Trainer("Harrison", Bisasam);
	Trainer Trainer4 = new Trainer("Morrison", Pikachu);
	Trainer Trainer5 = new Trainer("Tyson   ", Bisasam);
	Trainer Trainer6 = new Trainer("Paul    ", Pikachu);
	Trainer Trainer7 = new Trainer("Berry   ", Bisasam);
	Trainer Trainer8 = new Trainer("Biaz    ", Pikachu);
	Trainer Trainer9 = new Trainer("Bell    ", Bisasam);
	Trainer Trainer10 = new Trainer("Stephan", Pikachu);
	Trainer Trainer11 = new Trainer("Virigl ", Bisasam);
	Trainer Trainer12 = new Trainer("Tierno ", Pikachu);
	Trainer Trainer13 = new Trainer("Sawyer ", Bisasam);
	Trainer Trainer14 = new Trainer("Alian  ", Pikachu);
	Trainer Trainer15 = new Trainer("Gladio ", Bisasam);
	Trainer Trainer16 = new Trainer("Tali   ", Pikachu);
	

	
	
	
	
	
	
	
	
	
	void cGegner() {
		
		//Befüllen des Gegner-Arrays
		gegner [0] = Trainer1; gegner [1] = Trainer2; gegner [2] = Trainer3; 
		gegner [3] = Trainer4; gegner [4] = Trainer5; gegner [5] = Trainer6; 
		gegner [6] = Trainer7; gegner [7] = Trainer8; gegner [8] = Trainer9; 
		gegner [9] = Trainer10; gegner [10] = Trainer11; gegner [11] = Trainer12;
		gegner [12] = Trainer13; gegner [13] = Trainer14; gegner [14] = Trainer15;
		gegner [15] = Trainer16; 
		
		
		//Ausgabe der Gegner Namen
		System.out.println("Gegen Welchen Trainer möchtest du kämpfen? ");
		System.out.println("Zur Auswahl stehen: ");
		for(int i = 1; i <= gegner.length; i++) {
			System.out.print(i + "." + gegner[i-1].getTrName()  + "\t");
			if(  (i%4) == 0) { nl(); }
		}
		nl();

		gNr = readInt("Nummer des gewünschten Gegners: ")-1; 
		nl();
		System.out.println("Dein Gegner ist: " + gegner[gNr].getTrName() );
		System.out.println("Team des Gegners: ");
		//System.out.println("1." + gegner[gNr].pokemon1.getPkmName() + " 2." + gegner[gNr].pokemon2.getPkmName() + " 3." + gegner[gNr].pokemon3.getPkmName() + " 4." + gegner[gNr].pokemon4.getPkmName());
		nl2();
		
	}
	
	void cPokemon() {
	
		//Befüllen des Pokemon-Arrays
		pokemons[0] = Pikachu;	pokemons[1] = Glumanda; pokemons[2] = Shiggy; pokemons[3] = Bisasam;
	}
	
	void cTeam() {
		
		//Ausgabe der möglichen Pokemon
		System.out.println("Stelle aus folgenden Pokemon dein 4-köpfiges Team zusammen!");
		System.out.println("Zur Auswahl stehen:");
		
		for(int i = 1; i <= pokemons.length; i++) {
			System.out.print(i + "." + pokemons[i-1].getPkmName()  + "\t");
			if(  (i%4) == 0) { nl(); }		
		}
		nl();
		
		
		//Zusammenstellen des Teams
		for(int i = 0; i < team.length; i++) {
			team[i]=pokemons[readInt("Nummer des " + (i+1) + ".Pokemon: ")-1 ];
		}
		nl();
		
		
		//Ausgabe des Teams
		System.out.println("Dein Team: ");
		for(int i = 1; i <= team.length; i++) {
			System.out.println(i + "." + team[i-1].getPkmName() );
		}
		nl2();
			
	}
	
	void nl()  { System.out.println(""); }
	void nl2() {nl(); nl();				 }
	
}