package fr.meuh.CRUDJson.sauvegarde;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.meuh.CRUDJson.entites.Chaussure;
import fr.meuh.CRUDJson.entites.Fabricant;
import fr.meuh.CRUDJson.entites.Vetement;

public class TestEnregistreur {
	
	@Test
	public void testFonctionnementClassique() throws Exception{
		
		Enregistreur enregistreur = new Enregistreur();
		
		//On charge la liste actuelle des V�temetents
		List <Vetement> dressing1 = enregistreur.lireTous();
		
		//On instancie un nouveau v�tement
		Chaussure chaussure = new Chaussure();
		chaussure.setTaille(37);
		chaussure.setCouleur("Rouge");
		chaussure.setLongueurLacet(25);
		
		Fabricant fabricant = new Fabricant();
		fabricant.setNom("Prada");
		chaussure.setFabricant(fabricant);
		
		//On sauvegarde ce v�tement
		enregistreur.enregistrer(chaussure);
		
		//On v�rifie que la liste a pris en compte ce v�tement
		List <Vetement> dressing2 = enregistreur.lireTous();
		Assert.assertEquals("Le nouvea dressing � un �l�ment de plus", dressing1.size() + 1, dressing2.size());
		
		//On modifie ce v�tement on le sauvgarde 
		chaussure.setTaille(40);
        enregistreur.enregistrer(chaussure);
        
		//On v�rifie que la liste a pris en compte la modification
		
		//On supprime le v�tement 
		enregistreur.supprimer(chaussure);
		
		//On v�rifie que la liste a pris en compte la suppression
		List <Vetement> dressing3 = enregistreur.lireTous();
		Assert.assertEquals("Les deux dressing doivent avoir le m�me nombre d'�l�ment", dressing1.size() , dressing3.size());
		
	}
	
}
