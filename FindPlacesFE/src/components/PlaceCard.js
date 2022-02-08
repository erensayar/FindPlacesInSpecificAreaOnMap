import React from 'react'
import { useSelector } from 'react-redux'

const PlaceCard = (props) => {

    const { name, coordinate, rating, address, type, photoReference, isOpen } = props.data;

    // Set Photo Api URL
    // <============================================================================================================================================>
    const IMAGE_SOURCE_BASE_URL = "https://maps.googleapis.com/maps/api/place/photo?";
    const WIDTH_HEIGHT = "maxwidth=400&maxheight=400";
    const REFERENCE_PARAM = "&photo_reference=";
    const API_KEY_PREFIX = "&key=";
    const API_KEY = useSelector((state) => state.key.key);
    const IMAGE_SRC = IMAGE_SOURCE_BASE_URL.concat(WIDTH_HEIGHT, REFERENCE_PARAM, photoReference, API_KEY_PREFIX, API_KEY);
    // <============================================================================================================================================>

    return (
        <div className="card" style={{ width: '17rem', height: '30rem' }}>
            <img className="card-img-top" src={IMAGE_SRC} alt={name} style={{ width: '15.5rem', height: '15rem' }} />
            <div className="card-body">
                <div>
                    <h5 className="card-title">{name}</h5>
                    {isOpen ? <span className="dot-online"></span> : <span className="dot-offline"></span>}
                </div>
                <p className="card-text">Rating: {rating}</p>
                <p className="card-text">Type: {type}</p>
                <p className="card-text">Address: {address}</p>
                <p className="card-text">Coordinate: {coordinate}</p>
            </div>
        </div>
    )
}

export default PlaceCard
