import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import{BrowserRouter, Routes, Route, Link} from 'react-router-dom'
import Home from './pages/Home'
import Signup from './pages/Signup'
import Login from './pages/Login'
import axios from 'axios'

function App() {

  return (
      <BrowserRouter>
        <nav>
          <Link to="/">Home</Link>
          <Link to="/auth/login">Log in</Link>
          <Link to="/auth/signup">Sign up</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/auth/login" element={<Login/>}/>
          <Route path="/auth/signup" element={<Signup/>}/>
        </Routes>
      </BrowserRouter>      
  )
}

export default App
