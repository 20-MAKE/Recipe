package edu.data.recipe;

public class RecipeData {
    private String title;
    private String[] description;
    private String[] ingreds;
    private String imgURL;
    private int id;

    public void setData(String title, String[] description, String[] ingreds, String URL) {
        setTitle(title);
        setDescription(description);
        setIngreds(ingreds);
        setURL(URL);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String[] description) {
        this.description = new String[description.length];
        for (int i = 0; i < description.length; i++) {
            this.description[i] = description[i];
        }
    }

    public void setIngreds(String[] ingreds) {
        this.ingreds = new String[ingreds.length];
        for (int i = 0; i < ingreds.length; i++) {
            this.ingreds[i] = ingreds[i];
        }
    }

    public void setURL(String URL) {
        this.imgURL = URL;
    }


    public void setID(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public String[] getDescription() {
        return this.description;
    }
    public String getStringDescription() {
        String description = "";
        for (int i = 0; i < this.description.length-1; i++) {
            description += this.description[i]+"\n";
        }
        return description;
    }

    public String[] getIngreds() {
        return this.ingreds;
    }
    public String getStringIngreds() {
        String ingred = "";
        for (int i = 0; i < this.ingreds.length; i++) {
            ingred = ingred + this.ingreds[i];
        }
        return ingred;
    }



    public String getImgURL() {
        return this.imgURL;
    }
    public int getID() {
        return this.id;
    }

    @Override
    public String toString() {
        String description = "";
        for (int i = 0; i < this.description.length-1; i++) {
            description += this.description[i]+", ";
        }
        description += this.description[this.description.length-1];

        String ingreds = "";
        for (int i = 0; i < this.ingreds.length-1; i++) {
            ingreds += this.ingreds[i]+", ";
        }
        ingreds += this.ingreds[this.ingreds.length-1];

        return "Title: " + this.title + ", Desc: " + description + ", Ingreds: " + ingreds + ", URL: " + this.imgURL;
    }
}
