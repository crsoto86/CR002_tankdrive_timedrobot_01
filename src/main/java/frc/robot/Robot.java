/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
// Partially commented out by C. Rodriguez 2021-01-03 04:46 PM
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
// ---------------------------------------------------

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Commented out by C. Rodriguez 2021-01-04 6:46 PM
  /*
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  */

  // Added by C. Rodriguez 2021-01-03 4:54 PM
  // Define speed controllers here
  TalonSRX FWD_RIGHT_TalonSRX = new TalonSRX(0);
  TalonSRX AFT_RIGHT_TalonSRX = new TalonSRX(1);
  TalonSRX AFT_LEFT_TalonSRX = new TalonSRX(2);
  VictorSPX FWD_LEFT_VictorSPX = new VictorSPX(3);

  
  // TalonSRX AFT_RIGHT_TalonSRX = new TalonSRX(1);
  // TalonSRX AFT_LEFT_TalonSRX = new TalonSRX(3);
  // VictorSPX FWD_LEFT_VictorSPX = new VictorSPX(4);
  // -----------------------------------

  // Added by C. Rodriguez 2021-01-03 5:09 PM
  // Define Joystick input
  //private final Joystick m_stick = new Joystick(0);
  // ----------------------------------------------

  // Commented out by C. Rodriguez 2021-01-04 6:53 PM
  // Required by 'Benchtop Robot Program' example
  // private final Timer m_timer = new Timer();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // Commented out by C. Rodriguez 2021-01-04 6:50 PM
    /*
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    */
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */

   // Commented out by C. Rodriguez 2021-01-04 6:50 PM
   /*
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    m_timer.reset();
    m_timer.start();
  }
  */

  /**
   * This function is called periodically during autonomous.
   */
  // Commented out by C. Rodriguez 2021-01-04 6:51 PM
  /*
  @Override
  public void autonomousPeriodic() {
    // Commented out by C. Rodriguez 2021-01-03 5:14 PM
    
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
    

   
    
  }
  */
  

  /**
   * This function is called once when teleop is enabled.
   */
  @Override
  public void teleopInit() {
    //Added by C. Rodriguez 2021-01-03 5:23 PM
    // Set the motor output to neutral during init, example below:
    FWD_RIGHT_TalonSRX.set(ControlMode.PercentOutput,0);
    AFT_RIGHT_TalonSRX.set(ControlMode.PercentOutput, 0);
    AFT_LEFT_TalonSRX.set(ControlMode.PercentOutput,0);
    FWD_LEFT_VictorSPX.set(ControlMode.PercentOutput,0);

    // Set factory default to prevent unexpected behavior
    FWD_RIGHT_TalonSRX.configFactoryDefault();
    AFT_RIGHT_TalonSRX.configFactoryDefault();
    AFT_LEFT_TalonSRX.configFactoryDefault();
    FWD_LEFT_VictorSPX.configFactoryDefault();

    // set neutral mode
    FWD_RIGHT_TalonSRX.setNeutralMode(NeutralMode.Brake);
    AFT_RIGHT_TalonSRX.setNeutralMode(NeutralMode.Brake);
    AFT_LEFT_TalonSRX.setNeutralMode(NeutralMode.Brake);
    FWD_LEFT_VictorSPX.setNeutralMode(NeutralMode.Brake);

    // Configure output direction
    FWD_RIGHT_TalonSRX.setInverted(false);
    AFT_RIGHT_TalonSRX.setInverted(false);
    AFT_LEFT_TalonSRX.setInverted(false);
    FWD_LEFT_VictorSPX.setInverted(false);

    // Print to system
    // System.out.println("Teleop Init completed...");
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    //Added by C. Rodriguez 2021-01-03 5:16 PM
    // Use m_stick.getX() to set the speed on the speed controller
    //double forward = -1 * m_stick.getX();
    //forward = Deadband(forward);
    //System.out.println("test");

    // Set the percent output for the motor controller
    FWD_RIGHT_TalonSRX.set(ControlMode.PercentOutput,1);
    AFT_RIGHT_TalonSRX.set(ControlMode.PercentOutput,1);
    AFT_LEFT_TalonSRX.set(ControlMode.PercentOutput,1);
    FWD_LEFT_VictorSPX.set(ControlMode.PercentOutput,1);
  }

  // Added by C. Rodriguez 2021-01-03 5:37 PM
  // Per CTRE Phoenix examples for ArcadeDrive_ArbFeedForward
  // Defines the Deadband method used in teleopPeriodic above
  // Deadband is 5 percent for use with gamepad.

  /*
  double Deadband(final double value) {
    // Upper deadband
    if (value >= +0.05)
    return value;

    // Lower deadband
    if (value <= -0.05)
    return value;

    // Outside deadband
    return 0;
  }
  */

  // Commented out by C. rodriguez 2021-01-04 6:59 PM
  /**
   * This function is called once when the robot is disabled.
   */
  /*
  @Override
  public void disabledInit() {
  }
  */

  /**
   * This function is called periodically when disabled.
   */
  /*
  @Override
  public void disabledPeriodic() {
  }*/

  /**
   * This function is called once when test mode is enabled.
   */
  /*
  @Override
  public void testInit() {
  }*/

  /**
   * This function is called periodically during test mode.
   */
  /*
  @Override
  public void testPeriodic() {
  }*/
  
}
