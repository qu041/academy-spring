package com.test.file.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@Autowired
	private ServletContext servletContext; //application 객체

	@GetMapping("/ex01.do")
	public String ex01() {
		
		return "ex01";
	}
	
	@PostMapping("/ex01ok.do")
	public String ex01ok(Model model,
						 String txt,
						 MultipartFile attach,
						 HttpServletRequest req
						 ) {
		
		//System.out.println(txt);
		
		System.out.println(attach.getName()); //<input name="attach"
		System.out.println(attach.getOriginalFilename()); //catty01.png
		System.out.println(attach.getContentType()); //image/png
		System.out.println(attach.getSize()); //9348
		System.out.println(attach.isEmpty()); //false
		
		//업로드 파일이 어디 있는지??
		//- 임시 폴더에 있는 업로드 파일 > (이동) > 보관 폴더(files)
		String path = req.getServletContext().getRealPath("/resources/files");
		
		System.out.println(path);
		
		try {
			
//			String filename = getUniqueFileName(path, attach.getOriginalFilename());
			//String filename = getUniqueFileName2(attach.getOriginalFilename());
			String filename = getUniqueFileName3(attach.getOriginalFilename());
						
			File file = new File(path + "\\" + filename);
			
			attach.transferTo(file); //이동
			
			
			model.addAttribute("txt", txt);
			model.addAttribute("filename", filename);
			model.addAttribute("filetype", attach.getContentType());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "ex01ok";
	}

	private String getUniqueFileName3(String originalFilename) {
		
		//32개의 16진수 문자로 구성되며, 8-4-4-4-12 형식
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		
		return uuid + "_" + originalFilename;
	}

	private String getUniqueFileName2(String originalFilename) {
		
		System.out.println(System.currentTimeMillis()); //ms > 10^-3
		System.out.println(System.nanoTime()); //ns > 10^-9
		
		return System.nanoTime() + "_" + originalFilename;
	}

	private String getUniqueFileName(String path, String filename) {
		
		//files 폴더 > 같은 이름의 파일이 있는지 확인? > 이름 변경
		//- test.txt > test_1.txt > test_2.txt
		
		//test.txt
		int n = 1;
		
		File file = null;
		String tempName = "";
		
		while (true) {
			
			file = new File(path + "\\" + filename); //test.txt
			
			if (file.exists()) {
				//중복 > 이름 변경
				//test.txt > test_1.txt
				int lastIndex = filename.lastIndexOf(".");
				String fileNameWithoutExtension = filename.substring(0, lastIndex); //test
				
				if (tempName == "") {
					tempName = fileNameWithoutExtension;
				} 
				
				String extension = filename.substring(lastIndex); //.txt
				
				//"test" + "_" + n + ".txt" > "test_1.txt"
				filename = tempName + "_" + n + extension;
				n++;
				
			} else {
				return file.getName(); //유일한 파일명
			}
			
		}
		
	}
	
	@GetMapping("/ex02.do")
	public String ex02() {
		
		return "ex02";
	}
	
	@PostMapping("/ex02ok.do")
	public String ex02ok(Model model,
						 String txt,
						 MultipartFile[] attach
						 ) {
		
		String path = servletContext.getRealPath("/resources/files");		
		System.out.println(path);
		
		for (MultipartFile item : attach) {
		try {
			
			String filename = getUniqueFileName3(item.getOriginalFilename());						
			File file = new File(path + "\\" + filename);			
			item.transferTo(file);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
		model.addAttribute("txt",txt);
		model.addAttribute("attach",attach);
		
		return "ex02ok";
	}
	
	@GetMapping("/ex03.do")
	public String ex03() {
		
		return "ex03";
	}
	
	@GetMapping("/ex04.do")
	public String ex04() {
		
		return "ex04";
	}
	
	@PostMapping("/ex04ok.do")
	public @ResponseBody int ex04ok(Model model,
						 String txt,
						 MultipartFile[] attach
						 ) {
		
		String path = servletContext.getRealPath("/resources/files");		
		System.out.println(path);
		
		for (MultipartFile item : attach) {
		try {
			
			String filename = getUniqueFileName3(item.getOriginalFilename());						
			File file = new File(path + "\\" + filename);			
			item.transferTo(file);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
		return 1;
	}
	
}




















