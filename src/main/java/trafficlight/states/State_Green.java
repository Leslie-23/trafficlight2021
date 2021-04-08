package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class State_Green implements State{
    TrafficLightColor tlc;
    TrafficLightCtrl tlCtrl;

    public State_Green(TrafficLightCtrl tlCtrl) {
        this.tlc = TrafficLightColor.GREEN;
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
