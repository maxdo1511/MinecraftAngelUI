package ru.angelui.utils.interpolator;

import java.util.HashMap;
import java.util.Map;

public class MathInterpolationCore {

    public static MathInterpolationCore instance;
    public Map<Object, MathInterpolation> interpolationMap = new HashMap<>();

    public MathInterpolationCore() {
        instance = this;
    }

    public MathInterpolation getMathInterpolation(Object o) {
        return interpolationMap.get(o);
    }

    public void addMathInterpolation(Object o, MathInterpolation mathInterpolation) {
        interpolationMap.put(o, mathInterpolation);
    }

    public static MathInterpolationCore getInstance(){
        if (instance == null) {
            new MathInterpolationCore();
        }
        return instance;
    }

}
