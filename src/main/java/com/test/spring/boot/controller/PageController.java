package com.test.spring.boot.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class PageController {
	
	private static final String SHARE_FOLDER_PATH = "C:\\Users\\rajas\\Desktop\\TFS Search\\";
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @GetMapping("/")
    public String showHomepage() {
        return "index"; // Assuming you want to load index.html as your homepage
    }

    @GetMapping("/details")
    public String showDetailsPage() {
        return "detailPage"; // Maps to detailPage.html
    }
    
    @GetMapping("/openRGStory")
    public String openRGStory() {
        // Create the folder if it does not exist
    	System.out.println("Trying to create folder: " + SHARE_FOLDER_PATH + "/" );
    	 // Return the name of the template
        return "detailPage";
    }
    
    @GetMapping("/test")
    public String testEndpoint(Model model) {
    	model.addAttribute("msg", "Test endpoint is working!");
        return "test";
    }
}
