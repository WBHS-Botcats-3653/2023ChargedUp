package frc.robot.subsystems;

import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.XboxController;

public class OI {
    private static OI m_singleton = null;
    public XboxController m_controller;
    
    private OI() {
        m_controller = new XboxController(kXboxPort);
    }

    public static OI getInstance() {
		if (m_singleton == null) {
			m_singleton = new OI();
		}
		return m_singleton;
	}

    public double getLeftX() {
        return m_controller.getLeftX();
    }

    public double getLeftY() {
        return m_controller.getLeftY();
    }

    public double getRightX() {
        return m_controller.getRightX();
    }

    public double getRightY() {
        return m_controller.getRightY();
    }
}
