package frc.robot.subsystems;


import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.hardware.core.CoreTalonFX;
import com.ctre.phoenix6.hardware.traits.HasTalonControls;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.sim.TalonFXSimState.MotorType;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.ControlRequest;



public class diffdrive extends SubsystemBase{
    TalonFX leftLeader = new TalonFX(Constants.LLPORT);
    TalonFX leftFollower = new TalonFX(Constants.LFPORT);
    TalonFX rightLeader = new TalonFX(Constants.RLPORT);
    TalonFX rightFollower = new TalonFX(Constants.RFPORT);

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

        leftLeaderConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        leftLeader.getConfigurator().apply(leftLeaderConfig);

        rightLeaderConfig.CurrentLimits.StatorCurrentLimit = 40;
        rightLeaderConfig.CurrentLimits.SupplyCurrentLimit = 40;
        rightLeaderConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        rightLeaderConfig.CurrentLimits.SupplyCurrentLimitEnable = true;

        rightLeaderConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

        rightLeader.getConfigurator().apply(rightLeaderConfig);

        //follower motors
        leftFollowerConfig.CurrentLimits.StatorCurrentLimit = 40;
        leftFollowerConfig.CurrentLimits.SupplyCurrentLimit = 40;
        leftFollowerConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        leftFollowerConfig.CurrentLimits.SupplyCurrentLimitEnable = true;

        leftFollower.getConfigurator().apply(leftFollowerConfig);
        leftFollower.setControl(new Follower(Constants.LFPORT, MotorAlignmentValue.Aligned));

        rightFollowerConfig.CurrentLimits.StatorCurrentLimit = 40;
        rightFollowerConfig.CurrentLimits.SupplyCurrentLimit = 40;
        rightFollowerConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        rightFollowerConfig.CurrentLimits.SupplyCurrentLimitEnable = true;

        rightFollower.getConfigurator().apply(rightFollowerConfig);
        rightFollower.setControl(new Follower(Constants.RFPORT, MotorAlignmentValue.Aligned));
    }
    public void tankdrive(double leftSpeed, double rightSpeed) {
        leftLeader.set(leftSpeed);
        rightLeader.set(rightSpeed);
    }

    //plan to make encoders here idk?
    

}

