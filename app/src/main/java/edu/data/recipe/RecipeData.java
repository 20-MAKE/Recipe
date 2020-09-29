package edu.data.recipe;

public class RecipeData {
    private String title;
    private String description;
    private String[] ingreds;
    private String imgURL;

    public void setData(String title, String description, String[] ingreds, String URL) {
        setTitle(title);
        setDescription(description);
        setIngreds(ingreds);
        setURL(URL);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngreds(String[] ingreds) {
        this.ingreds = ingreds;
    }

    public void setURL(String URL) {
        this.imgURL = URL;
    }




    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getIngreds() {
        return this.ingreds;
    }

    public String getImgURL() {
        return this.imgURL;
    }

}
