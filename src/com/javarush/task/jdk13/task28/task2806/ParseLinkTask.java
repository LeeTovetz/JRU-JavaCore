package com.javarush.task.jdk13.task28.task2806;

import java.util.concurrent.Callable;

public class ParseLinkTask implements Callable<Link> {

    private String line;

    public ParseLinkTask(String line) {
        this.line = line;
    }

    @Override
    public Link call() {
        Link result = new Link();
        int colonIndex = line.indexOf(":");
        result.protocol = line.substring(0, colonIndex);

        int queryMarkIndex = line.indexOf("?");
        if (queryMarkIndex != -1) {
            result.address = line.substring(colonIndex + 3, queryMarkIndex);

            String[] parameters = line.substring(queryMarkIndex + 1).split("&");
            for (String parameter : parameters) {
                String[] param = parameter.split("=");
                result.parameters.put(param[0], param[1]);
            }
        } else {
            result.address = line.substring(colonIndex + 3);
        }

        return result;
    }
}