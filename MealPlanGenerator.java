/*4. Personalized Meal Plan Generator
Concepts: Generic Methods, Type Parameters, Bounded Type Parameters
Problem Statement:
Design a Personalized Meal Plan Generator where users can choose different meal categories like Vegetarian, Vegan, Keto, or High-Protein. The system should ensure only valid meal plans are generated.
Hints:
Define an interface MealPlan with subtypes (VegetarianMeal, VeganMeal, etc.).
Implement a generic class Meal<T extends MealPlan> to handle different meal plans.
Use a generic method to validate and generate a personalized meal plan dynamically. */
import java.util.*;

public class MealPlanGenerator {

    interface MealPlan {
        String getMeal();
    }

    static class VegetarianMeal implements MealPlan {
        public String getMeal() { return "Vegetarian Meal: Paneer, Veg Salad"; }
    }

    static class VeganMeal implements MealPlan {
        public String getMeal() { return "Vegan Meal: Tofu Bowl, Green Smoothie"; }
    }

    static class KetoMeal implements MealPlan {
        public String getMeal() { return "Keto Meal: Eggs, Avocado, Chicken"; }
    }

    static class HighProteinMeal implements MealPlan {
        public String getMeal() { return "High Protein Meal: Protein Shake, Beans, Chicken"; }
    }
    static class Meal<T extends MealPlan> {
        T plan;
        Meal(T plan) { this.plan = plan; }
        void show() { System.out.println(plan.getMeal()); }
    }
    static <T extends MealPlan> Meal<T> generate(T plan) {
        System.out.println("Meal Plan Validated!");
        return new Meal<>(plan);
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> veg = generate(new VegetarianMeal());
        Meal<VeganMeal> vegan = generate(new VeganMeal());
        Meal<KetoMeal> keto = generate(new KetoMeal());
        veg.show();
        vegan.show();
        keto.show();
    }
}
