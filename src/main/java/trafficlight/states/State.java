package trafficlight.states;

public interface State {
    void nextState();
    TrafficLightColor getState();
}