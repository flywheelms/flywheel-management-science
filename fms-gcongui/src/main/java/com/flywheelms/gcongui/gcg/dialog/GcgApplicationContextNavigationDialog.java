/* @(#)GcgApplicationContextNavigationDialog.java
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

package com.flywheelms.gcongui.gcg.dialog;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.flywheelms.gcongui.R;
import com.flywheelms.gcongui.gcg.activity.GcgActivity;
import com.flywheelms.gcongui.gcg.context.GcgActivityBreadcrumb;
import com.flywheelms.gcongui.gcg.context.GcgApplicationContext;
import com.flywheelms.gcongui.gcg.context.GcgNavigationTarget;
import com.flywheelms.gcongui.gcg.interfaces.GcgPerspective;

import java.util.ArrayList;

public class GcgApplicationContextNavigationDialog extends GcgDialog {

	private ArrayAdapter<GcgNavigationTarget> gcgNavigationTargetArrayAdapter;

	public GcgApplicationContextNavigationDialog(GcgActivity aGcgActivity) {
		super(aGcgActivity);
        initialSetup();
	}

	@Override
	protected int getDialogTitleStringResourceId() {
		return R.string.gcg__application_navigation;
	}

	@Override
	protected int getDialogTitleIconResourceId() {
		return R.drawable.gcg__application_navigation__dialog;
	}

	@Override
	protected void initializeDialogBody() {
		this.gcgNavigationTargetArrayAdapter = new ArrayAdapter<GcgNavigationTarget>(
				this.gcgActivity,
				R.layout.gcg__application_context__navigation__breadcrumb,
				getNavigationChoiceList() ) {

			@Override
			public View getView(int aViewPosition, View aRowView, ViewGroup aViewGroupParent) {
				// low volume, transient list; so we do not use the Android ViewHolder pattern  :-)
				final LayoutInflater inflater = LayoutInflater.from(GcgApplicationContextNavigationDialog.this.gcgActivity);
				View theRowView = inflater.inflate(R.layout.gcg__application_context__navigation__breadcrumb, null);
				GcgNavigationTarget theNavigationTarget = GcgApplicationContextNavigationDialog.this.gcgNavigationTargetArrayAdapter.getItem(aViewPosition);
				ImageView theImageView = (ImageView) theRowView.findViewById(R.id.gcg_context__breadcrumb__image);
				theImageView.setImageResource(theNavigationTarget.getDrawableResourceId() );
				TextView theTextView = (TextView) theRowView.findViewById(R.id.gcg_context__breadcrumb__headine);
				theTextView.setText(theNavigationTarget.getHeadline() );
				if(! theNavigationTarget.isPerspective()) {
					theRowView.setBackgroundResource(R.drawable.gcg__button_state_list__application_context_navigation__breadcrumb);
				} else {
					theRowView.setBackgroundResource(
							theNavigationTarget.isContextRoot() ? R.drawable.gcg__button_state_list__application_context_navigation__active_perspective : R.drawable.gcg__button_state_list__context_navigation__inactive_perspective);
				}
				return theRowView;
			}
		};
		this.dialogBuilder.setAdapter(this.gcgNavigationTargetArrayAdapter, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface aDialog, int aListItem) {
				GcgApplicationContextNavigationDialog.this.alertDialog.dismiss();
				GcgApplicationContextNavigationDialog.this.gcgActivity.gcgApplicationContextNavigation(
                        GcgApplicationContextNavigationDialog.this.gcgNavigationTargetArrayAdapter.getItem(aListItem));
			}
		});
	}

	private ArrayList<GcgNavigationTarget> getNavigationChoiceList() {
		ArrayList<GcgNavigationTarget> theChoiceList = new ArrayList<GcgNavigationTarget>();
		GcgApplicationContext theGcgApplicationContext = this.gcgActivity.getGcgApplicationContext();
		for(GcgPerspective thePerspective : theGcgApplicationContext.getRootActivityFrame().getPerspectiveList()) {
			theChoiceList.add(new GcgNavigationTarget(
					thePerspective.getIconDrawableResourceId(),
					thePerspective.getName(),
					true,
					thePerspective == theGcgApplicationContext.getRootActivityPerspective() ) );
		}
		boolean theFirstActivity = true;
		for(GcgActivityBreadcrumb theBreakcrumb : this.gcgActivity.getGcgApplicationContext().getActivityBreadcrumbList()) {
			if(theFirstActivity) {
				theFirstActivity = false;
				continue;
			}
			theChoiceList.add(new GcgNavigationTarget(
					theBreakcrumb.getDrawableResourceId(),
					theBreakcrumb.getText(),
					false,
					false,
					theBreakcrumb) );
		}
		return theChoiceList;
	}
}
