import React from "react";
import "./Header.css";
function Header(){
    return(
        <nav>
            <h1 className="HeaderH1">Nike</h1>
            <ul className="Menu">
                <li>Home</li>
                <li>About</li>
                <li>Cart</li>
                <li>Orders</li>
                <li>Support</li>
            </ul>
            <button className="Logout">Log out</button>
        </nav>
        
    )
}
export default Header;