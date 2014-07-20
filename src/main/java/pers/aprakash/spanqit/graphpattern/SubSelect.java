package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.core.BaseQuery;
import pers.aprakash.spanqit.core.Elements;
import pers.aprakash.spanqit.core.Projectable;
import pers.aprakash.spanqit.core.Projection;
import pers.aprakash.spanqit.core.Util;

public class SubSelect extends BaseQuery<SubSelect> implements GraphPattern {	
	private Projection select = Elements.select();
	
	/*
	 * If someone has any ideas how I can eliminate the need for repeating
	 * the following methods from SelectQuery without inheriting the methods
	 * that don't apply to SubSelect (prologue and dataset stuff), that would
	 * be awesome.
	 */
	
	public SubSelect distinct() {
		return distinct(true);
	}
	
	public SubSelect distinct(boolean isDistinct) {
		select.distinct(isDistinct);
		
		return this;
	}
	
	public SubSelect all() {
		return all(true);
	}
	
	public SubSelect all(boolean selectAll) {
		select.all(selectAll);
		
		return this;
	}
	
	public SubSelect select(Projectable... projectables) {
		select.select(projectables);
		
		return this;
	}
	
	@Override
	public boolean isEmpty() {
		return where.isEmpty();
	}
	
	@Override
	public int size() {
		return where.size();
	}
	
	// TODO: Values
	
	@Override
	protected String getQueryActionString() {
		return select.getQueryString();
	}
	
	@Override
	public String getQueryString() {
		StringBuilder subSelect = new StringBuilder();

		subSelect.append(super.getQueryString());
		
		// TODO: VALUES
		// subselect.append(values.getQueryString());
		
		return Util.getBracketedString(subSelect.toString());
	}

	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}