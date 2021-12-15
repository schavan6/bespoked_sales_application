import React, { useState } from "react";
import { formatDate } from "../../utils";
import * as api from "../../services/apis";

const CreateSalesperson = (props) => {
  const [salespersonData, setSalepersonData] = useState({});

  const handleFormSubmit = (e) => {
    e.preventDefault();

    const dataToUpdate = {
      ...salespersonData,
      manager: +salespersonData.manager,
    };

    api
      .createSalesperson(dataToUpdate)
      .then((resp) => {
        const createdSalespersonata = {
          ...resp,
          start_date: formatDate(resp.start_date),
          end_date: formatDate(resp.end_date),
        };
        props.onSalespersonCreated(createdSalespersonata);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleInputChange = (e, field) => {
    setSalepersonData({
      ...salespersonData,
      [field]: e.target.value,
    });
  };

  return (
    <div>
      <div>
        <h2 style={{ float: "left" }}>Create Salesperson</h2>
        <br />
        <br />
        <form onSubmit={handleFormSubmit} className="form-inline">
          <br />
          <div className="form-group row">
            <label htmlFor="fname" className="col-sm-2">
              First Name:
            </label>
            <input
              length="5px"
              onChange={(e) => handleInputChange(e, "first_name")}
              id="fname"
              className="form-control col-sm-4"
              style={{ width: 500 }}
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="lname" className="col-sm-2">
              Last Name:
            </label>
            <input
              className="form-control col-sm-6"
              style={{ width: 500 }}
              id="lname"
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
            <label htmlFor="manager" className="col-sm-2">
              Select Manager :
            </label>
            <select
              id="manager"
              className="form-control"
              onChange={(e) => handleInputChange(e, "manager")}
              style={{ width: 500 }}
            >
              <option value={0}>Select Manager</option>
              {props.managerData.map((s) => {
                return (
                  <option value={s.salesperson_id} key={s.salesperson_id}>
                    {`${s.first_name} ${s.last_name}`}
                  </option>
                );
              })}
            </select>
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
          <div className="form-group row">
            <label htmlFor="end_date" className="col-sm-2">
              End Date:
            </label>
            <input
              style={{ width: 500 }}
              className="form-control"
              id="end_date"
              onChange={(e) => handleInputChange(e, "end_date")}
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
            onClick={props.onCreateSalespersonCancel}
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

export default CreateSalesperson;
