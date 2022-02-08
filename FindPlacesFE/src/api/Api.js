import axios from "axios";

export const getPlaces = async (paramsFromUser) => {
  return await axios.get('/api/v1/query/google-places', { params: paramsFromUser });
};

export default getPlaces