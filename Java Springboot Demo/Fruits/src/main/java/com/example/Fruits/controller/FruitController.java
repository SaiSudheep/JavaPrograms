package com.example.Fruits.controller;

import com.example.Fruits.domain.Fruit;
import com.example.Fruits.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FruitController {

    @Autowired
    private FruitService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Fruit> listfruit = service.listAll();
        model.addAttribute("listfruit", listfruit);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("fruit", new Fruit());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveFruit(@ModelAttribute("fruit") Fruit f) {
        service.save(f);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditFruitPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Fruit f = service.get(id);
        mav.addObject("fruit", f);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteFruit(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
