#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int arr[1000001];
int parent[1000001];
bool check[1000001];
int first[1000001];
bool visited[1000001];
int ansa, ansb;
int n, m;
int cnt = 1;
int x[4] = {-1, 1, 0, 0};
int y[4] = {0, 0, -1, 1};
int find(int a)
{
    if (parent[a] == 0)
    {
        return a;
    }
    else
    {
        return parent[a] = find(parent[a]);
    }
}
void unite(int a, int b)
{
    a = find(a);
    b = find(b);

    if (arr[a] < arr[b])
    {
        parent[b] = a;
        
    }
    else if (arr[a] == arr[b])
    {
        
        if(first[a] >first[b]){
            parent[a] = b;
        }
        else{
            parent[b] = a;
        }
        
    }
    else
    {
        
        parent[a] = b;
    }
}
void change(int a){
    
}
vector<pair<int, pair<int, int>>> vec;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int q;
    cin >> n >> m >> q;
    int z[4] = {-1, 1, -m, m};
    for (int i = 1; i <= n * m; i++)
    {
        int a;
        cin >> a;
        arr[i] = a;
    }

    while (q--)
    {
       
        int a, b, c;
        cin >> a >> b >> c;
      
        int tmp = ((a - 1) * m) + b;
        
        check[((a - 1) * m) + b] = 1;
        arr[((a - 1) * m) + b] -= c;
        first[tmp] = cnt++;
    
        for (int i = 0; i < 4; i++)
        {
            if(i==0){
                if(tmp % m == 1){
                    continue;
                }
            }
            if(i==1){
                if(tmp %m == 0){
                    continue;
                }
            }
            int zi = tmp + z[i];
            if (zi >= 1 && zi <= n * m)
            {
    
                if (check[zi])
                {
                    if (find(tmp) != find(zi))
                    {
                        unite(tmp, zi);
                    }
                    else{
                        if(arr[tmp] < arr[find(tmp)]){
                            parent[find(tmp)] = tmp;
                            parent[tmp] = 0;
                        }
                    }
                }
            }
        }

        tmp = find(tmp);
       
        cout << ((tmp-1)/m)+1  << " ";
        if(tmp%m == 0){
            cout << m;
        }
        else{
            cout <<tmp%m;
        }
        cout <<"\n";
    }

    return 0;
}
