package frc.robot.control;

import edu.wpi.first.wpilibj.Joystick;

public class XboxMap extends Joystick{
	  public static double DEADZONE_MAGIC_NUMBER = .10;
	    
	    public static int LEFT_STICK_X = 0, LEFT_STICK_Y = 1, RIGHT_STICK_X = 4, RIGHT_STICK_Y = 5;
	    public static int A_BUTTON = 1, B_BUTTON = 2, X_BUTTON = 3, Y_BUTTON = 4, 
	                        LB = 5, RB = 6, SELECT = 7, START = 8, LEFT_JOY_CLICK = 9, RIGHT_JOY_CLICK = 10;
	    
	    // XBox Controller
	    public static int LEFT_TRIGGER = 2, RIGHT_TRIGGER = 3;
	    
	    //PlayStation Controller
//	    private static int LEFT_TRIGGER = 3, RIGHT_TRIGGER = 4;
	    
	    public XboxMap(int port)
	    {
	        super(port);
	    }
	    
	    public static double deadzone(double d) {
	        //whenever the controller moves LESS than the magic number, the 
	        //joystick is in the loose position so return zero - as if the 
	        //joystick was not moved
	        if (Math.abs(d) < DEADZONE_MAGIC_NUMBER) {
	            return 0;
	        }
	        
	        if (d == 0)
	        {
	            return 0;
	        }
	        //When the joystick is used for a purpose (passes the if statements, 
	        //hence not just being loose), do math
	        return (d / Math.abs(d)) * ((Math.abs(d) - DEADZONE_MAGIC_NUMBER) / (1 - DEADZONE_MAGIC_NUMBER)); //scales it
	    }
	    
	    public double getLeftStickX() {
	        return deadzone(this.getRawAxis(LEFT_STICK_X));
	    }

	    public double getLeftStickY() {
	        return deadzone(this.getRawAxis(LEFT_STICK_Y));
	    }

	    public double getRightStickX() {
	        return deadzone(this.getRawAxis(RIGHT_STICK_X));
	    }

	    public double getRightStickY() {
	        return deadzone(this.getRawAxis(RIGHT_STICK_Y));
	    }

	    public boolean isXButtonPressed() {
	        return this.getRawButton(X_BUTTON);
	    }

	    public boolean isYButtonPressed() {
	        return this.getRawButton(Y_BUTTON);
	    }

	    public boolean isAButtonPressed() {
	        return this.getRawButton(A_BUTTON);
	    }

	    public boolean isBButtonPressed() {
	        return this.getRawButton(B_BUTTON);
	    }

	    public boolean isRBButtonPressed() {
	        return this.getRawButton(RB);
	    }

	    public boolean isLBButtonPressed() {
	        return this.getRawButton(LB);
	    }

	    public boolean isLeftJoyClick() {
	        return this.getRawButton(RIGHT_JOY_CLICK);
	    }

	    public boolean isRightJoyClick() {
	        return this.getRawButton(LEFT_JOY_CLICK);
	    }

	    public boolean isSelectButtonPressed() {
	        return this.getRawButton(SELECT);
	    }

	    public boolean isStartButtonPressed() {
	        return this.getRawButton(START);
	    }
	    
	    public double getTriggerValue() {
	    	double value = 0.0;
	    	if (this.getRawAxis(RIGHT_TRIGGER)  != 0.0 && this.getRawAxis(LEFT_TRIGGER) == 0.0){
	    		value = deadzone(this.getRawAxis(RIGHT_TRIGGER));
		    	}else if (this.getRawAxis(LEFT_TRIGGER)  != 0.0 && this.getRawAxis(RIGHT_TRIGGER) == 0.0) {
		    		value = -deadzone(this.getRawAxis(LEFT_TRIGGER));
		    	}
	    	return value;
	    }
//	    public double shiftValue(double value){
//	    	return ((value + 1) /2);
//	    }
//	    public double getTriggerValue() {
//	    	double value = 0.0;
//	    	if (shiftValue(this.getRawAxis(RIGHT_TRIGGER))  != 0.0 && shiftValue(this.getRawAxis(LEFT_TRIGGER)) == 0.0){
//	    		value = deadzone(shiftValue(this.getRawAxis(RIGHT_TRIGGER)));
//		    	}else if (shiftValue(this.getRawAxis(LEFT_TRIGGER))  != 0.0 && shiftValue(this.getRawAxis(RIGHT_TRIGGER)) == 0.0) {
//		    		value = -deadzone(shiftValue(this.getRawAxis(LEFT_TRIGGER)));
//		    	}
//	    	return value;
//		    	
//	    	
//	    }

	    public double getRightTrigger() {
	    	return this.getRawAxis(RIGHT_TRIGGER);
	    }

	    public double getLeftTrigger() {
	    	return this.getRawAxis(LEFT_TRIGGER);
	    }
	    
	    public void checkControllerPorts()
	    {
	        
	    }
	}

