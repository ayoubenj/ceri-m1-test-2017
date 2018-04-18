package fr.univavignon.rodeo.test;

import junit.framework.TestCase;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;

public class IGameStateTest extends TestCase {
	
	public IGameState getinstance () {
		IGameState ia = Mockito.mock(IGameState.class);
		
		Mockito.when(ia.exploreAreas()).thenReturn(42);
		Mockito.when(ia.catchAnimal()).thenReturn(true);
		Mockito.when(ia.getSpecieLevel()).thenReturn(42);
		Mockito.when(ia.getProgression()).thenReturn(42);
		
		return ia;
	}

	public void exploreAreas() {
		//return 0;
		
	}
	
	@Test
	public void catchAnimal(IAnimal ia) {
		//return null;
		
	}
	@Test
	public ISpecie getSpecieLevel(ISpecie is) {
		return null;
		
	}
	@Test
	public int getProgression() {
		return 0;
		
	}
	
}
