package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    private SparkMax leftLeader = new SparkMax(1, MotorType.kBrushed);
    private SparkMax leftFollower = new SparkMax(2, MotorType.kBrushed);
    private SparkMax rightLeader = new SparkMax(5, MotorType.kBrushed);
    private SparkMax rightFollower = new SparkMax(6, MotorType.kBrushed);

    public Drive() {
      var config = new SparkMaxConfig();
      leftLeader.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
      leftFollower.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
      rightLeader.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
      rightFollower.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public Command drive(DoubleSupplier right, DoubleSupplier left) {
        return run(() -> {
            leftLeader.set(-left.getAsDouble());
            leftFollower.set(-left.getAsDouble());
            rightLeader.set(right.getAsDouble());
            rightFollower.set(right.getAsDouble());
        });
    }
}
