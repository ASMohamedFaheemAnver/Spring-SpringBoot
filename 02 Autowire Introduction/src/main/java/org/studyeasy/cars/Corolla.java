package org.studyeasy.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.studyeasy.interfaces.Car;
import org.studyeasy.interfaces.Engine;

@Component("corolla")
public class Corolla implements Car {

    @Autowired
    @Qualifier("v6")
    Engine engine;

    public String specs() {
        String specs = "Sedan from Toyota with engine type as " + engine.type();
        return specs;
    }
}
