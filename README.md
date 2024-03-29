# Weather Information App

This is a simple JavaFX application built to fetch and display weather information for a specific location.

## How to Use

1. Run the `WeatherApp` class to start the application.

2. You will see a text field. Enter your desired location here.

3. The application will then fetch the weather data for the entered location and display the temperature information.

## Tech Stack

1. Java 16
2. JavaFX
3. OpenWeatherMap API

## Dependencies

JavaFX and a JSON processing library are required to run this application.

The easiest way to manage these dependencies is through a build management tool such as Maven or Gradle.

## Note

To fetch weather information, you need to have a valid OpenWeatherMap API key. Replace the placeholder key in the `fetchWeather` method with your own valid API key. Without a valid API key, weather data cannot be fetched.

## Future Improvements

Future improvements may include adding more weather details like wind speed, humidity, etc. and better error handling for edge cases.
