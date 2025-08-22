package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Roller extends SubsystemBase {
    private SparkMax spark = new SparkMax(4, MotorType.kBrushed);

    public Command run(double voltage) {
        return run(() -> spark.setVoltage(voltage));
    }
}
