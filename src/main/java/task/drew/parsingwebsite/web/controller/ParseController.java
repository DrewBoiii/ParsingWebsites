package task.drew.parsingwebsite.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import task.drew.parsingwebsite.persistence.model.WebSite;
import task.drew.parsingwebsite.service.WebSiteService;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/parser")
public class ParseController {

    private WebSiteService webSiteService;

    @Autowired
    public ParseController(WebSiteService webSiteService) {
        this.webSiteService = webSiteService;
    }

    @GetMapping
    public String parserPage(Model model){
        model.addAttribute("website", new WebSite());
        return "parser";
    }

    @PostMapping("/submit")
    public String parseWebSite(@ModelAttribute @Valid WebSite webSite, Errors webSiteBlank){

        if(webSiteBlank.hasErrors()){
            return "parser";
        }

        webSiteService.save(webSite);

        return "redirect:/details";
    }

}
