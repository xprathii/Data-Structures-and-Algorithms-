Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:



class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> output;
        output.push_back({1});
        for( int i=1;i<numRows;i++)
        {
            vector <int> row ;
            row.push_back(1);
            vector<int>& prevRow=output[i-1];

            for ( int j=1;j<prevRow.size();j++)
            {
             row.push_back(prevRow[j-1]+prevRow[j]);   
            }
           row.push_back(1);
           output.push_back(row);
        }
      
              return output;
    }
};
