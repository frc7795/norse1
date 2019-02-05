/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;


public class Drivetrain extends Subsystem {
    private VictorSP leftDriveMain = new VictorSP(RobotMap.LEFT_DRIVE_MAIN);
    private VictorSP leftDriveFollower = new VictorSP(RobotMap.LEFT_DRIVE_FOLLOWER);
    private VictorSP rightDriveMain = new VictorSP(RobotMap.RIGHT_DRIVE_MAIN);
    private VictorSP rightDriveFollower = new VictorSP(RobotMap.RIGHT_DRIVE_FOLLOWER);

    private double speedScale = 0.2;
    public Drivetrain(){
        leftDriveMain.setInverted(true);
        leftDriveFollower.setInverted(true);
        rightDriveMain.setInverted(false);
        rightDriveFollower.setInverted(false);
    }

    public void drive(double leftPow, double rightPow) {
        leftPow *= speedScale;
        rightPow *= speedScale;
        leftDriveMain.set(leftPow);
        leftDriveFollower.set(leftPow);
        rightDriveMain.set(rightPow);
        rightDriveFollower.set(rightPow);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());

        //setDefaultCommand(new DriveTankCmd());
        setDefaultCommand(new DriveArcadeCmd());
    }
}
