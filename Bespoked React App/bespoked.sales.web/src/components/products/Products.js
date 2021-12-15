import React, { useEffect, useState } from "react";
import { getAllProducts } from "../../services/apis";
import CreateProduct from "./CreateProduct";
/**
 *
 * Displays a list of products
 */
const Products = () => {
  const [productsData, setProductsData] = useState(null);
  const [isCreateMode, setIfCreateMode] = useState(false);

  useEffect(() => {
    if (!productsData) {
      //make api call here. and remove mock later
      getAllProducts()
        .then((resp) => {
          console.log("Success", resp);
          setProductsData(resp);
        })
        .catch((error) => {
          console.log("Error", error);
        });
    }
  }, []);

  const onProductCreated = (product) => {
    setProductsData([...productsData, product]);
    setIfCreateMode(false);
  };

  const onCreateProductCancel = () => {
    setIfCreateMode(false);
  };

  return (
    <div>
      {isCreateMode ? (
        <CreateProduct
          onProductCreated={onProductCreated}
          onCreateProductCancel={onCreateProductCancel}
        />
      ) : (
        <>
          <button
            style={{ float: "left" }}
            className="btn btn-primary"
            onClick={() => {
              setIfCreateMode(!isCreateMode);
            }}
          >
            Create Product
          </button>
          <br />
          <br />
          <br />
        </>
      )}
      {productsData && productsData.length > 0 ? (
        <>
          <h2>Product List</h2>
          <table className="table table-bordered">
            <thead>
              <th>Name</th>
              <th>Manufacturer</th>
              <th>Style</th>
              <th>Purchase Price</th>
              <th>Sales Price</th>
              <th>Quantity on Hand</th>
              <th>Commission</th>
            </thead>
            <tbody>
              {productsData.map((product) => {
                return (
                  <tr key={product.product_id}>
                    <td>{product.name}</td>
                    <td>{product.manufacturer}</td>
                    <td>{product.style}</td>
                    <td>${product.purchase_price}</td>
                    <td>${product.sales_price}</td>
                    <td>{product.quantity_on_hand}</td>
                    <td>{product.commision_percentage}%</td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </>
      ) : (
        <h5>No data to display.</h5>
      )}
    </div>
  );
};

export default Products;
