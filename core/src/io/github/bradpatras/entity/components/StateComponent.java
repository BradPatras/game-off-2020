package io.github.bradpatras.entity.components;

import com.badlogic.ashley.core.Component;

public class StateComponent implements Component {
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PLANET_ORBIT = 1;
    public static final int STATE_MOON_ORBIT = 2;
    public static final int STATE_TRANSIT = 3;
    public static final int STATE_CRASHED = 4;

    private int state = STATE_NORMAL;
    public float time = 0f;
    public boolean isLooping = false;

    public void set(int newState){
        state = newState;
        time = 0.0f;
    }

    public int get(){
        return state;
    }
}
