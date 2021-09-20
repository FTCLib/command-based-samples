package org.firstinspires.ftc.teamcode.SimpleTeleSample.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import java.util.function.BooleanSupplier;

public class Intake extends SubsystemBase {
    private final Motor leftMotor, rightMotor;

    public Intake(Motor leftIntakeMotor, Motor rightIntakeMotor) {
        leftMotor = leftIntakeMotor;
        rightMotor = rightIntakeMotor;
    }

    public void activate() {
        leftMotor.set(0.75);
        rightMotor.set(-0.75);
    }

    public void stop() {
        leftMotor.set(0);
        rightMotor.set(0);
    }

    public void reverse() {
        leftMotor.set(-0.75);
        rightMotor.set(0.75);
    }
}
