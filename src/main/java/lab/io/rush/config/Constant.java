package lab.io.rush.config;

public class Constant {
	// 剩余票数键,存储到redis,可在src/test/java/init.InitRedis中用程序初始化。
	public static final String[] TICKET_ARRAY = { "The Godfather",
			"12 Angry Men", "Star Wars" };

	// redis IP
	public static final String PATH = "127.0.0.1";
	// redis 端口
	public static final int PORT = 6379;
	// 邮箱昵称
	public static final String NICKNAME = "中信卡中心";
	// 邮箱主题
	public static final String SUBJECT = "抢票成功";
	// 邮箱内容
	public static final String CONTENT = "尊敬的用户，您好，恭喜你抢票成功,票名为:";
}
