package peupleur;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.Action;
import modele.Role;
import modele.Utilisateur;

public class Peupleur {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("peuplement");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//---------------------------------------------------------------------------------------------
		
		Action action1 = new Action("action", "description", new Date(),"modifie");
		Role role1 = new Role("role", "description", new Date(), "modifie");
		Utilisateur user1 = new Utilisateur("mail", "mdp", "Djeffal", "Nabil", new Date(), "modifie");
		
		role1.ajoutAction(action1);
		role1.ajoutUtilisateur(user1);
				
		em.persist(role1);
	
		//---------------------------------------------------------------------------------------------
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
