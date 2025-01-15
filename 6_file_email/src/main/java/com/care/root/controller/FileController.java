package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.MultipartResolutionDelegate;

import com.care.root.dto.FileDTO;
import com.care.root.service.FileService;

@Controller
public class FileController {
	@Autowired FileService fs;
	
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
	
	@PostMapping("upload")//MultipartHttpServletRequest 이거만 사용해서 가능하고, 아니면 개별적으로도 사용이 가능함
	public String upload(MultipartHttpServletRequest mul, String id, String name, MultipartFile file) { //자기가 원하는걸로 사용 가능함
		fs.fileProcess(file, id, name);
		/*
		System.out.println("id : " + id );
		System.out.println("name : " + name );
		System.out.println("file : " + file.getOriginalFilename());
		System.out.println("------------------------------------------------------------");
		System.out.println("mul.id : " + mul.getParameter("id"));
		System.out.println("mul.name : " + mul.getParameter("name"));
		MultipartFile mf = mul.getFile("file"); //파일에 대한 정보를 가져올 수 있음
		System.out.println("mf.file : " + mf.getOriginalFilename());
		*/
		return "redirect:form";
		}
	
	@GetMapping("views")
	public String views(Model model) {
		model.addAttribute("list", fs.getList() );
		return "result";
	}
	
	@GetMapping("download")
//	public void download(String file, HttpServletResponse res) {
	public void download(@RequestParam ("file") String fileName, HttpServletResponse res) throws Exception { //여러가지를 받을때는 이 방법을 사용함
		res.addHeader("Content-disposition", "attachment; fileName=" +URLEncoder.encode(fileName,StandardCharsets.UTF_8) );//여기가 오타가 나면 파일이 제대로 다운로드가 안됨
		File file = new File(FileService.IMG_REPO + "/" + fileName );
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, res.getOutputStream() );
		in.close();
	
	}
	@GetMapping("delete")
	public String delete(String file, String id) {
		fs.delete(file, id);
		return "redirect:views";
	}
	
	@GetMapping("modify_form")
	public String modify_form(Model model, String id) {
		model.addAttribute("info", fs.getData(id));
		return "modify_form";
	}
	
	@PostMapping("modify")
	public String modify(MultipartFile file, String origin, FileDTO dto) {
		fs.modify(file, origin, dto);
		return "redirect:views";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
