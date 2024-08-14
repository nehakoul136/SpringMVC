package com.nt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.dao.EmployeeDao;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;

	@RequestMapping( "/register" )
	public String register(@ModelAttribute Employee e, Model model) {
		System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());	
		int result = dao.register(e);
		System.out.println(result +" record added.");
		model.addAttribute("message", "Registration Success");
		model.addAttribute("showDetails",false);
		model.addAttribute("showAll",false);
		return "response";
	}
	
	@RequestMapping( "/update" )
	public String UpdateSalary(Model model, @RequestParam("id") int id, @RequestParam("salary") int salary) {
		int result = dao.update( id,  salary);
		System.out.println(result +" record updated.");
		model.addAttribute("message", "Salary Update Successful");
		model.addAttribute("showDetails",false);
		model.addAttribute("showAll",false);
		return "response";
		
	}
	
	@RequestMapping( "/delete" )
	public String delete(Model model, @RequestParam("id") int id) {
		int result = dao.delete(id);
		System.out.println(result +" record deleted.");
		model.addAttribute("message", "Record Deleted Successfully");
		model.addAttribute("showDetails",false);
		model.addAttribute("showAll",false);
		return "response";
	}
	
	@RequestMapping( "/read" )
	public String read(Model model, @RequestParam("id") int id) {
		Employee e = dao.read(id);
		if(e != null) {
		model.addAttribute("message", "Employee Details:");
		model.addAttribute("showDetails",true);
		model.addAttribute("employee",e);
		}else {
		model.addAttribute("message", "Employee Not Found");
		model.addAttribute("showDetails",false);
		model.addAttribute("showAll",false);
		}	
		return "response";
		}
	
	@RequestMapping( "/readAll" )
	public String readAll(Model model) {
		List<Employee> eList = dao.readAll();
		model.addAttribute("message", "Employee Details:");
		model.addAttribute("showDetails",false);
		model.addAttribute("showAll",true);
		model.addAttribute("employee",eList);
	
		return "response";
        }
		
		
		
}
		
		
	

