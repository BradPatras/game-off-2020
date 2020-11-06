package io.github.bradpatras.entity.components;

import com.badlogic.ashley.core.Component;

public class TypeComponent implements Component {
    public static final int PLAYER = 0;
    public static final int PLANET = 1;
    public static final int MOON = 2;
    public static final int OTHER = 3;

    public int type = OTHER;
}
