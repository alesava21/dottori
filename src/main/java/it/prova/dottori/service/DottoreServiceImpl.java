package it.prova.dottori.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dottori.model.Dottore;
import it.prova.dottori.repository.DottoreRepository;

@Service
@Transactional(readOnly = true)
public class DottoreServiceImpl implements DottoreService {

	@Autowired
	DottoreRepository dottoreRepository;

	@Override
	public List<Dottore> listAll() {
		return (List<Dottore>) dottoreRepository.findAll();
	}

	@Override
	public Dottore caricaSingoloElemento(Long id) {
		return dottoreRepository.findById(id).orElse(null);
	}

	@Override
	public Dottore caricaSingoloElementoEager(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Dottore dottoreInstance) {
		dottoreRepository.save(dottoreInstance);

	}

	@Override
	public void inserisciNuovo(Dottore dottoreInstance) {
		dottoreRepository.save(dottoreInstance);

	}

	@Override
	public void rimuovi(Long idToRemove) {
		dottoreRepository.deleteById(idToRemove);

	}

	@Override
	public Dottore cercaCodiceFiscale(String codiceFiscale) {
		return dottoreRepository.findBycodFiscalePazienteAttualmenteInVisita(codiceFiscale);
	}

	@Override
	public Dottore verificaDisponibilita(String codiceDottore) {
		return dottoreRepository.findBycodiceDottore(codiceDottore);
	}

	@Override
	public Dottore impostaDottore(Dottore dottore) {
		Dottore result = dottoreRepository.findBycodiceDottore(dottore.codiceDottore());
		result.codFiscalePazienteAttualmenteInVisita(null);
		return dottoreRepository.save(result);
	}

	@Override
	public Dottore ricoverato(Dottore dottore) {
		Dottore result = dottoreRepository.findBycodiceDottore(dottore.codiceDottore());
		result.codFiscalePazienteAttualmenteInVisita(null);
		result.inVisita(false);
		return dottoreRepository.save(result);
	}

}
