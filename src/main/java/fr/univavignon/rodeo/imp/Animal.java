package fr.univavignon.rodeo.imp;

import fr.univavignon.rodeo.api.IAnimal;

/**
 * @author ENJOUMI AYOUB & BENHACHANI MOHAMMED 
 * 
 * Animal classe permettant la caractérisation d'un animal
 */
public class Animal implements IAnimal {
	
	
	/**
	 * caractéristiques d'un Animal
	 */
	String Name;
	int XP;
	boolean Secret;
	boolean Endangered;
	boolean Boss;
	
	/**
	 * 
	 * @param Name nom de l'animal
	 * @param XP la valeur de XP
	 * @param Secret indiquer si c'est un Animal de type SECRET
	 * @param Endangered indiquer si c'est un Animal de type Endangered
	 * @param Boss indiquer si c'est un Animal de type BOSS
	 */
	public Animal(String Name,int XP,boolean Secret,boolean Endangered,	boolean Boss ) {
	 this.Name  =Name ;
	 this.XP = XP;
	 this.Secret = Secret;
	 this.Endangered = Endangered;
	 this.Boss = Boss;
		
		
	}

	/**les Getteurs de ces caractéristiques ***/
	@Override
	public String getName() {
		return this.Name;
	}

	@Override
	public int getXP() {
		return this.XP;
	}

	@Override
	public boolean isSecret() {
		return this.Secret;
	}

	@Override
	public boolean isEndangered() {
		return this.Endangered;
	}

	@Override
	public boolean isBoss() {
		return this.Boss;
	}

}
