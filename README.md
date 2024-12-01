# Muse Snap 🎵📷

Muse Snap is an innovative web application designed to make music discovery seamless and fun. Upload an image of a musician, let our backend AI recognize the artist, and generate playlists based on trending songs. Whether you’re curating moods or just exploring new music, Muse Snap is your gateway to discovering the tunes that inspire the world.

---

## Features

### 1. **Image Uploading**
   - Users can upload images or screenshots of musicians via the web interface.
   - Backend API (`/api/imagga/recognize`) processes these images to analyze and identify the musician.
   - AI functionality is integrated but currently operational **only on the backend**.

### 2. **Image Analysis**
   - **Imagga API** is used to process the uploaded images for identifying the artist.
   - Use Postman or similar tools to test this feature via the backend API.

### 3. **Playlist Generation**
   - Once the artist's name is identified (manual input for now), the **Deezer API** fetches a playlist of their trending songs.
   - Users can explore mood-based, categorized playlists.

---

## Use Case: **Kestra Workflow Integration**
We used **Kestra** as a workflow orchestration tool in this project:
- It helps in automating backend tasks such as triggering API calls for image analysis and playlist generation.
- This allows seamless task orchestration, ensuring efficiency and scalability.

---

## Tools and Technologies

### **Frontend**
- **React** + **Vite** for a fast and efficient development environment.
- **Tailwind CSS** for a clean and responsive UI design.

### **Backend**
- **Spring Boot** to power the backend, ensuring robust API handling and integrations.
- **MongoDB** for cloud-based database storage and management via **MongoDB Atlas**.

### **AI and APIs**
- **ChatGPT** for auto-generating and optimizing code for image upload functionality.
- **Imagga API** for recognizing and analyzing uploaded musician images.
- **Deezer API** for generating artist-based playlists.

---

## How to Run the Project

### **Backend Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/musesnap.git
   cd musesnap/backend

