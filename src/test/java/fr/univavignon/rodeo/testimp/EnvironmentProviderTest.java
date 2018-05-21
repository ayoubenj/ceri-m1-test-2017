package fr.univavignon.rodeo.testimp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IEnvironmentProvider;
import fr.univavignon.rodeo.imp.EnvironmentProvider;
import fr.univavignon.rodeo.imp.readfile;
import fr.univavignon.rodeo.test.IEnvironmentProviderTest;


public class EnvironmentProviderTest extends IEnvironmentProviderTest  {

	readfile rf = new readfile();
	public IEnvironmentProvider getinstance () {
		EnvironmentProvider an = new EnvironmentProvider("Savannah");
		an.getEnvironment(rf.envchoisit);
		an.getAvailableEnvironments();
			
		return an;
	}

}
