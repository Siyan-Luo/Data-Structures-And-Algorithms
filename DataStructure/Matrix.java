package DataStructure;

public class Matrix implements Comparable
{
	// some appropriate private members.
	private int nrNodes;
	private Comparable[][] grid;
	
	public Matrix(int nrNodes)
	{
		// allocate an N-by-N matrix where N = nrNodes
		// all elements are initially 0
		this.nrNodes = nrNodes;
		this.grid = new Comparable[nrNodes][nrNodes];
		for (int i=0;i<nrNodes;i++) {
			for (int j=0;j<nrNodes;j++) {
				this.grid[i][j] = 0;
			}
		}
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void set(int row, int col, Comparable weight)
	{
		// store the weight at the given row and column.
		this.grid[row][col] = weight;
	}

	public Comparable get(int row, int col)
	{
		// return the weight at the given row and column.
		return this.grid[row][col];
	}
	
	public Comparable[][] getGrid() {
		return this.grid;
	}

}