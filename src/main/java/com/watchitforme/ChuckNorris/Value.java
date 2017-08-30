package com.watchitforme.ChuckNorris;

public class Value
{
    private String id;

    private String joke;

    private String[] categories;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getJoke ()
    {
        return joke;
    }

    public void setJoke (String joke)
    {
        this.joke = joke;
    }

    public String[] getCategories ()
    {
        return categories;
    }

    public void setCategories (String[] categories)
    {
        this.categories = categories;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", joke = "+joke+", categories = "+categories+"]";
    }
}
