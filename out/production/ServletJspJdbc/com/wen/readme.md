# Readme 
##分层 
Control 控制层  
Entity 实体类  
Repository 数据库交互层  
Util 抽取出来的公共代码  
Filter 过滤器  
## 数据库连接池
JDBC开发流程  
+ 加载驱动  
+ 建立数据库连接  
+ 执行sql语句
+ ResultSet接收结果集
+ 断开连接，释放资源  

数据库连接对象通过DriverManger来获取，每次都向数据库获取链接，验证账号密码，执行完语句后断开连接，这样浪费资源，数据库连接资源没有好的利用。  
使用数据库连接池为数据库建立一个缓冲池，预先向里面放置一定的连接对象，当需要获取数据库连接时，从中取出一个，用完还回来，供下一次使用。  
当数据库连接池没有空闲连接，新的请求进入等待队列。  
### JDBC实现数据库连接池
1. 使用javax.sql.DataSource接口来实现
2. 第三方工具实现  
+ C3P0  

使用  
导入jar包  
```java
public class DataSource {
    public static void main(String[] args) {
        //创建c3p0
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
         String url = "jdbc:mysql://127.0.0.1:3306/servlettest?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
         String username = "root";
         String password = "123456";
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl(url);
             dataSource.setUser(username);
            dataSource.setPassword(password);
            //初始化连接个数
            dataSource.setInitialPoolSize(20);
            //设置最大连接数
            dataSource.setMaxPoolSize(40);
            //不够继续申请个数
            dataSource.setAcquireIncrement(5);
            //最小连接数
            dataSource.setMinPoolSize(2);           
            dataSource.getConnection();
            dataSource.close();//还到缓冲池                                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
XML格式配置  
