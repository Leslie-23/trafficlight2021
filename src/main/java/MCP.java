import trafficlight.ctrl.TrafficLightCtrl;


public class MCP {
    public static void main(String[] args) {
        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        //TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.run();
    }
}