import React from 'react'
import { Link } from 'react-router-dom'

const Nav = () => {
  return (
    <div>
        <ul>
            <li><Link to="/form">Form</Link></li>
            <li><Link to="/view">View</Link></li>
        </ul>       
    </div>
  )
}

export default Nav