package com.company.model;

import java.util.HashMap;
import java.util.Set;

public class Model {
    private static HashMap<String, Pracownik> pracownikHashMap = new HashMap<>();

    public void put(String pesel, Pracownik pracownik){
        pracownikHashMap.put(pesel, pracownik);
    }

    public int size(){
        return pracownikHashMap.size();
    }

    public Set<String> keySet(){
        return pracownikHashMap.keySet();
    }

    public boolean containsKey(String key){
        return pracownikHashMap.containsKey(key);
    }

    public void remove(String key){
        pracownikHashMap.remove(key);
    }
    public void setPracownikHashMap(HashMap<String, Pracownik> map){
        pracownikHashMap = map;
    }

    public HashMap<String, Pracownik> getPracownikHashMap(){
        return pracownikHashMap;
    }

    public Pracownik get(String key){
        return pracownikHashMap.get(key);
    }
}
