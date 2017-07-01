package com.yanjinbin.concurrent.chapter_3;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Silver bullet
 * @Since 2017/6/30.
 */
public class Secrets {
    public static Set<Secret> knownSecrets;

    public void initialize(){
        knownSecrets = new HashSet<Secret>();
    }
}

class Secret{
}