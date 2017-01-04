  抢票系统说明
1项目主要思路:在Redis中存储剩余票数。每次抢票时，Redis的电影票键对应的值减一，如果抢票成功，将抢票信息存储到MariaDb,并发送邮件通知。
2此项目以Strut2作为MVC框架，DataNucleus提供的Jdo作为ORM框架，Spring作依赖注入,MariaDb作为底层数据库,Redis作为内存数据库。
3电影剩余票的实时显示由JavaScript + Ajax实现。
4由于腾讯审核不通过，没有实现QQ登陆功能，用任意邮箱都可登陆此系统。
5此项目在JDK1.8环境下编译运行。
部署时请修改如下配置。
1.修改/moana/src/main/resources/META-INF/persistence.xml文件的数据库连接信息，并建立相应的数据库。
2.修改/moana/src/main/java/lab/io/rush/config/Constant.java中redis的PATH和PORT(如在本地部署，且端口为6379,可不用修改)。
3.修改/moana/src/main/webapp/ticketOne.jsp中第48行ajax的url地址.(如在本地部署，可不用修改)。
4.运行/moana/src/test/java/init/InitRedis.java中的main程序，初始化redis数据库，在redis中存储剩余票数情况.(也可手动在redis中部署)。
