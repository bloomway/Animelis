package org.landscape.animelis.model;

/**
 * Created by Chatofrey on 28/04/2016.
 * chatofrey@gmail.com
 * Animelis
 */
public class Category {
    private String  name;

    public Category(String name){
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
