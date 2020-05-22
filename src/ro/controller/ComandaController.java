package ro.controller;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.dao.ComandaDAO;
import ro.pojo.Comanda;

@Controller
public class ComandaController {


	@RequestMapping(value="comanda.htm")
	public ModelAndView afisareConturi() throws SQLException
	{
		
		ArrayList<Comanda> comenzi = ComandaDAO.getAllComanda();
		ModelMap model = new ModelMap();
		model.put("comenzi", comenzi);
		return new ModelAndView("/WEB-INF/lista-comanda.jsp",
				"model", model);
	}
	

	@RequestMapping(value = "comanda-detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException {
		
		Comanda c = ComandaDAO.getComandaById(id);
		
		ModelMap model = new ModelMap();
		model.put("comanda", c);
		
		return new ModelAndView("/WEB-INF/detalii-comenzi.jsp", "model", model);
	}
	
	@RequestMapping(value="comanda-edit.htm")
	public ModelAndView contEdit(@RequestParam Integer id,Model model) throws SQLException {
		Comanda c=ComandaDAO.getComandaById(id);
		model.addAttribute("comandaForm", c);
		return new ModelAndView("/WEB-INF/editare-comanda.jsp","model",model);
	}
	
	@RequestMapping(value="comanda-save.htm", method=RequestMethod.POST)
	public ModelAndView saveCont(@ModelAttribute("comandaForm") Comanda comanda, ModelMap model, BindingResult result) {	
		
		model.put("mesaj","");
		Comanda contObj;
		try {
			contObj = ComandaDAO.getComandaById(comanda.getId());
			contObj.setUserId(comanda.getUserId());
			contObj.setMeniuId(comanda.getMeniuId());
			contObj.setDataComanda(comanda.getDataComanda());
			ComandaDAO.updateComanda(contObj);
			model.put("comandaForm", comanda);
			model.put("mesaj","Comanda a fost salvata");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("/WEB-INF/editare-comanda.jsp","model",model);		
	}
	
	
	@RequestMapping(value = "/comanda-delete.htm")
	public ModelAndView deleteCont(@RequestParam Integer id, Model model)
			throws NumberFormatException, SQLException {

		ComandaDAO.deleteComanda(id);
		ArrayList<Comanda> comanda=ComandaDAO.getAllComanda();
		model.addAttribute("comenzi", comanda);
		return new ModelAndView("/WEB-INF/lista-comanda.jsp", "model",model);
	}

	@RequestMapping(value = "/comanda-add.htm")
	public ModelAndView adaugaComanda(Model model) throws NumberFormatException, SQLException {

		Comanda comanda = new Comanda();
		model.addAttribute("comandaForm", comanda);

		return new ModelAndView("/WEB-INF/add-comenzi.jsp", "model", model);
	}

	@RequestMapping(value = "/comanda-add-save.htm", method = RequestMethod.POST)
	public ModelAndView addComanda(@ModelAttribute("comandaForm") Comanda comanda, ModelMap model, BindingResult result) {

		try {
			ComandaDAO.insert(comanda);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/comanda.htm");
	}
	
}
