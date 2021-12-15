import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router";
import * as api from "../../services/apis";

const UpdateSalesPerson = (props) => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [saleData, setSaleData] = useState(null);

  //call api here to get the details of sales person by Id and then use that info
  //to populate the Form to update sales person info.
  useEffect(() => {
    if (!saleData) {
      api
        .getSaleById(id)
        .then((data) => {
          setSaleData(data);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, []);

  const handleFormSubmit = (e) => {
    e.preventDefault();

    const dataToUpdate = { ...saleData, manager: +saleData.manager };

    api
      .updateSalesperson(id, dataToUpdate)
      .then((resp) => {
        navigate("/salespersons");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleInputChange = (e, field) => {
    setSaleData({
      ...saleData,
      [field]: e.target.value,
    });
  };

  const getISODate = (date) => {
    var new_date = new Date(date).toISOString().substring(0, 10);
    return new_date;
  };

  return (
    <div>
      {saleData ? (
        <div>
          <h2 style={{ float: "left" }}>Update Salesperson</h2>
          <br />
          <br />
          <form
            onSubmit={handleFormSubmit}
            className="form-inline"
            style={{ clear: "both", float: "left" }}
          >
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
                value={saleData.first_name}
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
                value={saleData.last_name}
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
                value={saleData.address}
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
                value={saleData.phone}
              />
            </div>
            <br />
            <div className="form-group row">
              <label htmlFor="manager" className="col-sm-2">
                Manager:
              </label>
              <input
                style={{ width: 500 }}
                className="form-control"
                id="manager"
                onChange={(e) => handleInputChange(e, "manager")}
                value={saleData.manager}
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
                value={getISODate(saleData.start_date)}
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
                value={getISODate(saleData.end_date)}
              />
            </div>
            <br />
            <button class="btn btn-primary" type="submit">
              Update
            </button>
          </form>
        </div>
      ) : (
        <div>No data found.</div>
      )}
    </div>
  );
};

export default UpdateSalesPerson;
