package fr.univavignon.rodeo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;
import junit.framework.TestCase;

public class IEnvironmentProviderTest extends TestCase {
	
	IEnvironment iee;
	public IEnvironmentProvider getinstance () {
		IEnvironmentProvider ia = Mockito.mock(IEnvironmentProvider.class);
		 List<String> list = new ArrayList<String> (20);
		 list.add("aaa");
		 list.add("bbb");
		 IEnvironmentTest ie = new IEnvironmentTest();
		 iee = ie.getinstance();
		 
		Mockito.when(ia.getAvailableEnvironments()).thenReturn(list);
		
		Mockito.when(ia.getEnvironment()).thenReturn(iee);
		
		
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
		assertEquals(tester.getEnvironment(),this.iee );
	}
}
