package com.lmax.singleselection;

public class Item {
    private String name;
    private String url;

    Item(String name, String url)  {
        this.name= name;
        this.url= url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()  {
        return name;
    }
}
