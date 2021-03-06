/* @(#)FmsDecoratorProjectManagement.java
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

package com.flywheelms.library.fmm.deckangl;

import android.graphics.drawable.Drawable;

import com.flywheelms.gcongui.deckangl.enumerator.DecKanGlDecoratorCanvasLocation;
import com.flywheelms.gcongui.deckangl.enumerator.DecKanGlDecoratorColor;
import com.flywheelms.gcongui.deckangl.glyph.DecKanGlDecoratorEnumeration;
import com.flywheelms.gcongui.gcg.GcgApplication;
import com.flywheelms.library.R;
import com.flywheelms.library.fmm.node.impl.enumerator.FmmTribKnQualityNormalizedDescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FmsDecoratorProjectManagement extends DecKanGlDecoratorEnumeration {
	
	protected static String qualityMetricName = GcgApplication.getAppResources().getString(R.string.tribkn_quality_metric__parent_fractals);
	protected static String qualityMetricDescription = GcgApplication.getAppResources().getString(R.string.tribkn_quality_metric__parent_fractals__description);
	protected static Drawable qualityMetricDrawable = GcgApplication.getAppResources().getDrawable(R.drawable.tribkn_quality_metric__parent_fractals);
	protected static DecKanGlDecoratorCanvasLocation decoratorCanvasLocation = DecKanGlDecoratorCanvasLocation.left_zone_TOP;
	
	@Override
	public String getQualityMetricName() {
		return FmsDecoratorProjectManagement.qualityMetricName;
	}
	
	@Override
	public String getQualityMetricDescription() {
		return FmsDecoratorProjectManagement.qualityMetricDescription;
	}
	
	@Override
	public Drawable getQualityMetricDrawable() {
		return FmsDecoratorProjectManagement.qualityMetricDrawable;
	}
	
	@Override
	public DecKanGlDecoratorCanvasLocation getDecoratorCanvasLocation() {
		return FmsDecoratorProjectManagement.decoratorCanvasLocation;
	}
	
	protected static FmsDecoratorProjectManagement staticInstance = new FmsDecoratorProjectManagement();
	
	public static FmsDecoratorProjectManagement NO_PARENT_FRACTALS = new FmsDecoratorProjectManagement(
			"No Project Management",
			R.string.decorator__project_management__none,
			FmmTribKnQualityNormalizedDescription.NONE,
			R.integer.fmm__decorator__parent_fractals__none__quality_index,
			DecKanGlDecoratorColor.RED );
	public static FmsDecoratorProjectManagement PARENT_FRACTALS_SWAG = new FmsDecoratorProjectManagement(
			"Project Management SWAG",
			R.string.decorator__project_management__swag,
			FmmTribKnQualityNormalizedDescription.SWAG,
			R.integer.fmm__decorator__parent_fractals__swag__quality_index,
			DecKanGlDecoratorColor.YELLOW );
	public static FmsDecoratorProjectManagement SUGGESTED_PARENT_FRACTALS = new FmsDecoratorProjectManagement(
			"Suggested Project Management",
			R.string.decorator__project_management__suggested,
			FmmTribKnQualityNormalizedDescription.SUGGESTED,
			R.integer.fmm__decorator__parent_fractals__suggested__quality_index,
			DecKanGlDecoratorColor.BLUE );
	public static FmsDecoratorProjectManagement PROPOSED_PARENT_FRACTALS = new FmsDecoratorProjectManagement(
			"Proposed Project Management",
			R.string.decorator__project_management__proposed,
			FmmTribKnQualityNormalizedDescription.PROPOSED,
			R.integer.fmm__decorator__parent_fractals__proposed__quality_index,
			DecKanGlDecoratorColor.PINK );
	public static FmsDecoratorProjectManagement ONE_CONFIRMED_PARENT_FRACTAL = new FmsDecoratorProjectManagement(
			"Confirmed Project Management",
			R.string.decorator__project_management__confirmed,
			FmmTribKnQualityNormalizedDescription.ONE_SPECIFIED,
			R.integer.fmm__decorator__parent_fractals__one__quality_index,
			DecKanGlDecoratorColor.TRANSPARENT );
	public static FmsDecoratorProjectManagement MULTIPLE_CONFIRMED_PARENT_FRACTALS = new FmsDecoratorProjectManagement(
			"Multiple Confirmed Project Management",
			R.string.decorator__project_management__multiple,
			FmmTribKnQualityNormalizedDescription.MULTIPLE_SPECIFIED,
			R.integer.fmm__decorator__parent_fractals__multiple__quality_index,
			DecKanGlDecoratorColor.ORANGE );
	public static FmsDecoratorProjectManagement UNKNOWN_PARENT_FRACTAL_QUALITY = new FmsDecoratorProjectManagement(
			"Unknown Project Management Quality",
			R.string.decorator__project_management__unknown_quality,
			FmmTribKnQualityNormalizedDescription.UNKNOWN,
			R.integer.fmm__decorator__parent_fractals__unknown_quality__quality_index,
			DecKanGlDecoratorColor.GRAY );
	public static FmsDecoratorProjectManagement PARENT_FRACTAL_QUALITY_NOT_APPLICABLE = new FmsDecoratorProjectManagement(
			"Project Management Quality Not Applicable",
			R.string.decorator__project_management__not_applicable,
			FmmTribKnQualityNormalizedDescription.NOT_APPLICABLE,
			R.integer.fmm__decorator__parent_fractals__not_applicable__quality_index,
			DecKanGlDecoratorColor.TRANSPARENT );
	public static FmsDecoratorProjectManagement PARENT_FRACTAL_QUALITY_NOT_ENABLED = new FmsDecoratorProjectManagement(
			"Project Management Quality Not Enabled",
			R.string.decorator__project_management__not_enabled,
			FmmTribKnQualityNormalizedDescription.NOT_ENABLED,
			R.integer.fmm__decorator__parent_fractals__not_enabled__quality_index,
			DecKanGlDecoratorColor.DISABLED );
	
	protected static ArrayList<DecKanGlDecoratorEnumeration> valuesList =
			new ArrayList<DecKanGlDecoratorEnumeration>();
	static {
		valuesList.add(NO_PARENT_FRACTALS);
		valuesList.add(PARENT_FRACTALS_SWAG);
		valuesList.add(SUGGESTED_PARENT_FRACTALS);
		valuesList.add(PROPOSED_PARENT_FRACTALS);
		valuesList.add(ONE_CONFIRMED_PARENT_FRACTAL);
		valuesList.add(MULTIPLE_CONFIRMED_PARENT_FRACTALS);
		valuesList.add(UNKNOWN_PARENT_FRACTAL_QUALITY);
		valuesList.add(PARENT_FRACTAL_QUALITY_NOT_APPLICABLE);
		valuesList.add(PARENT_FRACTAL_QUALITY_NOT_ENABLED);
	}
	
	protected static HashMap<String, FmsDecoratorProjectManagement> nameMap = new HashMap<String, FmsDecoratorProjectManagement>();
	static {
		for(DecKanGlDecoratorEnumeration theDecKanGlDecoratorEnumeration : valuesList) {
			FmsDecoratorProjectManagement.nameMap.put(theDecKanGlDecoratorEnumeration.getName(), (FmsDecoratorProjectManagement) theDecKanGlDecoratorEnumeration);
		}
	}
	
	public static FmsDecoratorProjectManagement getObjectForName(String aName) {
		return FmsDecoratorProjectManagement.nameMap.get(aName);
	}

	private FmsDecoratorProjectManagement() {
		super();
	}
	
	public static FmsDecoratorProjectManagement getStaticInstance() {
		return staticInstance;
	}
	
	public FmsDecoratorProjectManagement(
            String aName,
            int aDescriptionResourceId,
            FmmTribKnQualityNormalizedDescription aNormalizedDescription,
            int aTribKnQualityIndexResourceId,
            DecKanGlDecoratorColor aDecKanGlDecoratorColor) {
		super(
				aName,
				GcgApplication.getAppResources().getString(aDescriptionResourceId),
				aNormalizedDescription,
				GcgApplication.getAppResources().getInteger(aTribKnQualityIndexResourceId),
				aDecKanGlDecoratorColor);
	}
	
	public static List<DecKanGlDecoratorEnumeration> values() {
		return valuesList;
	}

	@Override
	public String getLabelText() {
		return GcgApplication.getContext().getResources().getString(R.string.tribkn_quality_metric__parent_fractals);
	}

	@Override
	public Drawable getLabelDrawable() {
		return GcgApplication.getContext().getResources().getDrawable(R.drawable.tribkn_quality_metric__parent_fractals);
	}

	@Override
	public int getLabelDrawableResourceId() {
		return R.drawable.tribkn_quality_metric__parent_fractals;
	}

}
