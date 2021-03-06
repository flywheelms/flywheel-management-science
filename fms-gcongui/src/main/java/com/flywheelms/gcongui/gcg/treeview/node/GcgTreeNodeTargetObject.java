/* @(#)GcgTreeNodeTargetObject.java
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

package com.flywheelms.gcongui.gcg.treeview.node;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import com.flywheelms.gcongui.deckangl.enumerator.DecKanGlDecoratedGlyphSize;
import com.flywheelms.gcongui.deckangl.enumerator.DecKanGlNounStateDrawableSize;
import com.flywheelms.gcongui.gcg.interfaces.GcgPerspective;

import java.io.Serializable;

public interface GcgTreeNodeTargetObject extends Serializable {

    public String getIdString();
	
	public Bitmap getDecKanGlBitmap();
	
	public Bitmap getDecKanGlBitmap(DecKanGlDecoratedGlyphSize aGlyphSize);
	
	public String getHeadline();

    public boolean hasSecondaryHeadline();

    public String getSecondaryHeadline();
	
	boolean hasNodeSummary(GcgPerspective anGcgPerspective);
	
	boolean hasNodeQuality();
	
	public String getNodeSummaryPrefix(GcgPerspective anGcgPerspective);
	
	public int getNodeSummaryDrawableResourceId(GcgPerspective anGcgPerspective);
	
	public String getNodeSummarySuffix(GcgPerspective anGcgPerspective);
	
	public int getNodeQualityIndex();

	public BitmapDrawable getDecKanGlElementNounStateDrawable();

	public BitmapDrawable getDecKanGlElementNounStateDrawable(DecKanGlNounStateDrawableSize aDrawableSize);

	public BitmapDrawable getUpdatedNounStatusDrawable();
	
	public BitmapDrawable getUpdatedNounStatusDrawable(DecKanGlNounStateDrawableSize aDrawableSize);

}
