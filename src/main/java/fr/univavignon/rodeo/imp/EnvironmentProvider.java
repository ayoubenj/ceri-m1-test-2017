package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;

public class EnvironmentProvider implements IEnvironmentProvider {

	//List<String> listprovider;
	IEnvironment ie =null;
	//IEnvironment ie ;
	readfile rf = new readfile();
	public EnvironmentProvider() {
		
		//listprovider =new ArrayList<String>(20);
		
	}
	@Override
	public List<String> getAvailableEnvironments() {
		Collection<String> list = rf.lenvname;
		 
		// Get collection without duplicate i.e. distinct only
		List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
		// TODO Auto-generated method stub
		return distinctElements;
	}

	@Override
	public IEnvironment getEnvironment(String name) throws IllegalArgumentException {
		for(int i=0; i<getAvailableEnvironments().size(); i++ ) {
			if(getAvailableEnvironments().get(i).contains(name))
				ie =new Environment(name);
				return ie;
		}
		return ie;
		
		// TODO Auto-generated method stub
		//return null;
	}

}
