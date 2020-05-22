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

import ro.dao.UserDAO;
import ro.pojo.User;

@Controller
public class UserController {


	@RequestMapping(value="user.htm")
	public ModelAndView afisareConturi() throws SQLException
	{
		
		ArrayList<User> users = UserDAO.getAllUsers();
		ModelMap model = new ModelMap();
		model.put("users", users);
		return new ModelAndView("/WEB-INF/lista-user.jsp",
				"model", model);
	}
	

	@RequestMapping(value = "user-detalii.htm")
	public ModelAndView afisareDetalii(@RequestParam Integer id) throws SQLException {
		
		User c = UserDAO.getUserById(id);
		
		ModelMap model = new ModelMap();
		model.put("user", c);
		
		return new ModelAndView("/WEB-INF/detalii-user.jsp", "model", model);
	}
	
	@RequestMapping(value="user-edit.htm")
	public ModelAndView contEdit(@RequestParam Integer id,Model model) throws SQLException {
		User c=UserDAO.getUserById(id);
		model.addAttribute("userForm", c);
		return new ModelAndView("/WEB-INF/editare-user.jsp","model",model);
	}
	
	@RequestMapping(value="user-save.htm", method=RequestMethod.POST)
	public ModelAndView saveCont(@ModelAttribute("userForm") User user, ModelMap model, BindingResult result) {	
		
		model.put("mesaj","");
		User contObj;
		try {
			contObj = UserDAO.getUserById(user.getId());
			contObj.setNume(user.getNume());
			contObj.setEmail(user.getEmail());
			contObj.setTelefon(user.getTelefon());
			contObj.setAdresa(user.getAdresa());
			UserDAO.updateUser(contObj);
			model.put("userForm", user);
			model.put("mesaj","Modificarea a fost salvata");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("/WEB-INF/editare-user.jsp","model",model);		
	}
	
	
	@RequestMapping(value = "/user-delete.htm")
	public ModelAndView deleteCont(@RequestParam Integer id, Model model)
			throws NumberFormatException, SQLException {

		UserDAO.deleteUser(id);
		ArrayList<User> users=UserDAO.getAllUsers();
		model.addAttribute("users", users);
		return new ModelAndView("/WEB-INF/lista-user.jsp", "model",model);
	}

	@RequestMapping(value = "/user-add.htm")
	public ModelAndView adaugaUser(Model model) throws NumberFormatException, SQLException {

		User user = new User();
		model.addAttribute("userForm", user);

		return new ModelAndView("/WEB-INF/add-user.jsp", "model", model);
	}

	@RequestMapping(value = "/user-add-save.htm", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userForm") User user, ModelMap model, BindingResult result) {

		try {
			UserDAO.insert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/user.htm");
	}
	
}
