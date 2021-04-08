package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class State_Red implements State{
    TrafficLightColor tlc;
    TrafficLightCtrl tlCtrl;

    public State_Red(TrafficLightCtrl tlCtrl) {
        this.tlc = TrafficLightColor.RED;
        this.tlCtrl = tlCtrl;
    }

    @Override
    public void nextState() {
        tlCtrl.setCurrentState(tlCtrl.getYellowState());
        tlCtrl.setPreviousState(this);
    }

    @Override
    public TrafficLightColor getState() {
        return tlc;
    }
}
