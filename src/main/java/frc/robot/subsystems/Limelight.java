package frc.robot.subsystems;

//import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

    private static Limelight m_singleton = null;
    private NetworkTable m_table;

    public Limelight() {
        m_table = NetworkTableInstance.getDefault().getTable("limelight");
    }

    public static Limelight getInstance() {
		if (m_singleton == null) {
			m_singleton = new Limelight();
		}
		return m_singleton;
	}

    public void SmartDashboardPeriodic() {
        double x = m_table.getEntry("tx").getDouble(0);
        double y = m_table.getEntry("ty").getDouble(0);
        double area = m_table.getEntry("ta").getDouble(0);
        double skew = m_table.getEntry("ts").getDouble(0);
        

        SmartDashboard.putNumber("Limelight X", x);
        SmartDashboard.putNumber("Limelight Y", y);
        SmartDashboard.putNumber("Limelight Area", area);
        SmartDashboard.putNumber("Limelight Skwe", skew);
    }
}