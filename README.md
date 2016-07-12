Simple REST API in Play using Java Objects
------------------------------------------

#Dependencies

* Java 8
* Scala version 2.11.8
* SBT Version 0.13.11
* Play version 2.5.4

#Usage 


```shell
export PATH=/share/sib/apps/linux/64/jdk1.8.0_74/bin:$PATH
activator run
```

#Package for production
```shell
activator stage
nohup target/universal/stage/bin/web-statements &
```


Note the it requires Java 8, it may be necessary to do
```shell
export PATH=/share/sib/apps/linux/64/jdk1.8.0_74/bin:$PATH
export JAVA_HOME=/share/sib/apps/linux/64/jdk1.8.0_74/
export JAVA_PATH=/share/sib/apps/linux/64/jdk1.8.0_74/bin
```

#Eclipse IDE
```
activator eclipse 
```
Scala Eclipse IDE 4.4.1 (if eclipse plugin does not set Java 8, set it up manually)

 http://scala-ide.org/


