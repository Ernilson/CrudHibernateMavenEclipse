package br.com.Testes;

import java.util.List;

import br.com.cad.model.CadastroModel;
import br.com.cad.repository.CadRepository;

public class Testes {

	public static void main(String[] args) {
		
		CadastroModel cm = new CadastroModel();
		 CadRepository rep = new CadRepository();
		
		cm.setNome("teste3");
		cm.setFone("1234567");
		cm.setEmail("teste@teste.com");
		
		//rep.saveCadastro(cm);
		
		// alterar----------------------------
		
		//cm.setNome("Daniel");
		//rep.updateCad(cm);
		
//-------------------busca por id------------
		// CadastroModel teste3 = rep.getByID(cm.getId());
		
// --------------lista todos -------------------------------
		List<CadastroModel> cad = rep.getAll(); 
		cad.forEach(cmd -> System.out.println(cm.getId()));
	}

}
