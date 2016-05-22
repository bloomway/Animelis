package org.empires.baham.kac.animelis.model;

import java.util.Date;

/**
 * Created by Chatofrey on 22/05/2016.
 * chatofrey@gmail.com
 * Animelis
 */
public class ItemCategory {
    private String name;
    private Date publicationDate;
    private Person owner;

    public ItemCategory (String name, Date publicationDate, Person owner){
        this.name = name;
        this.publicationDate = publicationDate;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
