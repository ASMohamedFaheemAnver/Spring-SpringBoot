package org.studyeasy.specs;


import org.studyeasy.interfaces.Engine;

// Can give different component name if we want
//@Component
public class V8 implements Engine {
    public String type() {
        return "V8 engine";
    }
}
