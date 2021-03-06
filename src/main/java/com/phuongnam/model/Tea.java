package com.phuongnam.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Tea {
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<String> ingredients;

    public Tea() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredient() {
        return ingredients;
    }

    public void setIngredient(List<String> ingredient) {
        this.ingredients = ingredient;
    }
}
