#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int main()
{
    int array[20][20];
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    int tmp;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >>tmp;
            array[i][j] = tmp;
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cout << array[i][j]<<" ";
        }
        cout <<"\n";
    }
}