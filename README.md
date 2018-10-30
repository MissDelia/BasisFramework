这是一个没有实际功能的框架，遵从MVVM架构，使用Android Architecture Components组件开发<br>
此版本仅支持CMake，需要Android.mk的同学请等待后续更新

# 简要说明

注意：使用前先将Manifest和module.gradle中的包名修改为实际包名

1、在com.iwhalecloud.mobile.basisframework包下新建模块名对应的包；

2、View、ViewModel和Activity必须继承基类，Activity必须实现getViewModelClass方法；

3、工具类、db和其它App共用方法都在app包下，请自行打开类查看说明。