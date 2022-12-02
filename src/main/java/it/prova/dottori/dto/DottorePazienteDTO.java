package it.prova.dottori.dto;

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
public class DottorePazienteDTO {

	private String codiceDottore;
	private String codFiscalePazienteAttualmenteInVisita;

	public static DottorePazienteDTO buildDottoreDTOFromModel(Dottore dottoreModel) {
		DottorePazienteDTO result = DottorePazienteDTO.builder().codiceDottore(dottoreModel.codiceDottore())
				.codFiscalePazienteAttualmenteInVisita(dottoreModel.codFiscalePazienteAttualmenteInVisita()).build();
		return result;
	}

}
