import React, { useState } from "react";
import { formatDate } from "../../utils";
import * as api from "../../services/apis";

const CreateProduct = (props) => {
  const [productData, setProductData] = useState({});

  const handleFormSubmit = (e) => {
    e.preventDefault();

    api
      .createProduct(productData)
      .then((resp) => {
        props.onProductCreated(resp);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleInputChange = (e, field) => {
    setProductData({
      ...productData,
      [field]: e.target.value,
    });
  };

  return (
    <div>
      <div>
        <h2 style={{ float: "left" }}>Create Product</h2>
        <br />
        <br />
        <form
          onSubmit={handleFormSubmit}
          className="form-inline"
          style={{ clear: "both", float: "left" }}
        >
          <br />
          <div className="form-group row">
            <label htmlFor="name" className="col-sm-2">
              Name:
            </label>
            <input
              length="5px"
              onChange={(e) => handleInputChange(e, "name")}
              id="name"
              className="form-control col-sm-4"
              style={{ width: 500 }}
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="manufacturer" className="col-sm-2">
              Manufacturer:
            </label>
            <input
              className="form-control"
              style={{ width: 500 }}
              id="manufacturer"
              onChange={(e) => handleInputChange(e, "manufacturer")}
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="style" className="col-sm-2">
              Style:
            </label>
            <input
              style={{ width: 500 }}
              className="form-control"
              id="style"
              onChange={(e) => handleInputChange(e, "style")}
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="purchase_price" className="col-sm-2">
              Purchase Price:
            </label>
            <input
              style={{ width: 500 }}
              className="form-control"
              id="purchase_price"
              onChange={(e) => handleInputChange(e, "purchase_price")}
              type="number"
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="sales_price" className="col-sm-2">
              Sales Price:
            </label>
            <input
              style={{ width: 500 }}
              className="form-control"
              id="sales_price"
              onChange={(e) => handleInputChange(e, "sales_price")}
              type="number"
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="quantity_on_hand" className="col-sm-2">
              Quantity On Hand
            </label>
            <input
              style={{ width: 500 }}
              className="form-control"
              id="quantity_on_hand"
              onChange={(e) => handleInputChange(e, "quantity_on_hand")}
              type="number"
            />
          </div>
          <br />
          <div className="form-group row">
            <label htmlFor="commision_percentage" className="col-sm-2">
              Commision Percentage
            </label>
            <input
              style={{ width: 500 }}
              className="form-control"
              id="commision_percentage"
              onChange={(e) => handleInputChange(e, "commision_percentage")}
              type="number"
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
            onClick={props.onCreateProductCancel}
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

export default CreateProduct;
