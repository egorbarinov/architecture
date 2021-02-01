package com.egorbarinov.creditingmodule.registry;

import com.egorbarinov.creditingmodule.entities.ExchangeRate;
import com.egorbarinov.creditingmodule.entities.Valute;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdentityMap {
    private static final ThreadLocal<IdentityMap> current = new ThreadLocal<>();

    public static void init(){
        current.set(new IdentityMap());
    }

    public static IdentityMap getCurrent(){
        return current.get();
    }

    private Map<LocalDate, List<Valute>> entities = new HashMap<>();

    public List<Valute> find(LocalDate date){
        return entities.get(date);
    }

    public String findAll() {
        return entities.entrySet().toString();
    }

    public void add(ExchangeRate rate){
        entities.put(rate.getDate(), rate.getValutes());
    }

    public void remove(ExchangeRate rate){
        entities.remove(rate.getDate(), rate);
    }

    public void clear(){
        entities.clear();
    }
}
