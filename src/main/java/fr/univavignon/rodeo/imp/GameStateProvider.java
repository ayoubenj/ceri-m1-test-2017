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

public class GameStateProvider implements IGameStateProvider {

	//dossier pour sauvegarde;//map contenant animal et ses caractéristiques;
	 public static Map<String, List<String>> sauvegarde;// map <fichier,liste mots clés>
	 public static readfile rf = new readfile();
	
	@Override
	public void save(IGameState gameState) {
		 String pathsInfo = "./save.txt";
         File source = new File(pathsInfo);
		// TODO Auto-generated method stub serizliser save
         try {     
             FileOutputStream fileOut = new FileOutputStream(source);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(rf.sauver);
             out.close();
             fileOut.close();
             ///System.out.printf("Serialized data is saved which are: \n"+keyword);
             
            } catch (IOException i) {
               i.printStackTrace();
            }
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub desarialise le nom
		return igs;
	}

}
