// This method fetches weather data from an API.
public void fetchWeather(String location) {
    // The API key and request URL for the OpenWeatherMap API.
    String apiKey = "092e3f97d2dcd2c7706cca1e1ea4536b";
    String requestUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey + "&units=metric";

    // A new HttpClient object is created to send the API request.
    HttpClient client = HttpClient.newHttpClient();

    // Prepare a GET request using the HttpRequest.newBuilder() method
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(requestUrl)) // Convert the request URL string to a URI and set it into the request
            .build(); // Build the HttpRequest object.

    // sendAsync() method of HttpClient is used to send the request asynchronously.
    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            // .thenApply() is called after the CompletableFuture returned by sendAsync() completes. It transforms the HttpResponse object to String.
            .thenApply(HttpResponse::body)
            // .thenAccept() is called after the previous stage is over. It takes the response body (now a String) and parse it as JSON.
            .thenAccept(response -> {
                // Create a JSONObject from the response String.
                JSONObject jsonResponse = new JSONObject(response);
                // Extract temperature information from the "main" object in the response JSON.
                double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
                // Update the GUI with temperature data. As the response comes from a non-JavaFX thread, JavaFX's Platform.runLater() is used to update the GUI safely.
                javafx.application.Platform.runLater(() -> weatherInfo.setText("Temperature: " + temperature + "°C"));
            })
            // .exceptionally() is called when an exception is thrown at any point during the async request. It prints the stack trace of the error.
            .exceptionally(ex -> {
                ex.printStackTrace();
                return null;
            });
}