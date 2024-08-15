package com.thevideogoat.digitizingassistant.data;

public enum Type {

    VHS("VHS"),
    VHSC("VHS-C"),
    _8MM("8mm"),
    BETAMAX("Betamax"),
    MINIDV("MiniDV"),
    CD("CD"),
    DVD("DVD"),
    ;

    final String name;
    Type(String s){
        this.name = s;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
