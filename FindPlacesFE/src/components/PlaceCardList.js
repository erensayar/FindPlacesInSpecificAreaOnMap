import React, { useState } from 'react';
import PlaceCard from './PlaceCard'
import getPlaces from '../api/Api'
import { useDispatch } from 'react-redux'
import { setKey } from '../redux/reducer/KeyReducer'

const PlaceCardList = () => {

    const [parameters, setParameters] = useState({});
    const dispatch = useDispatch();

    // Get Places From Api
    // <============================================================================================================================================>
    const [place, setPlace] = useState([]);
    const callApi = async (params) => {
        try {
            const response = await getPlaces(params);
            setPlace(response.data);
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <div>

            {/* <===================================================== Header ==================================================================> */}
            <nav className="navbar navbar-expand-lg navbar-light bg-light d-flex justify-content-center">
                <div className="nav-div">

                    <input className="form-control" placeholder="Coordinate (40.985276,29.024810)"
                        onChange={(e) => setParameters(() => ({ ...parameters, location: e.target.value }))} />

                    <input className="form-control" placeholder="Radius (1000)(Meter)"
                        onChange={(e) => setParameters(() => ({ ...parameters, radius: e.target.value }))} />

                    <input className="form-control" placeholder="Api key (Google Place Api)"
                        onChange={(e) => setParameters(() => ({ ...parameters, key: e.target.value }))} />

                    <input className="form-control" placeholder="Place type (bar,food)"
                        onChange={(e) => setParameters(() => ({ ...parameters, type: e.target.value }))} />

                    <button className="btn btn-success" type="submit" onClick={
                        () => { dispatch(setKey(parameters.key)); callApi(parameters); }
                    }>Query</button>

                </div>
            </nav>

            {/* <=================================================== Card List ================================================================> */}
            <div className="card-list row d-flex justify-content-center">
                {place && place.map(
                    (place) => (<PlaceCard key={place.id} data={place} />)
                )}
            </div>

        </div>
    )
}

export default PlaceCardList