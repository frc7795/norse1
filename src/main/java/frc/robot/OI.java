/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
public class OI {

    //Controllers
    public Joystick driverPad = new Joystick(0);
    public Joystick opPad = new Joystick(1);
    

    // Joystick reference:
    // http://wpilib.screenstepslive.com/s/currentCS/m/java/l/599723-joysticks


    private static final double STICK_DEADBAND = 0.05;
    private static double stickDeadband(double value, double deadband, double center) {
        return (value < (center + deadband) && value > (center - deadband)) ? center : value;
    }

    public double getDriverLeftStickY() {
        return stickDeadband(this.driverPad.getRawAxis(JoystickMap.LEFT_Y), STICK_DEADBAND, 0.0);
    }

    public double getDriverLeftStickX() {
        return stickDeadband(this.driverPad.getRawAxis(JoystickMap.LEFT_X), STICK_DEADBAND, 0.0);
    }

    public double getDriverRightStickY() {
        return stickDeadband(this.driverPad.getRawAxis(JoystickMap.RIGHT_Y), STICK_DEADBAND, 0.0);
    }

    public double getDriverRightStickX() {
        return stickDeadband(this.driverPad.getRawAxis(JoystickMap.RIGHT_X), STICK_DEADBAND, 0.0);
    }

    public boolean getCargoUpButton() {
        return driverPad.getRawButton(JoystickMap.B);
    }

    public boolean getCargoDownButton() {
        return driverPad.getRawButton(JoystickMap.A);
    }

    public double getDriverRightTrigger() {
        return driverPad.getRawAxis(JoystickMap.RIGHT_TRIGGER);
    }

    public boolean LBPressed() {
        return driverPad.getRawButton(JoystickMap.LB);
    }

    public boolean RBPressed() {
        return driverPad.getRawButton(JoystickMap.RB);
    }
}
