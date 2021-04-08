package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class State_Off implements State{
    TrafficLightColor tlc;
    TrafficLightCtrl tlCtrl;

    public State_Off(TrafficLightCtrl tlCtrl) {
        this.tlc = TrafficLightColor.OFF;
        this.tlCtrl = tlCtrl;
    }

    @Override
    public void nextState() {
        tlCtrl.setCurrentState(tlCtrl.getRedState());
        tlCtrl.setPreviousState(this);
    }

    @Override
    public TrafficLightColor getState() {
        return tlc;
    }
}
