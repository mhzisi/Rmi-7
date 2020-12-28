package exercice3;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;

public class CompteServeur extends UnicastRemoteObject implements CompteInterface
	{
		private double solde;
		
		public CompteServeur(double s) throws java.rmi.RemoteException
			{
				solde=s;
			}

		public void crediter(double montant) throws java.rmi.RemoteException
			{
				solde=solde+montant;
			}
		
		public void debiter(double montant) throws java.rmi.RemoteException
			{
				solde=solde-montant;
			}
		
		public double lire_solde() throws java.rmi.RemoteException
			{
				return solde;
			}
		
		public static void main(String[] args) throws RemoteException, MalformedURLException 
			{
	        	CompteServeur s = new CompteServeur(30);
	        	java.rmi.registry.LocateRegistry.createRegistry(1200);
	        	Naming.rebind("rmi://127.0.0.1:1200/server", s);        	
			}
} 
