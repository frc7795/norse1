/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Drive train
    public static final int LEFT_DRIVE_MAIN = 2;
    public static final int LEFT_DRIVE_FOLLOWER = 3;
    public static final int RIGHT_DRIVE_MAIN = 0;
    public static final int RIGHT_DRIVE_FOLLOWER = 1;

    // Pneumatics solenoids
    public static final int PNEU_UP = 0;
    public static final int PNEU_DOWN = 1;

    // Cargo trigger
    public static final int CARGO_SERVO_1 = 6;
    public static final int CARGO_SERVO_2 = 7;
}
