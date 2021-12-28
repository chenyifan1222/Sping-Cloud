docker system df  类似于Linux上的**df**命令，用于查看Docker的磁盘使用情况：

```
docker system df
TYPE                TOTAL               ACTIVE              SIZE                RECLAIMABLE
Images              147                 36                  7.204GB             3.887GB (53%)
Containers          37                  10                  104.8MB             102.6MB (97%)
Local Volumes       3                   3                   1.421GB             0B (0%)
Build Cache                                                 0B                  0B
```


**删除所有关闭的容器**：

```
docker ps -a | grep Exit | cut -d ' ' -f 1 | xargs docker rm
```


**删除所有dangling镜像（即无tag的镜像）**：

```
docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
```


**删除所有dangling数据卷（即无用的Volume）**：

```
docker volume rm $(docker volume ls -qf dangling=true)
```