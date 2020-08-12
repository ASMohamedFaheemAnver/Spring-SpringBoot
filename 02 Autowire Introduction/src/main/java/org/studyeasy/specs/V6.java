package org.studyeasy.specs;

import org.springframework.stereotype.Component;
import org.studyeasy.interfaces.Engine;

// Can give different component name if we want
@Component
public class V6 implements Engine {
    @Override
    public String type() {
        return "V6 engine";
    }
}
