import React, { useState } from 'react';
import PlaceCard from './PlaceCard'
import getPlaces from '../Api/Api'

const PlaceCardList = () => {

    const [place, setPlace] = useState([]);

    const callApi = async (params) => {
        try {
            const response = await getPlaces(params);
            setPlace(response.data);
        } catch (error) {
            console.log(error);
        }
    }

    const [parameters, setParameters] = useState({});

    return (
        <div>

            <nav className="navbar navbar-expand-lg navbar-light bg-light d-flex justify-content-center">
                <div className="nav-div">
                    <input className="form-control" placeholder="Coordinate (40.985276,29.024810)" onChange={(e) => setParameters((paramaters) => ({ ...parameters, location: e.target.value }))} />
                    <input className="form-control" placeholder="Radius (1000)" onChange={(e) => setParameters((paramaters) => ({ ...parameters, radius: e.target.value }))} />
                    <input className="form-control" placeholder="Api key (Google Place Api)" onChange={(e) => setParameters((paramaters) => ({ ...parameters, key: e.target.value }))} />
                    <input className="form-control" placeholder="Place type (bar,food)" onChange={(e) => setParameters((paramaters) => ({ ...parameters, type: e.target.value }))} />
                    <button className="btn btn-success" type="submit" onClick={() => callApi(parameters)}>Query</button>
                </div>
            </nav>

            <div className="card-list row d-flex justify-content-center">
                {place && place.map(
                    (place) => (<PlaceCard key={place.id} data={place} />)
                )}
            </div>

        </div>
    )
}

export default PlaceCardList
