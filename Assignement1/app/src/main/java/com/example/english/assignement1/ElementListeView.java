package com.example.english.assignement1;

/**
 * Created by english on 09/03/2016.
 */
public class ElementListeView {
    String text;
    int checked;

    ElementListeView(String text, int checked){
        this.text = text;
        this.checked = checked;
    }
    public String getName(){
        return this.text;
    }
    public int getValue(){
        return this.checked;
    }

}
