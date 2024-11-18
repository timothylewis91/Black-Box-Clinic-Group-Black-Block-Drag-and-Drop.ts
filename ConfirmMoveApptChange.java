package issPageClasses;

import platformIndependentCore.core.AutomatedObject;
import platformIndependentCore.core.Search;

/**
 * <b>Name :</b> ConfirmMoveApptChange.java
 * <p>
 * <b>Generated :</b> Dec 30, 2023
 * <p>
 * <b>Description :</b> Concrete class to work with objects on the Confirm No
 * Show Modal Page
 * <p>
 *
 * @since May 29, 2024
 * @author OITSDCLEWIST
 */
public class ConfirmMoveApptChange extends IssBase {

	/**
	 * Constructor
	 */
	public ConfirmMoveApptChange() {

		// Do not set a page url here
	}

	/**
	 * page classes and resources
	 */
	Resources r = new Resources();

	/**
	 * get the Confirm No Show Modal form object.
	 *
	 * @return object
	 */
	private AutomatedObject getMoveApptDate() {
		return getObjectById("appt-verify-modal");
	}

	/**
	 * get the Confirm No Show Modal form Shadow Root.
	 *
	 * @return object
	 */
	private AutomatedObject getShadowRootMoveApptModal() {
		return getMoveApptDate();
	}

	/**
	 * get the Cancel button object.
	 *
	 * @return button object
	 */
	private AutomatedObject getBtnCancel() {
		Search search = getSearch();

		// Set the shadow-root parent so that we can find the object within that
		// shadow-root
		search.setShadowRoot(getShadowRootMoveApptModal());

		search.addCriteria("css", "#modal-secondary-button");
		return getObject(search);
	}

	/**
	 * read the Cancel button label.
	 *
	 * @return button label string
	 */
	public String readBtnLblBtnConfirmNoShowCancel() {
		return getBtnCancel().readText();
	}

	/**
	 * click the Cancel button.
	 */
	public void clickBtnConfirmNoShowCancel() {
		getBtnCancel().click();
		waitForPageLoad();
	}

	/**
	 * get the Confirm Move Appt button object.
	 *
	 * @return button object
	 */
	private AutomatedObject getBtnConfirmMoveApptConfirm() {
		Search search = getSearch();

		// Set the shadow-root parent so that we can find the object within that
		// shadow-root
		// search.setShadowRoot(getShadowRootMoveApptModal());

		search.addCriteria("css", "#modal-primary-button");
		// search.setCacheResult(false);
		return getObject(search);
	}

	/**
	 * read the Confirm Move Appt button label.
	 *
	 * @return button label string
	 */
	public String readBtnLblConfirmNoShowConfirm() {
		return getBtnConfirmMoveApptConfirm().readText();
	}

	/**
	 * click the Confirm No Show Confirm button.
	 */
	public void clickBtnMoveApptConfirm() {
		getBtnConfirmMoveApptConfirm().click();
		waitForPageLoad();
	}

	/**
	 * is the Confirm No Show modal form displayed.
	 *
	 * @return true if form displayed
	 */
	public Boolean isPreviewConfirmNoShowDisplayed() {
		try {
			return getObjectById("appt-verify-modal").isDisplayed();
		} catch (Exception ex) {
			return false;
		}

	}

}