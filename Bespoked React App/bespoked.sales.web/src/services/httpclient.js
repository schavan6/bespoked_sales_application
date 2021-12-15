import axios from "axios";

const baseApiUri = process.env.REACT_APP_API_URI || "";

const axiosClient = axios.create({
  baseURL: baseApiUri,
  headers: {
    "Content-Type": "application/json",
  },
});

export default axiosClient;
