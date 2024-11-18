package unitTests;

import issPageClasses.AppointmentCalendarPage;
import issPageClasses.ApptRequestPage;
import issPageClasses.CancelApptPage;
import issPageClasses.ChangeLocationModalPage;
import issPageClasses.CheckInApptPage;
import issPageClasses.CheckOutApptPage;
import issPageClasses.ClinicStopCodeModalPage;
import issPageClasses.ConfirmMoveApptChange;
import issPageClasses.EditAppointmentPage;
import issPageClasses.ExpandEntryModalPage;
import issPageClasses.HeaderModalPage;
import issPageClasses.HomePage;
import issPageClasses.MissionActEligibleModalPage;
import issPageClasses.NewApptPage;
import issPageClasses.OverbookModalPage;
import issPageClasses.PatientEligibilityModalPage;
import issPageClasses.PatientHeaderModalPage;
import issPageClasses.PatientPage;
import issPageClasses.PatientRecordFlagsModalPage;
import issPageClasses.PendingAppointmentsTablePage;
import issPageClasses.PreviewPatientLetterModalPage;
import issPageClasses.Resources;
import issPageClasses.SensitiveRecordModalPage;
import issPageClasses.SignOnPage;
import issPageClasses.ViewAppointment;
import platformIndependentCore.scripts.Arguments;
import platformIndependentCore.scripts.TestScript;
import platformIndependentCore.utilities.ConfigProperties;

/**
 * <b>Name :</b> BlackBoxExistingAppointmentDragAndDropAnotherSlot.java
 * <p>
 * <b>Generated :</b> May 21, 2024
 * <p>
 * <b>Description :</b>
 * <p>
 *
 * @since May 21, 2024
 * @author OITSDCLEWIST
 */

public class BlackBoxExistingAppointmentDragAndDropAnotherSlot extends TestScript {

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
		CancelApptPage cap = new CancelApptPage();
		ViewAppointment va = new ViewAppointment();
		ClinicStopCodeModalPage ctcmp = new ClinicStopCodeModalPage();
		EditAppointmentPage eap = new EditAppointmentPage();
		ExpandEntryModalPage eemp = new ExpandEntryModalPage();
		CheckInApptPage ciap = new CheckInApptPage();
		CheckOutApptPage coap = new CheckOutApptPage();
		PendingAppointmentsTablePage patp = new PendingAppointmentsTablePage();
		OverbookModalPage obmp = new OverbookModalPage();
		MissionActEligibleModalPage maemp = new MissionActEligibleModalPage();
		ConfirmMoveApptChange cmac = new ConfirmMoveApptChange();
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

		// enter search string to cause name page to appear
		phmp.setSearchPatientInput("TEST,AKASH");
		sleep(5);

		phmp.selectPatientByName("TEST,AKASH");
		sleep(5);

		// Click on Patient Eligibility Acknowledge Button
		pemp.clickBtnPatientEligibilityAcknowledge();
		// Click on Patient Tab
		// hp.clickTabPatient();
		sleep(2);

		// click on the Patient button
		hmp.clickBtnPatient();
		pp.clickBtnAppointmentRequestsNewRequest();
		pp.clickBtnAppointmentRequestsNewRequestAppt();
		sleep(5);

		// Verify and Click the Service Radio Button
		arp.clickBtnService();

		// Verify and Click the Clinic Radio Button
		arp.clickBtnClinic();

		arp.setSearchClinicInput("AUTO BLACKBOX COUNT");
		sleep(5);

		// select the clinic by name
		arp.selectClinicByName("AUTO BLACKBOX COUNT");
		sleep(5);
		// Type Comment
		arp.setComments("BLACKBOX TESTING");
		if (arp.isBtnCreateRequestEnabled()) {
			arp.clickBtnCreateRequest();
		} else {
			arp.clickBtnCancel();
		}
		sleep(2);

		// Click Appointment Requests Reset Filter Button
		pp.clickBtnAppointmentRequestsResetFilters();
		// sleep statement
		sleep(3);

		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("CLINIC/SERVICE");

		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by CLINIC/SERVICE");

		String filter = r.getFilterType("CLINIC/SERVICE");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("CLINIC/SERVICE", filter, "AUTO BLACKBOX COUNT");

		// sleep statement
		sleep(3);
		// Press escape key
		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("APPT");
		sleep(3);
		pp.clickLstAppointmentRequestsActionsMenuItem("Appointment", "New");
		// sleep statement
		sleep(10);
		// Fetch this data from the Patient.csv
		String tsDateBegin = "6/11/2024";
		String tsStartTimeBegin = "10:00 AM";

		if (tsDateBegin.equalsIgnoreCase("tomorrow")) {
			tsDateBegin = r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateBegin);
		}

		r.scrollIntoView(acp.selectTimeSlotBySeparateDateTime(tsDateBegin, tsStartTimeBegin));

		r.clickBtnRightMouseContext(acp.selectScheduleDateTimeSlotCount(tsDateBegin, tsStartTimeBegin));
		sleep(5);

		acp.clickSlotPopupScheduleAppointmentMenuItem("Create Appointment");
		sleep(5);

		// Verify you are on New Appointment page
		vpEquals("Verify New Appointment Page is displayed", "New Appointment", nap.readLblNewAppointment());

		nap.selectBenefitEligibility("SHARING AGREEMENT");
		sleep(3);

		maemp.clickBtnClose();
		sleep(2);
		nap.clickBtnCreateAppointment();
		sleep(3);

		pplmp.clickBtnPreviewPatientLetterCancelIcon();
		sleep(5);

		hmp.clickBtnHome();
		sleep(3);

		hp.clickTabClinic();
		sleep(3);

		hp.setSearchClinicInput("AUTO BLACKBOX COUNT");
		sleep(3);
		hp.selectClinicByName("AUTO BLACKBOX COUNT");
		sleep(10);

		int dragFromX = -1;
		int dragFromY = -20;
		int holdAtX = -1;
		int holdAtY = 0;
		String patient = "TEST,AKASH";

		String tsEndTimeBegin = "10:30 AM";
		String tsDateNext = "6/12/2024";
		String tsStartTimeNext = "10:00 AM";

		sleep(5);

		// select date as today
		if (tsDateBegin.equalsIgnoreCase("tomorrow")) {
			tsDateBegin = r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateBegin);
		}

		// select date as tomorrow
		if (tsDateBegin.equalsIgnoreCase("tomorrow")) {
			tsDateBegin = r.readTomorrowsDate("M/d/yyyy");
			System.out.println(tsDateBegin);
		}

		// scroll the main page to the bottom to see the table better
		r.scrollBottom();

		addNote("Start of Drag and Hold");
		acp.selectDragAndHoldTimeSlot(
				acp.selectAppointmentByDateAndStartTime(tsDateBegin, tsStartTimeBegin, tsEndTimeBegin, patient),
				dragFromX, dragFromY, acp.selectTimeSlotBySeparateDateTime(tsDateNext, tsStartTimeNext), holdAtX,
				holdAtY);
		addNote("End of Drag and Hold");

		acp.selectTimeSlotBySeparateDateTime(tsDateNext, tsStartTimeNext).click();
		sleep(10);

		cmac.clickBtnMoveApptConfirm();
		sleep(5);

		maemp.clickCloseIcon();
		sleep(3);

		// passing input data in text field for Reason For Cancellation
		cap.setReasonForCancellationInput("OTHER");
		sleep(2);
		// selecting reason for cancellation
		cap.selectReasonForCancellationByName("OTHER");
		sleep(2);

		// clicking Cancel Appointment button
		cap.clickBtnCancelAppointment();

		// sleep statement
		sleep(5);

		// click on close button from Appointment Successfully Cancelled pop up window
		cap.clickBtnClose();
		// click on the Patient button
		hmp.clickBtnPatient();
		sleep(5);

		// Click Appointment Requests Reset Filter Button
		pp.clickBtnAppointmentRequestsResetFilters();
		// sleep statement
		sleep(3);

		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("REQUEST");
		sleep(3);
		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by REQUEST");
		sleep(3);
		String filterPtcsch = r.getFilterType("REQUEST");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("REQUEST", filter, "VETERAN");
		sleep(3);
		// Press escape key
		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("VETERAN");
		sleep(3);
		pp.clickLstAppointmentRequestsActionsMenuItem("Appointment", "New");

		sleep(3);
		acp.setSearchClinicInput("AUTO BLACKBOX COUNT");
		sleep(3);

		acp.selectClinicByName("AUTO BLACKBOX COUNT");
		// sleep statement
		sleep(10);
		// Fetch this data from the Patient.csv
		String tsDateBeginVet = "6/13/2024";
		String tsStartTimeBeginVet = "10:15 AM";

		if (tsDateBeginVet.equalsIgnoreCase("nextAppt")) {
			tsDateBeginVet = r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateBeginVet);
		}

		r.scrollIntoView(acp.selectTimeSlotBySeparateDateTime(tsDateBeginVet, tsStartTimeBeginVet));
		sleep(5);
		r.clickBtnRightMouseContext(acp.selectScheduleDateTimeSlotCount(tsDateBeginVet, tsStartTimeBeginVet));
		sleep(5);

		acp.clickSlotPopupScheduleAppointmentMenuItem("Create Appointment");
		sleep(5);

		nap.selectBenefitEligibility("SHARING AGREEMENT");
		sleep(3);

		nap.clickBtnCreateAppointment();
		sleep(3);

		pplmp.clickBtnPreviewPatientLetterCancelIcon();
		sleep(5);

		hmp.clickBtnHome();
		sleep(3);

		hp.clickTabClinic();
		sleep(3);

		hp.setSearchClinicInput("AUTO BLACKBOX COUNT");
		sleep(3);
		hp.selectClinicByName("AUTO BLACKBOX COUNT");
		sleep(10);

		int dragPTFromX = -1;
		int dragPTFromY = -20;
		int holdPTAtX = -1;
		int holdPTAtY = 0;
		String patientPT = "TEST,AKASH";

		String tsEndTimeBeginPT = "10:45 AM";
		String tsDateNextPT = "6/16/2024";
		String tsStartTimeNextPT = "10:15 AM";

		sleep(5);

		// select date as today
		if (tsDateBeginVet.equalsIgnoreCase("tomorrow")) {
			tsDateBeginVet= r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateBeginVet);
		}

		// select date as tomorrow
		if (tsDateBeginVet.equalsIgnoreCase("tomorrow")) {
			tsDateBeginVet = r.readTomorrowsDate("M/d/yyyy");
			System.out.println(tsDateBeginVet);
		}

		// scroll the main page to the bottom to see the table better
		r.scrollBottom();

		addNote("Start of Drag and Hold");
		acp.selectDragAndHoldTimeSlot(
				acp.selectAppointmentByDateAndStartTime(tsDateBeginVet, tsStartTimeBeginVet, tsEndTimeBeginPT,
						patientPT),
				dragPTFromX, dragPTFromY, acp.selectTimeSlotBySeparateDateTime(tsDateNextPT, tsStartTimeNextPT),
				holdPTAtX, holdPTAtY);
		addNote("End of Drag and Hold");

		acp.selectTimeSlotBySeparateDateTime(tsDateNextPT, tsStartTimeNextPT).click();
		sleep(5);

		cmac.clickBtnMoveApptConfirm();
		sleep(5);

		// maemp.clickCloseIcon();
		// sleep(3);

		// passing input data in text field for Reason For Cancellation
		cap.setReasonForCancellationInput("OTHER");
		sleep(2);
		// selecting reason for cancellation
		cap.selectReasonForCancellationByName("OTHER");
		sleep(2);

		// clicking Cancel Appointment button
		cap.clickBtnCancelAppointment();

		// sleep statement
		sleep(5);
		// click on close button from Appointment Successfully Cancelled pop up window
		cap.clickBtnClose();
		// click on the Patient button
		hmp.clickBtnPatient();
		sleep(5);

		// Click Appointment Requests Reset Filter Button
		pp.clickBtnAppointmentRequestsResetFilters();
		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("REQUEST");
		sleep(3);
		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by REQUEST");
		sleep(3);
		String filterRTC = r.getFilterType("REQUEST");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("REQUEST", filter, "PtCSch");
		sleep(3);
		// Press escape key
		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("PtCSch");
		sleep(3);
		pp.clickLstAppointmentRequestsActionsMenuItem("Appointment", "New");

		// acp.setSearchClinicInput("CHY CARDIOLOGY");
		sleep(10);

		// acp.selectClinicByName("CHY CARDIOLOGY");
		sleep(3);
		// Fetch this data from the Patient.csv
		String tsDateBeginPh = "6/11/2024";
		String tsStartTimeBeginPh = "11:00 AM";

		if (tsDateBeginPh.equalsIgnoreCase("nextAppt")) {
			tsDateBeginPh = r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateBeginPh);
		}

		r.scrollIntoView(acp.selectTimeSlotBySeparateDateTime(tsDateBeginPh, tsStartTimeBeginPh));
		sleep(5);
		r.clickBtnRightMouseContext(acp.selectScheduleDateTimeSlotCount(tsDateBeginPh, tsStartTimeBeginPh));
		sleep(5);

		acp.clickSlotPopupScheduleAppointmentMenuItem("Create Appointment");
		sleep(5);

		nap.selectBenefitEligibility("SHARING AGREEMENT");
		sleep(3);

		nap.clickBtnCreateAppointment();
		sleep(3);

		pplmp.clickBtnPreviewPatientLetterCancelIcon();
		sleep(5);

		hmp.clickBtnHome();
		sleep(3);

		hp.clickTabClinic();
		sleep(3);

		hp.setSearchClinicInput("CHY TEST CLINIC 1");
		sleep(3);
		hp.selectClinicByName("CHY TEST CLINIC 1");
		sleep(10);

		int dragFromXPT = -1;
		int dragFromYPT = -20;
		int holdAtXPT = -1;
		int holdAtYPT = 0;
		String patientPTCSH = "TEST,AKASH";

		String tsEndTimeBeginPTCSH = "11:30 AM";
		String tsDateNextPTCSH = "6/12/2024";
		String tsStartTimeNextPTCSH = "11:00 AM";

		sleep(5);

// select date as today
		if (tsDateBeginPh.equalsIgnoreCase("tomorrow")) {
			tsDateBeginPh = r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateBeginPh);
		}

// select date as tomorrow
		if (tsDateBeginPh.equalsIgnoreCase("tomorrow")) {
			tsDateBeginPh = r.readTomorrowsDate("M/d/yyyy");
			System.out.println(tsDateBeginPh);
		}

// scroll the main page to the bottom to see the table better
		r.scrollBottom();
		r.clickBtnRightMouseContext(acp.selectScheduleDateTimeSlotCount(tsDateBeginPh, tsStartTimeBeginPh));
		sleep(5);

		// acp.clickSlotPopupScheduleAppointmentMenuItem("Undo Check In Patient");
		// sleep(5);

		addNote("Start of Drag and Hold");
		acp.selectDragAndHoldTimeSlot(
				acp.selectAppointmentByDateAndStartTime(tsDateBeginPh, tsStartTimeBeginPh, tsEndTimeBeginPTCSH,
						patientPTCSH),
				dragFromXPT, dragFromYPT, acp.selectTimeSlotBySeparateDateTime(tsDateNextPTCSH, tsStartTimeNextPTCSH),
				holdAtXPT, holdAtYPT);
		addNote("End of Drag and Hold");

		acp.selectTimeSlotBySeparateDateTime(tsDateNextPTCSH, tsStartTimeNextPTCSH).click();
		sleep(5);

		cmac.clickBtnMoveApptConfirm();
		sleep(5);
		// passing input data in text field for Reason For Cancellation
		cap.setReasonForCancellationInput("OTHER");
		sleep(2);
		// selecting reason for cancellation
		cap.selectReasonForCancellationByName("OTHER");
		sleep(2);

		// clicking Cancel Appointment button
		cap.clickBtnCancelAppointment();

		// sleep statement
		sleep(5);

		// click on close button from Appointment Successfully Cancelled pop up window
		cap.clickBtnClose();
		// click on the Patient button
		hmp.clickBtnPatient();
		sleep(5);

		// Click Appointment Requests Reset Filter Button
		pp.clickBtnAppointmentRequestsResetFilters();
		// sleep statement
		sleep(3);

		// clicking on the action option from the comment section
		pp.clickAppointmentRequestsColumnHeaderActionsMenu("CLINIC/SERVICE");

		// Click from Request Column Select Filter by Request
		pp.clickLstAppointmentRequestsHeaderActionMenuItem("Filter by CLINIC/SERVICE");

		// sending data from CSV file
		pp.setAppointmentRequestsColumnHeaderFilterInput("CLINIC/SERVICE", filter, "AUTO BLACKBOX NON-COUNT");

		// sleep statement
		sleep(3);
		// Press escape key
		r.pressEscapeKey();
		sleep(3);
		pp.clickAppointmentRequestsActionsRowWithColumnValue("RTC");
		sleep(3);
		pp.clickLstAppointmentRequestsActionsMenuItem("Appointment", "New");
		// sleep statement
		sleep(10);

		String tsDateBeginNC = "2/3/2025";
		String tsStartTimeBeginNC = "10:00 AM";

		if (tsDateBeginNC.equalsIgnoreCase("tomorrow")) {
			tsDateBeginNC = r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateBeginNC);
		}

		r.scrollIntoView(acp.selectTimeSlotBySeparateDateTime(tsDateBeginNC, tsStartTimeBeginNC));

		r.clickBtnRightMouseContext(acp.selectScheduleDateTimeSlotCount(tsDateBeginNC, tsStartTimeBeginNC));
		sleep(5);

		acp.clickSlotPopupScheduleAppointmentMenuItem("Create Appointment");
		sleep(5);

		// Verify you are on New Appointment page
		vpEquals("Verify New Appointment Page is displayed", "New Appointment", nap.readLblNewAppointment());

		nap.selectBenefitEligibility("SHARING AGREEMENT");
		sleep(3);

		nap.clickBtnCreateAppointment();
		sleep(3);

		pplmp.clickBtnPreviewPatientLetterCancelIcon();
		sleep(5);

		hmp.clickBtnHome();
		sleep(3);

		hp.clickTabClinic();
		sleep(3);

		hp.setSearchClinicInput("AUTO BLACKBOX NON-COUNT");
		sleep(3);
		hp.selectClinicByName("AUTO BLACKBOX NON-COUNT");
		sleep(10);

		int dragFromXNCount = -1;
		int dragFromYNCount = -20;
		int holdAtXNCount = -1;
		int holdAtYNCount = 0;
		String patientNCount = "TEST,AKASH";

		String tsEndTimeBeginNCount = "10:30 AM";
		String tsDateNextNCount = "2/4/2025";
		String tsStartTimeNextNCount = "10:00 AM";

		sleep(5);

		// select date as today
		if (tsDateBeginNC.equalsIgnoreCase("tomorrow")) {
			tsDateBeginNC = r.readCurrentDate("M/d/yyyy");
			System.out.println(tsDateBeginNC);
		}

		// select date as tomorrow
		if (tsDateBeginNC.equalsIgnoreCase("tomorrow")) {
			tsDateBeginNC = r.readTomorrowsDate("M/d/yyyy");
			System.out.println(tsDateBeginNC);
		}

		// scroll the main page to the bottom to see the table better
		r.scrollBottom();

		addNote("Start of Drag and Hold");
		acp.selectDragAndHoldTimeSlot(
				acp.selectAppointmentByDateAndStartTime(tsDateBeginNC, tsStartTimeBeginNC, tsEndTimeBeginNCount,
						patientNCount),
				dragFromXNCount, dragFromYNCount,
				acp.selectTimeSlotBySeparateDateTime(tsDateNextNCount, tsStartTimeNextNCount), holdAtXNCount,
				holdAtYNCount);
		addNote("End of Drag and Hold");

		acp.selectTimeSlotBySeparateDateTime(tsDateNextNCount, tsStartTimeNextNCount).click();
		sleep(10);

		cmac.clickBtnMoveApptConfirm();
		sleep(5);

		// maemp.clickCloseIcon();
		// sleep(3);

		// passing input data in text field for Reason For Cancellation
		cap.setReasonForCancellationInput("OTHER");
		sleep(2);
		// selecting reason for cancellation
		cap.selectReasonForCancellationByName("OTHER");
		sleep(2);

		// clicking Cancel Appointment button
		cap.clickBtnCancelAppointment();

		// sleep statement
		sleep(5);

		// click on close button from Appointment Successfully Cancelled pop up window
		cap.clickBtnClose();
	}

}
