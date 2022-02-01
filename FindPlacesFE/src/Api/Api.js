import axios from "axios";

export const getPlaces = async (myParams) => {
  return await axios.get('/api/v1/query/google-places', { params: myParams });
};

export default getPlaces