package com.EventPlanner.Utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ErrorLoggerUtil {
	 private static final Logger logger = Logger.getLogger(ErrorLoggerUtil.class.getName());
	 
	 //setting up the Logger
	 static {
		 
		 try {		 
			 //change file location to whatever fits you :)
			FileHandler filehandler=new FileHandler("C:/Users/LENOVO/Documents/ErrorLogs/Error.log",true);
			filehandler.setFormatter(new SimpleFormatter());
			logger.addHandler(filehandler);
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 }
	 
	 //method which is called to log errors 
	 public static void logError(String errorSource,String message,Throwable error) {
		 
		 
		 if(error != null) {
			 logger.severe(errorSource+" :"+message+error.getMessage());
			 
		 }else {
			 logger.severe(errorSource+" :"+message);
		 }
		 
		 
		 
	 }
	 

}
