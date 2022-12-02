package it.prova.dottori.service;

import java.util.List;

import it.prova.dottori.model.Dottore;

public interface DottoreService {
	
public List<Dottore> listAll();
	
	public Dottore caricaSingoloElemento(Long id);
	
	public Dottore caricaSingoloElementoEager(Long id);

	public void aggiorna(Dottore dottoreInstance);

	public void inserisciNuovo(Dottore dottoreInstance);
	
	public Dottore cercaCodiceFiscale(String codiceFiscale);
	
	public void rimuovi(Long idToRemove);
	
	public Dottore verificaDisponibilita(String codiceDottore);
	
	public Dottore impostaDottore(Dottore dottore);

}
