![Sentr](https://camo.githubusercontent.com/2dfeafbee0904d6df16ddf7200993dace1629e60/68747470733a2f2f73656e7472792d6272616e642e73746f726167652e676f6f676c65617069732e636f6d2f73656e7472792d6c6f676f2d626c61636b2e706e67)
Stop hoping your users will report errors

## What's Sentry?
> [Sentry](https://sentry.io/) fundamentally is a service that helps you monitor and fix crashes in realtime. The server is in Python, but it contains a full API for sending events from any language, in any application.

### Supported Languages
![](image/Platforms%20-%20sentry.io.jpg)

### How it looked like

#### Error list
![](https://sentry.io/_assets/screenshots/cross-project-issues/workflow-f11903a7ccf33b8aee506a60fe5a3be3f77e4c34505042e7a574494dd40b1789.gif)

#### Error detail
![](https://sentry.io/_assets/tutorials/02/screenshot-f67e1e995ea479b8e17d3b063b3eadb16448b2ceaf565d7b8bf3736188a0390d.png)

#### Alert
![](https://images.ctfassets.net/em6l9zw4tzag/5ZCgIVP2mfm200TzSo1M62/4ba171c91b2fe9f87dbccb6524697bea/slack-resolve.gif)

### How to implement
#### Create sentry project
- On sentry dashboard, create a project, choose language and enter your project name.
- On project setting page, chose `Client Keys (DSN)`, you will see an url like `http://969d3426596f4134a40b0c1a792071d7@sentry.io/2`

#### Configure your project
> This example below is written in java with spring boot

- Import sentry in `pom.xml` file
```xml
<dependency>
    <groupId>io.sentry</groupId>
    <artifactId>sentry-spring</artifactId>
    <version>1.7.27</version>
</dependency>
```

- Create file `sentry.properties` in resource folder, you can configure many things, for example:
```properties
release=1.0.0
environment=staging
tags=service:gateway
stacktrace.app.packages=com.github.halab4dev


async.queuesize=100
timeout=1000
``` 
- Create `SentryConfiguration` class with:
    - Initialize sentry
```java
    @PostConstruct
    public void init() {
        Sentry.init("http://969d3426596f4134a40b0c1a792071d7@sentry.io/2?environment=staging");
    }
```
- Recording Exceptions
In order to record all exceptions thrown by your controllers, you can register `io.sentry.spring.SentryExceptionResolver` as a Bean in your application. Once registered, all exceptions will be sent to Sentry and then passed on to the default exception handlers.
```java
@Bean
public HandlerExceptionResolver sentryExceptionResolver() {
    return new io.sentry.spring.SentryExceptionResolver();
}
```
- In order to add HTTP request data (such as HTTP request headers) to your Sentry events in Spring Boot, you need to register the `io.sentry.spring.SentryServletContextInitializer` class as a Bean in your application.
```java
@Bean
public ServletContextInitializer sentryServletContextInitializer() {
    return new io.sentry.spring.SentryServletContextInitializer();
}
```
- Add `Sentry.capture(ex);` anywhere that you catch an exception:
```java
    try {
        ...
    } catch (Exception ex) {
        Sentry.capture(ex);
    }
```
- You can add custom data to get more information
```java
        Sentry.getContext().setUser(new UserBuilder().setId("user_id").build());
        Sentry.getContext().addTag("api", "api_name");
        Sentry.getContext().addExtra("request data", "json_data");
```

