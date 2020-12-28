package exercice3;

import java.io.*;
import java.rmi.*;

public class CompteClient
{
	public static void main (String [] arg) throws IOException
		{
			System.out.println("Arguments : Operation et Montant souhaité");
			System.out.println("Operations : 1 pour crediter, 2 pour debiter");
			System.out.println("Montant : la saisie d'un montant");
			
			if(arg.length != 2)
			{
				System.out.println("essayer : java CompteClient <num_operation><montant>");
				System.exit(1);
			}
			
			int operation = Integer.parseInt(arg[0]);
			double valeur = Double.parseDouble(arg[1]);


			try 
			{
				CompteInterface cpt= (CompteInterface) Naming.lookup("rmi://127.0.0.1:1200/Compteserveur"); 
				if (operation==1) 
					cpt.crediter(valeur);
				
				if (operation ==2) 
					cpt.debiter(valeur);
				
				System.out.println ("Votre solde courant = " +cpt.lire_solde() + " DT");


			}
			catch (Exception e)
			{
				System.out.println("Erreur");
				System.out.println(e.toString());
			}
		}
} 
