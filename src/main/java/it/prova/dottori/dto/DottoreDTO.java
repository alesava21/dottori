package it.prova.dottori.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.dottori.model.Dottore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DottoreDTO {
	
	private Long id;
	private String nome;
	private String cognome;
	private String codiceDottore;
	private String codFiscalePazienteAttualmenteInVisita;
	private boolean inVisita;
	private boolean inServizio;
	
	public Dottore buildDottoreModel() {
		Dottore result = Dottore.builder()
				.id(id)
				.nome(nome)
				.cognome(cognome)
				.codiceDottore(codiceDottore)
				.codFiscalePazienteAttualmenteInVisita(codFiscalePazienteAttualmenteInVisita)
				.inServizio(inServizio)
				.inVisita(inVisita)
				.build();
		return result;
	}
	
	public static DottoreDTO buildDottoreDTOFromModel(Dottore dottoreModel) {
		DottoreDTO result = DottoreDTO.builder()
				.id(dottoreModel.id())
				.nome(dottoreModel.nome())
				.cognome(dottoreModel.cognome())
				.codiceDottore(dottoreModel.codiceDottore())
				.codFiscalePazienteAttualmenteInVisita(dottoreModel.codFiscalePazienteAttualmenteInVisita())
				.inServizio(dottoreModel.inServizio())
				.inVisita(dottoreModel.inVisita())
				.build();
		return result;
	}
	
	public static List<DottoreDTO> createListDTOFromModel(List<Dottore> listaDottoreModel){
		return listaDottoreModel.stream().map(doc -> {
			return DottoreDTO.buildDottoreDTOFromModel(doc);
		}).collect(Collectors.toList());
	}
	
	public static List<Dottore> createModelListFromDTO(List<DottoreDTO> listaDottoreDTO){
		return listaDottoreDTO.stream().map(doc -> {
			return doc.buildDottoreModel();
		}).collect(Collectors.toList());
	}
}
