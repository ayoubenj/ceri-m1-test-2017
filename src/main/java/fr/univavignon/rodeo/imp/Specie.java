package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;


/**
 * @author ENJOUMI AYOUB & BENHACHANI MOHAMMED 
 * 
 * Specie classe permettant la définition des espéces.
 */

public class Specie implements ISpecie {

	readfile rf = new readfile(); //
	String Name ;
	public static List<IAnimal> lia;
	int area;
	public Specie(String name2) {
		this.Name = name2;
		// TODO Auto-generated constructor stub
	}
	public Specie(int x , List<IAnimal> st , String name2) {
		this.area = x;
		this.lia = st;
		this.Name = name2;
		
		
		// TODO Auto-generated constructor stub
	}
	
	public Specie() {
		
	}
	
	
	/**
	 * Getter pour récupérer le numéro de la zone ciblé dans
	 * laquelle l'espéce peux être trouvée.
	 * 
	 * @return La zone dans laquelle l'espéce en question peux être trouvée.
	 */
	@Override
	public int getArea() {//in which area can be found current spece
		for(int i=0;i<rf.larea.size();i++) {
			if(rf.lspecies.get(i).contains(this.getName()))
				return rf.larea.get(i);
			
		}
				
		return 0;
	}

	/**
	 * Method getAnimals permettant de récupérer la liste 
	 * d'animaux.
	 * 
	 * @return Liste des animaux disponibles pour un espéce donné.
	 */
	
	//List of available animal for this specie. //liste animaux slon espéce
	@Override
	public List<IAnimal> getAnimals() {
		//nouvelle liste de ianimal
		lia = new ArrayList<>();
		//pour chaque animal
		for(int i=0; i<rf.lanimal.size();i++) {
			
			if(rf.lspecies.get(i).contains(this.getName())) {
				//on définit si il est seret, boss...
				boolean s =false,e = false,b=false;
				if(rf.lclass.get(i).contains("Secret"))
					s = true;
				if(rf.lclass.get(i).contains("Endangered"))
					e = true;
				if(rf.lclass.get(i).contains("Boss"))
					b = true;
				//on crée un objet Ianimal de la classe animal, en définissant les caractéristiques de chaque animal
				IAnimal ia = new Animal(rf.lanimal.get(i),rf.larea.get(i),s,e,b);
				//ajouter à la liste
				lia.add(ia);
			}
			
		}
		
		return lia;
	}

	/**
	 * Getteur du nom de l'espéce en question
	 */
	@Override
	public String getName() {
		if(rf.currspecie.isEmpty())
			return this.Name;
		else
			return rf.currspecie;

	}

}
