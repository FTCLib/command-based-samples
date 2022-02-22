package org.firstinspires.ftc.teamcode.SimpleTeleSample;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SimpleTeleSample.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.SimpleTeleSample.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.SimpleTeleSample.subsystems.Intake;

@TeleOp
public class SimpleTeleOp extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx gamepad = new GamepadEx(gamepad1);

        DriveSubsystem driveSystem = new DriveSubsystem(
                new Motor(hardwareMap, "left_drive_motor"),
                new Motor(hardwareMap, "right_drive_motor"),
                gamepad
        );

        Intake intake = new Intake(
                new Motor(hardwareMap, "left_intake_motor"),
                new Motor(hardwareMap, "right_intake_motor")
        );

        // button bindings for the intake
        gamepad.getGamepadButton(GamepadKeys.Button.A)
                .whenHeld(new InstantCommand(intake::activate, intake))
                .whenReleased(new InstantCommand(intake::stop, intake));
        gamepad.getGamepadButton(GamepadKeys.Button.B)
                .whenHeld(new InstantCommand(intake::reverse, intake))
                .whenReleased(new InstantCommand(intake::stop, intake));

        // sets the default command to the drive command so that it is always looking
        // at the value on the joysticks
        driveSystem.setDefaultCommand(new DriveCommand(driveSystem));

        // update telemetry every loop
        schedule(new RunCommand(telemetry::update));
    }
}
