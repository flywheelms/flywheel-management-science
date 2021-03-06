/* @(#)GcgIncrementalButton.java
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

package com.flywheelms.gcongui.gcg.button;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flywheelms.gcongui.R;


/**
 * will always be on the right thumb menu
 */
public class GcgIncrementalButton extends LinearLayout {

	private static final int resource_id__WIDGET_LABEL = R.id.widget__label;
	private static final int resource_id__WIDGET_BUTTON = R.id.widget_button;
	private String labelString;
	private int numberOfStates = 99;
	private int initialState = 99;
	private boolean enableOffState = true;
    private RelativeLayout menuItemContainer;
	private TextView labelView;
	private GcgIncrementalStateButton incrementalStateButton;
	public static final int[] drawableResourceIdArray1 = {
		R.drawable.gcg__background_state_list__multi_state_button__on,
	};
	public static final int[] drawableResourceIdArray2_OFF = {
		R.drawable.gcg__background_state_list__multi_state_button__on,
		R.drawable.gcg__background_state_list__multi_state_button__off
	};
    public static final int[] drawableResourceIdArray2 = {
            R.drawable.gcg__background_state_list__multi_state_button__on,
            R.drawable.gcg__background_state_list__multi_state_button__level_2
    };
	public static final int[] drawableResourceIdArray3_OFF = {
		R.drawable.gcg__background_state_list__multi_state_button__on,
		R.drawable.gcg__background_state_list__multi_state_button__level_2,
		R.drawable.gcg__background_state_list__multi_state_button__off
	};
    public static final int[] drawableResourceIdArray3 = {
            R.drawable.gcg__background_state_list__multi_state_button__on,
            R.drawable.gcg__background_state_list__multi_state_button__level_2,
            R.drawable.gcg__background_state_list__multi_state_button__level_3
    };
	public static final int[] drawableResourceIdArray4_OFF = {
		R.drawable.gcg__background_state_list__multi_state_button__on,
		R.drawable.gcg__background_state_list__multi_state_button__level_2,
		R.drawable.gcg__background_state_list__multi_state_button__level_3,
		R.drawable.gcg__background_state_list__multi_state_button__off
	};
    public static final int[] drawableResourceIdArray4 = {
            R.drawable.gcg__background_state_list__multi_state_button__on,
            R.drawable.gcg__background_state_list__multi_state_button__level_2,
            R.drawable.gcg__background_state_list__multi_state_button__level_3,
            R.drawable.gcg__background_state_list__multi_state_button__level_4
    };
	public static final int[] drawableResourceIdArray5_OFF = {
		R.drawable.gcg__background_state_list__multi_state_button__on,
		R.drawable.gcg__background_state_list__multi_state_button__level_2,
		R.drawable.gcg__background_state_list__multi_state_button__level_3,
		R.drawable.gcg__background_state_list__multi_state_button__level_4,
		R.drawable.gcg__background_state_list__multi_state_button__off
	};
    public static final int[] drawableResourceIdArray5 = {
            R.drawable.gcg__background_state_list__multi_state_button__on,
            R.drawable.gcg__background_state_list__multi_state_button__level_2,
            R.drawable.gcg__background_state_list__multi_state_button__level_3,
            R.drawable.gcg__background_state_list__multi_state_button__level_4,
            R.drawable.gcg__background_state_list__multi_state_button__level_5
    };
    public static final int[] drawableResourceIdArray6_OFF = {
            R.drawable.gcg__background_state_list__multi_state_button__on,
            R.drawable.gcg__background_state_list__multi_state_button__level_2,
            R.drawable.gcg__background_state_list__multi_state_button__level_3,
            R.drawable.gcg__background_state_list__multi_state_button__level_4,
            R.drawable.gcg__background_state_list__multi_state_button__level_5,
            R.drawable.gcg__background_state_list__multi_state_button__off
    };

	public GcgIncrementalButton(Context aContext) {
		super(aContext);
		setup(aContext);
	}

	public GcgIncrementalButton(Context aContext, AttributeSet anAttributeSet) {
		super(aContext, anAttributeSet);
		processCustomAttributes(aContext, anAttributeSet);
		setup(aContext);
	}

	public GcgIncrementalButton(Context aContext, AttributeSet anAttributeSet, int aStyleDefinition) {
		super(aContext, anAttributeSet, aStyleDefinition);
		processCustomAttributes(aContext, anAttributeSet);
		setup(aContext);
	}
	
	protected void setup(Context aContext) {
		inflate(aContext, getLayoutResourceId(), this);
		this.incrementalStateButton = (GcgIncrementalStateButton) ((RelativeLayout) getChildAt(0)).findViewById(resource_id__WIDGET_BUTTON);
		this.incrementalStateButton.initialize(getDrawableResourceIdArray(), getInitialButtonState());
		this.labelView = (TextView) ((RelativeLayout) getChildAt(0)).findViewById(resource_id__WIDGET_LABEL);
		this.labelView.setText(getMenuItemLabel());
        this.menuItemContainer = ((RelativeLayout) this.labelView.getParent());
	}

	@SuppressWarnings("incomplete-switch")
	private void processCustomAttributes(Context aContext, AttributeSet anAttributeSet) {
		TypedArray aTypedArray = aContext.obtainStyledAttributes(anAttributeSet, R.styleable.GcgIncrementalStateButton);
		final int theArraySize = aTypedArray.getIndexCount();
		for (int theIndex = 0; theIndex < theArraySize; ++theIndex) {
			int theAttributeIndex = aTypedArray.getIndex(theIndex);
            if (theAttributeIndex == R.styleable.GcgIncrementalStateButton_buttonLabel) {
                this.labelString = aTypedArray.getString(theAttributeIndex);

            } else if (theAttributeIndex == R.styleable.GcgIncrementalStateButton_numberOfStates) {
                this.numberOfStates = aTypedArray.getInt(theAttributeIndex, 99);

            } else if (theAttributeIndex == R.styleable.GcgIncrementalStateButton_initialState) {
                this.initialState = aTypedArray.getInt(theAttributeIndex, 99);

            } else if (theAttributeIndex == R.styleable.GcgIncrementalStateButton_enableOffState) {
                this.enableOffState = aTypedArray.getBoolean(theAttributeIndex, true);
            }
		}
		aTypedArray.recycle();
	}

    @Override
	public void setOnClickListener(final OnClickListener aClickListener) {
		this.incrementalStateButton.setOnClickListener(aClickListener);
        this.menuItemContainer.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View aView) {
                GcgIncrementalButton.this.incrementalStateButton.performClick();
            }
        });
        this.labelView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View aView) {
                GcgIncrementalButton.this.incrementalStateButton.performClick();
            }
        });
	}
    
	@Override
	public void setOnLongClickListener(final OnLongClickListener aClickListener) {
		this.incrementalStateButton.setOnLongClickListener(aClickListener);
        this.menuItemContainer.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                GcgIncrementalButton.this.incrementalStateButton.performLongClick();
                return true;
            }
        });
		this.labelView.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				GcgIncrementalButton.this.incrementalStateButton.performLongClick();
				return true;
			}
		});
	}
    
	protected int[] getDrawableResourceIdArray() {
		return getDrawableResourceIdArray(getNumberOfStates());
	}
	
	protected int[] getDrawableResourceIdArray(int aNumberOfStates) {
		int[] theResourceIdArray;
		switch(aNumberOfStates) {
			case 1:
				theResourceIdArray  = drawableResourceIdArray1;
				break;
			case 2:
				theResourceIdArray  = isEnableOffState() ? drawableResourceIdArray2_OFF : drawableResourceIdArray2;
				break;
			case 3:
				theResourceIdArray  = isEnableOffState() ? drawableResourceIdArray3_OFF : drawableResourceIdArray3;
				break;
			case 4:
				theResourceIdArray  = isEnableOffState() ? drawableResourceIdArray4_OFF : drawableResourceIdArray4;
				break;
			case 5:
				theResourceIdArray  = isEnableOffState() ? drawableResourceIdArray5_OFF : drawableResourceIdArray5;
            case 6:
            default:
                theResourceIdArray  = drawableResourceIdArray6_OFF;
		}
		return theResourceIdArray;
	}

	public int getState() {
		return this.incrementalStateButton.getState();
	}

	public void setState(int aButtonState) {
		this.incrementalStateButton.setState(aButtonState);
	}

    public void setDefaultState() {
        this.incrementalStateButton.setState(getInitialButtonState());
    }

	public boolean isOff() {
		return this.incrementalStateButton.isOff();
	}

	public boolean isOn() {
		return this.incrementalStateButton.isOn();
	}
	
	protected int getInitialButtonState() {
		return this.initialState;
	}

    public boolean isEnableOffState() {
        return enableOffState;
    }

    public void setEnableOffState(boolean enableOffState) {
        this.enableOffState = enableOffState;
    }

    protected CharSequence getMenuItemLabel() {
		return this.labelString;
	}

	public int getNumberOfStates() {
		return this.numberOfStates;
	}
	
	protected int getLayoutResourceId() {
		return R.layout.gcg__incremental_menu_item;
	}
	
	public int getStateOn() {
		return GcgIncrementalStateButton.state__ON;
	}

}
