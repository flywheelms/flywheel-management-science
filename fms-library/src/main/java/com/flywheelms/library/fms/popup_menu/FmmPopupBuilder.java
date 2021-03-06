/* @(#)FmmPopupBuilder.java
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

package com.flywheelms.library.fms.popup_menu;

import android.view.View;
import android.widget.PopupMenu;

import com.flywheelms.gcongui.gcg.treeview.node.GcgTreeNodeInfo;
import com.flywheelms.library.fmm.context.FmmPerspective;
import com.flywheelms.library.fmm.node.impl.enumerator.FmmNodeDefinition;
import com.flywheelms.library.fmm.node.interfaces.horizontal.FmmHeadlineNode;
import com.flywheelms.library.fms.treeview.filter.FmsTreeViewAdapter;

/*
 * on the surface, the purpose of this class is to build context-sensitive popup menus for FMM Nodes.
 * the important "magic sauce" of this class is validating whether a menu option is appropriate, given
 * the rules of the management model and the state of parent(s), peer(s) and children
 */

public class FmmPopupBuilder {

	public static final String menu_item__CREATE_BOOKSHELF = "Create Bookshelf...";
	public static final String menu_item__DELETE_BOOKSHELF = "Delete Bookshelf...";
	public static final String menu_item__ADOPT_ORPHAN_DISCUSSION_TOPIC = "Adopt orphan Discussion Topic...";
	public static final String menu_item__CREATE_DISCUSSION_TOPIC = "Create Discussion Topic...";
	public static final String menu_item__EDIT_DISCUSSION_TOPICS = "Edit Discussion Topics...";
	public static final String menu_item__DELETE_DISCUSSION_TOPIC = "Delete Discussion Topic...";
	public static final String menu_item__MOVE_DISCUSSION_TOPIC = "Move Discussion Topic...";
	public static final String menu_item__ORPHAN_DISCUSSION_TOPIC = "Remove Discussion Topic...";
	public static final String menu_item__REFERENCE_HEADLINE_NODE = "Reference Headline Node...";
	public static final String menu_item__DEREFERENCE_HEADLINE_NODE = "Dereference Headline Node...";
	public static final String menu_item__MOVE_HEADLINE_NODE_REFERENCE = "Move Headline Node Reference...";
	public static final String menu_item__CREATE_FISCAL_YEAR = "Create Fiscal Year...";
	public static final String menu_item__DELETE_FISCAL_YEAR = "Delete Fiscal Year...";
	public static final String menu_item__CREATE_ALL_FLYWHEEL_CADENCES = "Create all Cadences...";
	public static final String menu_item__EDIT_FLYWHEEL_CADENCES = "Edit Cadences...";
	public static final String menu_item__DELETE_FLYWHEEL_CADENCE = "Delete Cadence...";
	public static final String menu_item__MOVE_FLYWHEEL_CADENCE = "Move Cadence...";
	public static final String menu_item__ADOPT_ORPHAN_NOTEBOOK = "Adopt orphan Notebook...";
	public static final String menu_item__CREATE_NOTEBOOK = "Create Notebook...";
	public static final String menu_item__DELETE_NOTEBOOK = "Delete Notebook...";
	public static final String menu_item__MOVE_NOTEBOOK = "Move Notebook...";
	public static final String menu_item__ORPHAN_NOTEBOOK = "Orphan Notebook...";
	public static final String menu_item__EDIT_NOTEBOOKS = "Edit Notebooks...";
	public static final String menu_item__CREATE_PORTFOLIO = "Create Portfolio...";
	public static final String menu_item__DELETE_PORTFOLIO = "Delete Portfolio...";
	public static final String menu_item__ADOPT_ORPHAN_PROJECT = "Adopt orphan Project...";
	public static final String menu_item__CREATE_PROJECT = "Create Project...";
	public static final String menu_item__EDIT_PROJECTS = "Edit Projects...";
	public static final String menu_item__DELETE_PROJECT = "Delete Project...";
	public static final String menu_item__MOVE_PROJECT = "Move Project...";
	public static final String menu_item__ORPHAN_PROJECT = "Orphan Project...";
	public static final String menu_item__ADOPT_ORPHAN_STRATEGIC_ASSET = "Adopt orphan Strategic Asset...";
	public static final String menu_item__ADOPT_ORPHAN_WORK_ASSET = "Adopt orphan Work Asset...";
	public static final String menu_item__CREATE_PROJECT_ASSET = "Create Project Asset...";
	public static final String menu_item__EDIT_ALL_ASSETS = "Edit All Assets...";
	public static final String menu_item__DELETE_PROJECT_ASSET = "Delete Project Asset...";
	public static final String menu_item__MOVE_PROJECT_ASSET = "Move Project Asset...";
	public static final String menu_item__ORPHAN_PROJECT_ASSET = "Orphan Project Asset...";
	public static final String menu_item__ORPHAN_STRATEGIC_ASSET = "Orphan Strategic Asset...";
	public static final String menu_item__CREATE_STRATEGIC_MILESTONE = "Create Strategic Milestone...";
	public static final String menu_item__EDIT_STRATEGIC_MILESTONES = "Edit Strategic Milestones...";
	public static final String menu_item__DELETE_STRATEGIC_MILESTONE = "Delete Strategic Milestone...";
	public static final String menu_item__MOVE_STRATEGIC_MILESTONE = "Move Strategic Milestone...";

    public static final String menu_item__CREATE_STRATEGY_TEAM = "Create Strategy Team...";
    public static final String menu_item__EDIT_STRATEGY_TEAM = "Edit Strategy Team...";
    public static final String menu_item__DELETE_STRATEGY_TEAM = "Delete Strategy Team...";

    public static final String menu_item__CREATE_STRATEGIC_ASSET = "Create Strategic Asset...";
    public static final String menu_item__EDIT_STRATEGIC_ASSETS = "Edit Strategic Assets...";
    public static final String menu_item__DELETE_STRATEGIC_ASSET = "Delete Strategic Asset...";
    public static final String menu_item__DEMOTE_STRATEGIC_ASSET = "Demote Strategic Asset...";
    public static final String menu_item__MOVE_STRATEGIC_ASSET = "Move Strategic Asset...";
    public static final String menu_item__PROMOTE_PROJECT_ASSET_TO_STRATEGIC_ASSET = "Select Work Asset as Strategic...";

	public static final String menu_item__ADOPT_ORPHAN_WORK_PACKAGE = "Adopt orphan Work Package...";
	public static final String menu_item__CREATE_WORK_PACKAGE = "Create Work Package...";
	public static final String menu_item__EDIT_WORK_PACKAGES = "Edit Work Packages...";
	public static final String menu_item__DELETE_WORK_PACKAGE = "Delete Work Package...";
	public static final String menu_item__MOVE_WORK_PACKAGE = "Move Work Package...";
	public static final String menu_item__ORPHAN_WORK_PACKAGE = "Orphan Work Package...";
	public static final String menu_item__EDIT_WORK_PLANS = "Edit Work Plans...";
	public static final String menu_item__DELETE_WORK_PLAN = "Delete Work Plan...";
	public static final String menu_item__MOVE_WORK_PLAN = "Move Work Plan...";
	public static final String menu_item__ADOPT_ORPHAN_WORK_TASK= "Adopt orphan Work Task...";
	public static final String menu_item__CREATE_WORK_TASK_FOR_WORK_PACKAGE = "Create Work Task...";
	public static final String menu_item__CREATE_WORK_TASK_FOR_WORK_PLAN= "Create Work Task...";
	public static final String menu_item__SCHEDULE_WORK_TASK_FROM_COMMITMENT = "Schedule Work Task from Commitment...";
	public static final String menu_item__EDIT_WORK_TASKS= "Edit Work Tasks...";
	public static final String menu_item__DELETE_WORK_TASK= "Delete Work Task...";
	public static final String menu_item__MOVE_WORK_TASK = "Move Work Task...";
	public static final String menu_item__ORPHAN_WORK_TASK = "Orphan Work Task...";
	public static final String menu_item__NO_OPTIONS = "No Options";

	public static final String menu_item__SEQUENCE_DOWN = "Sequence Down";
	public static final String menu_item__SEQUENCE_UP = "Sequence Up";
	public static final String menu_item__SEQUENCE_FIRST = "Sequence First";
	public static final String menu_item__SEQUENCE_LAST = "Sequence Last";

	public static final String menu_item__EDIT_HEADLINE = "Edit Headline...";
	public static final String menu_item__EDIT_STRATEGIC_MILESTONE_TARGET_DATE = "Edit Target Date...";

	public static final String menu_item__CREATE_FMM_CONFIGURATION = "Create FMM Configuration...";
	public static final String menu_item__EDIT_FMM_CONFIGURATION = "Edit FMM Configuration...";

	public static final String menu_item__DESTROY = "Destroy";
	public static final String menu_item__OPEN = "Open";

	public static PopupMenu createPopupMenu(
            FmsTreeViewAdapter aNodePopupListener,
			GcgTreeNodeInfo aLaunchTreeNodeInfo,
			GcgTreeNodeInfo aParentTreeNodeInfo,
			View aView,
			boolean bCanDelete,
			boolean bCanMove,
			boolean bCanOrphan,
			boolean bCanSequenceUp,
			boolean bCanSequenceDown,
			int aLaunchNodeSequence,
			int aLaunchNodeChildCount ) {
		FmmHeadlineNode theLaunchHeadlineNode = (FmmHeadlineNode) aLaunchTreeNodeInfo.getTargetObject();
		FmmHeadlineNode theParentHeadlineNode = (FmmHeadlineNode) aParentTreeNodeInfo.getTargetObject();
		switch (theLaunchHeadlineNode.getFmmNodeDefinition()) {
		case FISCAL_YEAR:
			return createFiscalYearPopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, aLaunchNodeChildCount);
        case CADENCE:
            return createCadencePopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
        case PORTFOLIO:
            return createPortfolioPopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, aLaunchNodeChildCount);
        case PROJECT:
            return createProjectPopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
        case PROJECT_ASSET:
            return createProjectAssetPopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
        case STRATEGIC_ASSET:
            if(theParentHeadlineNode.getFmmNodeDefinition() == FmmNodeDefinition.STRATEGIC_MILESTONE) {
                return createStrategicAssetPopupMenuForStrategicPlanning(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
            } else {
                return createStrategicAssetPopupMenuForWorkBreakdown(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
            }
        case STRATEGIC_MILESTONE:
            return createStrategicMilestonePopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
        case WORK_PACKAGE:
            return createWorkPackagePopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
        case WORK_PLAN:
            return createWorkPlanMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
        case WORK_TASK:
            return createWorkTaskPopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
        case BOOKSHELF:
            return createBookshelfPopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, aLaunchNodeChildCount);
        case NOTEBOOK:
            return createNotebookPopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
        case DISCUSSION_TOPIC:
            return createDiscussionTopicPopupMenu(aNodePopupListener, aLaunchTreeNodeInfo, theLaunchHeadlineNode, theParentHeadlineNode, aView, bCanDelete, bCanMove, bCanOrphan, bCanSequenceDown, bCanSequenceUp, aLaunchNodeSequence, aLaunchNodeChildCount);
		default:
			return null;
		}
	}

	private static PopupMenu createFiscalYearPopupMenu(
            FmsTreeViewAdapter aNodePopupListener,
			GcgTreeNodeInfo aLaunchTreeNodeInfo,
			FmmHeadlineNode aLaunchHeadlineNode,
			FmmHeadlineNode aParentHeadlineNode,
			View aView,
			boolean bCanDelete,
			int aLaunchNodeChildCount ) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
                aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeChildCount );
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_FISCAL_YEAR);
        if(bCanDelete) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_FISCAL_YEAR);
        }
        if(aNodePopupListener.getFmsTreeViewParent().getGcgPerspective() == FmmPerspective.STRATEGIC_PLANNING) {
            startNewGroup(thePopupMenu);
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_STRATEGIC_MILESTONE);
            if(aLaunchNodeChildCount > 0) {
                thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_STRATEGIC_MILESTONES);
            }
        } else {
            startNewGroup(thePopupMenu);
            if(aLaunchNodeChildCount > 0) {
                thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_FLYWHEEL_CADENCES);
            } else {
                thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_ALL_FLYWHEEL_CADENCES);
            }
        }
        return thePopupMenu;
	}

    public static PopupMenu createFmmPopupMenu(View aView) {
        PopupMenu thePopupMenu = new PopupMenu(aView.getContext(), aView);
        thePopupMenu.getMenu().add(menu_item__OPEN);
        thePopupMenu.getMenu().add(menu_item__DESTROY);
        return thePopupMenu;
    }

	private static PopupMenu createStrategicMilestonePopupMenu(
			FmmHeadlineNodePopupListener aNodePopupListener,
			GcgTreeNodeInfo aLaunchTreeNodeInfo,
			FmmHeadlineNode aLaunchHeadlineNode,
			FmmHeadlineNode aParentHeadlineNode,
			View aView,
			boolean bCanDelete,
			boolean bCanMove,
			boolean bCanOrphan,
			boolean bCanSequenceUp,
			boolean bCanSequenceDown,
			int aLaunchNodeSequence,
			int aLaunchNodeChildCount ) {
		FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
				aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_STRATEGIC_MILESTONE);
		if(bCanDelete) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_STRATEGIC_MILESTONE);
		}
		if(bCanMove) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_STRATEGIC_MILESTONE);
		}
        if(bCanSequenceUp || bCanSequenceDown) {
            startNewGroup(thePopupMenu);
        }
		if(bCanSequenceUp) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_FIRST);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_UP);
		}
		if(bCanSequenceDown) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_DOWN);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_LAST);
		}
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_STRATEGIC_MILESTONE_TARGET_DATE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_STRATEGIC_ASSET);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_STRATEGIC_ASSETS);
        }
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__PROMOTE_PROJECT_ASSET_TO_STRATEGIC_ASSET);
		return thePopupMenu;
	}

    private static PopupMenu createPortfolioPopupMenu(
            FmmHeadlineNodePopupListener aNodePopupListener,
            GcgTreeNodeInfo aLaunchTreeNodeInfo,
            FmmHeadlineNode aLaunchHeadlineNode,
            FmmHeadlineNode aParentHeadlineNode,
            View aView,
            boolean bCanDelete,
            int aLaunchNodeChildCount ) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
                aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeChildCount );
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_PORTFOLIO);
        if(bCanDelete) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_PORTFOLIO);
        }
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_PROJECT);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_PROJECTS);
        }
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_PROJECT);
        return thePopupMenu;
    }

    private static PopupMenu createBookshelfPopupMenu(
            FmmHeadlineNodePopupListener aNodePopupListener,
            GcgTreeNodeInfo aLaunchTreeNodeInfo,
            FmmHeadlineNode aLaunchHeadlineNode,
            FmmHeadlineNode aParentHeadlineNode,
            View aView,
            boolean bCanDelete,
            int aLaunchNodeChildCount ) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
                aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeChildCount );
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_BOOKSHELF);
        if(bCanDelete) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_BOOKSHELF);
        }
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_NOTEBOOK);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_NOTEBOOKS);
        }
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_NOTEBOOK);
        return thePopupMenu;
    }

	private static PopupMenu createProjectPopupMenu(
			FmmHeadlineNodePopupListener aNodePopupListener,
			GcgTreeNodeInfo aLaunchTreeNodeInfo,
			FmmHeadlineNode aLaunchHeadlineNode,
			FmmHeadlineNode aParentHeadlineNode,
			View aView,
			boolean bCanDelete,
            boolean bCanMove,
            boolean bCanOrphan,
            boolean bCanSequenceUp,
            boolean bCanSequenceDown,
            int aLaunchNodeSequence,
			int aLaunchNodeChildCount ) {
		FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
				aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
		if(bCanDelete) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_PROJECT);
		}
		if(bCanMove) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_PROJECT);
		}
		if(bCanOrphan) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ORPHAN_PROJECT);
		}
        startNewGroup(thePopupMenu);
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_PROJECT_ASSET);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_ALL_ASSETS);
        }
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_STRATEGIC_ASSET);
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_WORK_ASSET);
		return thePopupMenu;
	}

    private static PopupMenu createNotebookPopupMenu(
            FmmHeadlineNodePopupListener aNodePopupListener,
            GcgTreeNodeInfo aLaunchTreeNodeInfo,
            FmmHeadlineNode aLaunchHeadlineNode,
            FmmHeadlineNode aParentHeadlineNode,
            View aView,
            boolean bCanDelete,
            boolean bCanMove,
            boolean bCanOrphan,
            boolean bCanSequenceUp,
            boolean bCanSequenceDown,
            int aLaunchNodeSequence,
            int aLaunchNodeChildCount ) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
                aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_NOTEBOOK);
        if(bCanDelete) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_NOTEBOOK);
        }
        if(bCanMove) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_NOTEBOOK);
        }
        if(bCanOrphan) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ORPHAN_NOTEBOOK);
        }
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_DISCUSSION_TOPIC);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_DISCUSSION_TOPICS);
        }
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_DISCUSSION_TOPIC);
        return thePopupMenu;
    }

    private static PopupMenu createDiscussionTopicPopupMenu(
            FmmHeadlineNodePopupListener aNodePopupListener,
            GcgTreeNodeInfo aLaunchTreeNodeInfo,
            FmmHeadlineNode aLaunchHeadlineNode,
            FmmHeadlineNode aParentHeadlineNode,
            View aView,
            boolean bCanDelete,
            boolean bCanMove,
            boolean bCanOrphan,
            boolean bCanSequenceUp,
            boolean bCanSequenceDown,
            int aLaunchNodeSequence,
            int aLaunchNodeChildCount ) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
                aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_DISCUSSION_TOPIC);
        if(bCanDelete) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_DISCUSSION_TOPIC);
        }
        if(bCanMove) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_DISCUSSION_TOPIC);
        }
        if(bCanOrphan) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ORPHAN_DISCUSSION_TOPIC);
        }
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__REFERENCE_HEADLINE_NODE);
        return thePopupMenu;
    }

    private static PopupMenu createHeadlineNodePopupMenu(
            FmmHeadlineNodePopupListener aNodePopupListener,
            GcgTreeNodeInfo aLaunchTreeNodeInfo,
            FmmHeadlineNode aLaunchHeadlineNode,
            FmmHeadlineNode aParentHeadlineNode,
            View aView,
            boolean bCanDelete,
            boolean bCanMove,
            boolean bCanOrphan,
            boolean bCanSequenceUp,
            boolean bCanSequenceDown,
            int aLaunchNodeSequence,
            int aLaunchNodeChildCount ) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
                aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__REFERENCE_HEADLINE_NODE);
        if(bCanDelete) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DEREFERENCE_HEADLINE_NODE);
        }
        if(bCanMove) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_HEADLINE_NODE_REFERENCE);
        }
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        return thePopupMenu;
    }

	private static PopupMenu createProjectAssetPopupMenu(
			FmmHeadlineNodePopupListener aNodePopupListener,
			GcgTreeNodeInfo aLaunchTreeNodeInfo,
			FmmHeadlineNode aLaunchHeadlineNode,
			FmmHeadlineNode aParentHeadlineNode,
			View aView,
			boolean bCanDelete,
			boolean bCanMove,
			boolean bCanOrphan,
			boolean bCanSequenceUp,
			boolean bCanSequenceDown,
			int aLaunchNodeSequence,
			int aLaunchNodeChildCount ) {
		FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
				aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_PROJECT_ASSET);
		if(bCanDelete) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_PROJECT_ASSET);
		}
		if(bCanMove) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_PROJECT_ASSET);
		}
		if(bCanOrphan) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ORPHAN_PROJECT_ASSET);
		}
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_STRATEGIC_ASSET);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_WORK_ASSET);
        if(bCanSequenceUp || bCanSequenceDown) {
            startNewGroup(thePopupMenu);
        }
		if(bCanSequenceUp) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_FIRST);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_UP);
		}
		if(bCanSequenceDown) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_DOWN);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_LAST);
		}
        startNewGroup(thePopupMenu);
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_WORK_PACKAGE);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_WORK_PACKAGES);
        }
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_WORK_PACKAGE);
		return thePopupMenu;
	}

	private static PopupMenu createStrategicAssetPopupMenuForWorkBreakdown(
			FmmHeadlineNodePopupListener aNodePopupListener,
			GcgTreeNodeInfo aLaunchTreeNodeInfo,
			FmmHeadlineNode aLaunchHeadlineNode,
			FmmHeadlineNode aParentHeadlineNode,
			View aView,
			boolean bCanDelete,
			boolean bCanMove,
			boolean bCanOrphan,
			boolean bCanSequenceUp,
			boolean bCanSequenceDown,
			int aLaunchNodeSequence,
			int aLaunchNodeChildCount ) {
		FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
				aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
		if(bCanMove) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_STRATEGIC_ASSET);
		}
		if(bCanOrphan) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ORPHAN_STRATEGIC_ASSET);
		}
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_STRATEGIC_ASSET);
        if(bCanSequenceUp || bCanSequenceDown) {
            startNewGroup(thePopupMenu);
        }
		if(bCanSequenceUp) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_FIRST);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_UP);
		}
		if(bCanSequenceDown) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_DOWN);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_LAST);
		}
        startNewGroup(thePopupMenu);
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_PROJECT_ASSET);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_WORK_ASSET);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_WORK_PACKAGE);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_WORK_PACKAGES);
        }
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_WORK_PACKAGE);
		return thePopupMenu;
	}

	private static PopupMenu createStrategicAssetPopupMenuForStrategicPlanning(
            FmmHeadlineNodePopupListener aNodePopupListener,
            GcgTreeNodeInfo aLaunchTreeNodeInfo,
            FmmHeadlineNode aLaunchHeadlineNode,
            FmmHeadlineNode aParentHeadlineNode,
            View aView,
            boolean bCanDelete,
            boolean bCanMove,
            boolean bCanOrphan,
            boolean bCanSequenceUp,
            boolean bCanSequenceDown,
            int aLaunchNodeSequence,
            int aLaunchNodeChildCount) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
				aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_STRATEGIC_ASSET);
		if(bCanDelete) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_STRATEGIC_ASSET);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DEMOTE_STRATEGIC_ASSET);
		}
		if(bCanMove) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_STRATEGIC_ASSET);
		}
        if(bCanSequenceUp || bCanSequenceDown) {
            startNewGroup(thePopupMenu);
        }
        if(bCanSequenceUp) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_FIRST);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_UP);
		}
		if(bCanSequenceDown) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_DOWN);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_LAST);
		}
        startNewGroup(thePopupMenu);
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_WORK_PACKAGE);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_WORK_PACKAGES);
        }
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_WORK_PACKAGE);
		return thePopupMenu;
	}

    private static PopupMenu createNoOptionsMenu(
            FmmHeadlineNodePopupListener aNodePopupListener,
            GcgTreeNodeInfo aLaunchTreeNodeInfo,
            FmmHeadlineNode aLaunchHeadlineNode,
            FmmHeadlineNode aParentHeadlineNode,
            View aView,
            boolean bCanDelete,
            boolean bCanMove,
            boolean bCanOrphan,
            boolean bCanSequenceUp,
            boolean bCanSequenceDown,
            int aLaunchNodeSequence,
            int aLaunchNodeChildCount ) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
                aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__NO_OPTIONS);
        return thePopupMenu;
    }

    private static PopupMenu createCadencePopupMenu(
            FmmHeadlineNodePopupListener aNodePopupListener,
            GcgTreeNodeInfo aLaunchTreeNodeInfo,
            FmmHeadlineNode aLaunchHeadlineNode,
            FmmHeadlineNode aParentHeadlineNode,
            View aView,
            boolean bCanDelete,
            boolean bCanMove,
            boolean bCanOrphan,
            boolean bCanSequenceUp,
            boolean bCanSequenceDown,
            int aLaunchNodeSequence,
            int aLaunchNodeChildCount ) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
                aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
        if(aLaunchNodeChildCount == 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__NO_OPTIONS);
        } else {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_WORK_PLANS);
        }
        return thePopupMenu;
    }

    private static PopupMenu createWorkPlanMenu(
            FmmHeadlineNodePopupListener aNodePopupListener,
            GcgTreeNodeInfo aLaunchTreeNodeInfo,
            FmmHeadlineNode aLaunchHeadlineNode,
            FmmHeadlineNode aParentHeadlineNode,
            View aView,
            boolean bCanDelete,
            boolean bCanMove,
            boolean bCanOrphan,
            boolean bCanSequenceUp,
            boolean bCanSequenceDown,
            int aLaunchNodeSequence,
            int aLaunchNodeChildCount ) {
        FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
                aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_WORK_TASK_FOR_WORK_PLAN);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SCHEDULE_WORK_TASK_FROM_COMMITMENT);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_WORK_TASKS);
        }
        return thePopupMenu;
    }

	private static PopupMenu createWorkPackagePopupMenu(
			FmmHeadlineNodePopupListener aNodePopupListener,
			GcgTreeNodeInfo aLaunchTreeNodeInfo,
			FmmHeadlineNode aLaunchHeadlineNode,
			FmmHeadlineNode aParentHeadlineNode,
			View aView,
			boolean bCanDelete,
			boolean bCanMove,
			boolean bCanOrphan,
			boolean bCanSequenceUp,
			boolean bCanSequenceDown,
			int aLaunchNodeSequence,
			int aLaunchNodeChildCount ) {
		FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
				aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_WORK_PACKAGE);
		if(bCanDelete) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_WORK_PACKAGE);
		}
		if(bCanMove) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_WORK_PACKAGE);
		}
		if(bCanOrphan) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ORPHAN_WORK_PACKAGE);
		}
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_WORK_PACKAGE);
        if(bCanSequenceUp || bCanSequenceDown) {
            startNewGroup(thePopupMenu);
        }
        if(bCanSequenceUp) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_FIRST);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_UP);
		}
		if(bCanSequenceDown) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_DOWN);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_LAST);
		}
        startNewGroup(thePopupMenu);
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
        startNewGroup(thePopupMenu);
        thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_WORK_TASK_FOR_WORK_PACKAGE);
        if(aLaunchNodeChildCount > 0) {
            thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_WORK_TASKS);
        }
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ADOPT_ORPHAN_WORK_TASK);
		return thePopupMenu;
	}

	private static PopupMenu createWorkTaskPopupMenu(
			FmmHeadlineNodePopupListener aNodePopupListener,
			GcgTreeNodeInfo aLaunchTreeNodeInfo,
			FmmHeadlineNode aLaunchHeadlineNode,
			FmmHeadlineNode aParentHeadlineNode,
			View aView,
			boolean bCanDelete,
			boolean bCanMove,
			boolean bCanOrphan,
			boolean bCanSequenceUp,
			boolean bCanSequenceDown,
			int aLaunchNodeSequence,
			int aLaunchNodeChildCount ) {
		FmmHeadlineNodePopupMenu thePopupMenu = new FmmHeadlineNodePopupMenu(
				aNodePopupListener, aView, aLaunchHeadlineNode, aParentHeadlineNode, aLaunchTreeNodeInfo, aLaunchNodeSequence, aLaunchNodeChildCount );
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__CREATE_WORK_TASK_FOR_WORK_PACKAGE);
		if(bCanDelete) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__DELETE_WORK_TASK);
		}
		if(bCanMove) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__MOVE_WORK_TASK);
		}
		if(bCanOrphan) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__ORPHAN_WORK_TASK);
		}
        if(bCanSequenceUp || bCanSequenceDown) {
            startNewGroup(thePopupMenu);
        }
		if(bCanSequenceUp) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_FIRST);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_UP);
		}
		if(bCanSequenceDown) {
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_DOWN);
			thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__SEQUENCE_LAST);
		}
        startNewGroup(thePopupMenu);
		thePopupMenu.getMenu().add(FmmPopupBuilder.menu_item__EDIT_HEADLINE);
		return thePopupMenu;
	}

    private static void startNewGroup(FmmHeadlineNodePopupMenu aPopupMenu) {
        aPopupMenu.getMenu().add("--------------------------");
    }

}
