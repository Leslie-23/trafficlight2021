package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class State_Blue implements State {
    TrafficLightColor tlc;
    TrafficLightCtrl tlCtrl;

    public State_Blue(TrafficLightCtrl tlCtrl) {
        this.tlc = TrafficLightColor.BLUE;
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
