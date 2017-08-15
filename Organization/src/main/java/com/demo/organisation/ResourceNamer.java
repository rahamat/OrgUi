package com.demo.organisation;

import java.util.UUID;

public class ResourceNamer {
	
    private final String randName;
    public ResourceNamer(String name) {
        this.randName = name.toLowerCase() + UUID.randomUUID().toString().replace("-", "").substring(0, 3).toLowerCase();
    }

    public String randomName(String prefix, int maxLen) {
        prefix = prefix.toLowerCase();
        int minRandomnessLength = 5;
        if (maxLen <= minRandomnessLength) {
            return randomString(maxLen);
        }

        if (maxLen <= prefix.length() + minRandomnessLength) {
            return randomString(maxLen);
        }

        String minRandomString = String.valueOf(System.currentTimeMillis() % 100000L);
        if (maxLen <= prefix.length() + randName.length() + minRandomnessLength) {
            String str = prefix + minRandomString;
            return str + randomString((maxLen - str.length()) / 2);
        }

        String str = prefix + randName + minRandomString;
        return str + randomString((maxLen - str.length()) / 2);
    }

    private String randomString(int length) {
        String str = "";
        while (str.length() < length) {
            str += UUID.randomUUID()
                    .toString()
                    .replace("-", "")
                    .substring(0, Math.min(32, length)).toLowerCase();
        }
        return str;
    }
    
    public static String randomResourceName(String prefix, int maxLen) {
        ResourceNamer namer = new ResourceNamer("");
        return namer.randomName(prefix, maxLen);
    }
}

