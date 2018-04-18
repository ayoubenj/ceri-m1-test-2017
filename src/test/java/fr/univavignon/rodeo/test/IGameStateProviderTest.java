package fr.univavignon.rodeo.test;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;
import junit.framework.TestCase;

public class IGameStateProviderTest extends TestCase {

	public IGameStateProvider getinstance () {
		IGameStateProvider ia = Mockito.mock(IGameStateProvider.class);
		
		Mockito.when(ia.save()).thenReturn(42);
		Mockito.when(ia.get()).thenReturn(true);
		
		
		return ia;
	}
	
	@Test
	public void save(IGameState igs) {
		
	}
	@Test
	public IGameState testget(String s) {
		return null;
		
	}

}
