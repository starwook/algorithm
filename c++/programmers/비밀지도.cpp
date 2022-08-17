#include <string>
#include <vector>
#include <math.h>

using namespace std;
int arr[17][17];
vector<string> solution(int n, vector<int> arr1, vector<int> arr2)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (pow(2, j) > arr1[i])
            {
                arr[i][n-j]=1;
                arr1[i] -=pow(2,j-1);
            }
            else{
                arr[i][n-j+1] = 0;
            }
        }
    }
    for(int i=0;i<=n;i++){
        for(int j=0;j<=n;j++){
            cout <<" ";

        }
        cout <<"\n";
    }

    vector<string> answer;
    return answer;
}