package graph;


import java.util.Iterator;
import java.util.NoSuchElementException;

import list.LList;

/**
 * This will represent each of the small parts of a graph each containing a label to call it by and
 * store the desired data a list of edges to represent its neighboring connections, whether its been
 * visited or not, the vertex that came previous to it (used in some traversals) and the cost of the 
 * path to that vertex (again used in certain traversals).
 * @author kjjus
 *
 * @param <T>
 * Will be that data that is held within each vertex, the data of the label
 */
public class Vertex<T> implements VertexInterface<T> {
	//////////////////////////////////////////////////////////////////////////////
	//							Fields										   //
	////////////////////////////////////////////////////////////////////////////
	private T label;
	private LList<Edge> edgeList;
	private boolean visited;
	private VertexInterface<T> prevVertex;
	private double cost;
	
	//////////////////////////////////////////////////////////////////////////////
	//							Constructors								   //
	////////////////////////////////////////////////////////////////////////////
	public Vertex(T vertexLabel) {
		label = vertexLabel;
		edgeList = new LList<>();
		visited = false;
		prevVertex = null;
		cost = 0;
	}
	
	//////////////////////////////////////////////////////////////////////////////
	//							Public Methods								   //
	////////////////////////////////////////////////////////////////////////////
	@Override
	public T getLabel() {
		return label;
	}

	@Override
	public void visit() {
		visited = true;
	}

	@Override
	public void unvisit() {
		visited = false;
	}

	@Override
	public boolean isVisited() {
		return visited;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex, double weight) {
		if(!this.equals(endVertex)) { //The vertex is different
			Edge newEdge = new Edge(endVertex, weight);
			if(!edgeList.contains(newEdge)) {
				edgeList.add(newEdge);
				return true;
			}else
				return false;
		}else
			return false;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex) {
		return connect(endVertex, 0);
	}
	
	@Override
	public boolean disconnect(VertexInterface<T> endVertex) {
		Iterator<Edge> edgeIterator = edgeList.getLinkedListIterator();

		boolean found = false;
		Edge nextEdge = null;
		while(edgeIterator.hasNext() && !found) {
			 nextEdge = edgeIterator.next();
			if(nextEdge.getEndVertex().equals(endVertex))
				found = true;
		}
		
		if(found)
			return edgeList.remove(nextEdge);
		else
			throw new RuntimeException("The connection from " + this.getLabel() + " to " + endVertex.getLabel() + " does not exists");
	}

	@Override
	public Iterator<VertexInterface<T>> getNeighborIterator() {
		return new NeighborIterator();
	}

	@Override
	public Iterator<Double> getWeightIterator() {
		return new WeightIterator();
	}

	@Override
	public boolean hasNeighbor() {
		return !edgeList.isEmpty();
	}
	
	@Override
	public boolean hasUnvisitedNeighbor() {
		if(getUnvisitedNeighbor() == null)
			return false;
		else
			return true;
	}

	@Override
	public VertexInterface<T> getUnvisitedNeighbor() {
		VertexInterface<T> result = null;
		Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		while(neighbors.hasNext() && result == null) {
			VertexInterface<T> nextNeighbor = neighbors.next();
			if(!nextNeighbor.isVisited())
				result = nextNeighbor;
		}
		return result;
	}

	@Override
	public void setPredecessor(VertexInterface<T> predecessor) {
		prevVertex = predecessor;
	}

	@Override
	public VertexInterface<T> getPredecessor() {
		return prevVertex;
	}

	@Override
	public boolean hasPredecessor() {
		return prevVertex != null;
	}

	@Override
	public void setCost(double newCost) {
		cost = newCost;
	}

	@Override
	public double getCost() {
		return cost;
	}
	
	@Override
	public int compareTo(VertexInterface<T> vertex) {
		if(this.getCost() > vertex.getCost() )
			return 1;
		else if(this.getCost() < vertex.getCost())
			return -1;
		else
			return 0;
	}
	
	@Override
	public boolean equals(Object other) {
		boolean result;
		if(other == null || (this.getClass() != other.getClass())) {
			result = false;
		}else {
			@SuppressWarnings("unchecked")
			Vertex<T> otherVertex = (Vertex<T>) other;
			result = label.equals(otherVertex.label);
		}
		return result;
	}
	
	//////////////////////////////////////////////////////////////////////////////
	//							Internal Classes							   //
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Will iterate over each of the neighbor of this vertex
	 * @author kjjus
	 */
	private class NeighborIterator implements Iterator<VertexInterface<T>>{
		Iterator<Edge> edges;
		private NeighborIterator() {
			edges = edgeList.getLinkedListIterator();
		}
		@Override
		public boolean hasNext() {
			return edges.hasNext();
		}

		@Override
		public VertexInterface<T> next() {
			if(edges.hasNext()) {
				return edges.next().getEndVertex();
			}else
				throw new NoSuchElementException();
		}
	}
	
	/**
	 * Will iterate over each of the weights of this vertex in the same
	 * order of the NeighborIterator
	 * @author kjjus
	 */
	private class WeightIterator implements Iterator<Double>{
		Iterator<Edge> edges;
		private WeightIterator() {
			edges = edgeList.getLinkedListIterator();
		}
		@Override
		public boolean hasNext() {
			return edges.hasNext();
		}

		@Override
		public Double next() {
			if(edges.hasNext()) {
				return edges.next().getWeight();
			}else
				throw new NoSuchElementException();
		}
	}
	
	
	/**
	 * Will represent the one-way connection between each vertex with a wight and an end vertex
	 * @author kjjus
	 */
	protected class Edge {
		
		private VertexInterface<T> vertex;
		private double weight;
		
		protected Edge(VertexInterface<T> endVertex, double edgeWeight) {
			vertex = endVertex;
			weight = edgeWeight;
		}
		
		protected Edge(VertexInterface<T> endVertex) {
			vertex = endVertex;
			weight = 0;
		}
		
		protected VertexInterface<T> getEndVertex() {
			return vertex;
		}
		
		protected double getWeight() {
			return weight;
		}
		
	}//END OF EDGE CLASS
}//END OF VERTEX CLASS
