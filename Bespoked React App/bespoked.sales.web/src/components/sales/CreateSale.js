import React, { useState } from "react";
import { formatDate } from "../../utils";
import { createSale } from "../../services/apis";

const CreateSale = (props) => {
  const [saleData, setSaleData] = useState({
    product_id: 0,
    salesperson_id: 0,
    customer_id: 0,
    sales_date: null,
  });

  const handleProductChange = (e) => {
    const selectedProductId = +e.target.value;
    setSaleData({ ...saleData, product_id: selectedProductId });
  };

  const handleSalesPersonChange = (e) => {
    const selectedSalesPersonId = +e.target.value;
    setSaleData({ ...saleData, salesperson_id: selectedSalesPersonId });
  };

  const handleCustomerChange = (e) => {
    const selectedCustomerId = +e.target.value;
    setSaleData({ ...saleData, customer_id: selectedCustomerId });
  };

  const handleSaleDateChange = (e) => {
    setSaleData({
      ...saleData,
      sales_date: e.target.value,
    });
  };

  const handleFormSubmit = (e) => {
    e.preventDefault();

    const errors = validateInput();

    if (errors.length > 0) {
      const message = errors.join("\n");
      alert(message);
      return;
    }
    createSale(saleData).then((resp) => {
      if (props.onSaleCreated) {
        const createdSaleData = {
          ...resp,
          sales_date: formatDate(resp.sales_date),
        };
        props.onSaleCreated(createdSaleData);
      }
    });
  };

  /**
   *
   * @returns Check if all values are entered.
   */
  const validateInput = () => {
    let errors = [];
    if (saleData.product_id === 0) {
      errors.push("Select valid product");
    }
    if (saleData.salesperson_id === 0) {
      errors.push("Select valid sales person");
    }
    if (saleData.customer_id === 0) {
      errors.push("Select valid customer");
    }

    if (!saleData.sales_date) {
      errors.push("Select valid sales date");
    }
    return errors;
  };

  return (
    <div>
      <h2 style={{ display: "flex", justifyContent: "flex-start" }}>
        Create a New Sale
      </h2>
      <br />
      <br />
      <form onSubmit={handleFormSubmit} className="form-inline">
        <div className="form-group row">
          <label htmlFor="product" className="col-sm-2">
            Select Product :
          </label>
          <select
            id="product"
            className="form-control"
            value={saleData.product_id}
            style={{ width: 500 }}
            onChange={handleProductChange}
          >
            <option value={0}>Select Product</option>
            {props.products
              .filter((p) => p.quantity_on_hand > 0)
              .map((p) => {
                return (
                  <option value={p.product_id} key={p.product_id}>
                    {p.name}
                  </option>
                );
              })}
          </select>
        </div>
        <br />
        <div className="form-group row">
          <label className="col-sm-2" htmlFor="salesperson">
            Select Sales Person :
          </label>
          <select
            id="salesperson"
            className="form-control"
            value={saleData.salesperson_id}
            onChange={handleSalesPersonChange}
            style={{ width: 500 }}
          >
            <option value={0}>Select Sales Person</option>
            {props.salespersons.map((s) => {
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
          <label className="col-sm-2" htmlFor="customer">
            Select Customer :
          </label>
          <select
            id="customer"
            className="form-control"
            value={saleData.customer_id}
            style={{ width: 500 }}
            onChange={handleCustomerChange}
          >
            <option value={0}>Select Customer</option>
            {props.customers.map((c) => {
              return (
                <option value={c.customer_id} key={c.customer_id}>
                  {`${c.first_name} ${c.last_name}`}
                </option>
              );
            })}
          </select>
        </div>
        <br />
        <div className="form-group row">
          <label className="col-sm-2" htmlFor="salesdate">
            Sales Date:
          </label>
          <input
            id="salesdate"
            className="form-control"
            type="date"
            name="salesdate"
            value={saleData.sales_date}
            style={{ width: 500 }}
            onChange={handleSaleDateChange}
            max={new Date().toISOString().split("T")[0]}
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
          onClick={props.onCreateSalesCancel}
        >
          Cancel
        </button>
      </form>
    </div>
  );
};

export default CreateSale;
