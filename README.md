# SmallTravelSystem
Implement a small travel system with CORBA, EJB and WebService Separately





《分布式旅行系统》


目  录
1	题目描述	3
1.1	系统功能	3
1.2	系统对象	3
2	CORBA实验	5
2.1	应用系统设计	5
2.1.1	用户代理	5
2.1.2	酒店服务器	6
2.1.3	车票服务器	6
2.2	应用系统实现	7
2.2.1	物理拓扑	7
2.2.2	酒店服务器	8
2.2.3	车票服务器	11
2.2.4	用户代理	13
2.3	实验环境及结果	15
2.3.1	实验环境	15
2.3.2	实验结果	15
3	J2EE&WEB SERVICE实验	20
3.1	应用系统设计	20
3.2	应用系统实现	20
3.2.1	价格服务(PriceService)	20
3.2.2	余量服务(RemainsService)	22
3.2.3	订单服务(OrderService)	23
3.2.4	业务流程	25
3.2.5	客户端程序	27
3.3	实验环境及结果	29
3.3.1	实验环境	29
3.3.2	实验结果	29
4	总结	32
 
1	题目描述
1.1	系统功能
本实验实现一个小型的分布式旅行系统，其功能包括酒店信息处理，车票信息处理和订单处理。酒店信息处理模块包括查看酒店信息，预订酒店；车票信息处理模块包括查看酒店信息，预订车票；订单处理模块包括查看酒店订单和查看车票订单。系统用例图如图1 1所示。
 
图1 1 旅行系统用例图
1.2	系统对象
本旅行系统包括三个分布式对象——用户代理、酒店服务器和车票服务器。三个对象分别分布在独立的空间上，它们通过多种中间件技术进行信息交互。
用户代理(作为Client)为用户提供操作界面，包括输入酒店信息查询条件、选择酒店、预订酒店，输入车票查询条件、选择车票、预订车票，进行查询酒店订单、查询车票订单。
酒店服务器(作为Server)操作酒店信息数据库，接受用户代理的请求，对酒店信息数据库的酒店表和订单表进行查询、增加、修改操作。
车票服务器(作为Server)操作车票信息数据库，接受用户代理的请求，对车票信息数据库的车票表和订单表进行查询、增加和修改操作。
系统结构如图1 2所示。
 
图1 2 系统结构图

 
2	CORBA实验
2.1	应用系统设计
CORBA实验的系统结构与1.2节的系统结构(如图1 2所示)相同，Client和Server所实现的功能也与1.2节描述的功能相同。只是Client与Server之间的通信选择CORBA技术。
2.1.1	用户代理
用户代理向用户提供界面。用户可以通过用户代理实现查询酒店、预订酒店，查询车票、预订车票，查询酒店订单、查询车票订单等功能。用户功能流程图如图2 1所示。
 
图2 1 用户功能流程图
2.1.2	酒店服务器
酒店服务器接受用户代理的请求，对酒店信息数据库的酒店表和订单表进行操作，包括查询酒店信息表，增加订单，修改酒店房间余量等。其功能流程如图2 2所示。
 
图2 2 酒店服务器功能流程图
2.1.3	车票服务器
车票服务器(作为Server)操作车票信息数据库，接受用户代理的请求，对车票信息数据库的车票表和订单表进行操作，包括查询车票信息表，增加订单，修改车票余量等。器功能流程如图2 3所示。
 
图2 3 车票服务器功能流程图
2.2	应用系统实现
2.2.1	物理拓扑
由于实验环境有限，实验的服务器端和客户代理端均在一台机器上。ORB的调用端口为1050，主机名为localhost，这两个参数写在程序中，无法更改。如图2 4和图2 5所示。
 
图2 4 用户代理端连接酒店服务器参数
 
图2 5 用户代理端连接车票服务器参数
2.2.2	酒店服务器
2.2.2.1	IDL文件——HotelInfo.idl
IDL文件定义了远程对象的接口。HotelInfo.idl文件内容如下：
 
	HotelInfo.idl文件通过JDK自带的idlj编译工具进行编译，命令如下：
 
	生成HotelInfoApp包，目录结构如图2 6所示。
 
图2 6 HotelInfoApp包结构
2.2.2.2	酒店服务器ORB服务监听代码
 
 
2.2.2.3	远程接口实现类——HotelInfoImpl.java
 
(1) 连接数据库
 

(2) 远程方法实现
实现了三个方法：
 
2.2.3	车票服务器
2.2.3.1	IDL文件——TicketInfo.idl
 
HotelInfo.idl文件通过JDK自带的idlj编译工具进行编译，命令如下：
 
	生成TicketInfoApp包，目录结构如所示。
 
图2 7 TicketInfoApp包结构
2.2.3.2	车票服务器ORB服务监听代码
与2.2.2.2节类似，此处略。
2.2.3.3	远程接口实现类—TicketInfoImpl.java
 
(1) 连接数据库
 
(2) 远程方法实现
实现了三个方法：
 
2.2.4	用户代理
2.2.4.1	目录结构
 
图2 8 用户代理端目录结构
用户代理端的目录结构如所示，调入HotelInfo.idl生成的HotelInfoApp包和TicketInfoApp包。
2.2.4.2	连接服务器代码
 
2.3	实验环境及结果
2.3.1	实验环境
硬件环境：台式机一台
CPU：Intel Core2 Quad CPU Q9400 @ 2.66GHz
内存: 4G
	操作系统：Windows7 64位
	数据库：mysql 5.1
	开发环境：JDK 1.8 + Eclipse
CORBA编译器：JDK自带idl编译器
2.3.2	实验结果
1. 启动ORB命名服务
 
2. 启动酒店服务器
 
3. 启动车票服务器
 
4. 用户代理程序主界面
 
5. 查询酒店
 
6. 预订酒店
 
 
7. 查询车票
 
8. 预订车票
 
9. 查看车票订单
 
 
3	J2EE&Web Service实验
3.1	应用系统设计
	本节实验选取运行系统的一个子集，实现酒店房间预订的业务流程。EJB实现查询价格、修改余量和产生订单，并发布为Web服务；然后Web服务调用端用BEPL集成服务，实现服务流程，并将业务流程发不成Web服务；最后客户端调用业务流程Web服务，则可以预定酒店。系统结构如图3 1所示。
 
图3 1 系统结构图
3.2	应用系统实现
3.2.1	价格服务(PriceService)
价格服务用于查询房间的价格，房间一共三种类型：单人房、双人房和套房，在程序中以常量表示。
	创建价格Session Bean，生成接口和实现类，目录结构如图3 2所示。
 
图3 2 PriceService Bean目录
	PriceServiceRemote为接口，定义了getPrice接口函数。内容如下：
 
	PriceService是接口的实现，定义了三种房间的价格
 
实现了getPrice函数。
 
	并通过注释的方式将PriceService这个Session Bean发布成Web 服务。
 
	PriceService服务的发布结果如图3 3所示：
 
图3 3 PriceService发布结果
3.2.2	余量服务(RemainsService) 
余量服务用于查询修改房间余量，预订的房间对应房间类型的数量减去预订的数量。
	余量服务Session Bean，生成接口和实现类，目录结构如图3 4所示。
 
图3 4 RemainsService Bean目录
	RemainsServiceRemote为接口，定义了setRemains接口函数。内容如下：
 
	RemainsService是接口的实现，定义了三种房间的余量
 
实现了setRemains函数。
 
	并通过注释的方式将这个Session Bean发布成Web 服务。
 
	RemainsService服务的发布结果如图3 5所示：
 
图3 5 RemainsService发布结果
3.2.3	订单服务(OrderService) 
订单服务用于生成，订单号由服务器当前时间戳组成。
	订单服务Session Bean，生成接口和实现类，目录结构如图3 6所示。
 
图3 6 OrderService Bean目录
	OrderServiceRemote为接口，定义了createOrder接口函数。内容如下：
 
	OrderService是接口的实现，实现了createOrder函数。
 
	并通过注释的方式将这个Session Bean发布成Web 服务。
 
	OrderService服务的发布结果如图3 7所示：
 
图3 7 OrderService发布结果
3.2.4	业务流程 
业务流程实现调用了PriceService、RemainsService和OrderService三个服务，进行集成，实现了预定房间业务流程。
实现过程首先导入三个服务的WSDL文件，然后建立BPEL Process文件HotelorderProcess.bpel，工具自动生成HotelorderProcess	Artifacts.wsdl，最后建立BPEL Deployment Descriptor文件deploy.xml将业务流程发布到Apache ODE服务器。
HotelorderProcess.bpel流程图如图3 8所示。
 
图3 8 HotelorderProcess.bpel流程图
HotelorderProcessArtifacts.wsdl的内容如图3 9所示
 
图3 9 HotelorderProcessArtifacts.wsdl内容
deploy.xml文件内容如图3 10所示。
 
图3 10 deploy.xml内容
将业务流程发布到Apache ODE服务器结果如图3 11所示。


 
图3 11 业务流程发布成服务图

3.2.5	客户端程序 
客户端程序调用业务流程服务，进行房间预订。
利用JDK自带wsimport工具将业务流程服务HotelorderProcess	Artifacts.wsdl生成客户端接口文件。
命令：wsimport –p com.hotel.orderprocess –keep HotelorderProcess	Artifacts.wsdl。导入客户端工程，目录结果如图3 12所示。
 
图3 12 客户端目录结构图
客户端程序内容如下。
 

3.3	实验环境及结果
3.3.1	实验环境
台式机一台
CPU：Intel Core2 Quad CPU Q9400 @ 2.66GHz 
内存: 4G
操作系统：Windows7 -64bit
IP：192.168.10.61
服务器：jboss-eap-6.4
开发环境：JDK 1.8 + Eclipse
笔记本一台
CPU：IntelCore i3 CPU M370@2.40GHz 
内存：6G
操作系统：Windows7 -64bit
IP：192.168.10.63
服务器：apache-tomcat-8.0.23+apache-ode-war-1.3.6
开发环境：JDK 1.7 + Eclipse+BPEL Designer
3.3.2	实验结果
JBoss服务器启动结果：
 

JBoss服务管理界面WebService Endpoints结果：
 
ODE服务器启动及业务流程服务部署结果：
 
客户端运行结果：
 
 
 

