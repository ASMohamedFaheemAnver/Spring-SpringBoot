package org.studyeasy.cars;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    String type = "v8";

    public Engine() {
        type = "V8";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
