import axiosClient from "./httpclient";

export const getAllSalesPerson = async () => {
  const resp = await axiosClient.get("/api/v1/salespersons");
  return resp.data;
};

export const getAllCustomers = async () => {
  const resp = await axiosClient.get("/api/v1/customers");
  return resp.data;
};

export const getAllProducts = async () => {
  const resp = await axiosClient.get("/api/v1/products");
  return resp.data;
};

export const getAllSales = async () => {
  const resp = await axiosClient.get("/api/v1/sales");
  return resp.data;
};

export const createSale = async (data) => {
  const resp = await axiosClient.post("/api/v1/sales", data);
  return resp.data;
};

export const getSaleById = async (id) => {
  const resp = await axiosClient.get(`/api/v1/salesperson/${id}`, id);
  return resp.data;
};

export const updateSalesperson = async (id, salesperson) => {
  const resp = await axiosClient.put(`/api/v1/salesperson/${id}`, salesperson);
  return resp.data;
};

export const createSalesperson = async (salesperson) => {
  const resp = await axiosClient.post(`/api/v1/salesperson`, salesperson);
  return resp.data;
};

export const createProduct = async (product) => {
  const resp = await axiosClient.post(`/api/v1/product`, product);
  return resp.data;
};

export const createCustomer = async (customer) => {
  const resp = await axiosClient.post(`/api/v1/customer`, customer);
  return resp.data;
};

export const getCommissionReport = async (quarterId) => {
  const resp = await axiosClient.get(
    `/api/v1/salesreport?quarter=${quarterId}`
  );
  return resp.data;
};
