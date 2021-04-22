# POJO 解释
* POJO（Plain Ordinary Java Object）：是对DTO、PO、VO、BO的统称，不会会将一个对象命名以POJO结尾，包名可以用pojo
* DTO（Data Transfer Object）：不同服务之间数据传输对象
* PO（Persistent Object）：持久层对象，通常用做Dao层的参数或返回值
* VO（Value Object）：只包含get、set方法的值对象，一般DTO会引用它
* BO（Business Object）：由Service层输出的封装业务逻辑的对象，可引用VO对象

# 参数规范
* Param：数据查询对象，各层接收上层的查询请求
* Query：数据查询对象，用户Dao层sql查询

# 用法总结
## Dao层
* 查询参数：SQL查询语句的参数超过2个及以上可选用Query结尾的命名查询参数类
* 返回值：SQL查询语句的返回值2个及以上用PO结尾的结果类返回
## Service层
* 查询参数：参数超过2个及以上用Param结尾的参数类
* 返回值：返回值超过2个及以上用BO结尾命名的类，内部可用VO结尾命名的类组合信息
## Controller层
* 参数：参数超过2个及一行用Param结尾命名的参数类
* 返回值：用Result包装DTO命名类的结果，DTO可包含BO结尾命名或VO结尾命名的对象

# 以下情况除外
* 一个SQL语句或方法的返回值，用集合框架或基本类型或基本封装类型或字符串类型作为返回结果的除外
