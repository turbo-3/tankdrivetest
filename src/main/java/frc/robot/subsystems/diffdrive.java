package frc.robot.subsystems;


import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.sim.TalonFXSimState.MotorType;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix6.controls.Follower;




public class diffdrive extends SubsystemBase{
    TalonFX leftLeader = new TalonFX(Constants.LLPORT);
    TalonFX leftFollower = new TalonFX(Constants.LFPORT);
    TalonFX rightLeader = new TalonFX(Constants.RLPORT);
    TalonFX rightFollower = new TalonFX(Constants.RFPORT);
    
    //whoa idk how to make an encoder so placeholder XD

    public diffdrive(){
        TalonFXConfiguration leftLeaderConfig = new TalonFXConfiguration();
        TalonFXConfiguration leftFollowerConfig = new TalonFXConfiguration();
        TalonFXConfiguration rightLeaderConfig = new TalonFXConfiguration();
        TalonFXConfiguration rightFollowerConfig = new TalonFXConfiguration();
        //leader motors
        leftLeaderConfig.CurrentLimits.StatorCurrentLimit = 40;
        leftLeaderConfig.CurrentLimits.SupplyCurrentLimit = 40;
        leftLeaderConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        leftLeaderConfig.CurrentLimits.SupplyCurrentLimitEnable = true;

        leftLeaderConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

        leftLeader.getConfigurator().apply(leftLeaderConfig);

        rightLeaderConfig.CurrentLimits.StatorCurrentLimit = 40;
        rightLeaderConfig.CurrentLimits.SupplyCurrentLimit = 40;
        rightLeaderConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        rightLeaderConfig.CurrentLimits.SupplyCurrentLimitEnable = true;

        rightLeaderConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        rightLeader.getConfigurator().apply(rightLeaderConfig);

        //follower motors


    }
    public void tankdrive(double leftSpeed, double rightSpeed) {
        leftLeader.set(leftSpeed);
        rightLeader.set(rightSpeed);
    }
}

