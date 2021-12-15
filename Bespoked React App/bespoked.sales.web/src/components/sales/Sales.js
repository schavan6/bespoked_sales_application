import React, { useEffect, useState } from "react";
import { formatDate } from "../../utils";
import CreateSale from "./CreateSale";
import SalesList from "./SalesList";
import * as apis from "./../../services/apis";

/**
 * dataObj parameter contains data for customers, salespersons, products.
 * For a passed sale object, fill customer name, salesperson name, product name, product price using dataObj.
 *
 */
const getSaleInfo = (sale, dataObj) => {
  const customer = dataObj.customers.find(
    (c) => c.customer_id === sale.customer_id
  );
  const salesPerson = dataObj.salespersons.find(
    (c) => c.salesperson_id === sale.salesperson_id
  );
  const product = dataObj.products.find(
    (c) => c.product_id === sale.product_id
  );
  return {
    ...sale,
    formattedSalesDate: formatDate(sale.sales_date),
    customerName: customer
      ? `${customer.first_name} ${customer.last_name}`
      : "",
    salesPersonName: salesPerson
      ? `${salesPerson.first_name} ${salesPerson.last_name}`
      : "",
    productName: product ? `${product.name}` : "",
    productPrice: product ? `${product.sales_price}` : "",
  };
};

/**
 *
 * Each sales row has ids of customer, product and salesperson.
 * In this API, appropriate names are entered along with above ids
 * for displaying the list on the view.
 */
const getSalesData = (dataObj) => {
  if (dataObj && dataObj.sales) {
    const mappedSalesData = dataObj.sales.map((sale) => {
      return getSaleInfo(sale, dataObj);
    });

    return mappedSalesData;
  }

  return [];
};

/**
 * Parent component for displaying create sales and sales list components.
 */
const Sales = () => {
  const [salesData, setSaleData] = useState(null);
  const [masterData, setMasterData] = useState(null);
  const [isCreateMode, setIfCreateMode] = useState(false);

  useEffect(() => {
    if (!salesData) {
      const promises = [
        apis.getAllCustomers(),
        apis.getAllProducts(),
        apis.getAllSalesPerson(),
        apis.getAllSales(),
      ];

      Promise.all(promises).then((results) => {
        const data = {
          customers: results[0],
          products: results[1],
          salespersons: results[2],
          sales: results[3],
        };
        setMasterData(data);
        setSaleData(getSalesData(data));
      });
    }
  }, []);
  /**
   * Upon creatinga new sale, it is appended to the sales list
   * so that the updated sales list is displayed on the UI.
   */
  const onSaleCreated = (sale) => {
    const newlyCreatedSale = getSaleInfo(sale, masterData);
    setSaleData([...salesData, newlyCreatedSale]);
    setIfCreateMode(false);
  };
  /**
   * Remove the create sale component.
   */
  const onCreateSalesCancel = () => {
    setIfCreateMode(false);
  };

  /*
isCreateMode - decides whether or not to display create sale view
*/
  return (
    <div>
      {masterData &&
        (isCreateMode ? (
          <CreateSale
            onSaleCreated={onSaleCreated}
            customers={masterData.customers}
            salespersons={masterData.salespersons}
            products={masterData.products}
            onCreateSalesCancel={onCreateSalesCancel}
          />
        ) : (
          <button
            style={{ float: "left" }}
            className="btn btn-primary"
            onClick={() => {
              setIfCreateMode(!isCreateMode);
            }}
          >
            Create Sale
          </button>
        ))}
      <div style={{ clear: "both" }}>
        <SalesList salesData={salesData} />
      </div>
    </div>
  );
};

export default Sales;
