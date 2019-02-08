package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;


public class CargoServo extends Subsystem {
    // Reference:
    // http://wpilib.screenstepslive.com/s/currentCS/m/java/l/599708-operating-pneumatic-cylinders-solenoids
    private Servo servo = new Servo(RobotMap.CARGO_TRIGGER);
    static final double lo = 0.1;
    static final double hi = 0.8;

    public CargoServo(){
        // init the controllers?
        servo.set(lo);
     }
     
    public void obey(double trig) {
        // The incoming trigger value goes from 0 to 1 but we want lo to hi.
        double setting = lerp(trig, 0.0, 1.0, lo, hi);
        servo.set(setting);
    }

    // Linear interpolation.  As x goes from x0 to x1, y goes from y0 to y1.
    private double lerp(double x, double x0, double x1, double y0, double y1) {
        return y0 + (x - x0) / (x1 - x0) * (y1 - y0);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new CargoLiftCmd());
    }
}
