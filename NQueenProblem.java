public class NQueenProblem { 
	private int N; 

    public NQueenProblem(int nSize){
        if (nSize > 2){
            this.N = nSize;
        }
        else{
            this.N = 3;
        }
    }

	private void printSolution(int board[][]) 
	{ 
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N; j++) 
				System.out.print(" " + board[i][j] 
								+ " "); 
			System.out.println(); 
        } 
        System.out.println(); 
	} 

	private boolean isSafe(int board[][], int row, int col) 
	{ 
		int i, j; 

		for (i = 0; i < col; i++) 
			if (board[row][i] == 1) 
				return false; 

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
			if (board[i][j] == 1) 
				return false; 

		for (i = row, j = col; j >= 0 && i < N; i++, j--) 
			if (board[i][j] == 1) 
				return false; 

		return true; 
	} 

	private boolean solveNQUtil(int board[][], int col) 
	{ 
		if (col >= N) 
			return true; 

		for (int i = 0; i < N; i++) { 
			if (isSafe(board, i, col)) { 
				board[i][col] = 1; 

				if (solveNQUtil(board, col + 1) == true) 
					return true; 

				board[i][col] = 0; 
			} 
		} 

		return false; 
	} 

	public boolean solveNQ() 
	{ 
		int board[][] = new int[N][N]; 

		if (solveNQUtil(board, 0) == false) { 
			System.out.print("Solution does not exist"); 
			return false; 
		} 

		printSolution(board); 
		return true; 
    } 
 
	private boolean solveEveryNQUtil(int board[][], int col) 
	{ 
		if (col >= N) 
			return true; 

		for (int i = 0; i < N; i++) { 
			if (isSafe(board, i, col)) { 
				board[i][col] = 1; 

				if (solveEveryNQUtil(board, col + 1) == true) 
					printSolution(board); 

				board[i][col] = 0; 
			} 
		} 

		return false; 
	} 
    
    public void solveEveryNQ() { 
		int board[][] = new int[N][N]; 

        solveEveryNQUtil(board, 0);
			
	} 
} 
