package com.example.hrms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hrms.dto.AdminInfoDto;
import com.example.hrms.dto.EnquiryDto;
import com.example.hrms.dto.UserDto;
import com.example.hrms.model.AdminInfo;
import com.example.hrms.model.Enquiry;
import com.example.hrms.model.User;
import com.example.hrms.repo.AdminInfoRepo;
import com.example.hrms.repo.EnquiryRepo;
import com.example.hrms.repo.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	EnquiryRepo erepo; // variable of enquiryRepo interface

	@Autowired
	UserRepo urepo;

	@Autowired
	AdminInfoRepo airepo;

	@GetMapping("/")
	public String showIndex() {
		return "index";
	}

	@GetMapping("/aboutus")
	public String showAboutUs() {
		return "aboutus";
	}

	@GetMapping("/registration")
	public String showRegistration(Model model) {
		UserDto udto = new UserDto();
		model.addAttribute("udto", udto);
		return "registration";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String userDashboard(@RequestParam String emailaddress, @RequestParam String pwd, HttpSession session,
			RedirectAttributes redirectAttributes) {

		Optional<User> user = urepo.findByEmailaddressAndPwd(emailaddress, pwd);

		if (user.isPresent()) {
			session.setAttribute("user", user.get());
			return "redirect:/user/userdash";
		}

		redirectAttributes.addFlashAttribute("msg", "Invalid email or password");
		return "redirect:/login";
	}

	@GetMapping("/contactus")
	public String contactUs(Model model) {

		EnquiryDto edto = new EnquiryDto();
		model.addAttribute("edto", edto);
		return "contactus";
	}

	@PostMapping("/contactus")
	public String saveEnquiry(@ModelAttribute EnquiryDto edto, RedirectAttributes attrib) {
		Enquiry enq = new Enquiry();
		enq.setName(edto.getName());
		enq.setAddress(edto.getAddress());
		enq.setContact_no(edto.getContact_no());
		enq.setEmailaddress(edto.getEmailaddress());
		enq.setEnquirytext(edto.getEnquirytext());
		erepo.save(enq);
		attrib.addFlashAttribute("msg", "Enquiry is saved");
		return "redirect:/contactus";
	}

	@PostMapping("/registration")
	public String saveJobSeeker(@ModelAttribute UserDto udto, RedirectAttributes attrib) {

		User user = new User();
		user.setName(udto.getName());
		user.setGender(udto.getGender());
		user.setContactno(udto.getContactno());
		user.setEmailaddress(udto.getEmailaddress());
		user.setPwd(udto.getPwd());
		user.setQualification(udto.getQualification());
		user.setExperience(udto.getExperience());
		user.setKeyskill(udto.getKeyskill());
		user.setAddress(udto.getAddress());
		urepo.save(user);
		attrib.addFlashAttribute("msg", "Job Seeker is registered.");
		return "redirect:/registration";
	}

	
	@GetMapping("/adminlogin")
	public String showAdminLogin(Model model) {
		AdminInfoDto aidto = new AdminInfoDto();
		model.addAttribute("aidto", aidto);
		return "adminlogin";
	}

	@PostMapping("/adminlogin")
	public String adminLoginDashboard(@ModelAttribute AdminInfoDto aidto, RedirectAttributes attrib,
			HttpSession session) {

		String adminid = aidto.getAdminid();
		String password = aidto.getPassword();

		try {
			AdminInfo admin = airepo.findById(adminid).get();
			if (admin.getPassword().equals(password)) {
				session.setAttribute("admin", admin);
				return "redirect:/admin/admindashboard";
//			attrib.addFlashAttribute("msg","Welcome Admin");
			} else {

				attrib.addFlashAttribute("msg", "Invalid adminid / password");
				return "redirect:/adminlogin";
			}
		} catch (Exception e) {

			attrib.addFlashAttribute("msg", "Invalid adminid / password");
			return "redirect:/adminlogin";
		}

	}
}
