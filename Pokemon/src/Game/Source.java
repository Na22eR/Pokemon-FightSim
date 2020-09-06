package Game;

import static jsTools.Input.*;

public class Source {

	int gNr;
	
	//Erstellen des Trainer Arrays
	Trainer gegner [] = new Trainer [17];
		
	//Erstellen des Team Arrays
	Pokemon team [] = new Pokemon [5];
		
	//Erstellen des Eigenen Spielers & zuweisen der Team-Slots den Pokemon-Slots
	Trainer Trainer0 = new Trainer("Ashe", team[1], team[2], team[3], team[4]);
	
	//Erstellen des Pokemon Arrays
	Pokemon pokemons [] = new Pokemon [20];
	

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
	
	Trainer Trainer1 = new Trainer("Gary", Bisasam, Glumanda, Shiggy, Bisasam);	
	Trainer Trainer2 = new Trainer("Richie", Pikachu);
	Trainer Trainer3 = new Trainer("Harrison", Bisasam);
	Trainer Trainer4 = new Trainer("Morrison", Pikachu);
	Trainer Trainer5 = new Trainer("Tyson", Bisasam);
	Trainer Trainer6 = new Trainer("Paul", Pikachu);
	Trainer Trainer7 = new Trainer("Berry", Bisasam);
	Trainer Trainer8 = new Trainer("Biaz", Pikachu);
	Trainer Trainer9 = new Trainer("Bell", Bisasam);
	Trainer Trainer10 = new Trainer("Stephan", Pikachu);
	Trainer Trainer11 = new Trainer("Virigl", Bisasam);
	Trainer Trainer12 = new Trainer("Tierno", Pikachu);
	Trainer Trainer13 = new Trainer("Sawyer", Bisasam);
	Trainer Trainer14 = new Trainer("Alian", Pikachu);
	Trainer Trainer15 = new Trainer("Gladio", Bisasam);
	Trainer Trainer16 = new Trainer("Tali", Pikachu);
	

	
	
	
	
	
	
	
	
	
	
	void cGegner() {
	//Befüllen des Gegner-Arrays
		
		gegner [1] = Trainer1; gegner [2] = Trainer2; gegner [3] = Trainer3; 
		gegner [4] = Trainer4; gegner [5] = Trainer5; gegner [6] = Trainer6; 
		gegner [7] = Trainer7; gegner [8] = Trainer8; gegner [9] = Trainer9; 
		gegner [10] = Trainer10; gegner [11] = Trainer11; gegner [12] = Trainer12;
		gegner [13] = Trainer13; gegner [14] = Trainer14; gegner [15] = Trainer15;
		gegner [16] = Trainer16;	
		
		
		//Ausgabe der Gegner Namen
		System.out.println("Gegen Welchen Trainer möchtest du kämpfen? ");
		System.out.println("Zur Auswahl stehen: ");
		
		for(int i = 0; i < gegner.length; i++) {
			System.out.println(i + ". " + gegner[i].getTrName() );
		}
		
		/*
		System.out.println("1." + Trainer1.getTrName() + "2." + Trainer2.getTrName() + "3." + Trainer3.getTrName() + "4." + Trainer4.getTrName() +  
						   "5." + Trainer5.getTrName() + "6." + Trainer6.getTrName() + "7." + Trainer7.getTrName() + "8." + Trainer8.getTrName() );
		System.out.println("9." + Trainer9.getTrName() + "10." + Trainer10.getTrName() + "11." + Trainer11.getTrName() + "12." + Trainer12.getTrName() +  
						  "13" + Trainer13.getTrName() + "14." + Trainer14.getTrName() + "15." + Trainer15.getTrName() + "16." + Trainer16.getTrName() );
		
	*/
	
		//Auswahl des Gegners
		gNr = readInt("Nummer des gewünschten Gegners: "); 
	
	}
	
	void cPokemon() {
	
		//Befüllen des Pokemon-Arrays
		pokemons[1] = Pikachu;	pokemons[2] = Glumanda; pokemons[3] = Shiggy; pokemons[4] = Bisasam;
	}
	
	void cTeam() {
		
		int pkm1;	int pkm2;	int pkm3;	int pkm4;
		
		//Ausgabe der möglichen Pokemon
		System.out.println("Stelle aus folgenden Pokemon dein 4-köpfiges Team zusammen");
		System.out.println("Zur Auswahl stehen:");
		//Pokemon zur Auswahl fehlen noch
		System.out.println(" ");
		
		//Zusammenstellen des Teams
		pkm1 = readInt("Nummer des 1.Pokemon: "); team[1] = pokemons[pkm1]; 
		pkm2 = readInt("Nummer des 2.Pokemon: "); team[2] = pokemons[pkm2]; 
		pkm3 = readInt("Nummer des 3.Pokemon: "); team[3] = pokemons[pkm3]; 
		pkm4 = readInt("Nummer des 4.Pokemon: "); team[4] = pokemons[pkm4]; 
		System.out.println(" ");
		
		//Ausgabe des Teams
		System.out.println("Dein Team: ");
		System.out.println("1. " + team [1] + "\t" +  " 2. " + team [2] + "\t" + " 3. " + team [3] + "\t" + " 4. " + team [4] );
			
	}
	
}