# Muse Snap 🎵📷

Muse Snap is an innovative web application designed to make music discovery seamless and fun. Scrolling insta or Youtube , cannot find that drummer or artist anywhere else , upload an image of a musician, let our backend AI recognize the artist, and generate playlists based on trending songs. Whether you’re curating moods or just exploring new music, Muse Snap is your gateway to discovering the tunes that inspire the world.
<b>Checkout kestra config file for YAML code </b>

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
We used **Kestra** as a workflow orchestration tool in this project. 

- A custom workflow YAML file has been added, which triggers specific actions when a user uploads an image of a musician.
- The workflow automates the process of fetching uploaded images stored in **MongoDB**, downloading them, and analyzing them for artist recognition.
- This integration simplifies task management and enhances the scalability of the system.

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
 - For smooth running install Intellij iDE , and run the project, you can run the image  recognition part in backend , while
 - for front end use VS Code. Just select any image from your local device , upload it , then click on generate playlist , where you can add artist name, the API will help you generate playlist of their songs.
### **Backend Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/musesnap.git
   cd musesnap/backend
   ```
2. Open the backend folder in IntelliJ IDEA.

   Set up the required environment variables in the application.properties or application.yml file (e.g., MongoDB URI).

   - Run the backend:
   - Locate the main class (e.g., com.musesnap.MuseSnapApplication) and run it.
   - Ensure the backend is running at http://localhost:8080.
   - Test the backend: Use Postman or any API testing tool. API endpoint example: POST /api/upload-image to upload an image

### **Frontend Setup**
1. Navigate to the frontend folder:
   ```bash
   cd musesnap/frontend
   ```
2. Install the dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm run dev
   ```
4. Access the frontend: Open your browser and go to http://localhost:5173 (default Vite development port).

5. Future Enhancements
   - Add support for more complex image recognition.
   - Enhance the music playlist recommendations.
   - Allow direct downloading of playlists to Google Drive or the user's device.
  
This Project is part of my hackathon: #hackfrost2024. Conducted by @kestra.io , Special Thanks to @KunalKushwaha and @WeMakeDevs and @Kestra for conducting this Hackathon.



