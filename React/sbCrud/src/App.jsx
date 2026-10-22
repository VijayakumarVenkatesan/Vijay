import { useState } from 'react'
import './App.css'
import Nav from './Nav'
import Form from './Form'
import View from './View'
import {BrowserRouter, Routes, Route} from "react-router-dom"

function App() {

  return (
    <>
      <div>
        <h1>Form</h1>
        <BrowserRouter>
          <Nav/>
          <Routes>
            <Route path='/form' element={<Form/>}/>
            <Route path='/view' element={<View/>}/>
          </Routes>
        </BrowserRouter>
      </div>
    </>
  )
}

export default App
