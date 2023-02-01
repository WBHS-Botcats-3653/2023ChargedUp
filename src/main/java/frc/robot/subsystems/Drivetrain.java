package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import static frc.robot.Constants.*;
//import edu.wpi.first.wpilibj.interfaces.*;

public class Drivetrain {
    private static Drivetrain m_singleton = null;

    WPI_VictorSPX m_frontLeftMotor, m_frontRightMotor, m_rearLeftMotor, m_rearRightMotor;

    private MecanumDrive m_robotDrive;

    private XboxController m_controller; 

    private ADXRS450_Gyro m_gyro;
    
    public Drivetrain() {
        m_frontLeftMotor = new WPI_VictorSPX(kFrontLeftChannel);
        m_rearLeftMotor = new WPI_VictorSPX(kRearLeftChannel);
        m_frontRightMotor = new WPI_VictorSPX(kFrontRightChannel);
        m_rearRightMotor = new WPI_VictorSPX(kRearRightChannel);

        // Invert the right side motors.
        // You may need to change or remove this to match your robot.
        m_frontRightMotor.setInverted(true);
        m_rearRightMotor.setInverted(true);

        m_robotDrive = new MecanumDrive(m_frontLeftMotor, m_rearLeftMotor, m_frontRightMotor, m_rearRightMotor);

        m_controller = new XboxController(0);

        m_gyro = new ADXRS450_Gyro();
        m_gyro.calibrate();
        //Rotation2d rotation = m_gyro.getRotation2d();
    }

    //Returns an instance of DrainTrain, creating an instance only when one does not already exist
	public static Drivetrain getInstance() {
		if (m_singleton == null) {
			m_singleton = new Drivetrain();
		}
		return m_singleton;
	}
    
    public void drivePeriodic() {
        //Use the joystick Y axis for forward movement, X axis for lateral
        // movement, and Z axis for rotation.
        /*if (Math.abs(rotation.sin()) < 1e-9) {
            // rotation is approximately horizontal
            m_robotDrive.driveCartesian(m_controller.getLeftY(), m_controller.getLeftX(), m_controller.getRightX(), m_gyro.getRotation2d());
        } else {
            // rotation is not approximately horizontal
            m_robotDrive.driveCartesian(-m_controller.getLeftY(), m_controller.getLeftX(), m_controller.getRightX(), m_gyro.getRotation2d());
        }*/
        m_robotDrive.driveCartesian(-m_controller.getLeftY(), m_controller.getLeftX(), m_controller.getRightX());
    } 

    //Calibrates the gyro
	public void calibrateGyro() {
		m_gyro.calibrate();
	}

    //Returns the gyro
	public ADXRS450_Gyro getGyro() {
		return m_gyro;
	}

	//Returns the angle
	public double getAngle() {
		return m_gyro.getAngle();
	}

	//Returns the rate
	public double getRate() {
		return m_gyro.getRate();
	}
}
