package task.drew.parsingwebsite.util;

public enum HtmlTag {

    LINK_TAG("a"), PARAGRAPH_TAG("p"), SPAN_TAG("span");

    private String name;

    HtmlTag(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
