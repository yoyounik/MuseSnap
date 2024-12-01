import React, { useEffect, useState } from 'react'
import axios from "axios";

export const ThirdPage = () => {
    const [artistName, setArtistName] = useState("");
    const [artists, setArtists] = useState([]);
    const [error, setError] = useState("");

    const searchArtist = async () => {
        try {
            setError("");
            const response = await fetch(`http://localhost:8080/api/search/artist?name=${artistName}`);
            
            if (!response.ok) {
                throw new Error(`HTTP Error: ${response.status}`);
            }
            
            const data = await response.json();
            setArtists(data.data);
        } catch (err) {
            console.error("Error fetching artist data:", err.message);
            setError("Failed to fetch data from the backend. Please try again.");
        }
      };
    
      const fetchTopTracks = async (tracklistUrl) => {
        try {
          const response = await axios.get(tracklistUrl);
          console.log("Top Tracks: ", response.data);
          alert("Check the console for top tracks!");
        } catch (err) {
          console.error(err);
          alert("Failed to fetch top tracks.");
        }
      };
    

  return (
    <>
        <div style={{ padding: "20px", fontFamily: "Arial, sans-serif", maxWidth: "1200px", margin: "auto" }}>
            <h1 style={{ textAlign: "center", color: "#333" }}>Search for an Artist</h1>
            
            {/* Search Bar */}
            <div style={{ display: "flex", justifyContent: "center", marginBottom: "20px" }}>
                <input
                    type="text"
                    value={artistName}
                    onChange={(e) => setArtistName(e.target.value)}
                    placeholder="Enter artist name"
                    style={{
                        padding: "10px 15px",
                        fontSize: "16px",
                        borderRadius: "4px",
                        border: "1px solid #ddd",
                        width: "80%",
                        maxWidth: "500px",
                    }}
                />
                <button
                    onClick={searchArtist}
                    style={{
                        padding: "10px 15px",
                        fontSize: "16px",
                        backgroundColor: "#007BFF",
                        color: "white",
                        border: "none",
                        borderRadius: "4px",
                        cursor: "pointer",
                        marginLeft: "10px",
                    }}
                >
                    Search
                </button>
            </div>

            {/* Error Message */}
            {error && <p style={{ color: "red", textAlign: "center" }}>{error}</p>}

            {/* Artist Results */}
            <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fill, minmax(200px, 1fr))", gap: "20px" }}>
                {artists.length > 0 && artists.map((artist) => (
                    <div key={artist.id} style={{ textAlign: "center", backgroundColor: "#f9f9f9", padding: "15px", borderRadius: "8px", boxShadow: "0 2px 4px rgba(0, 0, 0, 0.1)" }}>
                        <img
                            src={artist.picture_medium}
                            alt={artist.name}
                            style={{
                                width: "100%",
                                height: "auto",
                                borderRadius: "50%",
                                objectFit: "cover",
                                marginBottom: "15px",
                            }}
                        />
                        <h3 style={{ color: "#333", fontSize: "18px" }}>{artist.name}</h3>
                        <p style={{ color: "#888", fontSize: "14px" }}>{artist.nb_fan} Fans</p>
                        <a
                            href={artist.link}
                            target="_blank"
                            rel="noopener noreferrer"
                            style={{
                                color: "#007BFF",
                                textDecoration: "none",
                                fontSize: "14px",
                                fontWeight: "bold",
                            }}
                        >
                            View on Deezer
                        </a>
                    </div>
                ))}
            </div>
        </div>
    </>
  )
}
