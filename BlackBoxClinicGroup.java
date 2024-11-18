package unitTests;

import issPageClasses.AppointmentCalendarPage;
import issPageClasses.ApptRequestPage;
import issPageClasses.ChangeLocationModalPage;
import issPageClasses.ClinicStopCodeModalPage;
import issPageClasses.HeaderModalPage;
import issPageClasses.HomePage;
import issPageClasses.NewApptPage;
import issPageClasses.PatientEligibilityModalPage;
import issPageClasses.PatientHeaderModalPage;
import issPageClasses.PatientPage;
import issPageClasses.PatientRecordFlagsModalPage;
import issPageClasses.PreviewPatientLetterModalPage;
import issPageClasses.Resources;
import issPageClasses.SensitiveRecordModalPage;
import issPageClasses.SignOnPage;
import platformIndependentCore.scripts.Arguments;
import platformIndependentCore.scripts.TestScript;
import platformIndependentCore.utilities.ConfigProperties;

/**
 * <b>Name :</b> BlackBoxClinicGroup.java
 * <p>
 * <b>Generated :</b> Mar 18, 2024
 * <p>
 * <b>Description :</b>
 * <p>
 *
 * @since Mar 30, 2024
 * @author OITSDCLEWIST
 */

public class BlackBoxClinicGroup extends TestScript {

	/** URL for SSOI login for the active test environment */
	protected static final String BROWSER = ConfigProperties.getValue("BROWSER");

	/**
	 * Main method
	 *
	 * @param args Args
	 */
	public static void main(String[] args) {
		runScript(args);
	}

	@Override
	public void testScript(Arguments args) {
		// TODO ENTER SCRIPT CODE HERE

		// page classes used

		HomePage hp = new HomePage();
		ChangeLocationModalPage clmp = new ChangeLocationModalPage();
		PatientHeaderModalPage phmp = new PatientHeaderModalPage();
		SensitiveRecordModalPage srmp = new SensitiveRecordModalPage();
		PatientRecordFlagsModalPage prfmp = new PatientRecordFlagsModalPage();
		PatientEligibilityModalPage pemp = new PatientEligibilityModalPage();
		PatientPage pp = new PatientPage();
		HeaderModalPage hmp = new HeaderModalPage();
		Resources r = new Resources();
		ApptRequestPage arp = new ApptRequestPage();
		SignOnPage sp = new SignOnPage();
		AppointmentCalendarPage acp = new AppointmentCalendarPage();
		NewApptPage nap = new NewApptPage();
		PreviewPatientLetterModalPage pplmp = new PreviewPatientLetterModalPage();

		ClinicStopCodeModalPage ctcmp = new ClinicStopCodeModalPage();

		hp.loadPage();

		sp.clickSignInWithWindowsAuthentication();
		sleep(10);

		hmp.clickBtnFacilityLocation();
		sleep(3);

		// Select desire facility
		clmp.selectFacilityLocationByName("958: 958 Cheyenne VA Medical Center", "958: 958 Cheyenne VA Medical Center");
		sleep(3);

		// verify you are on the right facility
		vpEquals("Verify the Location", "958: 958 Cheyenne VA Medical Center", hmp.readBtnLblFacilityLocation());

		hmp.clickBtnHome();
		sleep(3);

		// Verify and Click the Clinic Radio Button
		hp.clickTabClinic();

		hp.setSearchClinicInput("CHY CARDIOLOGY");
		sleep(5);

		// select the clinic by name
		hp.selectClinicByName("CHY CARDIOLOGY");
		sleep(5);

// Verify the clinic was selected
		vpEquals("Verify the clinic was selected", "CHY CARDIOLOGY", acp.readDdlClinicSearchSelected());
		sleep(5);

		// acp.clickViewAllProviders();
		// sleep(3);

		acp.clickTabProviderSchedules();
		sleep(3);
		acp.setSearchProviderInput("CERVANTES,DEWAYNE J");
		sleep(3);

		acp.selectProviderByName("CERVANTES,DEWAYNE J");
		sleep(3);
		acp.setSearchClinicViewInput("CHY CPL CV STRESS");
		sleep(3);
		acp.selectClinicViewByName("CHY CPL CV STRESS");
		sleep(3);
		acp.clickTabClinicGroups();
		sleep(3);
		acp.setClinicGroupInfoInput("CHY CARDIOLOGY");
		sleep(3);
		acp.selectClinicGroupInfoByName("CHY CARDIOLOGY");
		sleep(5);

		acp.setSearchClinicViewInput("CHY TEST CLINIC 1");
		sleep(5);
		acp.selectClinicViewByName("CHY TEST CLINIC 1");
		sleep(5);

		// Verify the Patient SC Percent label displays on Appointment Request
		// Page
		vpEquals("Special Indtuctions label is displayed on Appointment Calendar Page", "SPECIAL INSTRUCTIONS",
				acp.readLblSpecialInstructions());
		sleep(3);
		// Verify the Patient Primary Eligibility label displays on Appointment
		// Request Page
		vpEquals("Special Indtuctions Info is displayed on Appointment Request Page",
				"SCHEDULE FOR 60 MIN|schedule for 30 min", acp.readTxtSpecialInstructions());
		sleep(3);
		vpEquals("Read clinic setup info", "Variable Length 30 Min Appt┃Max Overbook: 99┃Timezone: MOUNTAIN",
				acp.readHdrTxtClinicSetupInfo());
		sleep(3);
		vpEquals("Read 8:00 am StartTime on Appointment Request Page", "8:00 AM", acp.readLblStartTime());
		sleep(3);

		// vpEquals("Read CurrentTime on Appointment Request Page", "4:59 PM",
		// acp.readLblCurrentTime());
		// sleep(3);

		vpEquals("Read label Unavailable", "Unavailable", acp.readLblUnavailable());
		sleep(3);

		sleep(3);
		vpEquals("Read label Overbook", "Overbook", acp.readLblOverbook());
		sleep(3);

		vpEquals("Read label Available", "Available", acp.readLblAvailable());
		sleep(3);

		vpEquals("Read label Slot Count", "1", acp.readLblSlotCount());
		sleep(3);

		String tsDateBeginCalender = "tomorrow";
		String tsStartTimeBeginCalendar = "07:00 AM";
		String tsClinicName = "CHOICE-UEXB STRESS TEST";
		if (tsDateBeginCalender.equalsIgnoreCase("tomorrow")) {
			tsDateBeginCalender = r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateBeginCalender);
		}
		r.clickBtnLeftMouseAfterMove(acp.selectProviderTimeSlotBySeparateDateTime(tsDateBeginCalender,
				tsStartTimeBeginCalendar, tsClinicName));
		sleep(5);

		acp.getTimeSlotViewerAppointment(tsDateBeginCalender);
		sleep(5);

		vpEquals("Read label Patient Name", "TEST,AKASH", acp.readLblTimeSlotNameCount());
		sleep(3);
		vpEquals("Read label Appointment Type", "APPT", acp.readLblApptType());
		sleep(3);
		vpEquals("Read label DOB and SSN", "DOB:11/11/2011SSN (Last 4):1110", acp.readLblDateOfBirthSSN());
		sleep(3);
		vpEquals("Read label Time and Date", "5/31/2024, 7:00 AM - 5/31/2024, 7:30 AM", acp.readLblTimeAndDateAppt());
		sleep(5);

		String tsDateApptBeginCalender = "checkAppt";
		String tsStartTimeApptBeginCalendar = "09:15 AM";
		String tsClinicApptName = "CHOICE-UEXB STRESS TEST";
		if (tsDateApptBeginCalender.equalsIgnoreCase("checkAppt")) {
			tsDateApptBeginCalender = r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateApptBeginCalender);
		}
		r.clickBtnLeftMouseAfterMove(acp.selectProviderTimeSlotBySeparateDateTime(tsDateApptBeginCalender,
				tsStartTimeApptBeginCalendar, tsClinicApptName));
		sleep(5);

		acp.getTimeSlotViewerAppointment(tsDateApptBeginCalender);
		sleep(5);

		vpEquals("Read label Patient Name", "TEST,AKASH", acp.readLblTimeSlotNameCount());
		sleep(3);
		vpEquals("Read label Appointment Type", "APPT", acp.readLblApptType());
		sleep(3);
		vpEquals("Read label DOB and SSN", "DOB:11/11/2011SSN (Last 4):1110", acp.readLblDateOfBirthSSN());
		sleep(3);
		vpEquals("Read label Time and Date", "5/31/2024, 9:15 AM - 5/31/2024, 9:45 AM", acp.readLblTimeAndDateAppt());
		sleep(3);

		acp.setClinicGroupInfoInput("CHYTEST");
		sleep(3);
		acp.selectClinicGroupInfoByName("CHYTEST");
		sleep(5);

		r.scrollToElement();
		sleep(10);
	}

}