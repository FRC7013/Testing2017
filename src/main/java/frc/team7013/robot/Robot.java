package frc.team7013.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;


public class Robot extends IterativeRobot {

    public static Constants constants = new Constants();
    public static Drive drive;

    public static Joystick driver_joy;

    @Override
    public void robotInit() {
        driver_joy = new Joystick(constants.driver_joy_stick);
        drive = new Drive(driver_joy, true);
    }

    @Override
    public void disabledInit() { }

    @Override
    public void autonomousInit() { }

    @Override
    public void teleopInit() { }

    @Override
    public void testInit() { }

    @Override
    public void disabledPeriodic() { }
    
    @Override
    public void autonomousPeriodic() { }

    @Override
    public void teleopPeriodic() {
        if(driver_joy.getRawButton(constants.joy_button_x))
            drive.toggleDrive();
        if(driver_joy.getRawButton(constants.joy_button_a))
            drive.toggleSpeed();
        drive.doDrive();
    }

    @Override
    public void testPeriodic() { }
}