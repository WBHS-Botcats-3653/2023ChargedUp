package frc.robot.subsystems;

import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.DigitalInput;

// Sensor Inputs
public class SI {
    
    private static SI m_singleton;

	// limit switches
	private static DigitalInput topLimitSwitch = new DigitalInput(kTopLimitSwitchPort);
	private static DigitalInput bottomLimitSwitch = new DigitalInput(kBottomLimitSwitchPort);

	public static SI getInstance() {
		if (m_singleton == null) {
			m_singleton = new SI();
		}
		return m_singleton;
	}

	// return true if the top limit switch is pressed
	public static boolean topSwitchDown() {
		return topLimitSwitch.get();
	}

	// returns true if the bottom limit switch is pressed
	public static boolean bottomSwitchDown() {
		return bottomLimitSwitch.get();
	}

	// return true if the top limit switch is not pressed
	public static boolean topSwitchUp() {
		return !topLimitSwitch.get();
	}

	// returns true if the bottom limit switch is not pressed
	public static boolean bottomSwitchUp() {
		return !bottomLimitSwitch.get();
	}
}
