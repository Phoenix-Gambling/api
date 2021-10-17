# API module for Phoenix Casino

This library is used to create custom plugins for Phoenix Casino.

## Repository

Define this repository in `settings.gradle` file and map it to module identifier:

```
sourceControl {
  gitRepository("https://github.com/Phoenix-Gambling/api.git") {
    producesModule("com.phoenix:api")
  }
}
```

Point dependency in your `build.gradle` to a specific tag (e.g.: '1.0.0')

```
dependencies {
  implementation 'com.phoenix:api:1.0.0'
}
```

## Documentation

You can find our API documentation [here](https://playin.team/docs#/).
