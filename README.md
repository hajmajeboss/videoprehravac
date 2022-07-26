# Videoplayer Android/Kotlin example
Frameworks used: Room, Retrofit, Hilt, Glide, Exoplayer, Moshi JSON

Architecture:
- Presentation layer: Views (layout XMLs, activities, fragments), ViewModels (LiveData)
- Domain layer: Use Cases, Repositories (interfaces only), POJO/DTO, Enums
- Data layer: Room database (DAO, entities), repositories (implementation), Retrofit network services 

Features:
- Downloads a list of videos from the internet or from a local SQLite (Room) database
- Filtering and sorting of the list of videos (quality, DRM protection, subtitles, live videos)
- Video playback (Exoplayer)
