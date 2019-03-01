package com.example.entreclub;

public class AsksListClass {
    String email;
    String description,type;

    public AsksListClass()
    {
    }


    public AsksListClass(String email, String description) {
        this.email = email;
        this.description = description;
        this.type=type;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
