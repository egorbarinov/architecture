package com.egorbarinov.creditingmodule.registry;

public class Registry {
    private static final Registry instance = new Registry();

    public static Registry getInstance(){
        return instance;
    }

    protected IdentityMap identityMap = IdentityMap.getCurrent();

    public IdentityMap getIdentityMap(){
        return identityMap;
    }

}
