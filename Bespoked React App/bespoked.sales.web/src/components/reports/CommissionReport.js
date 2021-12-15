import React, { useEffect, useState } from "react";
import { getCommissionReport } from "../../services/apis";
/**
 *
 * Displays quarter-wise commision report.
 * Quarter can be chosen via a input on the top
 */
const CommissionReport = () => {
  const [commissionData, setCommissionData] = useState(null);
  const [quarterId, setQuarterId] = useState(1);

  useEffect(() => {
    getCommissionReport(quarterId)
      .then((resp) => {
        if (resp && resp.length > 0) {
          resp.sort((a, b) => {
            if (a.salesperson_name === b.salesperson_name) {
              return a.quarter - b.quarter;
            }

            return a.salesperson_name.localeCompare(b.salesperson_name);
          });
          setCommissionData([...resp]);
        } else {
          setCommissionData([]);
        }
      })
      .catch((error) => {
        console.log("Commission Get All Error", error);
      });
  }, [quarterId]);

  const onQuarterChange = (e) => {
    const selectedQuarterId = +e.target.value;
    setQuarterId(selectedQuarterId);
  };
  return (
    <div>
      <h2>Commission Report</h2>
      <br />
      <label style={{ float: "left" }}>Select Quarter :</label>
      <br />
      <select
        style={{ width: "10%" }}
        className="form-select"
        value={quarterId}
        onChange={onQuarterChange}
      >
        <option value={0}>All</option>
        <option value={1}>1</option>
        <option value={2}>2</option>
        <option value={3}>3</option>
        <option value={4}>4</option>
      </select>
      <br />
      {commissionData && commissionData.length > 0 ? (
        <table className="table table-bordered">
          <thead>
            <th>Sales Person Name</th>
            <th>No of Sales</th>
            <th>Total Commission</th>
            <th>Quarter</th>
          </thead>
          <tbody>
            {commissionData.map((comm) => {
              return (
                <tr key={`${comm.salesperson_id}_${comm.quarter}`}>
                  <td>{comm.salesperson_name}</td>
                  <td>{comm.number_of_sales}</td>
                  <td>${comm.commision}</td>
                  <td>{comm.quarter}</td>
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

export default CommissionReport;
