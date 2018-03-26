package com.example.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.service.FileuploadService;

@Controller
public class FileUploadController {

    @Autowired
    FileuploadService fileuploadService;

    @RequestMapping("/form")
    public String form() {
	return "form";
    }

    @RequestMapping("/upload")
    public String upload( Model model, @RequestParam("email") String eamil, @RequestParam("file1") MultipartFile multipartFile) {

	String url = fileuploadService.restore( multipartFile );
	model.addAttribute( "url", url );
	return "result";
    }
}
