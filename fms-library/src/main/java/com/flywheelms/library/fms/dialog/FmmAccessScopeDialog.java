/* @(#)FmmAccessScopeDialog.java
** 
** Copyright (C) 2012 by Steven D. Stamps
**
**             Trademarks & Copyrights
** Flywheel Management Science(TM), Flywheel Management Model(TM),
** Flywheel Story Editor(TM) and FlywheelMS(TM) are exclusive trademarks
** of Steven D. Stamps and may only be used freely for the purpose of
** identifying the unforked version of this software.  Subsequent forks
** may not use these trademarks.  All other rights are reserved.
**
** DecKanGL (Decorated Kanban Glyph Language) and TribKn (Tribal Knowledge)
** are also exclusive trademarks of Steven D. Stamps.  These may be used
** freely within the unforked FlywheelMS application and documentation.
** All other rights are reserved.
**
** gConGUI (game Controller Graphical User Interface) is an exclusive
** trademark of Steven D. Stamps.  This trademark may be used freely
** within the unforked FlywheelMS application and documentation.
** All other rights are reserved.
**
** Trademark information is available at
** <http://www.flywheelms.com/trademarks>
**
** Flywheel Management Science(TM) is a copyrighted body of management
** metaphors, governance processes, and leadership techniques that is
** owned by Steven D. Stamps.  These copyrighted materials may be freely
** used, without alteration, by the community (users and developers)
** surrounding this GPL3-licensed software.  Additional copyright
** information is available at <http://www.flywheelms.org/copyrights>
**
**              GPL3 Software License
** This program is free software: you can use it, redistribute it and/or
** modify it under the terms of the GNU General Public License, version 3,
** as published by the Free Software Foundation. This program is distributed
** in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
** even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
** PURPOSE.  See the GNU General Public License for more details. You should
** have received a copy of the GNU General Public License, in a file named
** COPYING, along with this program.  If you cannot find your copy, see
** <http://www.gnu.org/licenses/gpl-3.0.html>.
*/

package com.flywheelms.library.fms.dialog;

import android.widget.RadioGroup;

import com.flywheelms.library.R;
import com.flywheelms.library.fmm.repository.FmmAccessScope;
import com.flywheelms.library.gcg.activity.GcgActivity;

public class FmmAccessScopeDialog extends FmsCancelOkDialog {
	
	private RadioGroup radioGroup;

	public FmmAccessScopeDialog(GcgActivity aLibraryActivity) {
		super(aLibraryActivity);
	}

	@Override
	protected int getDialogTitleStringResourceId() {
		return R.string.fmm_repository__scope_selection;
	}

	@Override
	protected int getDialogTitleIconResourceId() {
		return R.drawable.fmm_repository;
	}

	@Override
	protected void onClickButtonOk() {
//		boolean bMustSelectDataSource = this.gcgActivity.mustSelectDataSource();
//		this.gcgActivity.setMustSelectDataSource(false);
//		this.gcgActivity.cancelModalDialog(this);
//		this.gcgActivity.startCreateFmmConfigurationWizard(FmmAccessScopeDialog.this.getAccessScope());
//		this.gcgActivity.setMustSelectDataSource(bMustSelectDataSource);
	}

	private FmmAccessScope getAccessScope() {
		FmmAccessScope theFmmAccessScope;
		int theSelectionId = this.radioGroup.getCheckedRadioButtonId();
		if(theSelectionId == R.id.repository_scope__private) {
			theFmmAccessScope = FmmAccessScope.PRIVATE;
		} else if(theSelectionId == R.id.repository_scope__shared) {
			theFmmAccessScope = FmmAccessScope.SHARED;
		} else {
			theFmmAccessScope = FmmAccessScope.TEAM;
		}
		return theFmmAccessScope;
	}

	@Override
	protected int getCustomDialogContentsResourceId() {
		return R.layout.fmm__access_scope_selection__dialog;
	}

	@Override
	protected void initializeDialogBody() {
		super.initializeDialogBody();
		this.radioGroup = (RadioGroup) this.dialogBodyView.findViewById(R.id.repository_scope__radio);
	}
	
	@Override
	protected boolean defaultOkButtonState() {
		return true;
	}

	@Override
	protected void onClickButtonCancel() {
//		this.gcgActivity.endDialogTransition(this);
	}

}