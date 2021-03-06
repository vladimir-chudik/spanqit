package com.anqit.spanqit.core;

/**
 * A SPARQL expression to variable assignment
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#assignment">
 *      SPARQL Assignments</a>
 */
public class Assignment implements Projectable, Groupable {
	private static final String AS = " AS ";
	private Assignable expression;
	private Variable var;

	Assignment(Assignable exp, Variable var) {
		this.expression = exp;
		this.var = var;
	}

	@Override
	public String getQueryString() {
		return SpanqitStringUtils.getParenthesizedString(expression.getQueryString() + AS + var.getQueryString());
	}
}