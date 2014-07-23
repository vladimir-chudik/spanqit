package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.graphpattern.GraphPattern;
import pers.aprakash.spanqit.graphpattern.TriplePattern;
import pers.aprakash.spanqit.rdf.IRI;

/**
 * A class to with static methods to create SPARQL query elements.
 * 
 * @author Ankit
 * 
 */
public class Elements {
	// prevent instantiation of this class
	private Elements() {
	}

	/**
	 * Create a SPARQL variable
	 * 
	 * @param varName
	 *            the alias of the variable
	 * @return a new SPARQL variable
	 */
	public static SparqlVariable var(String varName) {
		return new SparqlVariable(varName);
	}

	/**
	 * Create a SPARQL assignment
	 * 
	 * @param exp
	 *            the expression to evaluate
	 * @param var
	 *            the variable to bind the expression value to
	 * @return an Assignment object
	 */
	public static Assignment as(Expression<?> exp, SparqlVariable var) {
		return new Assignment(exp, var);
	}

	/**
	 * Create a SPARQL Base declaration
	 * 
	 * @param iri
	 *            the base iri
	 * @return a Base object
	 */
	public static Base base(IRI iri) {
		return new Base(iri);
	}

	/**
	 * Create a SPARQL Prefix declaration
	 * 
	 * @param alias
	 *            the alias of the prefix
	 * @param iri
	 *            the iri the alias refers to
	 * @return a Prefix object
	 */
	public static Prefix prefix(String alias, IRI iri) {
		return new Prefix(alias, iri);
	}

	/**
	 * Create a SPARQL Prefix clause
	 * 
	 * @param prefixes
	 *            prefix declarations to add to this Prefix clause
	 * @return a new
	 */
	public static PrefixDeclarations prefixes(Prefix... prefixes) {
		return new PrefixDeclarations().addPrefix(prefixes);
	}

	/**
	 * Create a default graph reference
	 * 
	 * @param iri
	 *            the source of the graph
	 * @return a From clause
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#rdfDataset">
	 *      RDF Datasets</a>
	 */
	public static FromClause from(IRI iri) {
		return new FromClause(iri);
	}

	/**
	 * Create a named graph reference
	 *
	 * @param iri
	 *            the source of the graph
	 * @return a named From clause
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#rdfDataset">
	 *      RDF Datasets</a>
	 */
	public static FromClause fromNamed(IRI iri) {
		return new FromClause(iri, true);
	}

	/**
	 * Create a dataset declaration
	 * 
	 * @param graphs
	 * @return a new dataset clause
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#rdfDataset">
	 *      RDF Datasets</a>
	 */
	public static Dataset dataset(FromClause... graphs) {
		return new Dataset().from(graphs);
	}

	/**
	 * Create a SPARQL projection
	 * 
	 * @param projectables
	 *            projectable elements to add to the projection
	 * @return a Projection
	 */
	public static Projection select(Projectable... projectables) {
		return new Projection().select(projectables);
	}

	/**
	 * Create a SPARQL graph template
	 * 
	 * @param triples
	 *            triples to add to the template
	 * @return a new SPARQL graph template
	 */
	public static GraphTemplate construct(TriplePattern... triples) {
		return new GraphTemplate().construct(triples);
	}

	/**
	 * Create a SPARQL query pattern
	 * 
	 * @param patterns
	 *            graph patterns to add to the query pattern
	 * @return a new Query Pattern
	 */
	public static QueryPattern where(GraphPattern... patterns) {
		return new QueryPattern().where(patterns);
	}

	/**
	 * Create a SPARQL Group clause
	 * 
	 * @param groupables
	 *            the group conditions
	 * @return a Group By clause
	 */
	public static GroupBy groupBy(Groupable... groupables) {
		return new GroupBy().by(groupables);
	}

	/**
	 * Create a SPARQL Order clause
	 * 
	 * @param conditions
	 *            the order conditions
	 * @return an Order By clause
	 */
	public static OrderBy orderBy(OrderCondition... conditions) {
		return new OrderBy().by(conditions);
	}

	/**
	 * Create a SPARQL Having clause
	 * 
	 * @param expressions
	 *            the having conditions
	 * @return a Having clause
	 */
	public static Having having(Expression<?>... expressions) {
		return new Having().having(expressions);
	}

	/**
	 * Create an ascending SPARQL order condition
	 * 
	 * @param orderOn
	 *            the order comparator
	 * @return an ASC() order condition
	 */
	public static OrderCondition asc(Orderable orderOn) {
		return new OrderCondition(orderOn, true);
	}

	/**
	 * Create a descending SPARQL order condition
	 * 
	 * @param orderOn
	 *            the order comparator
	 * @return a DESC() order condition
	 */
	public static OrderCondition desc(Orderable orderOn) {
		return new OrderCondition(orderOn, false);
	}
}