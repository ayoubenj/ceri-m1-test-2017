package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;

public class Environment implements IEnvironment {

	public static String Name;
	int cmptarea ;
	readfile rf = new readfile();
	List<ISpecie> listspecie;
	
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
	
	@Override
	public String getName() {
		return this.Name;
	}

	@Override
	public int getAreas() {
		return this.cmptarea;
		//return 0;
	}

	//List of species available
	@Override
	public List<ISpecie> getSpecies() {
		//ISpecie is = new Specie();
		return this.listspecie;
	}

}
