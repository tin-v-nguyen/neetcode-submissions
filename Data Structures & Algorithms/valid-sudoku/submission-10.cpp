class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        // check rows
        for (int i = 0; i < board.size(); i++) {
            std::unordered_set<char> seen;
            for (int j = 0; j < board[i].size(); j++) {
                if (board[i][j] == '.') continue;
                if (seen.count(board[i][j])) return false;
                seen.insert(board[i][j]);
            }
        }
        for (int j = 0; j < board.size(); j++) {
            std::unordered_set<char> seen;
            for (int i = 0; i < board[i].size(); i++) {
                if (board[i][j] == '.') continue;
                if (seen.count(board[i][j])) return false;
                seen.insert(board[i][j]);
            }
        } 
        for (int square = 0; square < 9; square++) {
            std::unordered_set<char> seen;
            for (int row = (square / 3) * 3; row < (square / 3) * 3 + 3; row++) {
                for (int col = (square % 3) * 3; col < (square % 3) * 3 + 3; col++) {
                    if (board[row][col] == '.') continue;
                    if (seen.count(board[row][col])) return false;
                    seen.insert(board[row][col]);
                }
            }
        }
        return true;

        
    }
};
