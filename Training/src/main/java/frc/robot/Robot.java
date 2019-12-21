/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import java.util.Timer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot 
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {
  //JoyStick
  public Joystick xboxcontroller = new Joystick(0);
  //public static JoySticks operatorStick = new JoySticks(1);
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private long timems;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  PWMTalonSRX PWMTalonSRX1 = new PWMTalonSRX(1);
  PWMTalonSRX PWMTalonSRX2 = new PWMTalonSRX(2);
  PWMTalonSRX PWMTalonSRX3 = new PWMTalonSRX(3);
  PWMTalonSRX PWMTalonSRX4 = new PWMTalonSRX(0);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    this.PWMTalonSRX3.setInverted(true);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
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
  @Override
  public void autonomousInit() {
   m_autoSelected = m_chooser.getSelected();
   // autoSelected = SmartDashboard.getString("Auto Selector");
   // defaultAuto);
   System.out.println("Auto selected: " + m_autoSelected);
   timems = System.currentTimeMillis();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
   if (java.lang.System.currentTimeMillis() - timems >=2000){
      this.PWMTalonSRX1.set(0.5);
      this.PWMTalonSRX2.set(-0.5);
      this.PWMTalonSRX3.set(0.5);
      this.PWMTalonSRX4.set(0.5);
    }
    this.PWMTalonSRX1.set(0.5);
    this.PWMTalonSRX2.set(-0.5);
    this.PWMTalonSRX3.set(0.5);
    this.PWMTalonSRX4.set(0.5);
   
  }

  /**
   * This function is called periodically during operator control.
   */
  /**
   *  *This gets control points for controllers
   */
  @Override
  public void teleopPeriodic() {
    if (java.lang.System.currentTimeMillis() - timems >=2000){
      this.PWMTalonSRX1.set(xboxcontroller.getRawAxis(1));
      this.PWMTalonSRX2.set(xboxcontroller.getRawAxis(1));
      this.PWMTalonSRX3.set(xboxcontroller.getRawAxis(5));
      this.PWMTalonSRX4.set(xboxcontroller.getRawAxis(5));
    }
    this.PWMTalonSRX1.set(xboxcontroller.getRawAxis(1));
    this.PWMTalonSRX2.set(xboxcontroller.getRawAxis(1));
    this.PWMTalonSRX3.set(xboxcontroller.getRawAxis(5));
    this.PWMTalonSRX4.set(xboxcontroller.getRawAxis(5));
    
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
 
    }  
  }
