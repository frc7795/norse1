/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveArcadeCmd extends Command {
    private double lastSetPower = 0.0;
    private double magicPowerFraction = 0.05;
    public DriveArcadeCmd() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    private static double clip(double val) {
        return Math.max(-1.0, Math.min(1.0, val));
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double speedscale = 0.6;
        double overdriveSpeedscale = 1.0;
        double steeringSpeedscale = 0.6;
        double overdrive = Robot.oi.getDriverLeftTrigger();
        double steering = Robot.oi.getDriverRightStickX();
        double power = Robot.oi.getDriverLeftStickY();

        // for some reason pushing the joystick forward 
        // makes 'power' negative!
        if (power < 0.0) {
             if (Math.abs(steering) < 0.1) {
                // safety: overdrive only when moving forward
                power = Math.min(-overdriveSpeedscale * overdrive, speedscale * power);
             }
        }
        
        if (Robot.driveBackwards) power = -power;
        // Try to make it more gracious and professional
        power = lastSetPower + magicPowerFraction * (power - lastSetPower);
        lastSetPower = power;

        steering = steering * steeringSpeedscale;
        double powerLeft = clip(power - steering);
        double powerRight = clip(power + steering);

        Robot.drivetrain.drive(powerLeft, powerRight);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
