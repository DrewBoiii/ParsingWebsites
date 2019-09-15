package task.drew.parsingwebsite.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import task.drew.parsingwebsite.service.PairService;

@Controller
@RequestMapping("/details")
public class DetailsController {

    private PairService pairService;

    @Autowired
    public DetailsController(PairService pairService) {
        this.pairService = pairService;
    }

    @GetMapping
    public String detailsPage(Model model){
        model.addAttribute("pairs", pairService.getPairs());
        return "details";
    }

}
