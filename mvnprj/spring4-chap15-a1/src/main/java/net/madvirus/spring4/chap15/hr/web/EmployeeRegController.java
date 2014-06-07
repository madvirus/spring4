package net.madvirus.spring4.chap15.hr.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.madvirus.spring4.chap15.hr.model.Employee;
import net.madvirus.spring4.chap15.hr.service.DuplicateEmpNumberException;
import net.madvirus.spring4.chap15.hr.service.EmployeeRegistryService;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeRegController {

	private EmployeeRegistryService employeeRegistryService;

	@ModelAttribute("newEmployee")
	public Employee formBacking() {
		return new Employee();
	}

	@RequestMapping(value = "/hr/employee/register", method = RequestMethod.GET)
	public String regForm() {
		return "employee/registrationForm";
	}

	@RequestMapping(value = "/hr/employee/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("newEmployee") Employee newEmployee, BindingResult errors) {
		new NewEmployeeValidator().validate(newEmployee, errors);
		if (errors.hasErrors()) {
			return "employee/registrationForm";
		}
		try {
			employeeRegistryService.register(newEmployee);
			return "employee/registrationDone";
		} catch (DuplicateEmpNumberException ex) {
			errors.rejectValue("number", "duplicate");
			return "employee/registrationForm";
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new NewEmployeeValidator());
		CustomDateEditor dateEditor =
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);

	}

	public void setEmployeeRegistryService(EmployeeRegistryService employeeRegistryService) {
		this.employeeRegistryService = employeeRegistryService;
	}

}
