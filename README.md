# mark-book

## SDK 配置
![sdk.png](images/img-sdk.png)

## JDK配置
注意要选这IDEA中的jre
![jre.png](images/img-jre.png)
```
<!-- 导入的devkit模式的idea插件项目 model必须为 PLUGIN_MODULE -->
<?xml version="1.0" encoding="UTF-8"?>
<module type="PLUGIN_MODULE" version="4">
  <component name="DevKit.ModuleBuildProperties" url="file://$MODULE_DIR$/resources/META-INF/plugin.xml" />
  <component name="NewModuleRootManager" inherit-compiler-output="true">
    <exclude-output />
    <content url="file://$MODULE_DIR$">
      <sourceFolder url="file://$MODULE_DIR$/resources" type="java-resource" />
      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
    </content>
    <orderEntry type="inheritedJdk" />
    <orderEntry type="sourceFolder" forTests="false" />
  </component>
</module>
```