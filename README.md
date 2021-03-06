Towards Low-Latency Data Stream Processing
=

The contributions of this project
-
1) We conduct a deep investigation about the latency of each stage of DSP topology, and find the proportion of inter-operator latency in total event processing latency is up to 86.88\%.
	
2) We design the OSRingBuffer in IPC to reduce the times of memory copy and the waiting time of each single message when transmitting messages between the workers inside one node. Thus, the end-to-end latency of IPC decreases by 45.94\%(at least). To the best of our knowledge, we are the first to use the off-heap ring bytebuffer to accelerate the message transmission between JVM.
	
3) We further propose a general Group-based modeling framework, which uses the data dependencies in topology or the runtime traffic information to integrate the communicating operator instances before scheduling and BFS-based algorithm to assign the integrated operator instances. With this framework, scheduler can achieve both the load balance and the reduction in inter-node traffic.
	
4) With OSRingBuffer in IPC and the Group-based modeling framework, we integrate them into JStorm, termed TurboStream. In our experiments, the total event processing latency can decrease by 77.84\%.


Evaluation
-
The experiments following is on the Yahoo workload(https://github.com/stormprocessor/storm-benchmark).   

![lowload](https://github.com/liumihust/gitTset/blob/master/evaluation-latency-2.PNG)  

Note:
-
Current version of TurboStream is updated about 8 months before, and the newest version of TurboStream will be updated as soon as possible.

## The paper of this work has been accepted by 2018 IEEE 38th International Conference on Distributed Computing Systems (ICDCS) 
https://ieeexplore.ieee.org/document/8416362

ICDCS: CCF B & Top 80 Conference of Computer Science
