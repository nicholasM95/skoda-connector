# Škoda Connector
This project provides a simple and efficient way to obtain access tokens and ID tokens specifically for Škoda applications within the Volkswagen Group ecosystem.
Whether you're building tools, apps, or integrations for Škoda services, this connector streamlines the authentication and authorization process.

Disclaimer: This connector is `unofficial` and not affiliated with or endorsed by Škoda Auto or the Volkswagen Group.
It is independently developed to support developers in integrating with Škoda's online services.

## Adding Maven Repository and Dependency

To utilize the library in your Maven project, follow these steps.

Add the Maven Dependency to your `pom.xml`

```
<dependency>
    <groupId>be.nicholasmeyers.skoda-connector</groupId>
    <artifactId>skoda-connector</artifactId>
    <version>2.0.0</version>
</dependency>
```

## Get Tokens

This code snippet demonstrates how to use the ConnectorService to obtain authentication tokens using an email and
password.
Replace `email` and `password` with your actual credentials.
The `Client.CONNECT` parameter specifies the application.
Make sure to handle the obtained tokens securely for further usage within your application.

```
ConnectorService connectorService = new ConnectorService();
Tokens tokens = connectorService.getTokens(Client.CONNECT, "email", "password");
```

## Available applications

The following applications are available, choose the correct client for your implementation.

```
Client.CONNECT
Client.VWG
```
