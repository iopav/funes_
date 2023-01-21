# **maps**

---

## **第五人格地图聋瞎辅助app**

### **记录**
2023年1月21日
app版本竟然做出来！感谢https://github.com/feiyuu/FloatingView 提供的框架

bug是真的多，修得我肝疼

2023年1月15日

为了输入出生点能返回相应地图，所以需要所有出生点的名称，

先选择checkbox确定地图

再选择1~多个出生点

点击按钮返回地图，弹窗模式

接下来要做signal slot连接 准备用mapper或者partial sender实现

把所有checkbox绑定到同一个槽上？用sender查看是哪一个被选中了？

太麻烦了直接便利得了

查找被选中的checkbox

根据radio button 缩小查找范围

其余地图还没实现，因为我用不着

目录下有一个保存地图的文件夹还没传一传就大小上限我真服了



### **功能**

包括：

- 出生点
- 地窖
- 约瑟夫路线



**目前功能：**

- 输入出生点筛选地图

- 点击地窖返回地窖刷新点地图
- 点击约瑟夫特供返回最佳路线规划



**未来计划：**

- [ ] app版本将与gta6同时发布
- [ ] 根据过长动判断出生点
- [ ] 浮窗版等我学了再说
- [ ] 约瑟夫路线录像版
- [ ] 数据存储优化
- [ ] 相对目录
- [ ] 屠夫的checkbox改成radio button 只能选一个多选报错 开通多选功能
- [ ] 解决中文路径的潜在风险
- [ ] QMimeDatabase: Error loading internal MIME data
- [ ] An error has been encountered at line 1 of <internal MIME data>: Premature end of document.
- [ ] 打包exe，成功通过试用期的话,多窗口控制 线程结束 
- [ ] 子窗口与主窗口的关闭问题，关闭主窗口，子窗口还开着



### 版本特性：

1. 随便一写随便一用
2. 糟糕的设计结构
3. 丑陋的界面
4. 上个世纪风格的按钮
5. 垃圾的交互
6. 很不安全


