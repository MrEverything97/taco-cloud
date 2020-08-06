package com.phuongnam.controller;

import com.phuongnam.model.Ingredient;

import com.phuongnam.model.Tea;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/design-tea")
public class DesignTeaController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("BIG", "Big Size", Ingredient.Type.SIZE),
                new Ingredient("SMALL", "Small Size", Ingredient.Type.SIZE),
                new Ingredient("LITTER", "little sugar", Ingredient.Type.SUGAR),
                new Ingredient("MUCH", "much sugar", Ingredient.Type.SUGAR),
                new Ingredient("LITTER", "little ice", Ingredient.Type.ICE),
                new Ingredient("MUCH", "much ice", Ingredient.Type.ICE),
                new Ingredient("ZZ", "Zhen zhou", Ingredient.Type.TOPPING),
                new Ingredient("CR", "cream cheese", Ingredient.Type.TOPPING));
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Tea());
        return "design-tea";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        List<Ingredient> ingrList = new ArrayList<Ingredient>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getType().equals(type))
                ingrList.add(ingredient);
        }
        return ingrList;
    }

    @PostMapping
    public String processDesign(@Valid Tea tea, Errors errors) {
        if (errors.hasErrors()) {
            return "home";
        }
        // Save the taco design...
        // We'll do this later
        return "redirect:/orders/current";
    }
}
