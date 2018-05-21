package fr.univavignon.rodeo.testimp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.imp.Animal;
import fr.univavignon.rodeo.imp.Specie;
import fr.univavignon.rodeo.imp.readfile;
import fr.univavignon.rodeo.test.IAnimalTest;
import fr.univavignon.rodeo.test.ISpecieTest;

public class SpecieTest extends ISpecieTest{

	public ISpecie getinstance () {
		
		IAnimal isp;
		AnimalTest iss = new AnimalTest();
		isp = iss.getinstance();
		List<IAnimal> list = new ArrayList<> ();
		list.add(isp);
		
		 ISpecie anx = new Specie(0,list, "Buffalo"); 
		
		 //list.add(isp);
		
		//anx.getAnimals();
		//anx.getArea();
		
			
		return anx;
	}

}
