package fr.univavignon.rodeo.imp;

import java.net.*;
import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ENJOUMI AYOUB & BENHACHANI MOHAMMED 
 * 
 * readfile classe pour récupérer les informations des pokémon sur le net
 * et pour le test de nos méthode, en faisant évoluer le jeu
 */
public class readfile {

	/**listes pour chaque colonne*/
	public  List<String> lanimal = new ArrayList<>(); //liste de tous les animaux (pokémon)
	public  List<String> lspecies = new ArrayList<>(); //liste de toute les espéces (pokémon)
	public  List<String> lclass = new ArrayList<>(); //liste de toute classes (pokémon) 
	public  List<String> lenvname = new ArrayList<>();//liste de tous les environnements (pokémon) 
	public  List<Integer> larea = new ArrayList<>();//liste de toutes les zones (pokémon) 
	public  List<Integer> lxp = new ArrayList<>();//liste de tous les XP (pokémon)
	
	static List<String> lanimalee = new ArrayList<>();
	
	//Liste des animaux selon une espéce donné qui est dans un environementdonné.
	static List<String> anims ; 
	
	public static String myanimal =""; //l'animal en question courant
	public static String currspecie =""; //l'espéce courante choisit
	public static String envchoisit = ""; //l'environnement courant choisit
	public static int currentdistance = 0; //la distance courante parcouru pour un animal donné (état du jeu)
	public static int currentxp =0; //la XP courant Spour un animal donné (état du jeu)
	
	//map contenant les informations de chaque pokémon capturé 
	public static Map<String, List<String>> sauver = new HashMap<>();

	/**
	 * Construct permettant la récupération des informations
	 * des pokmon sur internet par colonne
	 */
  	public readfile() {
  		//mettre par défaut xp à 3
  		currentxp = 3;

  		
		try{
			URL url = new URL("http://rodeo-stampede.wikia.com/wiki/Animal_Tiers");
			Document doc = Jsoup.parse(url, 3000);
	
	
			Map<String, List<String>> maptd = new HashMap<>();//th + liste lements
			Elements tableall = doc.select("table"); //select all tables
			for(int q=1;q<tableall.size();q++){
				Element table = tableall.get(q); //select the first table.
				Elements rows = table.select("tr");
				Elements th = table.select("th");//table1<tous th
				for (int i = 0; i < th.size(); i++) { //first row is the col names so skip it.
				    Element thx = th.get(i);
		    		//maptd.put(thx.text(),null);
				    }	
		    		  
				for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
				    Element row = rows.get(i); // 
				    Elements cols = row.select("td");    
				    Element eanimal = cols.get(0);
				    Element especies = cols.get(1);
				    Element eclas = cols.get(2);
				    Element unlock = cols.get(3);
				    Element exp = cols.get(4);
	
				    //ajouter dans la liste correspondante 
				    lanimal.add(eanimal.text());
					lspecies.add(especies.text());
					lclass.add(eclas.text());
					String [] sp =unlock.text().split(" "); 
					int AREA = Integer.parseInt(sp[1]);
					lenvname.add(sp[0]);
					larea.add(AREA);
					int EXP = Integer.parseInt(exp.text());
					lxp.add(EXP); 	
	
				}
	    		  
			}
			

		}catch(IOException ie){
			System.out.println("erreur de connexion");
		}


	}
  	
  	/**
  	 * Method choisirspecies pour choisir l'espéce selon les valeurs
  	 * XP, et distance parcouru courante
  	 * @param dists
  	 * @param xp
  	 */
  	public void choisirspecies(int dists, int xp) {
  		
  		// demander à l'utilisateur de choisir une espéce
  		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir une espéce :");
		String str = sc.nextLine();
		this.currspecie  = str;

		
		// selon espéce choisit, récuppérer les informations relatif à cet espéce
		try{
		URL url = new URL("http://rodeo-stampede.wikia.com/wiki/Species:_"+str);
		Document doc = Jsoup.parse(url, 3000);

		List<String> lanimal2 = new ArrayList<>();
		List<String> lclass2 = new ArrayList<>();
		List<String> ldist = new ArrayList<>();
		List<String> lxp2 = new ArrayList<>();


		Elements tableall2 = doc.select("table"); //select all tables

			Element table = tableall2.get(0); //select the first table.
			Elements rows = table.select("tr");
			Elements th = table.select("th");//table1<tous th
			for (int i = 0; i < th.size(); i++) { //first row is the col names so skip it.
			    Element thx = th.get(i);
			    }	
	    		  
			for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
			    Element row = rows.get(i); // 
			    Elements cols = row.select("td");
			    System.out.println(cols.size());
	    		
			    Element eanimal = cols.get(0);
			    Element eclas = cols.get(1);
			    Element dist;
			    Element exp;
			    //des fois nous avons 4 colonnes et des fois on a 5 colonnes
			    if(cols.size()==4) {
			    	
			    	dist = cols.get(2);
			    	exp = cols.get(3);
			    
			    }else {
			    	dist = cols.get(3);
			    	exp = cols.get(4);
			    	
			    }
			    	
			    //ajouter les informations dans la liste correspondante
			    lanimal2.add(eanimal.text());
				lclass2.add(eclas.text());
				ldist.add(dist.text());
				lxp2.add(exp.text());

				
			}
			
				//remplissge liste des animaux selon cet espéce
				 anims = new ArrayList<>();
				 
					for(int v =0; v<ldist.size();v++){
						String distance =ldist.get(v);
						String [] p = distance.split("> ");
						String [] pp = p[1].split("m");
						int number = Integer.parseInt(pp[0]);
						System.out.println(" / "+number);
						
						int nxp = Integer.parseInt(lxp2.get(v));
						//System.out.println(lanimal2.get(v) + " /++/ " +  this.lanimalee + " /++/ " + this.anims );
						
						if(number<=dists && nxp<=xp){
							if(!this.lanimalee.contains(lanimal2.get(v))) {
								this.anims.add(lanimal2.get(v)); 
								//this.lanimalee.add(lanimal2.get(v));
							}else
								System.out.println("animal existant ");
								

						}
		
					}
					
				currspecie = str;
				
		}catch(IOException ie){
			System.out.println("erreur espéces");
		}


		//System.out.println("Vous avez saisi : " + str);

  		
  	}
  	
  	
  	/**
  	 * Method choisiranimal permettant de choisir un animal 
  	 * parmis la liste selon une espéce
  	 * @param l liste des animaux (anims)
  	 */
public void choisiranimal(List l) {
  		
		int tmp = 0;
		int i =0;
		int t ;
		//liste ajouter que les animaux non encore capturé
		List<String> noncapture = new ArrayList<>();
		//System.out.println("choisir xx ");
		
		for(i=0;i<this.anims.size();i++) {
			t=-1;
		for (Map.Entry<String,List<String>> e : load().entrySet()){
			if(this.anims.get(i).equals(e.getKey())) {
				t = -1;
	    		break;
			}else
				t = i;
			
	  	}
		    

		    	if(t!=-1) {
		    		noncapture.add(this.anims.get(i));//ajouter que animaux non encore capturés.
			    	//System.out.println(i+ " . " + this.anims.get(i));
			    	
		    	}
		    	
		    	
		    	
		}
			//mettre dans la liste des animaux (anims) que ceux on encore capturés(ll)
			this.anims = noncapture;
			//afficher la liste des animaux qu'on peux capturer
			for(String st : this.anims) {
				System.out.println(tmp + " . " + this.anims.get(tmp));
				tmp++;
			}
	
			//si la liste n'est pas vide, on peux choisir un animal
		if(this.anims.size()!=0)
		{
	  		Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez choisir un numero animal :");
			String str = sc.nextLine();
			int numanimal = Integer.parseInt(str);
			if(numanimal<=this.anims.size()-1) {
				System.out.println("Vous avez choisi l'animal : " + this.anims.get(numanimal));
				this.myanimal =  this.anims.get(numanimal);
			}else
				System.out.println("Vous n'avez pas choisi d'animal");
			
		}else
			System.out.println("pas d'animal dsponible");
			
}

/**
 * Method load permettant de charger le fichier de sauvegarde 
 * @return
 */
public Map<String, List<String>> load(){
	   
	
	   File file = new File("./save.txt");  
	   try {
		   FileInputStream f = new FileInputStream(file);  
		   ObjectInputStream s = new ObjectInputStream(f); 
		 //remplir la map sauver avec les informations de chaque animal capturé.
		   this.sauver = (HashMap<String,List<String>>)s.readObject();         
		   s.close();
	   
	   } catch (IOException i) {
	       i.printStackTrace();
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	   
	   return this.sauver;
	
}


/**
 * Method choisirenv permettant de choisir un environnement
 */
public void choisirenv() {

	Collection<String> list = this.lenvname;
	 
	// Get collection without duplicate i.e. distinct only
	List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
	
	//pour chaque env, on verifie que la distance  est bonne
	for(int i=0; i<distinctElements.size();i++)
		System.out.println(i + " . " + distinctElements.get(i));
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez choisir un environement 'chiffre':");
	String str = sc.nextLine();
	int numenv = Integer.parseInt(str);
	if(numenv<=distinctElements.size()-1) {
		System.out.println("Vous avez choisi d'environment : " + distinctElements.get(numenv));
		this.envchoisit = distinctElements.get(numenv);
	}else
		System.out.println("Vous n'avez pas choisi d'environment ");
	
	
	
	//liste des espéces selon environnement choisit
	List<String> espece = new ArrayList<>();
	
	try{
		URL url = new URL("http://rodeo-stampede.wikia.com/wiki/" + distinctElements.get(numenv));
		Document doc = Jsoup.parse(url, 3000);

		
		Elements tableall2 = doc.select("table"); //select all tables

		//for(int q=1;q<tableall2.size();q++){
			Element table = tableall2.get(0); //select the first table.
			Elements rows = table.select("tr");
			Elements th = table.select("th");//table1<tous th
			for (int i = 0; i < th.size(); i++) { //first row is the col names so skip it.
			    Element thx = th.get(i);
			    }	
	    		  
			for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
			    Element row = rows.get(i); // 
			    Elements cols = row.select("td");
	    		
			    Element anim = cols.get(0);
			    espece.add(anim.text());
				

				
			}

				 
		}catch(IOException ie){
			System.out.println("erreur espéces");
		}

	//affichage liste des espéces
		int b = 0;
		for(String s : espece) {
			System.out.println(espece.get(b));
			b++;
		}

		
}

/**
 * Method jouer permettant de faire évoluer le pokémon, 
 * évolution de la distance courante de l'animale
 */
public static void jouer() {
	currentdistance+=  100;
	
}

/**
 * Method getdist récupérer la distance parcouru d'un animale (selon espéce )
 * @param name nom de l'animal
 * @param spece l'espéce correspondante à cet animal
 * @return
 */
	public static int getdist(String name, String spece) {
		int tmp =0;
		System.out.println("*********************************");
		//System.out.println(sauver);
		//recupérer la distance courante 
		for(Map.Entry<String, List<String>> m : sauver.entrySet())
			if(m.getKey().equals(name))
				currentdistance = Integer.parseInt(m.getValue().get(6));				
		return currentdistance;
		
	}
  	
	/**
	 * Method main pour tester nos méthodes (et faire evoluer le jeu)
	 */
  	public static void main (String [] args) {

  	System.out.println("Jeu de pokémon");
  	
  	readfile rf = new readfile();
  	boolean quitter =false;
  	//charger le fihier depuis la sauvegarde
  	Map<String,List<String>> loadd = rf.load();
  	
  	//si le fichier est vide, on choisit l'animal 
  	//que l'on veux selon distance courante et XP qu'on a fixé
  		if(rf.load().size()==0) {
  			rf.choisirenv();
  		  	rf.choisirspecies(rf.currentdistance, rf.currentxp);
  		  	rf.choisiranimal(rf.anims);
  		  	rf.currentdistance = rf.getdist(rf.myanimal, currspecie);

  		  	//ajouter informations dans la map de sauvegarde
  		  	rf.sauver.put(myanimal, informer(rf));
  		  	
  		  	String pathsInfo = "./save.txt";
  		    File source = new File(pathsInfo);
  			// sauvegarder dans le fichier
  		   try {  
  			 	   
  		        FileOutputStream fileOut = new FileOutputStream(source);
  		        ObjectOutputStream out = new ObjectOutputStream(fileOut);
  		        out.writeObject(rf.sauver);
  		        out.close();
  		        fileOut.close();  		        
  		       } catch (IOException i) {
  		          i.printStackTrace();
  		       }
  		   
  		  // System.out.println("-------read-------") ;
  		  
  		 //System.out.println(rf.load());
  		 
  		   //si le fichier n'est pas vide,
  		}else 
  			{
  				//choisir un animal que l'on veux faire évoluer selon la sauvegarde
  				int tmp = 0;
  				System.out.println("choisir mon animal");
  				for (Map.Entry<String,List<String>> e : loadd.entrySet()){
  				    System.out.println( tmp + " . " + e.getKey());
  				    tmp++;
  				}
  				
  				//ou quitter
  				System.out.println( tmp + ". " + "quitter");
  				String infoss ="";
  				int index =-1;
  				Scanner sc = new Scanner(System.in);
  				String str = sc.nextLine();
  				int choix = Integer.parseInt(str);
  				
  				//si on choisit un animal
  				if(choix<=tmp-1) {
  					int compt =0;
  					for (Map.Entry<String,List<String>> e : loadd.entrySet()){
  							rf.lanimalee.add(e.getKey());
  							
  						//on récupére les infos de l'animal selectionné
  						if(choix==compt) {
  							System.out.println( compt + " . " + e.getKey());
  							infoss = e.getValue().toString();
  							rf.myanimal = e.getKey();
  							
  						}
  						index++;
  	  				    compt++;
  	  				}
  				System.out.println("vous avez choisi : " + rf.myanimal +  index);
  				//tant qu'on a pas quitté
  					while(quitter==false) {
  						System.out.println("0. jouer");
  						System.out.println("1. quitter");
  						
  						
  		  				
  		  				Scanner sc2 = new Scanner(System.in);
  		  				String str2 = sc2.nextLine();
  		  				int choix2 = Integer.parseInt(str2);
  		  				
  		  				//jouer 
  						if(choix2==0) {
  							jouer();
  							int ff = Integer.parseInt(""+loadd.get(rf.myanimal).get(6));
  							int total = ff + 100 ;
  							//System.out.println(""+total + "/" + ff);
  							loadd.get(rf.myanimal).set(6, ""+total);
  							//System.out.println(loadd.get(rf.myanimal));
  							//sauvegarder à chaque fois notre évolution
  							save(loadd);
  							
  							
  						}
  						//sinon on quitte le jeu	
  						else
  							quitter = true;
  						
  						
  						
  					}
  				//si on choisit un chiffre = tmp+1
  				}if(choix==tmp+1) {
  					
  					//pour attracper un nouveau animale
  					GameState gs = new GameState(rf.currentdistance, rf.myanimal);
  		  			rf.choisirenv();
  		  			rf.choisirspecies(rf.currentdistance, currentxp);
  		  			
  		  			rf.choisiranimal(rf.anims);
  		  			boolean s =false,e = false,b=false;
  					if(rf.informer(rf).get(3).contains("Secret"))
  						s = true;
  					if(rf.informer(rf).get(3).contains("Endangered"))
  						e = true;
  					if(rf.informer(rf).get(3).contains("Boss"))
  						b = true;
  		  			IAnimal iz = new Animal(rf.informer(rf).get(0),Integer.parseInt(rf.informer(rf).get(5)),s, e, b );
  		  			gs.catchAnimal(iz);
  		  			save(loadd);
  		  	
  		  			GameStateProvider gsp = new GameStateProvider();
  		  			gsp.save(gs);
  		  			
  		  		System.out.println("// "+gsp.get(rf.myanimal).getProgression());
  					
  				}
  				
  				
  				else {
  					quitter = true;
  					
  				}
  				
  			
	  	}
  		
  			System.out.println("Vous avez quitter");
  			
  			//System.out.println(rf.load());
  			rf.currentdistance = getdist(rf.myanimal, rf.currspecie);
  			//System.out.println(rf.currentdistance);
  			
  			ISpecie ispp = new Specie();
  			System.out.println(ispp.getArea());
  			
  			
  			
  	}
  	
  	/**
  	 * Method informer our rempilir la liste des informations d'un animale donné.
  	 * @param rf
  	 * @return
  	 */
  	public static List<String> informer(readfile rf) {
  		
  		List<String> infos = new ArrayList<>();
		  	for(int d=0; d<rf.lanimal.size();d++) {
		  			if(rf.lanimal.get(d).contains(myanimal)) {
		  				infos.add(rf.lanimal.get(d));
		  				infos.add(rf.lspecies.get(d));
		  				
		  				infos.add(rf.lclass.get(d));
		  				infos.add(rf.lenvname.get(d));
		  				
		  				infos.add(""+rf.larea.get(d));
		  				infos.add(""+rf.lxp.get(d));
		  				infos.add(""+getdist(rf.lanimal.get(d), currspecie));
		  			}
		
		  	}
		  	return infos;
  	}
  	
  	/**
     * fonction permettant de sauvegarder le contenu de la map dans un fichier txt.
  	 * @param sauver2 
     */
    public static void save(Map<String, List<String>> sauver2){
        
        try {     
         FileOutputStream fileOut = new FileOutputStream("./save.txt");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(sauver2);
         out.close();
         fileOut.close();
         
        } catch (IOException i) {
           i.printStackTrace();
        }
        
    }
  	
}


