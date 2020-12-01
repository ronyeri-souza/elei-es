package br.com.eleicoes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.eleicoes.dao.CandidatoDAO;
import br.com.eleicoes.dao.CargoDAO;
import br.com.eleicoes.dao.VotoDAO;
import br.com.eleicoes.model.Candidato;
import br.com.eleicoes.model.Voto;


@Controller
public class MenuController { 
	 
	@Autowired
	private CargoDAO cargoDAO;
	
	@Autowired
	private CandidatoDAO candidatoDAO;
	
	@Autowired
	private VotoDAO votoDAO;
	
	@Autowired
	private Voto voto;
	
/*
 *	********** CADASTRO DE CANDIDATOS ********** 
 */
	
	// EXIBIÇÃO DA PÁGINA DE CADASTRO DE CANDIDATOS
	@GetMapping("/candidatos")
	public ModelAndView candidatos() {
		ModelAndView mv = new ModelAndView("/cadastroCandidatos");
		mv.addObject("candidato", new Candidato	());
		mv.addObject("listaCargos", cargoDAO.findAll());
		return mv;
	}
	
	// PROCESSO DE CADASTRO DE CANDIDATOS
	@PostMapping("/cadastroCandidatos")
	public ModelAndView cadastrandoCandidatos(Candidato candidato) {
		ModelAndView mv = new ModelAndView("/cadastroCandidatos");
		mv.addObject("listaCargos", cargoDAO.findAll());
		this.candidatoDAO.save(candidato);
		return candidatos();
	}
	
/*
 *	********** LISTAGEM DOS CANDIDATOS QUE FORAM CADASTRADOS ********** 
 */
	
	//LISTAGEM DOS CADASTRADOS
	@GetMapping("/listaCandidatos")
	public ModelAndView listarCandidatos() {
		ModelAndView mv = new ModelAndView("/candidatos");
		mv.addObject("listaCandidatos", candidatoDAO.findAll());
		return mv;
		
	}
	
/*
*	********** PROCESSO DE VOTO ********** 
*/
	
	// EXIBIÇÃO DA PÁGINA DE VOTO PARA PRESIDENTE
	@GetMapping("/votacao")
	public ModelAndView votacao() {
		ModelAndView mv = new ModelAndView("/votacao");
		mv.addObject("candidato", new Candidato	());
		mv.addObject("listaCandidatos", candidatoDAO.findByCargo());	
		return mv;
	}
	
	
	// PROCESSO DE VOTO PARA PRESIDENTES
	@PostMapping("/realizandoVoto")
	public ModelAndView realizandoVoto(@RequestParam(name="id") Integer id) {
		Candidato candidato = candidatoDAO.findCandidatoById(id);
		candidato.addVoto();
		candidatoDAO.save(candidato);
		voto.setPercentual(voto.getTotalVotos(), voto.getTotalEleitores());
		voto.contagemVotos(); 
		votoDAO.save(voto);
		return votacao();
	}
	
	// EXIBIÇÃO DA PÁGINA DE VOTO PARA SENADORES
	@GetMapping("/votoSenador")
	public ModelAndView votoSenador() {
		ModelAndView mv = new ModelAndView("/votoSenador");
		mv.addObject("candidato", new Candidato());
		mv.addObject("listaCandidatos", candidatoDAO.findByCargoSenador());
		return mv;
		
	}
	 
	// PROCESSO DE VOTO PARA SENADORES
	@PostMapping("/realizandoVotoSenador")
	public ModelAndView realizandoVotoSenador(@RequestParam(name="id")Integer id) {
		Candidato candidato = candidatoDAO.findCandidatoById(id);
		candidato.addVoto();
		candidatoDAO.save(candidato);
		voto.setPercentual(voto.getTotalVotos(), voto.getTotalEleitores());
		voto.contagemVotos();
		votoDAO.save(voto);
		return votoSenador();
	}
	
	// PÁGINA DE VOTAÇÃO PARA GOVERNADOR
	@GetMapping("/votoGovernador") 
	public ModelAndView votoGovernador() {
		ModelAndView mv = new ModelAndView("/votoGovernador");
		mv.addObject("candidato", new Candidato());
		mv.addObject("listaCandidatos", candidatoDAO.findByCargoGovernador());
		return mv;
	}
	
	// PROCESSO DE VOTO PARA GOVERNADOR
	@PostMapping("/realizandoVotoGovernador")
	public ModelAndView realizandoVotoGovernador(@RequestParam(name="id") Integer id) {
		Candidato candidato = candidatoDAO.findCandidatoById(id);
		candidato.addVoto();
		candidatoDAO.save(candidato);
		voto.setPercentual(voto.getTotalVotos(), voto.getTotalEleitores());
		voto.contagemVotos();
		votoDAO.save(voto);
		return votoGovernador();
	}
		
	// PÁGINA DE VOTAÇÃO PARA DEPUTADO ESTADUAL
	@GetMapping("/votoDepEstadual")
	public ModelAndView votoDepEstadual() {
		ModelAndView mv = new ModelAndView("/votoDepEstadual");
		mv.addObject("candidato", new Candidato());
		mv.addObject("listaCandidatos", candidatoDAO.findByCargoDepEstadual());
		return mv;
		
	}
	
	// PROCESSO DE VOTAÇÃO PARA DEPUTADO ESTADUAL
	@PostMapping("/realizandoVotoDepEstadual")
	public ModelAndView realizandoVotoDepEstadual(@RequestParam(name="id") Integer id) {
		Candidato candidato = candidatoDAO.findCandidatoById(id);
		candidato.addVoto();
		candidatoDAO.save(candidato);
		voto.setPercentual(voto.getTotalVotos(), voto.getTotalEleitores());
		voto.contagemVotos();
		votoDAO.save(voto);
		return votoDepEstadual();
	}
	
	// PÁGINA DE VOTAÇÃO PARA DEPUTADO FEDERAL
	@GetMapping("/votoDepFederal")
	public ModelAndView votoDepFederal() {
		ModelAndView mv = new ModelAndView("/votoDepFederal");
		mv.addObject("candidato", new Candidato());
		mv.addObject("listaCandidatos", candidatoDAO.findByCargoDepFederal());
		return mv;
	}
	
	// PROCESSO DE VOTAÇÃO PARA DEPUTADO FEDERAL
	@PostMapping("/realizandoVotoDepFederal")
	public ModelAndView realizandoVotoDepFederal(@RequestParam(name="id") Integer id) {
		Candidato candidato = candidatoDAO.findCandidatoById(id);
		candidato.addVoto();
		candidatoDAO.save(candidato);
		voto.setPercentual(voto.getTotalVotos(), voto.getTotalEleitores());
		voto.contagemVotos();
		votoDAO.save(voto);
		return votoDepFederal();
	}

/*
 * ********** APURAÇÃO DE VOTOS *********** 
 */
	
	
	// APURAÇÃO GERAL DE VOTOS
	@GetMapping("/apuracaoVotos")
	public ModelAndView apuracaoVotos() {
		ModelAndView mv = new ModelAndView("/acompanharApuracao");
		mv.addObject("listaCandidatos", candidatoDAO.findAll());
		mv.addObject("percentual", votoDAO.findPercentual());
		mv.addObject("totalEleitores", votoDAO.findTotalEleitores());
		mv.addObject("totalVotos", votoDAO.findTotalVotos());
		return mv;							
	}

	
	/** CONTROLLERS EM DESUSO
	 
	// APURAÇÃO PARA PRESIDENTE
	@GetMapping("/apuracaoPresidente")
	public ModelAndView apuracaoPresidente() {
		ModelAndView mv = new ModelAndView("/apuracaoPresidente");
		mv.addObject("listaCandidatos", candidatoDAO.findByCargo());
		mv.addObject("percentual", votoDAO.findPercentual());
		return mv;		
	}
	
	// APURAÇÃO PARA GOVERNADOR
	@GetMapping("/apuracaoGovernador")
	public ModelAndView apuracaoGovernador() {
		ModelAndView mv = new ModelAndView("/apuracaoGovernador");
		mv.addObject("listaCandidatos", candidatoDAO.findByCargoGovernador());
		return mv;
	}
	
	// APURAÇÃO PARA SENADOR
	@GetMapping("/apuracaoSenador")
	public ModelAndView apuracaoSenador() {
		ModelAndView mv = new ModelAndView("/apuracaoSenador");
		mv.addObject("listaCandidatos", candidatoDAO.findByCargoSenador());
		return mv;
	}
		
	// APURAÇÃO PARA DEPUTADO ESTADUAL
	@GetMapping("/apuracaoDepEstadual")
	public ModelAndView apuracaoDepEstadual() {
		ModelAndView mv = new ModelAndView("/apuracaoDepEstadual");
		mv.addObject("listaCandidatos", candidatoDAO.findByCargoDepEstadual());
 		mv.addObject("percentual", votoDAO.findPercentual());
		return mv;			
	}
			
	// APURAÇÃO PARA DEPUTADO FEDERAL
	@GetMapping("/apuracaoDepFederal")
	public ModelAndView apuracaoDepFederal() {
		ModelAndView mv = new ModelAndView("/apuracaoDepFederal");
		mv.addObject("listaCandidatos", candidatoDAO.findByCargoDepFederal());
		return mv;						
	} 
*/
}
