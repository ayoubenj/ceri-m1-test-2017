package fr.univavignon.rodeo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.readfile;
import junit.framework.TestCase;

public class IEnvironmentProviderTest extends TestCase {
	
	IEnvironment iee;
	public IEnvironmentProvider getinstance () {
		//readfile rf = new readfile();
		IEnvironmentProvider ia = Mockito.mock(IEnvironmentProvider.class);
		 List<String> list = new ArrayList<>();
		 list.add("aaa");
		 list.add("bbb");
		 IEnvironmentTest ie = new IEnvironmentTest();
		 iee = ie.getinstance();
		 
		Mockito.when(ia.getAvailableEnvironments()).thenReturn(list);
		
		Mockito.when(ia.getEnvironment("Savannah")).thenReturn(iee);
		
		
		return ia;
	}
	@Test
	public void testgetAvailableEnvironments() {
		
		IEnvironmentProvider tester = getinstance();
		assertEquals(tester.getAvailableEnvironments().size(), 2);
		
	}
	@Test
	public void testgetEnvironment() {
	
		
		IEnvironmentProvider tester = getinstance();
		assertEquals(tester.getEnvironment("Savannah"),this.iee );
	}
}
