package task.drew.parsingwebsite.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import task.drew.parsingwebsite.service.WebSiteService;

@Controller
@RequestMapping("/details")
public class DetailsController {

    private WebSiteService webSiteService;

    @Autowired
    public DetailsController(WebSiteService webSiteService) {
        this.webSiteService = webSiteService;
    }

    @GetMapping
    public String detailsPage(Model model){
        model.addAttribute("websites", webSiteService.getWebSites());
        return "details";
    }

}
