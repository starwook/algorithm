//
// CPU Schedule Simulator Homework
// Student Number :
// Name :
//
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <unistd.h>
#include <limits.h>
#include <math.h>
#define SEED 10
// process states
#define S_IDLE 0
#define S_READY 1
#define S_BLOCKED 2
#define S_RUNNING 3
#define S_TERMINATE 4
int quantamtime;
int NPROC, NIOREQ, QUANTUM;
int scheduleState;
struct ioDoneEvent
{
	int procid;
	int doneTime;
	int len;
	struct ioDoneEvent *prev;
	struct ioDoneEvent *next;
} ioDoneEventQueue, *ioDoneEvent; //링크드 리스트로 우선순위 큐 구현

struct process
{
	int id;	 //프로세스 id
	int len; // for queue
	int targetServiceTime;
	int serviceTime;
	int startTime; //생성된 시간
	int endTime;   //터미네이트 시간
	char state;
	int priority;			//피드백
	int saveReg0, saveReg1; //레지스터리
	struct process *prev;
	struct process *next; //리스트
} * procTable;			  //레디나 블락드 큐의 헤드노드로 사용됨

struct process idleProc;
struct process readyQueue;
struct process blockedQueue;
struct process *runningProc; //현재 누구사용?

int cpuReg0, cpuReg1;
int currentTime = 0; //전체 시뮬레이션 타임
int *procIntArrTime, *procServTime, *ioReqIntArrTime, *ioServTime;

void compute()
{
	// DO NOT CHANGE THIS FUNCTION
	cpuReg0 = cpuReg0 + runningProc->id;
	cpuReg1 = cpuReg1 + runningProc->id;
	printf("In computer proc %d cpuReg0 %d\n", runningProc->id, cpuReg0);
}

void initProcTable()
{ // 테이블 초기화
	int i;
	for (i = 0; i < NPROC; i++)
	{
		procTable[i].id = i;
		procTable[i].len = 0;
		procTable[i].targetServiceTime = procServTime[i]; //min,max넘어옴
		procTable[i].serviceTime = 0;
		procTable[i].startTime = 0;
		procTable[i].endTime = 0;
		procTable[i].state = S_IDLE;
		procTable[i].priority = 0;
		procTable[i].saveReg0 = 0;
		procTable[i].saveReg1 = 0;
		procTable[i].prev = NULL;
		procTable[i].next = NULL;
	}
}

void RR()
{
	if(readyQueue.next ==&readyQueue){
		runningProc = &idleProc;
	}
	else{
		runningProc = readyQueue.next;
		readyQueue.next = runningProc->next;
		runningProc->next->prev = &readyQueue; //맨앞에서 뺴기
	}
}
void SJB()
{
	struct process *sjb = readyQueue.next;
	if (readyQueue.next == &readyQueue)
	{
		runningProc = &idleProc;
	}
	else{
		runningProc = sjb;
		while(sjb->next != &readyQueue){
			if(sjb->next->targetServiceTime < runningProc->targetServiceTime){
				runningProc = sjb->next;
			}
			sjb = sjb->next;
		}
		runningProc->next->prev = runningProc->prev;
		runningProc->prev->next = runningProc->next;
	}
}
void SRTN()
{
	struct process *srtn = readyQueue.next;
	if (readyQueue.next == &readyQueue)
	{
		runningProc = &idleProc;
	}
	else
	{
		runningProc = srtn;
		while (srtn->next != &readyQueue)
		{
			if (srtn->next->targetServiceTime - srtn->next->serviceTime <runningProc->targetServiceTime -runningProc->serviceTime)
			{
				runningProc = srtn->next;
			}
			srtn = srtn->next;
		}
		runningProc->next->prev = runningProc->prev;
		runningProc->prev->next = runningProc->next;
	}
}
void GS()
{
	struct process *gs = readyQueue.next;
	if (readyQueue.next == &readyQueue)
	{
		runningProc = &idleProc;
	}
	else
	{
		runningProc = gs;
		double tmp = (double)(runningProc->serviceTime) / (double)(runningProc->targetServiceTime);
		while (gs->next != &readyQueue)
		{
			if ((double)(gs->next->serviceTime)/(double)(gs->next->targetServiceTime) < tmp)
			{
				runningProc = gs->next;
				tmp = (double)(runningProc->serviceTime) / (double)(runningProc->targetServiceTime);
			}
			gs = gs->next;
		}
		runningProc->next->prev = runningProc->prev;
		runningProc->prev->next = runningProc->next;
	}
}
void SFS()
{
	struct process *sfs = readyQueue.next;
	if (readyQueue.next == &readyQueue)
	{
		runningProc = &idleProc;
	}
	else
	{
		runningProc = sfs;
		while (sfs->next != &readyQueue)
		{
			if (runningProc->priority< sfs->next->priority)
			{
				runningProc = sfs->next;
				
			}
			sfs = sfs->next;
		}
		runningProc->next->prev = runningProc->prev;
		runningProc->prev->next = runningProc->next;
	}
}
void scheduling(int sch)
{
	quantamtime = 0;
	switch (sch)
	{
	case 1:
		RR();
		break;
	case 2:
		SJB();
		break;
	case 3:
		SRTN();
		break;
	case 4:
		GS();
		break;
	case 5:
		SFS();
		break;
	}
}
void procExecSim(int sch)
{ //우리가 완성해야하는 것 compute뺴고 다 빠꿔도 됨
	int pid, cpuUseTime = 0, nproc = 0, termProc = 0, nioreq = 0;
	quantamtime =0;
	char schedule = 0, nextState = S_IDLE;
	int nextForkTime, nextIOReqTime;
	nextForkTime = procIntArrTime[nproc];	 //nextForkTime 시간때 프로세스가 생성이됨.
	nextIOReqTime = ioReqIntArrTime[nioreq]; //nextIOReqTime 때 I/O가 실행이 됨.
	runningProc = &idleProc;				 //처음은 idle로 시작
	while (1)
	{ // 한 번돌때마다 시뮬레이션 타임 업
		
		currentTime++;
		quantamtime++; //퀀텀 시간 증가
		runningProc->serviceTime++;
		if (runningProc != &idleProc)
			cpuUseTime++; //idle 아니라면 cpu사용시간 증가
		// MUST CALL compute() Inside While loop
		compute(); //이건 매사이클 돌려야함 레지스트리 저장
		if (currentTime == nextForkTime)
		{	/* CASE 2 : a new process created */
			//readyQueue에 프로세스를 만들어야함
			struct process *current = readyQueue.next;
			if (current == readyQueue.prev) //ready큐가 비어있다면
			{
				readyQueue.next = &procTable[nproc];
				readyQueue.prev = &procTable[nproc];
				procTable[nproc].prev = &readyQueue;
				procTable[nproc].next = &readyQueue;
				current = readyQueue.next;

				procTable[nproc].startTime = currentTime;
				procTable[nproc].state = S_READY;
			}
			else
			{
				while (current != readyQueue.prev) //뒷쪽에 추가
				{
					current = current->next;
				}
				procTable[nproc].prev = current;
				current->next = &procTable[nproc];
				procTable[nproc].next = &readyQueue;
				readyQueue.prev = &procTable[nproc];

				procTable[nproc].startTime = currentTime;
				procTable[nproc].state = S_READY;
			}
			nproc++; //다음 프로세스 추가를 위한 준비
			nextForkTime += procIntArrTime[nproc];
			scheduling(sch);
		}
		if (runningProc != &idleProc && runningProc->serviceTime == runningProc->targetServiceTime)
		{ /* CASE 끝 : the process job done and terminates */
			runningProc->endTime = currentTime;
			runningProc->state = S_TERMINATE;
			scheduling(sch);
		}
		if (cpuUseTime == nextIOReqTime && runningProc->state ==S_RUNNING)
		{ /* CASE IO요청: reqest IO operations (only when the process does not terminate) */
			struct process *current = blockedQueue.next;
			if (current == blockedQueue.prev) //blocked큐가 비어있다면
			{
				blockedQueue.next = runningProc;
				blockedQueue.prev = runningProc;
				runningProc->prev = &blockedQueue;
				runningProc->next = &blockedQueue;
				current = blockedQueue.next;
			}
			else
			{
				while (current != blockedQueue.prev) //뒷쪽에 추가
				{
					current = current->next;
				}
				runningProc->prev = current;
				current->next = runningProc;
				runningProc->next = &blockedQueue;
				blockedQueue.prev = runningProc;
			}

			ioDoneEvent[nioreq].doneTime = currentTime + ioServTime[nioreq];
			ioDoneEvent[nioreq].procid = runningProc->id;

			struct ioDoneEvent *curIo = ioDoneEventQueue.next;
			if (curIo == ioDoneEventQueue.prev)
			{
				ioDoneEventQueue.next = &ioDoneEvent[nioreq];
				ioDoneEvent[nioreq].next = &ioDoneEventQueue;
				ioDoneEventQueue.prev = &ioDoneEvent[nioreq];
				ioDoneEvent[nioreq].prev = &ioDoneEventQueue;
			} //ioDoneEvent 하나도 없다면
			else
			{

				while (curIo->doneTime <= ioDoneEvent[nioreq].doneTime)
				{
					if (curIo->next == &ioDoneEventQueue) //마지막 직전이면서 ,시간이 이상일때
					{
						ioDoneEvent[nioreq].next = &ioDoneEventQueue;
						ioDoneEventQueue.prev = &ioDoneEvent[nioreq];
						curIo->next = &ioDoneEvent[nioreq];
						ioDoneEvent[nioreq].prev = curIo;
						break;
					} //뒤에다 붙혀준다
					else
					{
						curIo = curIo->next;
					}
				}
				if (curIo->doneTime > ioDoneEvent[nioreq].doneTime) //IODOne시간순으로
				{
					ioDoneEvent[nioreq].prev = curIo->prev;
					ioDoneEvent[nioreq].next = curIo;
					curIo->prev->next = &ioDoneEvent[nioreq];
					curIo->prev = &ioDoneEvent[nioreq];
				}
			}
			runningProc->state = S_BLOCKED;
			if(quantamtime !=QUANTUM){
				runningProc->priority ++;
			}
			nioreq++;
			nextIOReqTime += ioReqIntArrTime[nioreq];
			scheduling(sch);
		}

		if (quantamtime == QUANTUM && runningProc->state ==S_RUNNING &&runningProc != &idleProc)
		{ /* CASE 1퀀텀 다 사용 : The quantum expires */
			struct process *current = readyQueue.next;
			if (current == readyQueue.prev) //ready큐가 비어있다면
			{
				readyQueue.next = runningProc;
				readyQueue.prev = runningProc;
				runningProc->prev = &readyQueue;
				runningProc->next = &readyQueue;
				current = readyQueue.next;
			}
			else
			{
				while (current != readyQueue.prev) //뒷쪽에 추가
				{
					current = current->next;
				}
				runningProc->prev = current;
				current->next = runningProc;
				runningProc->next = &readyQueue;
				readyQueue.prev = runningProc;
			}

			runningProc ->priority--;
			scheduling(sch);
		}
		
		struct process *tmp = &idleProc;
		while (ioDoneEventQueue.next->doneTime == currentTime)
		{ /* CASE IO처리 끄탄ㅁ : IO Done Event */
		    if(runningProc != &idleProc){ //io끝날때 돌아가는 idle이 있다면
			 tmp = runningProc;
			}
			int changeid = ioDoneEventQueue.next->procid ;
			if (procTable[changeid].state == S_TERMINATE)
			{
				continue;
			}
			else{
				

				struct process *current = readyQueue.next;
				if (current == readyQueue.prev) //ready큐가 비어있다면
				{
					readyQueue.next = &procTable[changeid];
					readyQueue.prev = &procTable[changeid];
					procTable[changeid].prev = &readyQueue;
					procTable[changeid].next = &readyQueue;
					current = readyQueue.next;
					// procTable[changeid].startTime = currentTime;
					procTable[changeid].state = S_READY;
				}
				else
				{
					while (current != readyQueue.prev) //뒷쪽에 추가
					{
						current = current->next;
					}
					procTable[changeid].prev = current;
					current->next = &procTable[changeid];
					procTable[changeid].next = &readyQueue;
					readyQueue.prev = &procTable[changeid];
					// procTable[changeid].startTime = currentTime;
					procTable[changeid].state = S_READY;
				}
				current = blockedQueue.next; //blocedqueue에서 빼줘야함
				while(current->id != changeid){
					current = current->next;
				}
				current->next->prev = current->prev;
				current->prev->next = current->next;
			}
            
			ioDoneEventQueue.next = ioDoneEventQueue.next->next;
			ioDoneEventQueue.next->prev = &ioDoneEventQueue;
		}
		if(tmp != &idleProc){
			struct process *current = readyQueue.next;
			if (current == readyQueue.prev) //ready큐가 비어있다면
			{
				readyQueue.next = runningProc;
				readyQueue.prev = runningProc;
				runningProc->prev = &readyQueue;
				runningProc->next = &readyQueue;
				current = readyQueue.next;
				// procTable[changeid].startTime = currentTime;
				runningProc->state = S_READY;
			}
			else
			{
				while (current != readyQueue.prev) //뒷쪽에 추가
				{
					current = current->next;
				}
				runningProc->prev = current;
				current->next = runningProc;
				runningProc->next = &readyQueue;
				readyQueue.prev = runningProc;
				// procTable[changeid].startTime = currentTime;
				runningProc->state = S_READY;
			}
			scheduling(sch);
		}
		
		
		// call scheduler() if needed
		// 만약 다 끝나면 break;
	} // while loop
}

//RR,SJF(Modified),SRTN,Guaranteed Scheduling(modified),Simple Feed Back Scheduling
//스케쥴러
// struct process *RRschedule()
// {
// }
// struct process *SJFschedule()
// {
// }
// struct process *SRTNschedule()
// {
// }
// struct process *GSschedule()
// {
// }
// struct process *SFSschedule()
// {
// }

void printResult()
{
	// DO NOT CHANGE THIS FUNCTION
	int i;
	long totalProcIntArrTime = 0, totalProcServTime = 0, totalIOReqIntArrTime = 0, totalIOServTime = 0;
	long totalWallTime = 0, totalRegValue = 0;
	for (i = 0; i < NPROC; i++)
	{
		totalWallTime += procTable[i].endTime - procTable[i].startTime;
		/*
      printf("proc %d serviceTime %d targetServiceTime %d saveReg0 %d\n",
         i,procTable[i].serviceTime,procTable[i].targetServiceTime, procTable[i].saveReg0);
      */
		totalRegValue += procTable[i].saveReg0 + procTable[i].saveReg1;
		/* printf("reg0 %d reg1 %d totalRegValue %d\n",procTable[i].saveReg0,procTable[i].saveReg1,totalRegValue);*/
	}
	for (i = 0; i < NPROC; i++)
	{
		totalProcIntArrTime += procIntArrTime[i];
		totalProcServTime += procServTime[i];
	}
	for (i = 0; i < NIOREQ; i++)
	{
		totalIOReqIntArrTime += ioReqIntArrTime[i];
		totalIOServTime += ioServTime[i];
	}

	printf("Avg Proc Inter Arrival Time : %g \tAverage Proc Service Time : %g\n", (float)totalProcIntArrTime / NPROC, (float)totalProcServTime / NPROC);
	printf("Avg IOReq Inter Arrival Time : %g \tAverage IOReq Service Time : %g\n", (float)totalIOReqIntArrTime / NIOREQ, (float)totalIOServTime / NIOREQ);
	printf("%d Process processed with %d IO requests\n", NPROC, NIOREQ);
	printf("Average Wall Clock Service Time : %g \tAverage Two Register Sum Value %g\n", (float)totalWallTime / NPROC, (float)totalRegValue / NPROC);
}

int main(int argc, char *argv[])
{
	// DO NOT CHANGE THIS FUNCTION
	int i;
	int totalProcServTime = 0, ioReqAvgIntArrTime;
	int SCHEDULING_METHOD, MIN_INT_ARRTIME, MAX_INT_ARRTIME, MIN_SERVTIME, MAX_SERVTIME, MIN_IO_SERVTIME, MAX_IO_SERVTIME, MIN_IOREQ_INT_ARRTIME;

	if (argc < 12)
	{
		printf("%s: SCHEDULING_METHOD NPROC NIOREQ QUANTUM MIN_INT_ARRTIME MAX_INT_ARRTIME MIN_SERVTIME MAX_SERVTIME MIN_IO_SERVTIME MAX_IO_SERVTIME MIN_IOREQ_INT_ARRTIME\n", argv[0]);
		exit(1);
	}

	SCHEDULING_METHOD = atoi(argv[1]);
	NPROC = atoi(argv[2]);
	NIOREQ = atoi(argv[3]);
	QUANTUM = atoi(argv[4]);
	MIN_INT_ARRTIME = atoi(argv[5]);
	MAX_INT_ARRTIME = atoi(argv[6]);
	MIN_SERVTIME = atoi(argv[7]);
	MAX_SERVTIME = atoi(argv[8]);
	MIN_IO_SERVTIME = atoi(argv[9]);
	MAX_IO_SERVTIME = atoi(argv[10]);
	MIN_IOREQ_INT_ARRTIME = atoi(argv[11]);

	printf("SIMULATION PARAMETERS : SCHEDULING_METHOD %d NPROC %d NIOREQ %d QUANTUM %d \n", SCHEDULING_METHOD, NPROC, NIOREQ, QUANTUM);
	printf("MIN_INT_ARRTIME %d MAX_INT_ARRTIME %d MIN_SERVTIME %d MAX_SERVTIME %d\n", MIN_INT_ARRTIME, MAX_INT_ARRTIME, MIN_SERVTIME, MAX_SERVTIME);
	printf("MIN_IO_SERVTIME %d MAX_IO_SERVTIME %d MIN_IOREQ_INT_ARRTIME %d\n", MIN_IO_SERVTIME, MAX_IO_SERVTIME, MIN_IOREQ_INT_ARRTIME);

	srandom(SEED);

	// allocate array structures
	procTable = (struct process *)malloc(sizeof(struct process) * NPROC);
	ioDoneEvent = (struct ioDoneEvent *)malloc(sizeof(struct ioDoneEvent) * NIOREQ);
	procIntArrTime = (int *)malloc(sizeof(int) * NPROC);
	procServTime = (int *)malloc(sizeof(int) * NPROC);
	ioReqIntArrTime = (int *)malloc(sizeof(int) * NIOREQ);
	ioServTime = (int *)malloc(sizeof(int) * NIOREQ);

	// initialize queues
	readyQueue.next = readyQueue.prev = &readyQueue;
	blockedQueue.next = blockedQueue.prev = &blockedQueue; //큐들 초기화
	ioDoneEventQueue.next = ioDoneEventQueue.prev = &ioDoneEventQueue;
	ioDoneEventQueue.doneTime = INT_MAX;
	ioDoneEventQueue.procid = -1;
	ioDoneEventQueue.len = readyQueue.len = blockedQueue.len = 0;

	// generate process interarrival times //배열 초기화 하는중
	for (i = 0; i < NPROC; i++)
	{
		procIntArrTime[i] = random() % (MAX_INT_ARRTIME - MIN_INT_ARRTIME + 1) + MIN_INT_ARRTIME;
	}
	
	// assign service time for each process
	for (i = 0; i < NPROC; i++)
	{
		procServTime[i] = random() % (MAX_SERVTIME - MIN_SERVTIME + 1) + MIN_SERVTIME;
		totalProcServTime += procServTime[i];
	}

	ioReqAvgIntArrTime = totalProcServTime / (NIOREQ + 1);
	assert(ioReqAvgIntArrTime > MIN_IOREQ_INT_ARRTIME);

	// generate io request interarrival time
	for (i = 0; i < NIOREQ; i++)
	{
		ioReqIntArrTime[i] = random() % ((ioReqAvgIntArrTime - MIN_IOREQ_INT_ARRTIME) * 2 + 1) + MIN_IOREQ_INT_ARRTIME;
	}

	// generate io request service time
	for (i = 0; i < NIOREQ; i++)
	{
		ioServTime[i] = random() % (MAX_IO_SERVTIME - MIN_IO_SERVTIME + 1) + MIN_IO_SERVTIME;
	}

#ifdef DEBUG
	// printing process interarrival time and service time
	printf("Process Interarrival Time :\n");
	for (i = 0; i < NPROC; i++)
	{
		printf("%d ", procIntArrTime[i]);
	}
	printf("\n");
	printf("Process Target Service Time :\n");
	for (i = 0; i < NPROC; i++)
	{
		printf("%d ", procTable[i].targetServiceTime);
	}
	printf("\n");
#endif

	// printing io request interarrival time and io request service time
	printf("IO Req Average InterArrival Time %d\n", ioReqAvgIntArrTime);
	printf("IO Req InterArrival Time range : %d ~ %d\n", MIN_IOREQ_INT_ARRTIME,
		   (ioReqAvgIntArrTime - MIN_IOREQ_INT_ARRTIME) * 2 + MIN_IOREQ_INT_ARRTIME);

#ifdef DEBUG
	printf("IO Req Interarrival Time :\n");
	for (i = 0; i < NIOREQ; i++)
	{
		printf("%d ", ioReqIntArrTime[i]);
	}
	printf("\n");
	printf("IO Req Service Time :\n");
	for (i = 0; i < NIOREQ; i++)
	{
		printf("%d ", ioServTime[i]);
	}
	printf("\n");
#endif

	int schFunc;
	switch (SCHEDULING_METHOD)
	{
	case 1:
		schFunc = 1;//RRschedule;
		break;
	case 2:
		schFunc = 2;// SJFschedule;
		break;
	case 3:
		schFunc = 3;//SRTNschedule;
		break;
	case 4:
		schFunc = 4;//GSschedule;
		break;
	case 5:
		schFunc = 5;//SFSschedule;
		break;
	default:
		printf("ERROR : Unknown Scheduling Method\n");
		exit(1);
	}
	initProcTable();
	procExecSim(schFunc); // 스케쥴러 부름
	printResult();
}