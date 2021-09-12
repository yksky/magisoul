# magisoul
基于springboot2.4构建的开发平台

模块划分:
```
magisoul-admin:管理平台的入口,主要用作controller接收数据,filter以及interceptor等等
magisoul-api-gateway:网关入口
magisoul-cache:缓存处理,提供统一的标准化接口
magisoul-data:数据处理层,包括一些常规算法集成,mq消息,es等等
magisoul-framework:系统核心层(实现功能待定)
magisoul-generate:代码生成工具,表单生成,可生成文件,也可线上实际运行等等;数据模拟等等
magisoul-schedule:定时任务调度
magisoul-syncx:数据同步任务,批处理,提供统一接口进行处理
magisoul-system:系统类(包括用户管理,资源管理,部门管理,角色管理,字典管理等等)
magisoul-util:系统工具类
```

