/**
 * 
 */
package org.feature.multi.perspective.model.editor.util;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.Group;

/**
 * This class creates a matrix about the relations between groups.
 * @author winkelti
 *
 */
public class Matrix {
	private static Logger log = Logger.getLogger(Matrix.class);
	private CoreGroup coreGroup;

	/**
	 * @param coreGroup
	 */
	public Matrix(CoreGroup coreGroup) {
		super();
		this.coreGroup = coreGroup;
		createMatrix();
	}
	
	/**
	 * creates the relationship matrix
	 */
	private void createMatrix() {
		List<EObject> allGroups = allGroups();
		EObject[] groups = allGroups.toArray(new EObject[allGroups.size()]);
		boolean[][] matrix = new boolean[allGroups.size()][allGroups.size()];
		for (int i = 0; i < matrix.length; i++) {
			EObject gx = groups[i];
			EList<?> x = null;
			if (gx instanceof Group) {
				x = ((Group) gx).getGroups();
			}else{
				x =  ((CoreGroup) gx).getGroups();
			}
			boolean[] bs = matrix[i];
			for (int j = 0; j < bs.length; j++) {
				EObject gy = groups[j];
				EList<?> y = null;
				if (gy instanceof Group) {
					y = ((Group) gy).getGroups();
				}else{
					y =  ((CoreGroup) gy).getGroups();
				}
				if (x.contains(gy) || y.contains(gx) || gy.equals(gx)) {
					bs[j] = true;
				}else{
					bs[j] = false;
				}
			}
		}
		print(groups,matrix);
	}
	
	/**
	 * print the matrix
	 * @param groups used to name the axis
	 * @param matrix the boolean group relationship matrix
	 */
	private void print(EObject[] groups, boolean[][] matrix) {
		String s = "\n\t\t\t";//indent Header 
		for (EObject group : groups) {
			if (group instanceof Group) {
				Group g = (Group) group;
				s = s + g.getName() + "\t";
			}else{
				s = s +  ("core" + "\t");
			}
		}
		s = s + "\n";
		for (int i = 0; i < matrix.length; i++) {
			if (groups[i] instanceof Group) {
				Group g = (Group) groups[i];
				s = s + (g.getName() + "\t");
				int j = 3 - (g.getName().length() / 6);
				for (int j2 = 0; j2 < j; j2++) {
					s = s + "\t";
				}
			}else{
				s = s + ("core" + "\t\t\t");
			}
			boolean[] bs = matrix[i];
			for (int j = 0; j < bs.length; j++) {
				boolean b = bs[j];
				s = s + (b + "\t");
			}
			s = s+ "\n";
		}
		log.debug(s);
	}

	/**
	 * Traverse the group tree to catch all groups in a {@link List}
	 * @return {@link List} of all groups
	 */
	private List<EObject> allGroups() {
		List<EObject> groups = new LinkedList<EObject>();
		groups.add(coreGroup);
		for (Group group : coreGroup.getGroups()) {
			groups.add(group);
			groups.addAll(allGroups(group.getGroups()));
		}
		return groups;
	}

	/**
	 * creates a list with all groups from groups and there children and there children.
	 * @param groups will be added to the return list
	 * @return a list with all groups from groups and there children and there children.
	 */
	private List<Group> allGroups(EList<Group> groups) {
		List<Group> groups2 = new LinkedList<Group>();
		for (Group group : groups) {
			groups2.add(group);
			groups2.addAll(allGroups(group.getGroups()));
		}
		return groups2;
	}
}
