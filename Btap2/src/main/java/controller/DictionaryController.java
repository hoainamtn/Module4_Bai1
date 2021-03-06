package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.DictionaryService;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("dich")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("dich");
        return modelAndView;
    }

    @GetMapping("translate")
    public ModelAndView translate(@RequestParam("key") String key) {
        String answer = dictionaryService.translate(key);
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("answer",answer);
        return modelAndView;
    }
}
