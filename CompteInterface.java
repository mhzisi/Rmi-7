package exercice3;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CompteInterface extends java.rmi.Remote
	{
		void debiter(double montant) throws java.rmi.RemoteException;
		void crediter(double montant) throws java.rmi.RemoteException;
		double lire_solde() throws java.rmi.RemoteException;
};