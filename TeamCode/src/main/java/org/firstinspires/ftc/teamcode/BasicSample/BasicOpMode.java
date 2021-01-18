package org.firstinspires.ftc.teamcode.BasicSample;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.BasicSample.commands.RunMotorCommand;
import org.firstinspires.ftc.teamcode.BasicSample.commands.StopMotorCommand;
import org.firstinspires.ftc.teamcode.BasicSample.subsystems.BasicSubsystem;

@TeleOp
public class BasicOpMode extends CommandOpMode {
    private BasicSubsystem subsystem;
    private GamepadEx gamepad;

    @Override
    public void initialize() {
        gamepad = new GamepadEx(gamepad1);

        subsystem = new BasicSubsystem(hardwareMap.get(DcMotor.class, "motor"), telemetry);

        // bindings
        gamepad.getGamepadButton(GamepadKeys.Button.A)
                .whenPressed(new RunMotorCommand(subsystem));
        gamepad.getGamepadButton(GamepadKeys.Button.B)
                .whenPressed(new StopMotorCommand(subsystem));
    }
}
