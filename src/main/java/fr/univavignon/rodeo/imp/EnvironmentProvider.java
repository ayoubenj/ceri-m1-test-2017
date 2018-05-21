package fr.univavignon.rodeo.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;

/**
 * @author ENJOUMI AYOUB & BENHACHANI MOHAMMED 
 * 
 * Animal classe comme point d'entrée, obtention des environnements  
 */

public class EnvironmentProvider implements IEnvironmentProvider {


	
	IEnvironment ie ;
	readfile rf = new readfile();

	/**
	 * Method permettant de récuppérer, remplir
	 * une liste des noms distinct des environnements et la retourner.
	 * 
	 * @return list qui est la liste noms des environnements.
	 */
	public EnvironmentProvider(String name, IEnvironment ie ) {
		rf.envchoisit =name;
		this.ie = ie;
		
	}
	@Override
	public List<String> getAvailableEnvironments() {
		Collection<String> list = rf.lenvname; 
		List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
		return distinctElements;
	}
	
	/**
	 *  Method permettant de récuppérer un environnement
	 * si le nom entrée en paramétre est dans la liste des environnements disponible.
	 * 
	 * @param name le nom de l'environnement recherché
	 * @return environnement si disponible , null sinon
	 * @throws IllegalArgumentException If the given <tt>name</tt> is null.
	 */

	@Override
	public IEnvironment getEnvironment(String name) throws IllegalArgumentException {
		for(int i=0; i<getAvailableEnvironments().size(); i++ ) {
			if(getAvailableEnvironments().get(i).contains(name))
				ie =new Environment(name);
				return ie;
		}
		
		return ie;
	}

}
