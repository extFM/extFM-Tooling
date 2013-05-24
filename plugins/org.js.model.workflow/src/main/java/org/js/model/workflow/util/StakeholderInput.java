package org.js.model.workflow.util;

import org.js.model.rbac.Role;

/**
 * This class provides a structure depicting the stakeholder input information.
 * 
 * @author Xi
 * 
 */
public class StakeholderInput {
	private String stakeholderName;
	private Role stakeholderType;
	private Role stakeholderGroup;

	public StakeholderInput(String stakeholderName, Role stakeholderType,
			Role stakeholderGroup) {
		this.stakeholderName = stakeholderName;
		this.stakeholderType = stakeholderType;
		this.stakeholderGroup = stakeholderGroup;
	}

	public String getStakeholderName() {
		return stakeholderName;
	}

	public void setStakeholderName(String stakeholderName) {
		this.stakeholderName = stakeholderName;
	}

	public Role getStakeholderType() {
		return stakeholderType;
	}

	public void setStakeholderType(Role stakeholderType) {
		this.stakeholderType = stakeholderType;
	}

	public Role getStakeholderGroup() {
		return stakeholderGroup;
	}

	public void setStakeholderGroup(Role stakeholderGroup) {
		this.stakeholderGroup = stakeholderGroup;
	}
}
