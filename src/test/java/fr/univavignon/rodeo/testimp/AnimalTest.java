package fr.univavignon.rodeo.testimp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.imp.Animal;
import fr.univavignon.rodeo.test.IAnimalTest;

public class AnimalTest extends IAnimalTest  {

	public IAnimal getinstance () {
		Animal an = new Animal("moha", 42, true, true, true);
			
		return an;
	}

}
