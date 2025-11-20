package com.city3d.utils;

import java.util.UUID;

public class CharacterUtils {
	public String getUUID() {  
        return UUID.randomUUID().toString().replace("-", "");  
    } 
}
