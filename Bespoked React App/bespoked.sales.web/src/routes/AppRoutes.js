import React from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import SalesPersons from "../components/salesperson/SalesPersons";
import Home from "../components/home/Home";
import Products from "../components/products/Products";
import Customers from "../components/customers/Customers";
import Sales from "../components/sales/Sales";
import CommissionReport from "../components/reports/CommissionReport";
import NavBar from "./NavBar";
import UpdateSalesPerson from "../components/salesperson/UpdateSalesperson";
import CreateSalesperson from "../components/salesperson/CreateSalesperson";
import "./AppRoute.css";

export default function AppRoutes(props) {
  return (
    <Router>
      <NavBar />
      <div className="container" style={{ minHeight: "85vh" }}>
        <Routes>
          <Route exact path="/products" element={<Products />} />
          <Route exact path="/customers" element={<Customers />}></Route>
          <Route exact path="/sales" element={<Sales />}></Route>
          <Route exact path="/report" element={<CommissionReport />}></Route>
          <Route exact path="/salespersons" element={<SalesPersons />}></Route>

          <Route
            exact
            path="/salesperson/:id/update"
            element={<UpdateSalesPerson />}
          ></Route>
          <Route
            exact
            path="/salesperson/create"
            element={<CreateSalesperson />}
          ></Route>
          <Route exact path="/" element={<Home />}></Route>
          <Route path="*" element={<Home />}></Route>
        </Routes>
      </div>
      <hr />
      <footer>&copy;BeSpoked 2021.</footer>
    </Router>
  );
}
