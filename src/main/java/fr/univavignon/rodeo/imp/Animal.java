package fr.univavignon.rodeo.imp;

import fr.univavignon.rodeo.api.IAnimal;

public class Animal implements IAnimal {
	
	String Name;
	int XP;
	boolean Secret;
	boolean Endangered;
	boolean Boss;
	
	public Animal(String Name,int XP,boolean Secret,boolean Endangered,	boolean Boss ) {
	 this.Name  =Name ;
	 this.XP = XP;
	 this.Secret = Secret;
	 this.Endangered = Endangered;
	 this.Boss = Boss;
		
		
	}

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
