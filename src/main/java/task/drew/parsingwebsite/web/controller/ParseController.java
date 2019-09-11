package task.drew.parsingwebsite.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parser")
public class ParseController {

    @GetMapping
    public String parserPage(){
        return "parser";
    }



}
