package core.helpers.pagehelpers;

import java.util.logging.Level;
import java.util.logging.Logger;

import pages.*;

public class MyPages<T> {
	public static final <T extends CorePage> T getPage(Class<T> pageObjectClass) {
		T newInstance = null;

		try {
			newInstance = pageObjectClass.newInstance();
		} catch (InstantiationException | IllegalAccessException ex) {
			Logger.getLogger(MyPages.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return newInstance;
	}

	public static final CompareHelper getCompareHelper() {
		return getPage(CompareHelper.class);
	}

	public static final PnRefrigeratorsHelper getPnRefrigeratorsHelper() {
		return getPage(PnRefrigeratorsHelper.class);
	}

	public static final PnAirConditionedHelper getPnAirConditionedHelper() {
		return getPage(PnAirConditionedHelper.class);
	}

	public static final PnBreadMakerHelper getPnBreadMakerHelper() {
		return getPage(PnBreadMakerHelper.class);
	}

	public static final PnWashersHelper getPnWashersHelper() {
		return getPage(PnWashersHelper.class);
	}

	public static final PnMicrowavesHelper getPnMicrowavesHelper() {
		return getPage(PnMicrowavesHelper.class);
	}

	public static final PnGoodsInfoHelper getPnGoodsInfoHelper() {
		return getPage(PnGoodsInfoHelper.class);
	}

	public static final PnAirConditionedPage getPnAirConditionedPage() {
		return getPage(PnAirConditionedPage.class);
	}

	public static final PnBreadMakerPage getPnBreadMakerPage() {
		return getPage(PnBreadMakerPage.class);
	}

	public static final PnGoodsInfoPage getPnGoodsInfoPage() {
		return getPage(PnGoodsInfoPage.class);
	}

	public static final PnMainPage getPnMainPage() {
		return getPage(PnMainPage.class);
	}

	public static final PnMicrowavesPage getPnMicrowavesPage() {
		return getPage(PnMicrowavesPage.class);
	}

	public static final PnRefrigeratorsPage getPnRefrigeratorsPage() {
		return getPage(PnRefrigeratorsPage.class);
	}

	public static final PnWashersPage getPnWashersPage() {
		return getPage(PnWashersPage.class);
	}

	public static final ComparePage getComparePage() {
		return getPage(ComparePage.class);
	}

	public static final PnMainHelper getPnMainHelper() {
		return getPage(PnMainHelper.class);
	}
}
