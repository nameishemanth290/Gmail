package com.google.gmail.testscripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Sample {
	public static void main(String[] args) {
		/*ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new 
									ExtentSparkReporter("./extentReports/reports.html");
		extentReports.attachReporter(sparkReporter);
		
		ExtentTest test = extentReports.createTest("TC001");
		test.log(Status.PASS, "The Browser Successfully");
		String path = "D:\\GitHub\\Gmail\\errorShots\\abc.png";
		//test.addScreenCaptureFromPath("D:\\GitHub\\Gmail\\errorShots\\abc.png");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		extentReports.flush();*/
		System.out.println(System.getProperty("user.dir")+"/errorshots/TC0012020-12-30T16-02-28.818.png");
	}
}
