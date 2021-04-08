package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class State_Yellow implements State{
    TrafficLightColor tlc;
    TrafficLightCtrl tlCtrl;

    public State_Yellow(TrafficLightCtrl tlCtrl) {
        this.tlc = TrafficLightColor.YELLOW;
        this.tlCtrl = tlCtrl;
    }

    @Override
    public void nextState() {

        if(tlCtrl.getPreviousState().getState()==TrafficLightColor.RED) {
            tlCtrl.setCurrentState(tlCtrl.getGreenState());
        }
        else if(tlCtrl.getPreviousState().getState()==TrafficLightColor.GREEN){
            tlCtrl.setCurrentState(tlCtrl.getRedState());
        }
        tlCtrl.setPreviousState(this);
    }

    @Override
    public TrafficLightColor getState() {
        return tlc;
    }
}
