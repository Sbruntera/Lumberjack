package pack;

import java.io.IOException;
import java.util.Scanner;

public class Lumberjack extends Thread{
	
	public Integer holz;
	public Integer decay;
	public Integer axtpreis;
	public Boolean Wounded;
	public Integer arme;
	public Scanner in;
	public Boolean arbeiten;
	public Integer helfeElfen;
	public Integer kaputteAexte;
	
	public boolean firstStep = false;
	public boolean momsChild = false;
	public boolean pussy = false;
	public boolean monstercook = false;
	public boolean wonderwoman = false;
	public boolean breakmen = false;


	public void run() {
		while (true){
			this.clearScreen();
			showStatus();
			
			Integer holzGehackt = 1+this.helfeElfen;
			if(arme != 0){
				System.out.println("| Ich habe: " + holzGehackt + " neu gehackt.");
			}
			this.chanceWound();
			if (!Wounded && arbeiten){
				if (decay != 0){
					if(arme != 0){
						this.chancefoundHelfendeElfe();
						this.hasAchivment();
						this.holz++;
						this.holz = this.holz + this.helfeElfen;
						this.decay--;
					}
				}else{
					this.kaputteAexte++;
					System.out.println("| Meine Axt ist kaputt und selber kauf ich mir garantiert keine neue.");
					System.out.println("|");
					System.out.println("| Neue Axt kaufen für: " + this.axtpreis + "€ \n"
							+ "| \t 1. Ja [y]\n"
							+ "| \t 2. Nein [n]");
					System.out.print("| Eingabe: ");
					if(this.in.nextLine().equals("y")){
						Bank.getInstance().balance = Bank.getInstance().balance - axtpreis;
						DecayAxt();
						System.out.println("| Axt gekauft für " + this.axtpreis + "€");
						generateAxtPreis();
					}else{
						System.out.println("| Dann nicht du Arsch.");
					}
					
				}
				try {
					Lumberjack.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("| Ich hab meinen Arm abgehackt! Ich brauch einen Neuen!");
				if(arme == 0){
					System.out.println("| Ich besitze keine Arme mehr, was nun? [w (weitermachen)|a (aufhoeren)]");
					System.out.println("+-------------------------------------------------+");
					
					String line = this.in.nextLine();
					if(line.equals("a")){
						System.out.println("| Ok, hau rein.");
						System.out.println("+-------------------------------------------------+");
						this.arbeiten = false;
					}else if(line.equals("w")){
						System.out.println("| Ok, aber dann gibts kein Holz mehr du Idiot.");
						System.out.println("+-------------------------------------------------+");
						this.arbeiten = true;
					}
				}
			}

		}
    }
	
	public void showStatus(){
		System.out.println("+-------------------------------------------------+");
		System.out.println("| Holzlager: " + this.holz);
		System.out.println("| Arme: " + this.arme);
		System.out.println("| Helfende Elfen: " + this.helfeElfen);
		System.out.println("| Bankbalance: " + Bank.getInstance().balance);
		System.out.println("| Kaputte Aexte: " + this.kaputteAexte);
		System.out.println("| Achivments: " + this.getAchivments());
		System.out.println("|");
		System.out.println("+-------------------------------------------------+");
	}
	
	public void chancefoundHelfendeElfe(){
		int chance = (int) (Math.random()*100+1);
		if (chance <= 10 && arme != 0){
			System.out.println("| Hurraka! Ich hab ne helfe Elfe gefunden! Jetzt besitze ich schon: " + this.helfeElfen + " helfende Elfen");
			System.out.println("+-------------------------------------------------+");
			this.helfeElfen++;
		}
		
	}
	
	public void hasAchivment(){
		if (this.holz >= 10){
			this.firstStep = true;
		}
		if (this.holz >= 20){
			this.momsChild = true;
		}
		if  (this.holz >= 50){
			this.pussy = true;
		}
		if  (this.holz >= 100){
			this.monstercook = true;
		}
		if  (this.helfeElfen >= 3){
			this.wonderwoman = true;
		}
		if  (this.kaputteAexte >= 4){
			this.breakmen = true;
		}
	}
	
	public String getAchivments(){
		String Achivment = "";
		
		if (firstStep){
			Achivment = "Firststep(10 Wood)";
		}
		if (momsChild){
			Achivment = Achivment + ", " + "MomsChild(20 Wood)";
		}
		if (pussy){
			Achivment = Achivment + ", " + "Pussy(50 Wood)";
		}
		if (monstercook){
			Achivment = Achivment + ", " + "Monstercook(100 Wood)";
		}
		if (wonderwoman){
			Achivment = Achivment + ", " + "Wonderwoman(3 Elfen)";
		}
		if (breakmen){
			Achivment = Achivment + ", " + "Breakmen(4 KaputteÄxte)";
		}
		
		return Achivment;
	}
	
	
	
	public void chanceWound(){
		int chance = (int) (Math.random()*100+1);
		this.Wounded = false;
		if (chance <= 5 && arme != 0){
			this.Wounded = true;
			this.arme--;
		}
	}
	
	public Lumberjack(){
		this.holz = 0;
		this.arme = 2;
		this.in = new Scanner(System.in); 
		this.arbeiten = true;
		this.helfeElfen = 0;
		this.kaputteAexte = 0;
		DecayAxt();
		generateAxtPreis();
	}
	
	public void DecayAxt(){
		this.decay = (int) ((Math.random()*20)+1);
		
	}
	
	public void generateAxtPreis(){
		this.axtpreis = (int) ((Math.random()*100)+1);
	}
	
	public void clearScreen() {
		for(int i = 30; i > 0; i--){
			System.out.println("\n");
		}
	}

}
