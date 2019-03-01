package com.example.entreclub;

public class AddNeeds {
    String type,description,email,id;

    public AddNeeds()
    {

    }
    public AddNeeds(String type, String description, String email, String id) {
        this.type = type;
        this.description = description;
        this.email = email;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
