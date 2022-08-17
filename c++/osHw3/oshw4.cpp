

//
// Simple FIle System
// Student Name :
// Student Number :
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

/* optional */
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
/***********/

#include "sfs_types.h"
#include "sfs_func.h"
#include "sfs_disk.h"
#include "sfs.h"

                                                                                                          void dump_directory();

/* BIT operation Macros */
/* a=target variable, b=bit number to act upon 0-n */
#define BIT_SET(a, b) ((a) |= (1 << (b)))
#define BIT_CLEAR(a, b) ((a) &= ~(1 << (b)))
#define BIT_FLIP(a, b) ((a) ^= (1 << (b)))
#define BIT_CHECK(a, b) ((a) & (1 << (b)))

static struct sfs_super spb;                // superblock
static struct sfs_dir sd_cwd = {SFS_NOINO}; // current working directory

void error_message(const char *message, const char *path, int error_code)
{
    switch (error_code)
    {
    case -1:
        printf("%s: %s: No such file or directory\n", message, path);
        return;
    case -2:
        printf("%s: %s: Not a directory\n", message, path);
        return;
    case -3:
        printf("%s: %s: Directory full\n", message, path);
        return;
    case -4:
        printf("%s: %s: No block available\n", message, path);
        return;
    case -5:
        printf("%s: %s: Not a directory\n", message, path);
        return;
    case -6:
        printf("%s: %s: Already exists\n", message, path);
        return;
    case -7:
        printf("%s: %s: Directory not empty\n", message, path);
        return;
    case -8:
        printf("%s: %s: Invalid argument\n", message, path);
        return;
    case -9:
        printf("%s: %s: Is a directory\n", message, path);
        return;
    case -10:
        printf("%s: %s: Is not a file\n", message, path);
        return;
    default:
        printf("unknown error code\n");
        return;
    }
}
void sfs_mount(const char *path)
{
    if (sd_cwd.sfd_ino != SFS_NOINO)
    {
        //umount
        disk_close();
        printf("%s, unmounted\n", spb.sp_volname);
        bzero(&spb, sizeof(struct sfs_super));
        sd_cwd.sfd_ino = SFS_NOINO;
    }

    printf("Disk image: %s\n", path);

    disk_open(path);
    disk_read(&spb, SFS_SB_LOCATION);

    printf("Superblock magic: %x\n", spb.sp_magic);

    assert(spb.sp_magic == SFS_MAGIC);

    printf("Number of blocks: %d\n", spb.sp_nblocks);
    printf("Volume name: %s\n", spb.sp_volname);
    printf("%s, mounted\n", spb.sp_volname);

    sd_cwd.sfd_ino = 1; //init at root
    sd_cwd.sfd_name[0] = '/';
    sd_cwd.sfd_name[1] = '\0';
}
void sfs_umount()
{

    if (sd_cwd.sfd_ino != SFS_NOINO)
    {
        //umount
        disk_close();
        printf("%s, unmounted\n", spb.sp_volname);
        bzero(&spb, sizeof(struct sfs_super));
        sd_cwd.sfd_ino = SFS_NOINO;
    }
}

void sfs_touch(const char *path)
{
    //skeleton implementation
    int checked = 0;
    int i, freeBitNum, j, x, tmpi;
    unsigned char tmp, tmp2;
    tmp = 0xff;
    unsigned char *tmpBitMap = malloc(sizeof(char) * SFS_BLOCKSIZE);
    unsigned char *tmpBitMap2 = malloc(sizeof(char) * SFS_BLOCKSIZE);
    struct sfs_inode si;
    disk_read(&si, sd_cwd.sfd_ino);
    //for consistency
    //we assume that cwd is the root directory and root directory is empty which has . and .. only
    //unused DISK2.img satisfy these assumption
    //for new directory entry(for new file), we use cwd.sfi_direct[0] and offset 2
    //becasue cwd.sfi_directory[0] is already allocated, by .(offset 0) and ..(offset 1)
    //for new inode, we use block 6
    // block 0: superblock, block 1:root, block 2:bitmap
    // block 3:bitmap,   block 4:bitmap block 5:root.sfi_direct[0] block 6:unused
    //
    //if used DISK2.img is used, result is not defined

    //buffer for disk read
    struct sfs_dir sd[SFS_DENTRYPERBLOCK];
    for (x = 0; x < SFS_NDIRECT; x++)
    {
        disk_read(sd, si.sfi_direct[x]);
        for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
        {
            if (strcmp(sd[i].sfd_name, path) == 0 && sd[i].sfd_ino != 0)
            {
                error_message("touch", path, -6);
                return;
            }
        }
    }
    //block access
    //allocate new block
    int xi, freeBitNum2, freeBitNumMap, freeBitNumMap2;
    int cnt = 0;
    int a, b, c, d, e, f, s;
    int tmpi2;
    checked = 0;
    for (xi = 0; xi < SFS_NDIRECT; xi++)
    {
        if (si.sfi_direct[xi] == 0)
        { // 새로운 디렉토리 엔트리들을 만들어야함
            for (tmpi = 2; tmpi < spb.sp_nblocks; tmpi++)
            {
                if (checked == 1)
                {
                    break;
                }
                disk_read(tmpBitMap, tmpi);
                for (j = 0; j < SFS_BLOCKSIZE; j++)
                { //spb.sp_nblocks 넣어줘야할 수도!
                    if (checked == 1)
                    {
                        break;
                    }
                    tmp2 = tmp & tmpBitMap[j];
                    for (x = 0; x < 8; x++)
                    {
                        if (j * 8 + x + (tmpi - 2) * SFS_BLOCKBITS == spb.sp_nblocks - 1)
                        {
                            error_message("touch", path, -4);
                            return;
                        }
                        if (BIT_CHECK(tmp2, x))
                        {
                            continue;
                        }
                        else
                        {
                            BIT_SET(tmpBitMap[j], x);
                            a = j * 8 + x + (tmpi - 2) * SFS_BLOCKBITS;
                            checked = 1;
                            f = tmpi;
                            break;
                        }
                    }
                }
            }
            checked = 0;
            for (tmpi2 = 2; tmpi2 < spb.sp_nblocks; tmpi2++)
            {
                if (checked == 1)
                {
                    break;
                }
                disk_read(tmpBitMap2, tmpi2);
                for (j = 0; j < SFS_BLOCKSIZE; j++)
                { //spb.sp_nblocks 넣어줘야할 수도!
                    if (checked == 1)
                    {
                        break;
                    }
                    tmp2 = tmp & tmpBitMap2[j];
                    for (x = 0; x < 8; x++)
                    {
                        if (j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS == spb.sp_nblocks - 1)
                        {
                            error_message("touch", path, -4);
                            return;
                        }
                        if (BIT_CHECK(tmp2, x))
                        {
                            continue;
                        }
                        else
                        {
                            if (j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS == a)
                            {
                                continue;
                            }
                            b = j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS;
                            if (f == tmpi2)
                            { //같은 페이지였다면
                                BIT_SET(tmpBitMap[j], x);
                            }
                            else
                            {
                                BIT_SET(tmpBitMap2[j], x);
                                s = tmpi2;
                            }

                            checked = 1;
                            break;
                        }
                    }
                }
            }

            // a = inode할당을 위한 블록 위치, f 그블록 번호
            // b = 새로운 directentry할당 위한 블록 위치, s 그 블록 번호
            // 둘이 같은 블록 번호라면 tmpBitMap에 저장 ,아니라면 tmpBitMap2에 각각
            struct sfs_dir newEntry[SFS_DENTRYPERBLOCK];
            int nd;
            for (nd = 0; nd < SFS_DENTRYPERBLOCK; nd++)
            { //초기화
                newEntry[nd].sfd_ino = SFS_NOINO;
            }
            newEntry[0].sfd_ino = b;
            strcpy(newEntry[0].sfd_name, path);

            struct sfs_inode newbie;
            bzero(&newbie, SFS_BLOCKSIZE); // initalize sfi_direct[] and sfi_indirect
            newbie.sfi_size = 0;
            newbie.sfi_type = SFS_TYPE_FILE;
            disk_write(&newbie, b);

            si.sfi_direct[xi] = a;
            si.sfi_size += sizeof(struct sfs_dir);
            disk_write(&si, sd_cwd.sfd_ino); //디렉 블록 저장

            disk_write(newEntry, a);

            if (f == s)
            {
                disk_write(tmpBitMap, f);
            }
            else
            {
                disk_write(tmpBitMap, f);
                disk_write(tmpBitMap2, s);
            }
            return;
        }
        else
        { //남아있다면
            disk_read(sd, si.sfi_direct[xi]);
            for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
            {
                if (sd[i].sfd_ino == 0)
                {
                    for (tmpi = 2; tmpi < spb.sp_nblocks; tmpi++)
                    {
                        if (checked == 1)
                        {
                            break;
                        }
                        disk_read(tmpBitMap, tmpi);
                        for (j = 0; j < SFS_BLOCKSIZE; j++)
                        { //spb.sp_nblocks 넣어줘야할 수도!
                            if (checked == 1)
                            {
                                break;
                            }
                            tmp2 = tmp & tmpBitMap[j];
                            for (x = 0; x < 8; x++)
                            {
                                if (j * 8 + x + (tmpi - 2) * SFS_BLOCKBITS == spb.sp_nblocks - 1)
                                {
                                    error_message("touch", path, -4);
                                    return;
                                }
                                if (BIT_CHECK(tmp2, x))
                                {
                                    continue;
                                }
                                else
                                {
                                    BIT_SET(tmpBitMap[j], x);
                                    a = j * 8 + x + (tmpi - 2) * SFS_BLOCKBITS;
                                    checked = 1;
                                    f = tmpi;

                                    strcpy(sd[i].sfd_name, path);
                                    sd[i].sfd_ino = a; //번호도 적어야함
                                    disk_write(sd, si.sfi_direct[xi]);
                                    si.sfi_size += sizeof(struct sfs_dir);
                                    disk_write(&si, sd_cwd.sfd_ino);
                                    struct sfs_inode newbie;
                                    bzero(&newbie, SFS_BLOCKSIZE); // initalize sfi_direct[] and sfi_indirect
                                    newbie.sfi_size = 0;
                                    newbie.sfi_type = SFS_TYPE_FILE;
                                    disk_write(&newbie, a);
                                    disk_write(tmpBitMap, f);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //끝까지 가도 없음
    error_message("touch", path, -3);
    return;

    //int newbie_ino = 6;
    //sd[2].sfd_ino = newbie_ino;
    //strncpy( sd[2].sfd_name, path, SFS_NAMELEN );

    //disk_write( sd, si.sfi_direct[0] );

    //si.sfi_size += sizeof(struct sfs_dir);
    //disk_write( &si, sd_cwd.sfd_ino );

    //struct sfs_inode newbie;

    //bzero(&newbie,SFS_BLOCKSIZE); // initalize sfi_direct[] and sfi_indirect
    //newbie.sfi_size = 0;
    //newbie.sfi_type = SFS_TYPE_FILE;
    //disk_write( &newbie, newbie_ino );
}

void sfs_cd(const char *path)
{
    int i, j, x;
    if (path == NULL)
    {
        sd_cwd.sfd_ino = 1; //init at root
        sd_cwd.sfd_name[0] = '/';
        sd_cwd.sfd_name[1] = '\0';
        return;
    }
    struct sfs_inode c_inode;
    struct sfs_inode t_inode;
    disk_read(&c_inode, sd_cwd.sfd_ino);
    struct sfs_dir dir_entry[SFS_DENTRYPERBLOCK];
    for (x = 0; x < SFS_NDIRECT; x++)
    {
        disk_read(dir_entry, c_inode.sfi_direct[x]); //DIR_ENTRY= CWD의 블럭
        for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
        {
            if (dir_entry[i].sfd_ino == 0)
            {
                continue;
            }
            if (strcmp(dir_entry[i].sfd_name, path) == 0)
            {
                disk_read(&t_inode, dir_entry[i].sfd_ino);
                if (t_inode.sfi_type == SFS_TYPE_FILE)
                {
                    error_message("cd", path, -2); // 못 찾았을 경우 처음 경로로
                    return;
                }
                else
                {
                    sd_cwd.sfd_ino = dir_entry[i].sfd_ino; //init at root
                    strcpy(sd_cwd.sfd_name, dir_entry[i].sfd_name);
                    return;
                }
            }
        }
    }
    error_message("cd", path, -1); // 못 찾았을 경우 처음 경로로

    /*printf("Not Implemented\n");*/
}

void sfs_ls(const char *path)
{
    int i, j, x;
    struct sfs_inode c_inode;
    struct sfs_inode t_inode;
    struct sfs_inode t2_inode;
    struct sfs_dir dir_entry[SFS_DENTRYPERBLOCK];
    struct sfs_dir tmp_dir_entry[SFS_DENTRYPERBLOCK];
    disk_read(&c_inode, sd_cwd.sfd_ino);

    if (path == NULL)
    {
        for (x = 0; x < SFS_NDIRECT; x++)
        {
            if (c_inode.sfi_direct[x] == 0)
            {
                printf("\n");
                return;
            }
            disk_read(dir_entry, c_inode.sfi_direct[x]);
            for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
            { //해당 블럭의 ls실행
                if (dir_entry[i].sfd_ino == 0)
                {
                    continue;
                }
                disk_read(&t_inode, dir_entry[i].sfd_ino);
                printf("%s", dir_entry[i].sfd_name);
                if (t_inode.sfi_type == SFS_TYPE_DIR)
                {
                    printf("/");
                }

                printf("\t");
            }
        }
        printf("\n");
        return;
    }
    else
    {
        for (x = 0; x < SFS_NDIRECT; x++)
        {
            if (c_inode.sfi_direct[x] == 0)
            { //못찾았음
                break;
            }
            disk_read(dir_entry, c_inode.sfi_direct[x]);
            for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
            {
                if (dir_entry[i].sfd_ino == 0)
                {
                    continue;
                }
                if (strcmp(dir_entry[i].sfd_name, path) == 0)
                {
                    disk_read(&t_inode, dir_entry[i].sfd_ino);
                    if (t_inode.sfi_type == SFS_TYPE_DIR)
                    {
                        int x1, i1;
                        for (x1 = 0; x1 < SFS_NDIRECT; x1++)
                        {
                            if (t_inode.sfi_direct[x1] == 0)
                            {
                                printf("\n");
                                return;
                            }
                            disk_read(tmp_dir_entry, t_inode.sfi_direct[x1]);
                            for (i1 = 0; i1 < SFS_DENTRYPERBLOCK; i1++)
                            {
                                if (tmp_dir_entry[i1].sfd_ino == 0)
                                {
                                    continue;
                                }
                                disk_read(&t2_inode, tmp_dir_entry[j].sfd_ino);
                                printf("%s", tmp_dir_entry[i1].sfd_name);
                                if (t2_inode.sfi_type == SFS_TYPE_DIR)
                                {
                                    printf("/");
                                }

                                printf("\t");
                            }
                        }
                        printf("\n");
                    }
                    else
                    {
                        printf("%s\n", dir_entry[i].sfd_name);
                    }
                    return;
                }
            }
        }
    }

    error_message("ls", path, -1);

    /*printf("Not Implemented\n");*/
}

void sfs_mkdir(const char *org_path)
{
    int a, b;
    int checked = 0;
    int cnt = 0;
    int i, freeBitNum, j, x, tmpi, tmpi2;
    unsigned char tmp, tmp2;
    tmp = 0xff;
    unsigned char *tmpBitMap = malloc(sizeof(char) * SFS_BLOCKSIZE);
    unsigned char *tmpBitMap2 = malloc(sizeof(char) * SFS_BLOCKSIZE);
    unsigned char *tmpBitMap3 = malloc(sizeof(char) * SFS_BLOCKSIZE);
    /*printf("Not Implemented\n");*/
    struct sfs_inode si;
    disk_read(&si, sd_cwd.sfd_ino);
    //for consistency
    assert(si.sfi_type == SFS_TYPE_DIR);

    //we assume that cwd is the root directory and root directory is empty which has . and .. only
    //unused DISK2.img satisfy these assumption
    //for new directory entry(for new file), we use cwd.sfi_direct[0] and offset 2
    //becasue cwd.sfi_directory[0] is already allocated, by .(offset 0) and ..(offset 1)
    //for new inode, we use block 6
    // block 0: superblock, block 1:root, block 2:bitmap
    // block 3:bitmap,   block 4:bitmap block 5:root.sfi_direct[0] block 6:unused
    //
    //if used DISK2.img is used, result is not defined

    //buffer for disk read

    struct sfs_dir sd[SFS_DENTRYPERBLOCK];

    for (x = 0; x < SFS_NDIRECT; x++)
    {
        disk_read(sd, si.sfi_direct[x]);
        for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
        {
            if (strcmp(sd[i].sfd_name, org_path) == 0 && sd[i].sfd_ino != 0)
            {
                error_message("mkdir", org_path, -6);
                return;
            }
        }
    }
    //block access
    int f, s;
    //allocate new block
    for (tmpi = 2; tmpi < spb.sp_nblocks; tmpi++)
    {
        if (checked == 1)
        {
            break;
        }
        disk_read(tmpBitMap, tmpi);
        for (j = 0; j < SFS_BLOCKSIZE; j++)
        { //spb.sp_nblocks 넣어줘야할 수도!
            if (checked == 1)
            {
                break;
            }
            tmp2 = tmp & tmpBitMap[j];
            for (x = 0; x < 8; x++)
            {
                if (j * 8 + x + (tmpi - 2) * SFS_BLOCKBITS == spb.sp_nblocks - 1)
                {
                    error_message("mkdir", org_path, -4);
                    return;
                }
                if (BIT_CHECK(tmp2, x))
                {
                    continue;
                }
                else
                {
                    BIT_SET(tmpBitMap[j], x);
                    a = j * 8 + x + (tmpi - 2) * SFS_BLOCKBITS;
                    checked = 1;
                    f = tmpi;
                    break;
                }
            }
        }
    }
    checked = 0;
    for (tmpi2 = 2; tmpi2 < spb.sp_nblocks; tmpi2++)
    {
        if (checked == 1)
        {
            break;
        }
        disk_read(tmpBitMap2, tmpi2);
        for (j = 0; j < SFS_BLOCKSIZE; j++)
        { //spb.sp_nblocks 넣어줘야할 수도!
            if (checked == 1)
            {
                break;
            }
            tmp2 = tmp & tmpBitMap2[j];
            for (x = 0; x < 8; x++)
            {
                if (j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS == spb.sp_nblocks - 1)
                {
                    error_message("mkdir", org_path, -4);
                    return;
                }
                if (BIT_CHECK(tmp2, x))
                {
                    continue;
                }
                else
                {
                    if (j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS == a)
                    {
                        continue;
                    }
                    b = j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS;
                    if (f == tmpi2)
                    { //같은 페이지였다면
                        BIT_SET(tmpBitMap[j], x);
                    }
                    else
                    {
                        BIT_SET(tmpBitMap2[j], x);
                        s = tmpi2;
                    }

                    checked = 1;
                    break;
                }
            }
        }
    }
    checked = 0;
    int xi;
    for (xi = 0; xi < SFS_NDIRECT; xi++)
    {
        if (si.sfi_direct[xi] == 0)
        {
            //a 원래의 새로운 디렉토리를 위한 뉴엔트리들
            //B는 새로운 디렉토리할당되는 블록
            //C는 아이노드
            int c, d;
            for (tmpi2 = 2; tmpi2 < spb.sp_nblocks; tmpi2++)
            {
                if (checked == 1)
                {
                    break;
                }
                disk_read(tmpBitMap3, tmpi2);
                for (j = 0; j < SFS_BLOCKSIZE; j++)
                { //spb.sp_nblocks 넣어줘야할 수도!
                    if (checked == 1)
                    {
                        break;
                    }
                    tmp2 = tmp & tmpBitMap3[j];
                    for (x = 0; x < 8; x++)
                    {
                        if (j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS == spb.sp_nblocks - 1)
                        {
                            error_message("mkdir", org_path, -4);
                            return;
                        }
                        if (BIT_CHECK(tmp2, x))
                        {
                            continue;
                        }
                        else
                        {
                            if (j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS == a || j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS == b)
                            {
                                continue;
                            }
                            c = j * 8 + x + (tmpi2 - 2) * SFS_BLOCKBITS;
                            if (f == tmpi2)
                            { //같은 페이지였다면 //f=d 랑 같은 경우
                                BIT_SET(tmpBitMap[j], x);
                                if (s == tmpi2)
                                {
                                    disk_write(tmpBitMap, f);
                                }
                                else
                                {
                                    disk_write(tmpBitMap, f);
                                    disk_write(tmpBitMap2, s);
                                }
                            }
                            else if (s == tmpi2)
                            { //f !=s = d랑 같은 경우
                                BIT_SET(tmpBitMap2[j], x);
                                disk_write(tmpBitMap, f);
                                disk_write(tmpBitMap2, s);
                            }
                            else
                            { //     다 다름 f랑 s는 같을 수도 있음
                                BIT_SET(tmpBitMap3[j], x);
                                disk_write(tmpBitMap3, tmpi2);
                                if (f == s)
                                {
                                    disk_write(tmpBitMap, f);
                                }
                                else
                                {
                                    disk_write(tmpBitMap, f);
                                    disk_write(tmpBitMap2, s);
                                }
                            }

                            checked = 1;
                            break;
                        }
                    }
                }
            }
            struct sfs_dir newDir[SFS_DENTRYPERBLOCK];
            int rr;
            for (rr = 0; rr < SFS_DENTRYPERBLOCK; rr++)
            {
                newDir[rr].sfd_ino = 0;
                newDir[rr].sfd_name[0] = 'f';
            }
            newDir[0].sfd_ino = b; //c == inode 번호
            strcpy(newDir[0].sfd_name, org_path);

            disk_write(newDir, a);

            si.sfi_direct[xi] = a;
            si.sfi_size += sizeof(struct sfs_dir);
            disk_write(&si, sd_cwd.sfd_ino);

            struct sfs_inode newinode;
            bzero(&newinode, SFS_BLOCKSIZE);
            newinode.sfi_size += 2 * sizeof(struct sfs_dir);
            newinode.sfi_direct[0] = c;
            newinode.sfi_type = SFS_TYPE_DIR;
            disk_write(&newinode, b);

            struct sfs_dir semiDir[SFS_DENTRYPERBLOCK];
            for (rr = 0; rr < SFS_DENTRYPERBLOCK; rr++)
            {
                semiDir[rr].sfd_ino = 0;
                semiDir[rr].sfd_name[0] = 'f';
            }
            semiDir[1].sfd_ino = sd_cwd.sfd_ino;
            semiDir[0].sfd_ino = b;
            strcpy(semiDir[1].sfd_name, "..");
            semiDir[0].sfd_name[0] = '.';
            disk_write(semiDir, c);

            return;
        }
        disk_read(esd, si.sfi_direct[xi]);
        for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
        {
            if (sd[i].sfd_ino == 0)
            {
                strcpy(sd[i].sfd_name, org_path);
                sd[i].sfd_ino = a; //a가 i node번호
                disk_write(sd, si.sfi_direct[xi]);
                si.sfi_size += sizeof(struct sfs_dir);
                disk_write(&si, sd_cwd.sfd_ino);

                int t;
                struct sfs_inode newbie;
                for (t = 0; t < SFS_NDIRECT; t++)
                {
                    newbie.sfi_direct[t] = 0;
                    newbie.sfi_indirect = 0;
                }
                newbie.sfi_direct[0] = b;
                newbie.sfi_size = 2 * sizeof(struct sfs_dir);
                newbie.sfi_type = SFS_TYPE_DIR;

                disk_write(&newbie, a);
                //struct sfs_inode newnew;
                //disk_read(&newnew, a);
                ///*printf("%d ", newnew.sfi_size);
                //printf("%d ", newnew.sfi_type);
                //printf("%d\n", newnew.sfi_direct[0]);*/

                struct sfs_dir newdir[SFS_DENTRYPERBLOCK];

                newdir[0].sfd_name[0] = '.';
                newdir[0].sfd_ino = a;
                strcpy(newdir[1].sfd_name, "..");
                newdir[1].sfd_ino = sd_cwd.sfd_ino;
                for (j = 2; j < SFS_DENTRYPERBLOCK; j++)
                {
                    newdir[j].sfd_ino = SFS_NOINO;
                    newdir[j].sfd_name[0] = 'f';
                }

                disk_write(newdir, b);

                if (f == s)
                {
                    disk_write(tmpBitMap, f);
                }
                else
                {
                    disk_write(tmpBitMap, f);
                    disk_write(tmpBitMap2, s);
                }

                return;
            }
        }
    }
    error_message("mkdir", org_path, -3);
}
void sfs_rmdir(const char *org_path)
{
    struct sfs_inode si;
    disk_read(&si, sd_cwd.sfd_ino);
    //for consistency
    struct sfs_dir sd[SFS_DENTRYPERBLOCK];
    int tmpn, n, m, g;
    int checked = 0;
    int i, freeBitNum, j, x, tmpi, tmpi2;
    unsigned char tmp, tmp2;
    unsigned char *tmpBitMap = malloc(sizeof(char) * SFS_BLOCKSIZE);
    unsigned char *tmpBitMap2 = malloc(sizeof(char) * SFS_BLOCKSIZE);
    tmp = 0xff;
    struct sfs_inode ti, ti2;
    struct sfs_dir delDir[SFS_DENTRYPERBLOCK];
    struct sfs_dir delDir2[SFS_DENTRYPERBLOCK];
    int xi;
    for (xi = 0; xi < SFS_NDIRECT; xi++)
    {
        if (si.sfi_direct[xi] == 0)
        {
            break;
        }
        disk_read(sd, si.sfi_direct[xi]);
        for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
        {
            if (strcmp(sd[i].sfd_name, org_path) == 0 && sd[i].sfd_ino != 0)
            {
                disk_read(&ti, sd[i].sfd_ino);
                if (ti.sfi_type == SFS_TYPE_FILE)
                { //파일인지 확인
                    error_message("rmdir", org_path, -2);
                    return;
                }
                else if (i == 0 && xi == 0)
                {
                    error_message("rmdir", org_path, -8);
                    return;
                }
                else if (i == 1 && xi == 0)
                {
                    error_message("rmdir", org_path, -7);
                    return;
                }
                else
                { //찾았다!
                    for (j = 0; j < SFS_NDIRECT; j++)
                    {
                        if (ti.sfi_direct[j] != 0)
                        {
                            disk_read(delDir, ti.sfi_direct[j]);
                            for (x = 0; x < SFS_DENTRYPERBLOCK; x++)
                            {
                                if (j == 0 && x == 0)
                                {
                                    continue;
                                }
                                else if (j == 0 && x == 1)
                                {
                                    continue;
                                }
                                if (delDir[x].sfd_ino != 0)
                                {
                                    error_message("rmdir", org_path, -7);
                                    return;
                                }
                            }
                        }
                    } // 비어있는지 확인
                    for (j = 0; j < SFS_NDIRECT; j++)
                    {
                        if (ti.sfi_direct[j] != 0)
                        {
                            tmpn = ti.sfi_direct[j];
                            g = tmpn / SFS_BLOCKBITS;
                            disk_read(tmpBitMap, g + 2);
                            tmpn = tmpn - SFS_BLOCKBITS * n;
                            n = tmpn / 8;
                            m = tmpn % 8;
                            BIT_CLEAR(tmpBitMap[n], m); //direct 블럭으로
                        }
                    }
                    int tmpn1, g1, n1, m1;
                    tmpn1 = sd[i].sfd_ino;
                    g1 = tmpn1 / SFS_BLOCKBITS;
                    disk_read(tmpBitMap2, g1 + 2);
                    tmpn1 = tmpn1 - SFS_BLOCKBITS * n1;
                    n1 = tmpn1 / 8;
                    m1 = tmpn1 % 8;
                    if (g1 == g)
                    {
                        BIT_CLEAR(tmpBitMap[n1], m1);
                        disk_write(tmpBitMap, g + 2);
                    }
                    else
                    {
                        BIT_CLEAR(tmpBitMap2[n1], m1); //direct 블럭으로
                        disk_write(tmpBitMap, g + 2);
                        disk_write(tmpBitMap2, g1 + 2);
                    }

                    sd[i].sfd_ino = SFS_NOINO;
                    disk_write(sd, si.sfi_direct[0]);
                    si.sfi_size -= sizeof(struct sfs_dir);
                    disk_write(&si, sd_cwd.sfd_ino);
                    return;
                }
            }
        }
    }

    error_message("rmdir", org_path, -1);
    /*printf("Not Implemented\n");*/
}

void sfs_mv(const char *src_name, const char *dst_name)
{
    /*printf("Not Implemented\n");*/
    int checked = 0;
    int i, freeBitNum, j, x, tmpi;

    unsigned char tmp, tmp2;
    tmp = 0xff;
    struct sfs_inode si;
    disk_read(&si, sd_cwd.sfd_ino);
    //for consistency
    struct sfs_dir sd[SFS_DENTRYPERBLOCK];
    for (x = 0; x < SFS_NDIRECT; x++)
    {
        if (si.sfi_direct[x] == 0)
        {
            break;
        }
        disk_read(sd, si.sfi_direct[x]);
        for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
        {
            if (sd[i].sfd_ino != 0 && strcmp(sd[i].sfd_name, dst_name) == 0)
            {
                error_message("mv", dst_name, -6); //중복되는 이름 있음
                return;
            }
        }
        for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
        {
            if (sd[i].sfd_ino != 0 && strcmp(sd[i].sfd_name, src_name) == 0)
            {
                if (i == 0 || i == 1 && x == 0)
                {
                    error_message("mv", src_name, -8); //. , ..바꾸는 거 아님
                    return;
                }
                else
                {
                    strcpy(sd[i].sfd_name, dst_name);
                    disk_write(sd, si.sfi_direct[0]);
                    return;
                }
            }
        }
    }

    error_message("mv", src_name, -1);
}

void sfs_rm(const char *path)
{
    /*printf("Not Implemented\n");*/
    //skeleton implementation

    struct sfs_inode si;
    disk_read(&si, sd_cwd.sfd_ino);
    //for consistency
    struct sfs_dir sd[SFS_DENTRYPERBLOCK];

    //allocate new block
    int checked = 0;
    int i, freeBitNum, j, x, tmpi;
    int x1;
    unsigned char tmp, tmp2;
    tmp = 0xff;
    unsigned char *tmpBitMap = malloc(sizeof(char) * SFS_BLOCKSIZE);
    struct sfs_inode tmpNode;

    for (x1 = 0; x1 < SFS_NDIRECT; x1++)
    {
        if (si.sfi_direct[x1] == 0)
        {
            break;
        }

        disk_read(sd, si.sfi_direct[x1]);
        for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
        {
            if (strcmp(sd[i].sfd_name, path) == 0 && sd[i].sfd_ino != 0)
            {
                disk_read(&tmpNode, sd[i].sfd_ino);
                if (tmpNode.sfi_type == SFS_TYPE_DIR)
                {
                    error_message("rm", path, -10);
                    return;
                }
                else
                {

                    int tmpn, n, m, g;
                    for (j = 0; j < SFS_NDIRECT; j++)
                    {
                        if (tmpNode.sfi_direct[j] != 0)
                        {
                            tmpn = tmpNode.sfi_direct[j];
                            g = tmpn / SFS_BLOCKBITS;
                            disk_read(tmpBitMap, g + 2);
                            tmpn = tmpn % SFS_BLOCKBITS;
                            n = tmpn / 8;
                            m = tmpn % 8;
                            BIT_CLEAR(tmpBitMap[n], m); //direct 블럭으로
                            disk_write(tmpBitMap, g + 2);
                        }
                    }

                    if (tmpNode.sfi_indirect != 0)
                    {
                        tmpn = tmpNode.sfi_indirect;
                        g = tmpn / SFS_BLOCKBITS;
                        disk_read(tmpBitMap, g + 2);
                        tmpn = tmpn % SFS_BLOCKBITS;
                        n = tmpn / 8;
                        m = tmpn % 8;
                        BIT_CLEAR(tmpBitMap[n], m); //indirect블럭 0으로
                        disk_write(tmpBitMap, g + 2);
                    }

                    struct sfs_inode newbie;
                    bzero(&newbie, SFS_BLOCKSIZE); // initalize sfi_direct[] and sfi_indirect
                    newbie.sfi_size = 0;
                    disk_write(&newbie, sd[i].sfd_ino);

                    tmpn = sd[i].sfd_ino;
                    sd[i].sfd_ino = 0;
                    disk_write(sd, si.sfi_direct[x1]);
                    si.sfi_size -= sizeof(struct sfs_dir);
                    disk_write(&si, sd_cwd.sfd_ino);
                    g = tmpn / SFS_BLOCKBITS;
                    disk_read(tmpBitMap, g + 2);
                    tmpn = tmpn % SFS_BLOCKBITS;
                    n = tmpn / 8;
                    m = tmpn % 8;

                    BIT_CLEAR(tmpBitMap[n], m); //inode 할당된 블럭 0으로 만들기
                    disk_write(tmpBitMap, g + 2);
                }
                return;
            }
        }
    }
    error_message("rm", path, -1);
}
void sfs_cpin(const char *local_path, const char *path)
{
    /*printf("Not Implemented\n");*/
}

void sfs_cpout(const char *local_path, const char *path)
{
    /*printf("Not Implemented\n");*/
}

void dump_inode(struct sfs_inode inode)
{
    int i;
    struct sfs_dir dir_entry[SFS_DENTRYPERBLOCK];

    printf("size %d type %d direct ", inode.sfi_size, inode.sfi_type);
    for (i = 0; i < SFS_NDIRECT; i++)
    {
        printf(" %d ", inode.sfi_direct[i]);
    }
    printf(" indirect %d", inode.sfi_indirect);
    printf("\n");
    if (inode.sfi_type == SFS_TYPE_DIR)
    {
        for (i = 0; i < SFS_NDIRECT; i++)
        {
            if (inode.sfi_direct[i] == 0)
                break;
            disk_read(dir_entry, inode.sfi_direct[i]);
            dump_directory(dir_entry);
        }
    }
}

void dump_directory(struct sfs_dir dir_entry[])
{
    int i;
    struct sfs_inode inode;
    for (i = 0; i < SFS_DENTRYPERBLOCK; i++)
    {
        printf("%d %s\n", dir_entry[i].sfd_ino, dir_entry[i].sfd_name);
        disk_read(&inode, dir_entry[i].sfd_ino);
        if (inode.sfi_type == SFS_TYPE_FILE)
        {
            printf("\t");
            dump_inode(inode);
        }
    }
}

void sfs_dump()
{
    // dump the current directory structure
    struct sfs_inode c_inode;
    disk_read(&c_inode, sd_cwd.sfd_ino);
    printf("cwd inode %d name %s\n", sd_cwd.sfd_ino, sd_cwd.sfd_name);
    dump_inode(c_inode);
    printf("\n");
}