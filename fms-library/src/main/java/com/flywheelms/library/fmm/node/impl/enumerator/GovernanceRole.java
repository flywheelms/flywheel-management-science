/* @(#)GovernanceRole.java
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
package com.flywheelms.library.fmm.node.impl.enumerator;

import android.graphics.drawable.Drawable;

import com.flywheelms.gcongui.gcg.GcgApplication;
import com.flywheelms.gcongui.gcg.interfaces.GcgGuiable;
import com.flywheelms.library.R;
import com.flywheelms.library.fmm.node.NodeId;
import com.flywheelms.library.fmm.node.impl.FmmNodeImpl;
import com.flywheelms.library.fmm.node.interfaces.FmmEnumNode;

import java.util.Date;
import java.util.HashMap;

public enum GovernanceRole implements FmmEnumNode, GcgGuiable {
	
	SPONSOR (R.string.governance_role__sponsor, R.string.governance_role__sponsor__description, R.string.governance_role__definition__sponsor, R.drawable.governance_role__sponsor),
	FACILITATOR (R.string.governance_role__facilitator, R.string.governance_role__facilitator__description, R.string.governance_role__definition__facilitator, R.drawable.governance_role__facilitator),
	CUSTOMER (R.string.governance_role__customer, R.string.governance_role__customer__description, R.string.governance_role__definition__customer, R.drawable.governance_role__customer),
	ADMINISTRATOR (R.string.governance_role__administrator, R.string.governance_role__administrator__description, R.string.governance_role__definition__administrator, R.drawable.governance_role__administrator);
	
	public static final String name_COLUMN_1 = "governance_role";
	public static final String name_COLUMN_2 = "description";
	
	private static final HashMap<String, GovernanceRole> nameMap = new HashMap<String, GovernanceRole>();
	static {
		for(GovernanceRole theGovernanceRole : values()) {
			GovernanceRole.nameMap.put(theGovernanceRole.getName(), theGovernanceRole);
		}
	}

    public static GovernanceRole getObjectForName(String aName) {
		return GovernanceRole.nameMap.get(aName);
	}

	private static FmmNodeDefinition fmmNodeDictionaryEntry = FmmNodeDefinition.getEntryForClass(GovernanceRole.class);
	private static String labelText = fmmNodeDictionaryEntry.getLabelText();
	private static Drawable labelDrawable = fmmNodeDictionaryEntry.getLabelDrawable();
	
	public static GcgGuiable getStaticInstance() {
		return SPONSOR;
	}

	@Override
	public String getLabelText() {
		return labelText;
	}

	@Override
	public Drawable getLabelDrawable() {
		return labelDrawable;
	}

	@Override
	public int getLabelDrawableResourceId() {
		return fmmNodeDictionaryEntry.getLabelDrawableResourceId();
	}

	@Override
	public int getDataDrawableResourceId() {
		return this.drawableResourceId;
	}

	private NodeId nodeId;
	private Date timestamp = new Date(0);
	private int nameStringResourceId;
	private String name;
	private int descriptionStringResourceId;
	private String description;
    private int dictionaryDefinitionResourceId;
    private String dictionaryDefinitionText;
	private int drawableResourceId;
	private Drawable drawable;
	
	private GovernanceRole(int aNameStringResourceId, int aDescriptionStringResourceId, int aDictionaryDefinitionResourceId, int aDrawableResourceId) {
		this.nameStringResourceId = aNameStringResourceId;
		this.name = GcgApplication.getAppResources().getString(this.nameStringResourceId);
		this.descriptionStringResourceId = aDescriptionStringResourceId;
		this.description = GcgApplication.getAppResources().getString(this.descriptionStringResourceId);
        this.dictionaryDefinitionResourceId = aDictionaryDefinitionResourceId;
        this.dictionaryDefinitionText = GcgApplication.getAppResources().getString(this.dictionaryDefinitionResourceId);
		this.drawableResourceId = aDrawableResourceId;
		this.drawable = GcgApplication.getAppResources().getDrawable(this.drawableResourceId);
		this.nodeId = new NodeId(
				FmmNodeDefinition.getEntryForClass(GovernanceRole.class),
				getName() );

	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getNodeIdString() {
		return getNodeId().getNodeIdString();
	}
	
	@Override
	public String getAbbreviatedNodeIdString() {
		return getNodeId().getAbbreviatedNodeIdString();
	}
	
	public String getDescription() {
		return this.description;
	}

	@Override
	public Drawable getDataDrawable() {
		return this.drawable;
	}

	@Override
	public String getDataText() {
		return getName();
	}

	@Override
	public NodeId getNodeId() {
		return this.nodeId;
	}

	@Override
	public Date getRowTimestamp() {
		return this.timestamp;
	}

	@Override
	public void setRowTimestamp(Date aTimestamp) {
		this.timestamp = aTimestamp;
	}

	@Override
	public FmmNodeDefinition getFmmNodeDefinition() {
		return fmmNodeDictionaryEntry;
	}

	@Override
	public String getNodeTypeCode() {
		return getFmmNodeDefinition().getNodeTypeCode();
	}

	@Override
	public String getNodeTypeName() {
		return getFmmNodeDefinition().getNodeTypeName();
	}

	@Override
	public int getNodeEditorActivityRequestCode() {
		return getFmmNodeDefinition().getNodeEditorActivityRequestCode();
	}
	
	@Override
	public int getNodeCreateActivityRequestCode() {
		return getFmmNodeDefinition().getNodeCreateActivityRequestCode();
	}
	
	@Override
	public int getNodePickerActivityRequestCode() {
		return getFmmNodeDefinition().getNodePickerActivityRequestCode();
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean isModified(String aSerializedObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FmmNodeImpl getClone() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Date updateRowTimestamp() { return null; }

    public String getDictionaryDefinitionText() {
        return this.dictionaryDefinitionText;
    }
}
