
#include <stdio.h>

int main(){
    char n;
    int count =0;
    int count2 = 0;
    
    while(n !='\n'){
        scanf("%c",&n);
        count *=10;
        count += n-48;
        count2 += n-48;
    }
    printf("%d",count+count2);




}