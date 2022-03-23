
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <unistd.h>
#include <limits.h>

// void RR()
// {
// 	struct process *runnungProc;
// }
// void SJB()
// {
// 	struct process *procTable[nproc];
// }
// void SRTN()
// {
// 	struct process *procTable[nproc];
// }
// void GS()
// {
// 	struct process *procTable[nproc];
// }
// void SFS()
// {
// 	struct process *procTable[nproc];
// }

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
int main(){
    struct process *current = readyQueue.next;
    if (current == readyQueue.prev)
    {
        struct process *tmp = malloc(sizeof(struct process));
        tmp->id = 5;
        readyQueue.next = tmp;
        readyQueue.prev = tmp;
        tmp->prev = &readyQueue;
        tmp->next = &readyQueue;
        current = readyQueue.next;
    }
    while (current != &readyQueue)
    {
        printf("%d", current->id);
        current = current->next;
    }
}
