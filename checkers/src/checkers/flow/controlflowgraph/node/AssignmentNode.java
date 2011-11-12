package checkers.flow.controlflowgraph.node;

import com.sun.source.tree.AssignmentTree;
import com.sun.source.tree.Tree;

/**
 * A tree node for an assignment.
 * 
 * @author Stefan Heule
 * 
 */
public class AssignmentNode extends Node {

	protected AssignmentTree tree;
	protected Node lhs;
	protected Node rhs;
	
	public AssignmentNode(AssignmentTree tree, Node target, Node expression) {
		this.tree = tree;
		this.lhs = target;
		this.rhs = expression;
	}

	public Node getTarget() {
		return lhs;
	}
	
	public Node getExpression() {
		return rhs;
	}

	/**
	 * Guaranteed to return the same tree as {@link getTree}, but with a more
	 * specific type.
	 */
	public AssignmentTree getAssignmentTree() {
		return tree;
	}

	@Override
	public Tree getTree() {
		return getAssignmentTree();
	}

	@Override
	public <R, P> R accept(NodeVisitor<R, P> visitor, P p) {
		return visitor.visitAssignment(this, p);
	}

}
