#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int su[9][9];

void sudoku(int i, int j,int n)
{
    if(su[i][j] == 0){
        for(int t1= 0;t1<9;t1++){
            if(n == su[i][t1]){
                cout << n <<" 행중복with"<< t1<<"\n";
                sudoku(i,j,n+1);
                
                return;
            }
        }
        for(int t =0;t<9;t++){
            if(n == su[t][j]){
                cout << n <<" 열중복with"<< t<<"\n";
                sudoku(i,j,n+1);
                return;
            }
        }
        for(int t= i/3;t<i/3+3;t++){
            for(int t1 = j/3;t1<j/3+3;t1++){
                if(n == su[t][t1]){
                    cout << n <<" 같은 사각형 중복 with"<<  t<<t1<<"\n";
                    sudoku(i,j,n+1);
                    return;
                }
            }
        }
        su[i][j] = n;
        if(i<8){
            if(j<8){
                sudoku(i,j+1,1);
                return;
            }
            else{
                sudoku(i+1,j,1);
                return;
            }
        }
        else{
            if(j<8){
                sudoku(i,j+1,1);
                return;
            }
            
        }

    }
    else if (su[i][j] == n){
        cout <<"이미 존재하는 곳\n";
        sudoku(i,j,n+1);
    }

}
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> su[i][j];
        }
    }
    sudoku(0, 0,1);
}