package trafficlight.ctrl;

import trafficlight.gui.TrafficLightGui;
import trafficlight.states.*;

public class TrafficLightCtrl {

    private State greenState;

    private State redState;

    private State yellowState;

    private State currentState;

    private State previousState;

    private TrafficLightGui gui;

    private static TrafficLightCtrl myInstance = null;


    public static TrafficLightCtrl getInstance() {
        if (myInstance == null) {
            myInstance = new TrafficLightCtrl();
        }
        return myInstance;
    }

    public TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
    }


    private void initStates() {
        //TODO create the states and set current and previous state
        greenState = new State_Green(this);
        redState = new State_Red(this);
        yellowState = new State_Yellow(this);
        currentState = new State_Off(this);
        previousState = currentState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public void run() {
        gui.run();
    }

    public void nextState() {
        //TODO handle GUi request and update GUI
        System.out.print("current: "+this.currentState.getState()+" - last: "+this.previousState.getState());
        gui.setLight(currentState.getState());
        currentState.nextState();
        System.out.print(" - next: "+currentState.getState()+"\n");
    }
}