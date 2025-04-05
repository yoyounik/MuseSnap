import React from 'react'
import { useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";

export const SecondPage = () => {
    const location = useLocation();
    const { imageUrl } = location.state || {}; // Retrieve the image URL from state

    //for thirdpage
    const navigate = useNavigate();

    const handleButtonClick = () => {
        navigate('/Thirdpage'); // Navigate to ThirdPage.jsx
    };
  return (
   <>
        <body class="bg-white flex flex-col items-center justify-center min-h-screen">
        <div class="flex items-center justify-center space-x-8">
            <div class="flex flex-col items-center">
                <div class="w-40 h-40 rounded-full border-4 border-green-500 overflow-hidden">
                {imageUrl ? (
                    <img
                        alt="Uploaded"
                        className="w-full h-full object-cover"
                        src={imageUrl}
                    />
                    ) : (
                    <p>No image uploaded</p>
                    )}
                </div>
                <p class="mt-4 text-2xl font-bold">
                UPLOADED
                </p>
                <hr class="w-24 border-black mt-2"/>
            </div>

            <div class="text-6xl font-bold text-black">
                <i class="fas fa-chevron-right">
                </i>
            </div>

            <div class="flex flex-col items-center">
                <p class="text-5xl font-bold">
                    Charlie Puth
                </p>
                <hr class="w-32 border-black mt-2"/>
                <p class="mt-2 text-center text-sm">
                Charles Otto Puth Jr. is an American singer-songwriter. His initial exposure came through the viral success of his song covers uploaded to YouTube
                </p>
                <div class="mt-8 w-40 h-40 rounded-full border-4 border-purple-500 flex items-center justify-center hover:bg-blue-300">
                    <button class="text-xl font-bol" onClick={handleButtonClick}>
                        Generate Playlist
                    </button>
                </div>

            </div>
        </div>

        <div class="mt-16 bg-black text-white p-4 rounded-full text-center">
            <p>
            Scrolling Instagram Reels or YouTube? and found an artist voice amusing? Just take the screenshot and upload it here and we will recommend your personalized downloadable playlist.
            </p>
        </div>
        </body>       
   </>
        
  )
}