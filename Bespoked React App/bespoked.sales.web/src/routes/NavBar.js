import React from "react";
import { NavLink } from "react-router-dom";
import "./NavBar.css";

export default function NavBar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div className="navbar-nav">
            <NavLink className={"nav-item nav-link"} to="/">
              Home
            </NavLink>
            <NavLink className={"nav-item nav-link"} to="/salespersons">
              Sales Persons
            </NavLink>

            <NavLink className={"nav-item nav-link"} to="/products">
              Products
            </NavLink>

            <NavLink className={"nav-item nav-link"} to="/customers">
              Customers
            </NavLink>

            <NavLink className={"nav-item nav-link"} to="/sales">
              Sales
            </NavLink>

            <NavLink className={"nav-item nav-link"} to="/report">
              Commision Report
            </NavLink>
          </div>
        </div>
      </nav>
    </div>
  );
}
