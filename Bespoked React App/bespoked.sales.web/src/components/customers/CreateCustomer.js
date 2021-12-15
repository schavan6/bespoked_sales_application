import React, { useState } from "react";
import { formatDate } from "../../utils";
import * as api from "../../services/apis";

const CreateCustomer = (props) => {
  const [customerData, setCustomerData] = useState({});

  const handleFormSubmit = (e) => {
    e.preventDefault();

    api
      .createCustomer(customerData)
      .then((resp) => {
        const createdCustomerata = {
          ...resp,
          start_date: formatDate(resp.start_date),
        };
        props.onCustomerCreated(createdCustomerata);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleInputChange = (e, field) => {
    setCustomerData({
      ...customerData,
      [field]: e.target.value,
    });
  };

  return (
    <div>
      <div>
        <h2 style={{ float: "left" }}>Create Customer</h2>
        <br />
        <br />
        <form onSubmit={handleFormSubmit} className="form-inline">
          <br />
          <div className="form-group row">
            <label htmlFor="first_name" className="col-sm-2">
              First Name:
            </label>
            <input
              length="5px"
              onChange={(e) => handleInputChange(e, "first_name")}
              id="first_name"
              className="form-control col-sm-4"
              style={{ width: 500 }}
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="last_name" className="col-sm-2">
              Last Name:
            </label>
            <input
              className="form-control col-sm-6"
              style={{ width: 500 }}
              id="last_name"
              onChange={(e) => handleInputChange(e, "last_name")}
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="address" className="col-sm-2">
              Address:
            </label>
            <input
              className="form-control"
              style={{ width: 500 }}
              id="address"
              onChange={(e) => handleInputChange(e, "address")}
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="phone" className="col-sm-2">
              Phone:
            </label>
            <input
              style={{ width: 500 }}
              className="form-control"
              id="phone"
              onChange={(e) => handleInputChange(e, "phone")}
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="start_date" className="col-sm-2">
              Start Date:
            </label>
            <input
              style={{ width: 500 }}
              className="form-control"
              id="start_date"
              onChange={(e) => handleInputChange(e, "start_date")}
              type="date"
            />
          </div>
          <br />
          <button type="submit" class="btn btn-primary">
            Create
          </button>
          &nbsp;
          <button
            type="button"
            class="btn btn-secondary"
            onClick={props.onCreateCustomerCancel}
          >
            Cancel
          </button>
        </form>
        <br />
        <br />
        <br />
      </div>
    </div>
  );
};
export default CreateCustomer;
