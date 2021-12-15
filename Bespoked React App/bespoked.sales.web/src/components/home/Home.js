import react from "react";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <>
      <div style={{ backgroundColor: "cadetblue", padding: "1rem" }}>
        <div className="jumbotron">
          <h1>BeSpoked Sales</h1>

          <p>
            Bespoked is a sales application for a bicycle shop. We eneble users
            to keep track of the sales, salespeople, products and customers in
            the system. We even display a quarter-wise commision report.
          </p>
        </div>
      </div>
      <div className="row" style={{ marginTop: "1rem" }}>
        <div className="col-md-4">
          <h2>Commission Report</h2>
          <p>
            View quarter-wise commision report for each employee based on the
            sales in the system.
          </p>
          <p>
            {/* <a className="btn btn-secondary" href="#" role="button">
              View details »
            </a> */}
            <Link className="btn btn-secondary" to="/report">
              View details »
            </Link>
          </p>
        </div>
        <div className="col-md-4">
          <h2>Sales</h2>
          <p>
            View all the sales made in the system. Create a new sale in the
            system.{" "}
          </p>
          <p>
            <Link className="btn btn-secondary" to="/sales">
              View details »
            </Link>
          </p>
        </div>
        <div className="col-md-4">
          <h2>Sales Persons</h2>
          <p>
            View all the sales persons in the system. Create a new sale person
            in the system.
          </p>
          <p>
            <Link className="btn btn-secondary" to="/salespersons">
              View details »
            </Link>
          </p>
        </div>
      </div>
      <div className="row" style={{ marginTop: "5rem", marginBottom: "5rem" }}>
        <div className="col-md-4">
          <h2>Products</h2>
          <p>
            View all the products in the system. Create a new product in the
            system.
          </p>
          <p>
            <Link className="btn btn-secondary" to="/products">
              View details »
            </Link>
          </p>
        </div>
        <div className="col-md-4">
          <h2>Customers</h2>
          <p>
            View all the customers made in the system. Create a new customer in
            the system.
          </p>
          <p>
            <Link className="btn btn-secondary" to="/customers">
              View details »
            </Link>
          </p>
        </div>
      </div>
    </>
  );
};

export default Home;
