package frc.team7013.util;

public class PID {
    private double setpoint, Kp, Kd, Ki, error, summation, Kd_out, Ki_out;

    PID(double Kp, double Kd, double Ki){
        this.Kp = Kp;
        this.Kd = Kd;
        this.Ki = Ki;
        Ki_out = 0;
        error = 0;
        Kd_out = 0;
        summation = 0;
    }
    public void newSetpoint(double setpoint){
        this.setpoint = setpoint;
    }
    public double compute(double current_position){
        error = setpoint - current_position;

        Kd_out = Kd_out - error;
        Ki_out += error;

        summation = (error * Kp) + (Kd_out * Kd) + (Ki_out * Ki);

        if(summation > 1.0)
            return 1.0;
        else if (summation < -1.0)
            return -1.0;
        else
            return summation;
    }

}
