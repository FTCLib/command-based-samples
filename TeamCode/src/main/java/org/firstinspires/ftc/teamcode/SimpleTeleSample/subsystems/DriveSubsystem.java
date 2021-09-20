package org.firstinspires.ftc.teamcode.SimpleTeleSample.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import java.util.function.DoubleSupplier;

public class DriveSubsystem extends SubsystemBase {
    private DoubleSupplier leftSpeed, rightSpeed;
    private DifferentialDrive drive;

    public DriveSubsystem(Motor leftMotor, Motor rightMotor,
                          GamepadEx gamepad) {
        leftSpeed = gamepad::getLeftY;
        rightSpeed = gamepad::getRightY;
        drive = new DifferentialDrive(leftMotor, rightMotor);
    }

    public void drive() {
        drive.tankDrive(leftSpeed.getAsDouble(), rightSpeed.getAsDouble());
    }
}
