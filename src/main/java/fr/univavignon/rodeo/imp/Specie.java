package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;

public class Specie implements ISpecie {

	readfile rf = new readfile();
	String Name ;
	List<IAnimal> lia;
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
	
	@Override
	public int getArea() {//in which area can be found current spece
		System.out.println(rf.larea.size() + "/ " + this.getName() );
		for(int i=0;i<rf.larea.size();i++) {
			//System.out.println(rf.lspecies.get(i));
			if(rf.lspecies.get(i).contains(this.getName()))
				return rf.larea.get(i);
			
		}
				
		
		// TODO Auto-generated method stub
		return 0; //The area in which this specie can be found from.
	}

	//List of available animal for this specie. //liste animaux slon espéce
	@Override
	public List<IAnimal> getAnimals() {
		//nouvelle liste de ianimal
		lia = new ArrayList<>();
		//pour chaque animal
		for(int i=0; i<rf.lanimal.size();i++) {
			
			if(rf.lspecies.get(i).contains(this.getName())) {
				//if(rf.anims.contains(rf.lanimal.get(i))){
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
			//	}
			}
			
		}
		
		
		// TODO Auto-generated method stub
		return lia;
	}

	@Override
	public String getName() {
		System.out.println("here" + Name);
		if(rf.currspecie.isEmpty())
			return this.Name;
		else
			return rf.currspecie;
		// TODO Auto-generated method stub
		//return null;
	}

}
