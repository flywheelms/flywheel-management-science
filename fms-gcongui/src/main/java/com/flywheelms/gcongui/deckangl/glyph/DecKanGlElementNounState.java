/* @(#)DecKanGlElementNounState.java
** 
** Copyright (C) 2012 by Steven D. Stamps
**
**             Trademarks & Copyrights
** Flywheel Management Science(TM), Flywheel Management Model(TM),
** Flywheel Story Editor(TM) and FlywheelMS(TM) are exclusive trademarks
** of Steven D. Stamps and may only be used freely for the purpose of
** identifying the unforked version of this software.  Subsequent forks
** may not use these trademarks.  All other rights are reserved.
** and FlywheelMS(TM) are exclusive trademarks of Steven D. Stamps
** and may only be used freely for the purpose of identifying the
** unforked version of this software.  Subsequent forks (if any) may
** not use these trademarks.  All other rights are reserved.
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
package com.flywheelms.gcongui.deckangl.glyph;

import android.graphics.drawable.Drawable;

import com.flywheelms.gcongui.R;
import com.flywheelms.gcongui.deckangl.enumerator.DecKanGlNounStateColor;
import com.flywheelms.gcongui.gcg.GcgApplication;
import com.flywheelms.gcongui.gcg.interfaces.GcgGuiable;

public class DecKanGlElementNounState extends DecKanGlElement {

	protected static GcgGuiable staticInstance;

	private DecKanGlNounStateColor nounStateColor;

	private DecKanGlElementNounState() {  // "static" Guiable instance for the Dictionary Activity
		super("", null);
	}
	
	public DecKanGlElementNounState(String aName, DecKanGlNounStateColor aNounStateColor) {
		super(aName, aNounStateColor.getDrawable());
		this.nounStateColor = aNounStateColor;
	}

	// implemented by all children of DecKanGlElement
	public static String getMetaDescription() {
		return "Noun State";
	}
	
	public DecKanGlNounStateColor getNounStateColor() {
		return this.nounStateColor;
	}

	@Override
	public Drawable getDrawable() {
		return this.getNounStateColor().getDrawable();
	}

	@Override
	public String getLabelText() {
		return GcgApplication.getContext().getResources().getString(R.string.deckangl__language_element__noun_status);
	}

	@Override
	public Drawable getLabelDrawable() {
		return GcgApplication.getContext().getResources().getDrawable(R.drawable.deckangl__noun_status);
	}
	
	public static GcgGuiable getStaticInstance() {  // return a Guiable instance, since this is not a "real" WorkState
		if(staticInstance == null) {
			staticInstance = new DecKanGlElementNounState();
		}
		return staticInstance;
	}

}