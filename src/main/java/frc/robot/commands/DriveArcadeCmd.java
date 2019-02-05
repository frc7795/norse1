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
    public DriveArcadeCmd() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

      private static double clip(double val) {
        //return max(-1.0, min(1.0, val));
        return val;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double power = Robot.oi.getDriverLeftStickY();
        double steering = Robot.oi.getDriverRightStickX();

        double powerLeft = clip(power + steering);
        double powerRight = clip(power - steering);

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
