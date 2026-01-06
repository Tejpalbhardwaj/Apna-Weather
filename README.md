# 🌦️ Apna Weather

Apna Weather is a clean and simple Android application that provides real-time weather information in an easy-to-understand way. The app is designed with a minimal UI and focuses on delivering accurate weather updates such as temperature, weather conditions, and basic forecasts, making it perfect for everyday use.

---

## 📱 Features

* 🌡️ Real-time temperature updates
* ☁️ Current weather conditions (Clear, Cloudy, Rainy, etc.)
* 📍 Location-based weather detection
* 🔄 Refresh weather data instantly
* 🎨 Clean and minimal UI
* ⚡ Fast and lightweight performance

---

## 🛠️ Tech Stack

* **Language:** Kotlin
* **UI:** Jetpack Compose
* **Architecture:** MVVM (Model-View-ViewModel)
* **API:** OpenWeather API (or any weather API used)
* **Networking:** Retrofit
* **Async:** Kotlin Coroutines

---

## 📸 App Screenshots

<p align="center">
  <img src="screenshots/home.png" width="250" />
  <img src="screenshots/search.png" width="250" />
  <img src="screenshots/details.png" width="250" />
</p>

---

## 🚀 Getting Started

### Prerequisites

* Android Studio (latest version recommended)
* Android device or emulator
* Internet connection

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/apna-weather.git
   ```
2. Open the project in **Android Studio**
3. Sync Gradle files
4. Run the app on an emulator or physical device

---

## 🔑 API Configuration

1. Get your API key from a weather service provider (e.g., OpenWeather)
2. Add the API key in your `local.properties` or constants file

   ```
   WEATHER_API_KEY=your_api_key_here
   ```
3. Rebuild the project

---

## 📂 Project Structure

```
ApnaWeather/
├── data        # API & repository layer
├── ui          # Compose UI screens
├── viewmodel   # ViewModels
├── utils       # Helper classes
└── screenshots # App screenshots
```

---

## 🎯 Future Improvements

* 🌙 Dark mode support
* 📆 7-day weather forecast
* 🌍 Search weather by city name
* ⏰ Weather alerts & notifications

---

## 🤝 Contributing

Contributions are welcome! If you find any bugs or want to improve the app:

1. Fork the repo
2. Create a new branch
3. Commit your changes
4. Open a Pull Request

---

## 📄 License

This project is open-source and available under the **MIT License**.

---

## 👨‍💻 Developer

**Tejpal Bhardwaj**
Android Developer | Kotlin | Jetpack Compose

> *"Simple UI. Accurate Weather. Apna Style."* ☁️🌤️
