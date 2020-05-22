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
import ro.dao.MeniuDAO;
import ro.pojo.Meniu;

@Controller
public class MeniuController {

	@RequestMapping(value = "meniu.htm")
	public ModelAndView afisareConturi() throws SQLException {

		ArrayList<Meniu> meniuri = MeniuDAO.getAllMeniu();
		ModelMap model = new ModelMap();
		model.put("meniuri", meniuri);
		return new ModelAndView("/WEB-INF/lista-meniu.jsp", "model", model);
	}

	@RequestMapping(value = "meniu-detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException {

		Meniu c = MeniuDAO.getMeniuById(id);

		ModelMap model = new ModelMap();
		model.put("meniu", c);

		return new ModelAndView("/WEB-INF/detalii-meniu.jsp", "model", model);
	}

	@RequestMapping(value = "meniu-edit.htm")
	public ModelAndView contEdit(@RequestParam Integer id, Model model) throws SQLException {
		Meniu c = MeniuDAO.getMeniuById(id);
		model.addAttribute("meniuForm", c);
		return new ModelAndView("/WEB-INF/editare-meniu.jsp", "model", model);
	}

	@RequestMapping(value = "meniu-save.htm", method = RequestMethod.POST)
	public ModelAndView saveCont(@ModelAttribute("meniuForm") Meniu meniu, ModelMap model, BindingResult result) {

		model.put("mesaj", "");
		Meniu contObj;
		try {
			contObj = MeniuDAO.getMeniuById(meniu.getId());
			contObj.setPret(meniu.getPret());
			contObj.setDescriere(meniu.getDescriere());
			contObj.setAlergeni(meniu.getAlergeni());
			MeniuDAO.updateMeniu(contObj);
			model.put("meniuForm", meniu);
			model.put("mesaj", "Modificarea a fost salvat");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("/WEB-INF/editare-meniu.jsp", "model", model);
	}

	@RequestMapping(value = "/meniu-delete.htm")
	public ModelAndView deleteCont(@RequestParam Integer id, Model model) throws NumberFormatException, SQLException {

		MeniuDAO.deleteMeniu(id);
		ArrayList<Meniu> meniu = MeniuDAO.getAllMeniu();
		model.addAttribute("meniuri", meniu);
		return new ModelAndView("/WEB-INF/lista-meniu.jsp", "model", model);
	}

	@RequestMapping(value = "/meniu-add.htm")
	public ModelAndView adaugaMeniu(Model model) throws NumberFormatException, SQLException {

		Meniu meniu = new Meniu();
		model.addAttribute("meniuForm", meniu);

		return new ModelAndView("/WEB-INF/add-meniu.jsp", "model", model);
	}

	@RequestMapping(value = "/meniu-add-save.htm", method = RequestMethod.POST)
	public ModelAndView addMeniu(@ModelAttribute("meniuForm") Meniu meniu, ModelMap model, BindingResult result) {

		try {
			MeniuDAO.insert(meniu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/meniu.htm");
	}

}
