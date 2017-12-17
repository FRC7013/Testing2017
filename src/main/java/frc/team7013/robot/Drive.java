package frc.team7013.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Drive {

    private VictorSP[] Victors_left, Victors_right;
    private Solenoid Sol_left, Sol_right;
    private Joystick drive_joy;
    private boolean Tank;
    private boolean shift;
    private Constants constants;
    private int speed = 0;

    Drive(Joystick drive_joy, boolean Tank){

        constants = new Constants();

        Victors_left = new VictorSP[constants.Victors_left.length];
        Victors_right = new VictorSP[constants.Victors_right.length];

        for(int i = 0; i < constants.Victors_left.length; i++){
            Victors_left[i] = new VictorSP(constants.Victors_left[i]);
            Victors_right[i] = new VictorSP(constants.Victors_right[i]);
        }

        this.drive_joy = drive_joy;
        this.Tank = Tank;

    }
    Drive(Joystick drive_joy, boolean Tank, Solenoid Sol_left, Solenoid Sol_right){

        constants = new Constants();

        Victors_left = new VictorSP[constants.Victors_left.length];
        Victors_right = new VictorSP[constants.Victors_right.length];

        for(int i = 0; i < constants.Victors_left.length; i++){
            Victors_left[i] = new VictorSP(constants.Victors_left[i]);
            Victors_right[i] = new VictorSP(constants.Victors_right[i]);
        }

        this.drive_joy = drive_joy;
        this.Tank = Tank;

        this.Sol_left = Sol_left;
        this.Sol_right = Sol_right;

    }
    public void doDrive() {
        if (Tank) {

            for (VictorSP vic : Victors_left)
                vic.set(drive_joy.getRawAxis(constants.joy_left_stick_y)/speed);
            for (VictorSP vic : Victors_right)
                vic.set(drive_joy.getRawAxis(-constants.joy_right_stick_y)/speed);
        }
        else {

            double left_sum = drive_joy.getRawAxis(constants.joy_left_stick_y) + drive_joy.getRawAxis(constants.joy_left_stick_x);
            double right_sum = -(drive_joy.getRawAxis(constants.joy_left_stick_y) - drive_joy.getRawAxis(constants.joy_left_stick_x));

            for (VictorSP vic : Victors_left)
                vic.set(left_sum/speed);
            for (VictorSP vic : Victors_right)
                vic.set(right_sum/speed);
        }
    }
    public void toggleSpeed(){
        speed = (speed == 2)?1:2;
    }
    public void shift(){
        shift = !shift;

        Sol_left.set(shift);
        Sol_right.set(shift);
    }
    public void toggleDrive(){
        Tank = !Tank;
    }

}
