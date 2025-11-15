//Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        // Your code goes here
        int row = matrix.size();
        int col=matrix[0].size();

        // have row and col vector to set 0 later 

        vector <bool> rowmark(row,false);
        vector <bool> colmark(col,false);


        // traverse for all 0's 

        for (int i=0;i<row;i++)
        {
            for ( int j=0;j<col;j++)
            {
                if (matrix[i][j]==0)
                {
                    rowmark[i]=true;
                    colmark[j]=true;
                }
            }
        }
        // mark back all trues to 0 

        for (int i =0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                if ( rowmark[i]||colmark[j])
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
};
