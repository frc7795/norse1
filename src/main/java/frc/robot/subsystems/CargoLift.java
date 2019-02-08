package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;

// CargoLift operates the cargo dumper (pneumatic solenoids).
// It uses the A and B buttons (B up, A down).
public class CargoLift extends Subsystem {
    // Reference:
    // http://wpilib.screenstepslive.com/s/currentCS/m/java/l/599708-operating-pneumatic-cylinders-solenoids
    private Solenoid upValve   = new Solenoid(RobotMap.PNEU_UP);
    private Solenoid downValve = new Solenoid(RobotMap.PNEU_DOWN);

    public CargoLift(){
        // init the controllers?
    }

    public void obey(boolean up, boolean down) {
        if (up) {
            downValve.set(false);
            upValve.set(true);
        } else if (down) {
            upValve.set(false);
            downValve.set(true);
        } else {
            upValve.set(false);
            downValve.set(false);
        }
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new CargoLiftCmd());
    }
}
