import React from "react";
/**
 * Display a list of sales
 */
const SalesList = (props) => {
  return (
    <div>
      <h2>Sales list</h2>
      {props.salesData && props.salesData.length > 0 ? (
        <table className="table table-bordered">
          <thead>
            <th>Sales Person Name</th>
            <th>Customer Name</th>
            <th>Product Name</th>
            <th>Product Price</th>
            <th>Sales Date</th>
            <th>Commission</th>
          </thead>
          <tbody>
            {props.salesData.map((sale) => {
              return (
                <tr key={sale.sales_id}>
                  <td>{sale.salesPersonName}</td>
                  <td>{sale.customerName}</td>
                  <td>{sale.productName}</td>
                  <td>${sale.productPrice}</td>
                  <td>{sale.formattedSalesDate}</td>
                  <td>${sale.commision}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      ) : (
        <h5>No data to display.</h5>
      )}
    </div>
  );
};

export default SalesList;
