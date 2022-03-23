#include <iostream>
using namespace std;

long long solution(int w,int h) {
    long long answer = 1;
    int b,s;
    if(w ==1 || h ==1){
        answer = 0;
    }
    else if(w>h){
        for(int)

    }
    else if(w<h){

    }
    else{
        answer = w*h -2;
    }
    
    return answer;
}
1 1 1 1

2 1 2-2
2 2 4-2

3 1 3-3
3 2 6-4
3 3 9-3

4 1 4-4
4 2 8-4
4 3 12-6


5 1 5-5
5 2 10-6
5 3 15-7
5 4 20-8

6 1 6-6
6 2 12-6
6 3 18 -8
6 4 24 - 8
6 5 3 - 10

9 6 
8 1 8-8
8 2 16 - 8
8 3 24 - 10
8 4 32 - 8
8 5 
12 1 12 - 12
12 2 24 - 12
12 3 36 - 12
12 4      14
12 5      14
12 6      16
12 7      16
