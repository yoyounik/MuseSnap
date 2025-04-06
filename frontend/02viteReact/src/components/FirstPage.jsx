import React , { useState } from 'react'
import {useNavigate} from "react-router-dom";
import axios from "axios";

function FirstPage() {
  const navigate = useNavigate();
  const [file, setFile] = useState(null);
  const API_URL = import.meta.env.VITE_API_URL;

  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };

  const handleFileUpload = async (file) => {
    if (!file) {
      alert("Please select a file first!");
      return;
    }

    const formData = new FormData();
    formData.append("file", file);

    try {
      console.log("Attempting to upload to:", `${API_URL}/api/uploads/images`);
      const response = await axios.post(
        `${API_URL}/api/uploads/images`,
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        }
      );

      // On successful upload, navigate to the second page
      const uploadedImageId = response.data.split(": ")[1];
      const imageUrl = `${API_URL}/api/uploads/images/${uploadedImageId.trim()}`;

      navigate("/second", { state: { imageUrl } });
    } catch (error) {
      console.error("Upload error details:", {
        message: error.message,
        response: error.response?.data,
        status: error.response?.status,
        url: `${API_URL}/api/uploads/images`
      });
      alert(`Failed to upload image: ${error.message}\nStatus: ${error.response?.status}\nPlease check console for details.`);
    }
  };


  return (
    <>
      <div className="flex flex-col items-center justify-center h-screen bg-black text-white">
      {/* Hidden File Input */}
      <input
        id="fileInput"
        type="file"
        accept="image/*"
        style={{ display: "none" }}
        onChange={handleFileChange}
      />

      {/* Header Section */}
      <div className="absolute top-10 left-10 text-sm font-medium tracking-wide">
        <span className="flex items-center">
          <span className="mr-2 text-xl">✨</span> N S original's
        </span>
      </div>

      {/* Content Section */}
      <div className="flex flex-col lg:flex-row items-center lg:items-start justify-between w-full max-w-5xl px-6">
        {/* Text Content */}
        <div className="text-center lg:text-left">
          <h1 className="text-9xl font-bold mb-4">MuseSnap</h1>
          <p className="text-lg mb-2">Snap, share, and listen!</p>
          <p className="text-gray-400">
            Upload a screenshot of your favorite musician, and MuseSnap will
            suggest their trending tracks.
          </p>
        </div>

        {/* Image */}
        <div className="mt-10 lg:mt-0">
          <img
            src="https://i.pinimg.com/originals/7a/74/d9/7a74d97d1d2d2cedf1173df2f1391952.jpg" // Replace with actual image URL
            alt="Musician"
            className="rounded-full object-cover w-60 h-60"
          />
          
        </div>
      </div>

      {/* Upload Button */}
      <button
        onClick={() => document.getElementById("fileInput").click()}
        className="border border-gray-500 rounded-full px-8 py-3 text-sm font-medium hover:bg-gray-700 transition">
        SELECT IMAGE
      </button>

      {/* Upload and Navigate */}
      <button
        onClick={() => handleFileUpload(file)} // Pass the file state explicitly
        className="mt-4 border border-green-500 rounded-full px-8 py-3 text-sm font-medium hover:bg-green-700 transition">
        UPLOAD IMAGE
      </button>
    </div>
    </>
  )
}

export default FirstPage