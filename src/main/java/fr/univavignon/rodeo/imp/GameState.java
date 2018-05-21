package fr.univavignon.rodeo.imp;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

/**
 * @author ENJOUMI AYOUB & BENHACHANI MOHAMMED 
 * 
 * GameState classe pour représenter, gérer l'état du jeu
 */

public class GameState implements IGameState {

	String Name;
	int Progression;
	readfile rf =new readfile();
	
	/**
	 * Construct Constructeur de la classe 
	 * @param Progression du jeu en (%)
	 * @param name nom de l'animale
	 */
	public GameState(int Progression, String name) {
		this.Name = Name;
		this.Progression = Progression;
		
	}
	
	/**
	 * Getteur 
	 */
	@Override
	public String getName() {
		return this.Name;
	}

	/**
	 * Method exploreArea permettant de débloquer un nouveau environnement. 
	 * Pour que tous les animaux de cet environnement sont débloqué 
	 * throwing an IllegalStateException otherwise.
	 * 
	 * @throws IllegalStateException If the area cannot be explored.
	 */
	
	@Override
	public void exploreArea() throws IllegalStateException {
		

	}

	/**
	 * Method catchAnimal permettant de rendre un animal disponible, capturé 
	 * en l'ajoutant dans le fichier de sauvegarde
	 * 
	 * @param animal Animale à capturer
	 * @throws IllegalArgumentException If the given <tt>animal</tt> is <tt>null</tt>.
	 * @throws IllegalStateException If the given <tt>animal</tt> can not be found in current areas.
	 */
	
	@Override
	public void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException {

		rf.load().put(animal.getName(), rf.informer(rf));
		System.out.println("liste "+rf.lanimalee);

	}

	/**
	 * Method getSpecieLevel récupérer le niveau d'une espéce.
	 * 
	 * @param specie l'espéce en question.
	 * @return niveau de l'espéce courant.
	 * @throws IllegalArgumentException If the given <tt>specie</tt> is <tt>null</tt>
	 */
	@Override
	public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(getProgression()<25 && getProgression()>0)
			return SpecieLevel.NOVICE;
		if(getProgression()>=25 && getProgression()<150 )
			return SpecieLevel.WRANGLER;
		if(getProgression()>=150 && getProgression()<600 )
			return SpecieLevel.NOVICE;
		if(getProgression()>=600)
			return SpecieLevel.MASTER;
		return null;

	}

	/**
	 * Method getProgression permettant de
	 * retourne progression du jeu en pourcentage. 
	 * 
	 * @return le nombre tortal de la progression du jeu en pourcentage.
	 */
	
	@Override
	public int getProgression() {
		return this.Progression;
	}

}
