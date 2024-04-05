package trafficlight.gui;

import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.states.TrafficLightColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightGui extends JFrame implements ActionListener {

    public static final String ACTION_COMMAND_NEXT = "Next";

    public static final String ACTION_COMMAND_AUTO_MODE = "AutoMode";
    public static final String NAME_OF_THE_GAME = "Traffic Light Simulator";

    private JButton buttonNextState;
    private JCheckBox checkBoxAutoMode;
    private JLabel labelAutoMode;

    private Light green = null;
    private Light yellow = null;
    private Light red = null;
    private Light blue = null;

    private TrafficLightCtrl trafficLightCtrl = null;

    private boolean isAutoMode = false;
    private boolean doExit = false;

    private int yellowIntervall = 500;

    private int intervall = 1500;

    public TrafficLightGui(TrafficLightCtrl ctrl) {
        super(NAME_OF_THE_GAME);
        trafficLightCtrl = ctrl;
        initLights();
        init();
    }

    private void initLights() {
        green = new Light(Color.green);
        yellow = new Light(Color.yellow);
        red = new Light(Color.red);
        blue = new Light(Color.blue);
    }

    private void init() {
        getContentPane().setLayout(new GridLayout(3, 1));
        buttonNextState = new JButton("next State");
        buttonNextState.setActionCommand(ACTION_COMMAND_NEXT);
        buttonNextState.addActionListener(this);

        labelAutoMode = new JLabel("AutoMode ");

        checkBoxAutoMode = new JCheckBox();
        checkBoxAutoMode.setActionCommand("autoMode");
        checkBoxAutoMode.addActionListener(this);

        JPanel p1 = new JPanel(new GridLayout(3, 1));
        p1.add(red);
        p1.add(yellow);
        p1.add(green);
        p1.add(blue);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(buttonNextState);
        p2.add(labelAutoMode);
        p2.add(checkBoxAutoMode);

        getContentPane().add(p1);
        getContentPane().add(p2);
        pack();
    }

    public void run() {
        while (!doExit) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                JOptionPane pane = new JOptionPane();
                JDialog dialog = pane.createDialog(this, "Traffic Light Problem");
                JOptionPane.showMessageDialog(dialog, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (isAutoMode) {
                // TODO call the controller
                trafficLightCtrl.nextState();
                try {
                    if (yellow.isOn) {
                        Thread.sleep(yellowIntervall);
                    } else {
                        Thread.sleep(intervall);
                    }
                } catch (InterruptedException e) {
                    JOptionPane pane = new JOptionPane();
                    JDialog dialog = pane.createDialog(this, "Traffic Light Problem");
                    JOptionPane.showMessageDialog(dialog, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    isAutoMode = false;
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (ACTION_COMMAND_NEXT.equals(e.getActionCommand())) {
            trafficLightCtrl.nextState();
        } else if (ACTION_COMMAND_AUTO_MODE.equals(e.getActionCommand())) {
            isAutoMode = !isAutoMode;
            System.out.println("set Auto mode to " + isAutoMode);
        }
    }

    public void setLight(TrafficLightColor trafficLightColor) {
        // TODO setLight
        if (trafficLightColor == TrafficLightColor.GREEN) {
            green.turnOn(true);
            yellow.turnOn(false);
            red.turnOn(false);
            blue.turnOn(false);
        } else if (trafficLightColor == TrafficLightColor.YELLOW) {
            green.turnOn(false);
            yellow.turnOn(true);
            red.turnOn(false);
            blue.turnOn(false);
        } else if (trafficLightColor == TrafficLightColor.RED) {
            green.turnOn(false);
            yellow.turnOn(false);
            red.turnOn(true);
            blue.turnOn(false);
        } /*
           * else if (trafficLightColor == TrafficLightColor.BLUE) {
           * green.turnOn(false);
           * yellow.turnOn(false);
           * red.turnOn(false);
           * blue.turnOn(true);
           * }
           */
    }
}
