package com.sudicode.fb2gh.fogbugz;

import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

/**
 * FogBugz case.
 */
public final class FBCase extends FBXmlObject {

    private final Integer id;
    private final Integer parentCaseId;
    private final Boolean open;
    private final String title;
    private final String assignee;
    private final String status;
    private final Integer duplicateOfId;
    private final String priority;
    private final Integer milestoneId;
    private final String category;
    private final List<FBCaseEvent> events;
    private final Integer salesforceCaseId;
    private final FogBugz fogBugz;

    /**
     * Constructor.
     * 
     * @param caze
     *            The <code>case</code> XML element that this object represents
     * @param fogBugz
     *            The <code>FogBugz</code> instance that owns this case
     */
    FBCase(Element caze, FogBugz fogBugz) {
        this.id = Integer.parseInt(caze.getAttribute("ixBug"));
        this.parentCaseId = getIntValue(caze, "ixBugParent");
        this.open = getBooleanValue(caze, "fOpen");
        this.title = getTextValue(caze, "sTitle");
        this.assignee = getTextValue(caze, "sPersonAssignedTo");
        this.status = getTextValue(caze, "sStatus");
        this.duplicateOfId = getIntValue(caze, "ixBugOriginal");
        this.priority = getTextValue(caze, "sPriority");
        this.milestoneId = getIntValue(caze, "ixFixFor");
        this.category = getTextValue(caze, "sCategory");
        this.salesforceCaseId = getIntValue(caze, "sCase");
        this.fogBugz = fogBugz;
        this.events = Collections.unmodifiableList(FBCaseEvent.listCaseEvents(caze, this));
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the parentCaseId
     */
    public Integer getParentCaseId() {
        return parentCaseId;
    }

    /**
     * @return the open
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the assignee
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the duplicateOfId
     */
    public Integer getDuplicateOfId() {
        return duplicateOfId;
    }

    /**
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @return the milestoneId
     */
    public Integer getMilestoneId() {
        return milestoneId;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the events
     */
    public List<FBCaseEvent> getEvents() {
        return events;
    }

    /**
     * @return the salesforceCaseId
     */
    public Integer getSalesforceCaseId() {
        return salesforceCaseId;
    }

    /**
     * @return the fogBugz
     */
    public FogBugz getFogBugz() {
        return fogBugz;
    }

}