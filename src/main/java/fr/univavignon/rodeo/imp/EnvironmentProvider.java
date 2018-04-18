package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;

public class EnvironmentProvider implements IEnvironmentProvider {

	List<String> listprovider;
	//IEnvironment ie ;
	
	public EnvironmentProvider() {
		
		listprovider =new ArrayList<String>(20);
		
	}
	@Override
	public List<String> getAvailableEnvironments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEnvironment getEnvironment() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
