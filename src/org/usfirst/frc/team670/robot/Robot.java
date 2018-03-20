/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team670.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends IterativeRobot {
	private Joystick leftStick;
	private Joystick rightStick;
	private TalonSRX left1, left2, right1, right2;
	//These values must be set to the proper motor inputs
	private static int leftM1 = 1, leftM2 = 2, rightM1 = 3, rightM2 = 0;

	@Override
	public void robotInit() {
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		left1 = new TalonSRX(leftM1);
		left2 = new TalonSRX(leftM2);
		right1 = new TalonSRX(rightM1);
		right2 = new TalonSRX(rightM2);

		left2.set(ControlMode.Follower, leftM1);
		//right2.set(ControlMode.Follower, rightM1);
	}

	@Override
	public void teleopPeriodic() {
		left1.set(ControlMode.PercentOutput, leftStick.getY());
		right2.set(ControlMode.PercentOutput, -rightStick.getY());
		right1.set(ControlMode.PercentOutput, rightStick.getY());
	}
}
