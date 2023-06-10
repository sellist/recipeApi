package recipeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipeapi.models.Recipe;
import recipeapi.service.RecipeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeServiceImpl recipeServiceImpl;


    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        Recipe foundRecipe = recipeServiceImpl.getRecipeById(id);
        if (foundRecipe == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundRecipe);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> foundRecipes = recipeServiceImpl.getAllRecipe();
        if (foundRecipes == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundRecipes);
        }
    }


}
