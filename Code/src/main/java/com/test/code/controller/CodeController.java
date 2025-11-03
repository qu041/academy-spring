package com.test.code.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.code.model.CodeDAO;
import com.test.code.model.CodeDTO;
import com.test.code.model.LanguageDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CodeController {
	
	private final CodeDAO dao;
	
	@GetMapping("/list.do")
	public String list(Model model) {
		
		List<CodeDTO> list = dao.list();
		
		model.addAttribute("list",list);
		
		return "list";
	
	}
	
	@GetMapping("/add.do")
	public String add(Model model) {
		
		List<LanguageDTO> llist = dao.llist();
		
		model.addAttribute("llist",llist);
		
		return "add";
		
	}
	
	@PostMapping("/addok.do")
	public String addok(Model model, CodeDTO dto, HttpServletResponse resp) {
		
		int result = dao.add(dto);
		
		if (result > 0) {
			return "redirect:/list.do";
		} else {
		try {
		resp.getWriter().write("<script>alert('failed');history.back();</script>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		return null;
		
	}
	
	@GetMapping("/view.do")
	public String view(Model model, @RequestParam("seq") String seq) {
		
		CodeDTO dto = dao.get(seq);
		
		model.addAttribute("dto",dto);
		
		return "view";
		
	}

}
