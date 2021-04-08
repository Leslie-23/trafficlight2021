import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.states.*;


// Repo: https://github.com/AnasKay/trafficlight2021

public class StateTests {

    TrafficLightCtrl ctrl;
    State test = null;
    private State greenState;

    private State redState;

    private State yellowState;

    private State currentState;

    private State previousState;

    @BeforeAll
    static void init() {}

    @BeforeEach
    void setUp() {
        ctrl = TrafficLightCtrl.getInstance();
        greenState = new State_Green(ctrl);
        redState = new State_Red(ctrl);
        yellowState = new State_Yellow(ctrl);
    }

    @AfterAll
    static void closeAll(){}

    @AfterEach
    void closeEach(){
        ctrl = null;
        test = null;
        greenState = null;
        redState = null;
        yellowState = null;
    }



    @DisplayName("test current Color Green")
    @Test
    public void testCurrentColor_Green() {
        test = new State_Green(ctrl);
        TrafficLightColor actual = test.getState();
        TrafficLightColor expected = TrafficLightColor.GREEN;
        assertEquals(expected,actual);
    }

    @DisplayName("test current Color Yellow")
    @Test
    public void testCurrentColor_Yellow() {
        test = new State_Yellow(ctrl);
        TrafficLightColor actual = test.getState();
        TrafficLightColor expected = TrafficLightColor.YELLOW;
        assertEquals(expected,actual);
    }

    @DisplayName("test current Color Red")
    @Test
    public void testCurrentColor_Red() {
        test = new State_Red(ctrl);
        TrafficLightColor actual = test.getState();
        TrafficLightColor expected = TrafficLightColor.RED;
        assertEquals(expected,actual);
    }

    @DisplayName("test red to yellow")
    @Test
    public void testRedToYellow() {
        ctrl.setCurrentState(redState);
        ctrl.nextState();
        State actual = ctrl.getCurrentState();
        State expected = ctrl.getYellowState();
        assertEquals(expected,actual);
    }

    @DisplayName("test red to green")
    @Test
    public void testRedToGreen() {
        ctrl.setCurrentState(redState);
        ctrl.nextState();
        ctrl.nextState();
        State actual = ctrl.getCurrentState();
        State expected = ctrl.getGreenState();
        assertEquals(expected,actual);
    }

    @DisplayName("test yellow to red")
    @Test
    public void testYellowToRed() {
        ctrl.setCurrentState(yellowState);
        ctrl.setPreviousState(greenState);
        ctrl.nextState();
        State actual = ctrl.getCurrentState();
        State expected = ctrl.getRedState();
        assertEquals(expected,actual);
    }

    @DisplayName("test yellow to green")
    @Test
    public void testYellowToGreen() {
        ctrl.setCurrentState(yellowState);
        ctrl.setPreviousState(redState);
        ctrl.nextState();
        State actual = ctrl.getCurrentState();
        State expected = ctrl.getGreenState();
        assertEquals(expected,actual);
    }

    @DisplayName("test green to yellow")
    @Test
    public void testGreenToYellow() {
        ctrl.setCurrentState(greenState);
        ctrl.setPreviousState(yellowState);
        ctrl.nextState();
        State actual = ctrl.getCurrentState();
        State expected = ctrl.getYellowState();
        assertEquals(expected,actual);
    }

    @DisplayName("test green to Red")
    @Test
    public void testGreenToRed() {
        ctrl.setCurrentState(greenState);
        ctrl.setPreviousState(yellowState);
        ctrl.nextState();
        ctrl.nextState();
        State actual = ctrl.getCurrentState();
        State expected = ctrl.getRedState();
        assertEquals(expected,actual);
    }


}
