package com.ysy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final RecipeRepository recipeRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PutMapping("/user")
    public Recipe create(@RequestBody Recipe recipe) {
        System.out.println(recipe.toString());
        recipeRepository.save(recipe);
        return recipe;
    }

    @GetMapping("/user")
    public Recipe select(@RequestParam Long id) {
        System.out.println("id: " + id.toString());
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.get();
    }
}
