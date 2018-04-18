package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;

public class Environment implements IEnvironment {

	String Name;
	int Areas;
	List<ISpecie> listspecie;
	
	public Environment (String Name, int Area) {
		this.Name = Name;
		this.Areas = Area;
		listspecie = new ArrayList<ISpecie>(20);
		//...
		
	}
	
	@Override
	public String getName() {
		return this.Name;
	}

	@Override
	public int getAreas() {
		return this.Areas;
	}

	@Override
	public List<ISpecie> getSpecies() {
		return this.listspecie;
	}

}
