import React, { useEffect, useState } from "react";
import { formatDate } from "../../utils";
import { getAllSalesPerson } from "../../services/apis";
import { Link } from "react-router-dom";
import CreateSalesperson from "./CreateSalesperson";
/**
 *
 * Display a list of salesperson.
 */
const SalesPersons = () => {
  const [salesPersonData, setSalesPersonData] = useState(null);
  const [updatesp, setUpdatesp] = useState(0);
  const [isCreateMode, setIfCreateMode] = useState(false);

  useEffect(() => {
    if (!salesPersonData) {
      //make api call here. and remove mock later
      getAllSalesPerson()
        .then((resp) => {
          console.log("Success", resp);
          setSalesPersonData(resp);
        })
        .catch((error) => {
          console.log("Error", error);
        });
    }
  }, []);

  const onSalespersonCreated = (salesperson) => {
    setSalesPersonData([...salesPersonData, salesperson]);
    setIfCreateMode(false);
  };

  const onCreateSalespersonCancel = () => {
    setIfCreateMode(false);
  };

  const getManagerName = (id) => {
    if (!id || id === 0) {
      return "-";
    }
    const manager = salesPersonData.find((m) => m.salesperson_id === id);

    if (manager) {
      return `${manager.first_name} ${manager.last_name}`;
    }

    return "-";
  };

  return (
    <div>
      {isCreateMode ? (
        <CreateSalesperson
          onSalespersonCreated={onSalespersonCreated}
          onCreateSalespersonCancel={onCreateSalespersonCancel}
          managerData={salesPersonData}
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
            Create Sales Person
          </button>
          <br />
          <br />
          <br />
        </>
      )}
      {salesPersonData && salesPersonData.length > 0 ? (
        <>
          <h2>Sales Person List</h2>
          <table className="table table-bordered">
            <thead>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Address</th>
              <th>Contact No</th>
              <th>Start Date</th>
              <th>Termination Date</th>
              <th>Manager</th>
              <th></th>
            </thead>
            <tbody>
              {salesPersonData.map((person) => {
                return (
                  <tr key={person.salesperson_id}>
                    <td>{person.first_name}</td>
                    <td>{person.last_name}</td>
                    <td>{person.address}</td>
                    <td>{person.phone}</td>
                    <td>{formatDate(person.start_date)}</td>
                    <td>{formatDate(person.end_date)}</td>
                    <td>{getManagerName(person.manager)}</td>
                    <td>
                      <Link to={`/salesperson/${person.salesperson_id}/update`}>
                        Update
                      </Link>
                    </td>
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

export default SalesPersons;
