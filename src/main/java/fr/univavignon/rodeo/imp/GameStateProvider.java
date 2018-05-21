package fr.univavignon.rodeo.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;


/**
 * @author ENJOUMI AYOUB & BENHACHANI MOHAMMED 
 * 
 * GameStateProvider classe permettant la gestion de l'état du jeu.
 */

public class GameStateProvider implements IGameStateProvider {

	//map contenant pour chaque animale une liste de caractéristiques;
	 //public static Map<String, List<String>> sauvegarde;
	
	 //lecture des informations sur le site Rodeo
	 public static readfile rf = new readfile();
	
	 

	/**
	 * Method  save pour sauvegarder l'état du jeu.
	 * 
	 * @param gameState l'état du jeu.
	 */
	@Override
	public void save(IGameState gameState) {
		//le fichier de sauvegarde
		 String pathsInfo = "./save.txt";
         File source = new File(pathsInfo);
		
         //sauvegarder les informations dans le fichier save.txt
         try {     
             FileOutputStream fileOut = new FileOutputStream(source);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(rf.sauver);
             out.close();
             fileOut.close();
             
            } catch (IOException i) {
               i.printStackTrace();
            }
	}

	
	/**
	 * Method get permettant de charger les informations
	 * du jeu d'un animal donné.
	 * 
	 * @param name nom de l'animal en question 
	 * @return l'état du jeu en question. 
	 * @throws IllegalArgumentException If the given <tt>name</tt> is <tt>null</tt>
	 */
	
	@Override
	public IGameState get(String name) throws IllegalArgumentException {
		System.out.println(" currdist on IGamestate : " + rf.currentdistance);
		IGameState igs = new GameState(rf.currentdistance,name);
		
		File file = new File("./save.txt");  
		   try {
			   FileInputStream f = new FileInputStream(file);  
			   ObjectInputStream s = new ObjectInputStream(f);  
			    rf.sauver= (HashMap<String,List<String>>)s.readObject();         
			   s.close();
		   
		   } catch (IOException i) {
		       i.printStackTrace();
		    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return igs;
	}

}
