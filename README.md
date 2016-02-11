# Hystrix
<br />Spring Boot + Hystrix
<br />
<br /> By calling adress:
<br /> http://localhost:8080/
<br /> it will download http://www.google.com page and display
<br />
<br /> By calling adress:
<br /> http://localhost:8080/networkProblems
<br /> it will emulate some problems
<br />
<br /> You can connect with JConsole and find mBean "Config-com.netflix.config.jmx"
<br /> You can get all properties by calling "obtainProperties"
<br /> You can update property by calling "updateProperty", for example:
<br /> hystrix.command.hystrix.command.http.circuitBreaker.forceClosed  ,  true
<br />
<br /> hystrix.command.hystrix.command.http.circuitBreaker.forceOpen  ,  true
<br />
<br /> To "switch off" Hystrix, call:
<br /> hystrix.command.default.circuitBreaker.enabled, false
<br />
<br /> Useful links:
<br /> https://raw.githubusercontent.com/wiki/Netflix/Hystrix/images/hystrix-command-flow-chart.png
<br /> https://raw.githubusercontent.com/wiki/Netflix/Hystrix/images/circuit-breaker-1280.png
<br /> https://github.com/Netflix/Hystrix
<br /> https://github.com/Netflix/Hystrix/wiki/Getting-Started
<br /> https://github.com/Netflix/Hystrix/wiki/How-To-Use
<br /> https://github.com/Netflix/Hystrix/wiki/Operations
<br /> https://github.com/Netflix/Hystrix/wiki/Configuration
<br /> https://github.com/Netflix/Hystrix/tree/master/hystrix-dashboard
<br /> https://netflix.github.io/Hystrix/javadoc/index.html?com/netflix/hystrix/HystrixCommand.html
<br /> https://netflix.github.io/Hystrix/javadoc/index.html?com/netflix/hystrix/HystrixCircuitBreaker.html
<br /> https://github.com/Netflix/Hystrix/blob/master/hystrix-examples/src/main/java/com/netflix/hystrix/examples/basic/CommandWithStubbedFallback.java
<br /> https://webcache.googleusercontent.com/search?q=cache:http://techblog.netflix.com/2012/11/hystrix.html
<br /> https://github.com/Netflix/Hystrix/wiki/Dashboard
<br /> https://github.com/Netflix/Turbine
<br /> https://github.com/Netflix/Turbine/wiki
<br /> https://github.com/Netflix/Turbine/wiki/How-To-Use
<br /> https://github.com/Netflix/Hystrix/tree/master/hystrix-contrib/hystrix-metrics-event-stream
<br /> https://github.com/Netflix/Hystrix/tree/master/hystrix-contrib
<br /> https://github.com/Netflix/Hystrix/tree/master/hystrix-examples-webapp
<br /> https://github.com/Netflix/Hystrix/blob/master/hystrix-contrib/hystrix-metrics-event-stream/README.md
<br /> https://github.com/Netflix/Hystrix/wiki/How-it-Works#flow4
