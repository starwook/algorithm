#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <unistd.h>
#include <limits.h>
#include <iostream>

using namespace std;
struct process
{
    int id;  //프로세스 id
    int len; // for queue
    int targetServiceTime;
    int serviceTime;
    int startTime; //생성된 시간
    int endTime;   //터미네이트 시간
    char state;
    int priority;           //피드백
    int saveReg0, saveReg1; //레지스터리
    struct process *prev;
    struct process *next; //리스트
} * procTable;
struct process readyQueue;
int main()
{
    readyQueue.id = 5;
    readyQueue.next = readyQueue.prev = &readyQueue;
    struct process *current = readyQueue.next;
    
    while (current != readyQueue.prev)
    {
        current = readyQueue.next;
        cout << current->id;
    }
    while (current != readyQueue.prev)
    {
        current = readyQueue.next;
        cout << current->id;
    }
}
