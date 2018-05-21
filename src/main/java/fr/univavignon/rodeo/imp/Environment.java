package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;


/**
 * @author ENJOUMI AYOUB & BENHACHANI MOHAMMED 
 * 
 * Environment classe pour l'environement ciblé
 */

public class Environment implements IEnvironment {

	
	public static String Name; // nom de l'environnement comme 'Savannah'
	int cmptarea ; // compteur utile pour le nombre de zones
	readfile rf = new readfile(); //creation d'un objet pour la récupération des informations depuis internet 
	List<ISpecie> listspecie;
	
	
	/**
	 * Constructeur permettant l'obtention de toute les espéces 
	 * selon l'environnement, avec l'incrémentation de nombre 
	 * de zones disponible dans cet environnement
	 * 
	 * @param Name nom de l'environnement rechercher
	 */
	
	public Environment (String Name) {
		cmptarea =0;
		listspecie = new ArrayList<>();
		this.Name = Name;//savannah...
		for(int i = 0; i<rf.lenvname.size();i++) {
			if(rf.lenvname.get(i).contains(this.Name)) {
				cmptarea++;
				//System.out.println(rf.lspecies.get(i));
				ISpecie is = new Specie(rf.lspecies.get(i));
				this.listspecie.add(is);
			}
			
		}
		
		
		
		
	}
	

	/**
	 * Getter redéfinition, pour le nom de l'environnement.
	 * 
	 * @return nom de l'environnement.
	 */
	
	@Override
	public String getName() {
		return this.Name;
	}

	/**
	 * Getter redéfinition pour le numbre of de zones
	 * disponible pour cet environnement.
	 * 
	 * @return nombre de zones disponible.
	 */

	@Override
	public int getAreas() {
		return this.cmptarea;
		//return 0;
	}
	/**
	 * Getter redéfinition pour les espéces disponible 
	 * dans cet environnement.
	 * 
	 * @return List des espéces disponible.
	 */

	@Override
	public List<ISpecie> getSpecies() {
		return this.listspecie;
	}

}
