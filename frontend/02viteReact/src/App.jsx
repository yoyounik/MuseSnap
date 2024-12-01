import { useCallback, useState, useEffect } from 'react'
import FirstPage from './components/FirstPage'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import { SecondPage } from './components/SecondPage'
import { ThirdPage } from './components/ThirdPage'

function App() {
 
  return (
   <>
      <Router>
        <Routes>
          <Route path="/" element={<FirstPage/>}></Route>
          <Route path="/second" element={<SecondPage/>}></Route>
          <Route path="/thirdpage" element={<ThirdPage />} />
        </Routes>
      </Router>
   </>
  )
}

export default App
