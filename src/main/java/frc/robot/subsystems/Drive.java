package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    private SparkMax leftLeader = new SparkMax(0, MotorType.kBrushed);
    private SparkMax leftFollower = new SparkMax(1, MotorType.kBrushed);
    private SparkMax rightLeader = new SparkMax(2, MotorType.kBrushed);
    private SparkMax rightFollower = new SparkMax(3, MotorType.kBrushed);

    public Command drive(DoubleSupplier right, DoubleSupplier left) {
        return run(() -> {
            leftLeader.set(left.getAsDouble());
            leftFollower.set(left.getAsDouble());
            rightLeader.set(-right.getAsDouble());
            rightFollower.set(-right.getAsDouble());
        });
    }
}
