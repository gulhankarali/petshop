package com.api.classes;

import java.util.ArrayList;
import java.util.List;

public class CreatePet {

    public static Pet createPet(Pet pet){

        Category category = new Category();
        category.setId(9191919);
        category.setName("poppy");

        Tag tag = new Tag();
        tag.setId(10101010);
        tag.setName("tony");
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        List<String> listPhotoUrls = new ArrayList<>();
        listPhotoUrls.add("string");

        pet = new Pet();
        pet.setId(9222968140491043506L);
        pet.setStatus("sold");
        pet.setName("Tyrannosaurus");
        pet.setCategory(category);
        pet.setTags(tagList);
        pet.setPhotoUrls(listPhotoUrls);
        return pet;
    }

}
